/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.devtools.atsconsole.result.report;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth8.assertThat;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.devtools.atsconsole.result.proto.ReportProto.Result;
import com.google.devtools.atsconsole.util.TestRunfilesUtil;
import com.google.devtools.mobileharness.shared.util.file.local.LocalFileUtil;
import com.google.inject.Guice;
import java.io.File;
import java.nio.file.Paths;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class CompatibilityReportCreatorTest {

  private static final String CTS_TEST_RESULT_XML =
      TestRunfilesUtil.getRunfilesLocation(
          "result/report/testdata/report_creator_cts_test_result.xml");

  private static final Splitter LINE_SPLITTER = Splitter.onPattern("\r\n|\n|\r");

  private final LocalFileUtil realLocalFileUtil = new LocalFileUtil();

  @Rule public TemporaryFolder temporaryFolder = new TemporaryFolder();

  @Inject private CompatibilityReportParser reportParser;

  private CompatibilityReportCreator reportCreator;

  @Before
  public void setUp() {
    Guice.createInjector(new TestModule()).injectMembers(this);
    reportCreator = new CompatibilityReportCreator(realLocalFileUtil);
  }

  @Test
  public void writeReportToXml() throws Exception {
    Result report = reportParser.parse(Paths.get(CTS_TEST_RESULT_XML)).get();

    File xmlResultDir = temporaryFolder.newFolder("xml_result");

    reportCreator.writeReportToXml(report, xmlResultDir);

    assertThat(
            replaceLineBreak(
                realLocalFileUtil
                    .readFile(
                        xmlResultDir
                            .toPath()
                            .resolve(CompatibilityReportCreator.TEST_RESULT_FILE_NAME))
                    .trim()))
        .isEqualTo(
            replaceLineBreak(realLocalFileUtil.readFile(Paths.get(CTS_TEST_RESULT_XML)).trim()));
  }

  @Test
  public void createReport() throws Exception {
    Result report = reportParser.parse(Paths.get(CTS_TEST_RESULT_XML)).get();

    File xmlResultDir = temporaryFolder.newFolder("xml_result");

    reportCreator.createReport(report, xmlResultDir.toPath());

    assertThat(
            realLocalFileUtil.listFilePaths(xmlResultDir.toPath(), false).stream()
                .map(p -> p.getFileName().toString()))
        .containsExactlyElementsIn(
            ImmutableList.<String>builder()
                .addAll(CompatibilityReportCreator.RESULT_RESOURCES)
                .add(CompatibilityReportCreator.TEST_RESULT_FILE_NAME)
                .add(CompatibilityReportCreator.HTML_REPORT_NAME)
                .add("checksum-suite.data")
                .build());

    assertThat(
            realLocalFileUtil.listFilePaths(xmlResultDir.toPath().getParent(), false).stream()
                .map(p -> p.getFileName().toString()))
        .containsExactly("xml_result.zip");
  }

  private static String replaceLineBreak(String str) {
    return Joiner.on("\n").join(LINE_SPLITTER.omitEmptyStrings().splitToList(str));
  }
}
