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

load("//src/javatests/com/google/devtools/deviceinfra/builddefs:junit_test_suites.bzl", "junit_test_suites")

package(
    default_applicable_licenses = ["//:license"],
    default_testonly = 1,
)

java_library(
    name = "command",
    srcs = glob(
        ["*.java"],
        exclude = ["StdoutStderrPrinter.java"],
    ),
    data = [
        ":stdout_stderr_printer",
        "//src/javatests/com/google/devtools/deviceinfra/shared/util/command/testdata",
    ],
    deps = [
        "//src/java/com/google/devtools/deviceinfra/api/error/id/defined",
        "//src/java/com/google/devtools/deviceinfra/shared/util/command",
        "//src/java/com/google/devtools/deviceinfra/shared/util/logging:google_logger",
        "//src/java/com/google/devtools/deviceinfra/shared/util/path",
        "//src/javatests/com/google/devtools/deviceinfra/builddefs:truth",
        "//src/javatests/com/google/devtools/deviceinfra/shared/util/runfiles:runfiles_util",
        "@maven//:com_google_guava_guava",
        "@maven//:junit_junit",
        "@maven//:org_mockito_mockito_core",
    ],
)

java_binary(
    name = "stdout_stderr_printer",
    srcs = ["StdoutStderrPrinter.java"],
    main_class = "com.google.devtools.deviceinfra.shared.util.command.StdoutStderrPrinter",
    visibility = [
    ],
)

junit_test_suites(
    name = "gen_tests",
    sizes = [
        "small",
        "medium",
    ],
    deps = [
        ":command",
    ],
)
