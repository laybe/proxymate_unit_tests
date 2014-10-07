package org.laybe.proxymate.android.activities.modules;


import static org.mockito.Mockito.*;

import javax.inject.Singleton;

import org.laybe.proxymate.android.activities.ActivityView;
import org.laybe.proxymate.android.activities.MainActivity;
import org.laybe.proxymate.android.activities.presenters.ActivityPresenter;
import org.laybe.proxymate.android.modules.ForActivity;
import org.laybe.proxymate.android.modules.MockAppModule;

import android.app.Fragment;
import android.content.Context;
import dagger.Module;
import dagger.Provides;

@Module (
		library = true,
		addsTo = MockAppModule.class)
public class MockMainActivityModule {

	@Provides @Singleton @ForActivity Context provideActivityContext() {
		return mock(Context.class);
	}

	@Provides @Singleton
	ActivityView provideActivityView() {
		return mock(ActivityView.class);
	};
	
	@Provides @Singleton
	MainActivity provideView() {
		return mock(MainActivity.class);
	}

	@Provides @Singleton
	ActivityPresenter providePresenter() {
		return mock(ActivityPresenter.class);
	}

	@Provides @Singleton
	Fragment provideContentFragment() {
		return mock(Fragment.class);
	}

}
