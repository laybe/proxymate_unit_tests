package org.laybe.proxymate.android.modules;

import javax.inject.Singleton;

import org.laybe.proxymate.android.controllers.AppController;
import org.laybe.proxymate.android.events.EventBus;
import org.laybe.proxymate.android.modules.ForApplication;

import static org.mockito.Mockito.*;
import android.content.Context;
import dagger.Module;
import dagger.Provides;

@Module (
		library = true,
		includes = MockLoginModule.class
		)
public class MockAppModule {

	@Provides @Singleton
	AppController provideAppController() {
		return mock(AppController.class);
	}
	
	@Provides @Singleton @ForApplication 
	Context provideApplicationContext() {
		return mock(Context.class);
	}

	@Provides @Singleton @ForApplication
	EventBus provideEventBus() {
		return mock(EventBus.class);
	}
}
