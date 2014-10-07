package org.laybe.proxymate.android.modules;

import static org.mockito.Mockito.*;

import javax.inject.Singleton;

import org.laybe.proxymate.android.models.User;
import org.laybe.proxymate.android.services.LoginManager;
import org.laybe.proxymate.android.services.SessionManager;

import dagger.Module;
import dagger.Provides;

@Module (
		library = true
		)
public class MockLoginModule {

	@Provides @Singleton
	SessionManager provideSessionManager() {
		return mock(SessionManager.class);
	}
	
	@Provides @Singleton
	LoginManager provideLoginManager() {
		return mock(LoginManager.class);
	}
	
	@Provides @Singleton
	User provideUser() {
		return mock(User.class);
	}

}
