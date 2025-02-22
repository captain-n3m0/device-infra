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

package com.google.devtools.atsconsole.command;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.devtools.atsconsole.Annotations.DeviceInfraServiceFlags;
import com.google.devtools.atsconsole.ConsoleInfo;
import com.google.devtools.atsconsole.controller.olcserver.OlcServerModule;
import com.google.devtools.deviceinfra.shared.util.concurrent.ThreadFactoryUtil;
import com.google.devtools.deviceinfra.shared.util.time.Sleeper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import java.nio.file.Path;
import java.util.concurrent.Executors;

/** Console command module for testing. */
public class ConsoleCommandTestModule extends AbstractModule {

  private final ConsoleInfo consoleInfo;

  ConsoleCommandTestModule(ConsoleInfo consoleInfo) {
    this.consoleInfo = consoleInfo;
  }

  @Override
  protected void configure() {
    install(new OlcServerModule(() -> Path.of("")));
  }

  @Provides
  ConsoleInfo provideConsoleInfo() {
    return consoleInfo;
  }

  @Provides
  @DeviceInfraServiceFlags
  ImmutableList<String> provideDeviceInfraServiceFlags() {
    return ImmutableList.of();
  }

  @Provides
  ListeningScheduledExecutorService provideThreadPool() {
    return MoreExecutors.listeningDecorator(
        Executors.newScheduledThreadPool(
            /* corePoolSize= */ 5, ThreadFactoryUtil.createThreadFactory("main-thread")));
  }

  @Provides
  Sleeper provideSleeper() {
    return Sleeper.defaultSleeper();
  }
}
