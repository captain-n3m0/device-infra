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

package(default_applicable_licenses = ["//:license"])

java_library(
    name = "mobly_aosp_test_setup_util",
    srcs = ["MoblyAospTestSetupUtil.java"],
    visibility = [
        "//src/java/com/google/devtools/atsconsole:__subpackages__",
        "//src/javatests/com/google/devtools/atsconsole:__subpackages__",
    ],
    deps = [
        "//src/java/com/google/devtools/deviceinfra/shared/util/logging:google_logger",
        "//src/java/com/google/devtools/mobileharness/api/model/error",
        "//src/java/com/google/devtools/mobileharness/shared/util/command",
        "//src/java/com/google/devtools/mobileharness/shared/util/file/local",
        "@maven//:com_google_code_findbugs_jsr305",
        "@maven//:com_google_guava_guava",
    ],
)

java_library(
    name = "subdevice_type",
    srcs = [
        "MoblySubdeviceType.java",
    ],
)

java_library(
    name = "config_generator",
    srcs = [
        "MoblyConfigGenerator.java",
    ],
    visibility = [
        "//java/com/google/wireless/qa/mobileharness/shared:__subpackages__",
        "//src/java/com/google/wireless/qa/mobileharness/shared:__subpackages__",
    ],
    runtime_deps = [
        "//src/java/com/google/wireless/qa/mobileharness/shared/api:android_device",
        "//src/java/com/google/wireless/qa/mobileharness/shared/api:misc_testbed_subdevice",
        "//src/java/com/google/wireless/qa/mobileharness/shared/api:no_op_device",
        "//src/java/com/google/wireless/qa/mobileharness/shared/api:simple_composite_device",
    ],
    deps = [
        ":subdevice_type",
        "//src/java/com/google/devtools/mobileharness/api/model/error",
        "//src/java/com/google/devtools/mobileharness/platform/testbed/adhoc",
        "//src/java/com/google/devtools/mobileharness/platform/testbed/config:base",
        "//src/java/com/google/devtools/mobileharness/platform/testbed/mobly:mobly_constant",
        "//src/java/com/google/wireless/qa/mobileharness/shared/api",
        "@maven//:com_google_code_findbugs_jsr305",
        "@maven//:com_google_guava_guava",
        "@maven//:org_json_json",
    ],
)
