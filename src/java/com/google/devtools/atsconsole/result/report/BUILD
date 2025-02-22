# Copyright 2022 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#    https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

java_library(
    name = "compatibility_report_parser",
    srcs = ["CompatibilityReportParser.java"],
    visibility = [
        "//src/javatests/com/google/devtools/atsconsole/result/report:__pkg__",
    ],
    deps = [
        ":context",
        "//src/devtools/atsconsole/result/proto:report_java_proto",
        "//src/java/com/google/devtools/atsconsole/result/xml:xml_constants",
        "//src/java/com/google/devtools/mobileharness/api/model/error",
        "//src/java/com/google/devtools/mobileharness/shared/util/file/local",
        "@maven//:com_google_code_findbugs_jsr305",
        "@maven//:com_google_guava_guava",
        "@maven//:javax_inject_jsr330_api",
    ],
)

java_library(
    name = "context",
    srcs = ["Context.java"],
    deps = ["//src/devtools/atsconsole/result/proto:report_java_proto"],
)

java_library(
    name = "compatibility_report_merger",
    srcs = ["CompatibilityReportMerger.java"],
    visibility = [
        "//src/javatests/com/google/devtools/atsconsole/result/report:__pkg__",
    ],
    deps = [
        ":compatibility_report_parser",
        "//src/devtools/atsconsole/result/proto:report_java_proto",
        "//src/java/com/google/devtools/atsconsole/result/xml:xml_constants",
        "//src/java/com/google/devtools/deviceinfra/shared/util/auto:auto_value",
        "//src/java/com/google/devtools/deviceinfra/shared/util/logging:google_logger",
        "//src/java/com/google/devtools/mobileharness/api/model/error",
        "@maven//:com_google_guava_guava",
        "@maven//:javax_inject_jsr330_api",
    ],
)

java_library(
    name = "compatibility_report_module",
    srcs = ["CompatibilityReportModule.java"],
    visibility = [
        "//src/javatests/com/google/devtools/atsconsole/result/report:__pkg__",
    ],
    deps = ["@maven//:com_google_inject_guice"],
)

java_library(
    name = "compatibility_report_creator",
    srcs = ["CompatibilityReportCreator.java"],
    resources = [
        "//src/java/com/google/devtools/atsconsole/result/report/res:compatibility_res",
    ],
    visibility = [
        "//src/javatests/com/google/devtools/atsconsole/result/report:__pkg__",
    ],
    runtime_deps = [
        "@maven//:net_sf_kxml_kxml2",
    ],
    deps = [
        ":zip_util",
        "//src/devtools/atsconsole/result/proto:report_java_proto",
        "//src/java/com/google/devtools/atsconsole/result/checksum:compatibility_report_checksum_helper",
        "//src/java/com/google/devtools/atsconsole/result/xml:xml_constants",
        "//src/java/com/google/devtools/deviceinfra/shared/util/logging:google_logger",
        "//src/java/com/google/devtools/mobileharness/api/model/error",
        "//src/java/com/google/devtools/mobileharness/shared/util/error:more_throwables",
        "//src/java/com/google/devtools/mobileharness/shared/util/file/local",
        "@maven//:com_google_guava_guava",
        "@maven//:javax_inject_jsr330_api",
        "@maven//:xmlpull_xmlpull",
    ],
)

java_library(
    name = "zip_util",
    srcs = ["ZipUtil.java"],
)
