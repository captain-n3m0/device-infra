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

package com.google.devtools.mobileharness.infra.client.longrunningservice;

import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.devtools.deviceinfra.infra.client.api.Annotations.GlobalInternalEventBus;
import com.google.devtools.deviceinfra.infra.client.api.ClientApi;
import com.google.devtools.deviceinfra.infra.client.api.ClientApiModule;
import com.google.devtools.deviceinfra.infra.client.api.mode.local.LocalMode;
import com.google.devtools.deviceinfra.shared.util.concurrent.ThreadFactoryUtil;
import com.google.devtools.deviceinfra.shared.util.time.Sleeper;
import com.google.devtools.mobileharness.infra.client.longrunningservice.controller.ControllerModule;
import com.google.devtools.mobileharness.infra.controller.test.util.SubscriberExceptionLoggingHandler;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

/** Module for OLC server. */
public class ServerModule extends AbstractModule {

  @Override
  protected void configure() {
    install(new ControllerModule());
    install(new ClientApiModule());

    bind(ClientApi.class).in(Scopes.SINGLETON);
  }

  @Provides
  @Singleton
  LocalMode provideLocalMode() {
    return new LocalMode();
  }

  @Provides
  @Singleton
  ListeningScheduledExecutorService provideListeningScheduledExecutorService() {
    return MoreExecutors.listeningDecorator(
        Executors.newScheduledThreadPool(
            /* corePoolSize= */ 5, ThreadFactoryUtil.createThreadFactory("main-thread")));
  }

  @Provides
  Sleeper provideSleeper() {
    return Sleeper.defaultSleeper();
  }

  @Provides
  @Singleton
  @GlobalInternalEventBus
  EventBus provideGlobalInternalEventBus() {
    return new EventBus(new SubscriberExceptionLoggingHandler());
  }
}
