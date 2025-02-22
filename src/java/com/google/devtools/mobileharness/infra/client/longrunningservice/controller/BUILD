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

package(
    default_visibility = [
        "//src/java/com/google/devtools/mobileharness/infra/client/longrunningservice:__subpackages__",
        "//src/javatests/com/google/devtools/mobileharness/infra/client/longrunningservice:__subpackages__",
    ],
)

java_library(
    name = "controller_module",
    srcs = ["ControllerModule.java"],
    deps = [
        ":session_runner",
        "@maven//:com_google_inject_extensions_guice_assistedinject",
        "@maven//:com_google_inject_guice",
    ],
)

java_library(
    name = "session_detail_creator",
    srcs = ["SessionDetailCreator.java"],
    deps = [
        "//src/devtools/mobileharness/infra/client/longrunningservice/proto:session_java_proto",
    ],
)

java_library(
    name = "session_job_creator",
    srcs = ["SessionJobCreator.java"],
    deps = [
        "//src/devtools/mobileharness/infra/client/longrunningservice/proto:session_java_proto",
        "//src/java/com/google/devtools/mobileharness/infra/client/longrunningservice/model:session_detail_holder",
        "//src/java/com/google/wireless/qa/mobileharness/shared/model/job",
        "@maven//:com_google_guava_guava",
    ],
)

java_library(
    name = "session_job_runner",
    srcs = ["SessionJobRunner.java"],
    deps = [
        "//src/java/com/google/devtools/deviceinfra/infra/client/api",
        "//src/java/com/google/devtools/deviceinfra/infra/client/api/mode/local",
        "//src/java/com/google/devtools/deviceinfra/shared/util/logging:google_logger",
        "//src/java/com/google/devtools/deviceinfra/shared/util/time",
        "//src/java/com/google/devtools/mobileharness/api/model/error",
        "//src/java/com/google/devtools/mobileharness/infra/client/longrunningservice/model:session_detail_holder",
        "//src/java/com/google/wireless/qa/mobileharness/shared/model/job",
        "@maven//:com_google_guava_guava",
        "@maven//:javax_inject_jsr330_api",
    ],
)

java_library(
    name = "session_manager",
    srcs = ["SessionManager.java"],
    deps = [
        ":session_detail_creator",
        ":session_runner",
        "//src/devtools/mobileharness/infra/client/longrunningservice/proto:session_java_proto",
        "//src/java/com/google/devtools/common/metrics/stability/converter",
        "//src/java/com/google/devtools/deviceinfra/shared/util/concurrent:callables",
        "//src/java/com/google/devtools/deviceinfra/shared/util/logging:google_logger",
        "//src/java/com/google/devtools/mobileharness/api/model/error",
        "@com_google_protobuf//:protobuf_java",
        "@maven//:com_google_code_findbugs_jsr305",
        "@maven//:com_google_guava_guava",
        "@maven//:javax_inject_jsr330_api",
    ],
)

java_library(
    name = "session_plugin_loader",
    srcs = ["SessionPluginLoader.java"],
    deps = [
        "//src/devtools/mobileharness/infra/client/longrunningservice/proto:session_java_proto",
        "//src/java/com/google/devtools/deviceinfra/api/error:exception",
        "//src/java/com/google/devtools/deviceinfra/shared/util/logging:google_logger",
        "//src/java/com/google/devtools/deviceinfra/shared/util/reflection:reflection_util",
        "//src/java/com/google/devtools/mobileharness/api/model/error",
        "//src/java/com/google/devtools/mobileharness/infra/client/longrunningservice/model:session_detail_holder",
        "//src/java/com/google/devtools/mobileharness/infra/client/longrunningservice/model:session_info",
        "//src/java/com/google/devtools/mobileharness/infra/client/longrunningservice/model:session_plugin",
        "//src/java/com/google/devtools/mobileharness/shared/util/event:event_bus_backend",
        "@com_google_protobuf//:protobuf_java",
        "@maven//:com_google_guava_guava",
        "@maven//:com_google_inject_guice",
        "@maven//:javax_inject_jsr330_api",
    ],
)

java_library(
    name = "session_plugin_runner",
    srcs = ["SessionPluginRunner.java"],
    deps = [
        "//src/devtools/mobileharness/infra/client/longrunningservice/proto:session_java_proto",
        "//src/java/com/google/devtools/common/metrics/stability/converter",
        "//src/java/com/google/devtools/deviceinfra/shared/util/logging:google_logger",
        "//src/java/com/google/devtools/mobileharness/infra/client/longrunningservice/model:session_detail_holder",
        "//src/java/com/google/devtools/mobileharness/infra/client/longrunningservice/model:session_event",
        "//src/java/com/google/devtools/mobileharness/infra/client/longrunningservice/model:session_info",
        "//src/java/com/google/devtools/mobileharness/infra/client/longrunningservice/model:session_plugin",
        "//src/java/com/google/devtools/mobileharness/shared/util/event:event_bus_backend",
        "@maven//:com_google_code_findbugs_jsr305",
        "@maven//:com_google_guava_guava",
    ],
)

java_library(
    name = "session_runner",
    srcs = ["SessionRunner.java"],
    deps = [
        ":session_job_creator",
        ":session_job_runner",
        ":session_plugin_loader",
        ":session_plugin_runner",
        "//src/devtools/mobileharness/infra/client/longrunningservice/proto:session_java_proto",
        "//src/java/com/google/devtools/mobileharness/api/model/error",
        "//src/java/com/google/devtools/mobileharness/infra/client/longrunningservice/model:session_detail_holder",
        "//src/java/com/google/devtools/mobileharness/infra/client/longrunningservice/model:session_plugin",
        "@maven//:com_google_guava_guava",
        "@maven//:com_google_inject_extensions_guice_assistedinject",
        "@maven//:javax_inject_jsr330_api",
    ],
)
