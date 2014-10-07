package org.laybe.proxymate.android.fragments.presenters;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.laybe.proxymate.android.activities.modules.MockMainActivityModule;
import org.laybe.proxymate.android.fragments.FragmentView;
import org.laybe.proxymate.android.fragments.MainFragment;
import org.laybe.proxymate.android.models.AuthDetails;
import org.laybe.proxymate.android.modules.MockAppModule;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.tester.android.view.TestMenuItem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import dagger.Provides;

@RunWith(RobolectricTestRunner.class)
public class MainLoggedInFragmentPresenterTest extends MainBaseFragmentPresenterTest {

	@dagger.Module(
			injects = {
					MainLoggedInFragmentPresenter.class,
					MainLoggedInFragmentPresenterTest.class
			},
			addsTo = MockMainActivityModule.class
			)
	class Module {

		MainFragment fragment;

		@Provides @Singleton
		FragmentView provideFragmentView() {
			if (fragment == null)
				fragment = provideMainFragment();
			return fragment;	
		};

		@Provides @Singleton
		MainFragment provideMainFragmentView() {
			if (fragment == null)
				fragment = provideMainFragment();
			return fragment;
		}
		
		MainFragment provideMainFragment() {
			return mock(MainFragment.class);
		}

	}

	@Inject
	MainLoggedInFragmentPresenter sut;

	@Override
	protected List<Object> getModules() {
		return Arrays.asList(new MockAppModule(), new MockMainActivityModule(), new Module());
	}
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		sut = null;
	}

	@Test
	public void testPreconditions() {
		assertNotNull(sut);
	}

	@Test
	public void should_onOptionsItemSelected_performSwitchProfile() {
		MenuItem item = new TestMenuItem(org.laybe.proxymate.R.id.action_switch_profile);
		sut.onActivityCreated(any(Bundle.class));
		sut.onOptionsItemSelected(item);
		
		verify(view, times(1)).startActivityForResult(any(Intent.class), eq(MainBaseFragmentPresenter.SWITCH_PROFILE_REQUEST));
	}
	
	@Test
	public void should_onOptionsItemSelected_performLogout() {
		MenuItem item = new TestMenuItem(org.laybe.proxymate.R.id.action_logout);
		sut.onActivityCreated(any(Bundle.class));
		sut.onOptionsItemSelected(item);
		
		verify(loginManager, times(1)).logout();
	}
	
	
	@Test
	public void should_onOptionsItemSelected_performSettings() {
		MenuItem item = new TestMenuItem(org.laybe.proxymate.R.id.action_settings);
		sut.onActivityCreated(any(Bundle.class));
		sut.onOptionsItemSelected(item);
		
		fail("Should show Settings");
	}
	
	@Test
	public void should_saveState() {
		Bundle inState = new Bundle();
		// TODO Add state values
		sut.onActivityCreated(inState);
		
		Bundle outState = new Bundle();
		sut.onSaveInstanceState(outState);

		assertEquals(inState, outState);
	}
	
	@Test
	public void should_onActivityResult_login() {
		sut.onActivityResult(MainBaseFragmentPresenter.SWITCH_PROFILE_REQUEST, Activity.RESULT_OK, new Intent());
		
		verify(loginManager, times(1)).login(any(AuthDetails.class));
	}
	
	@Test
	public void should_onCreateView_inflateView() {
		sut.onCreateView(any(LayoutInflater.class), any(ViewGroup.class), any(Bundle.class));
		
		verify(view, times(1)).inflateView(any(LayoutInflater.class), any(ViewGroup.class), any(Bundle.class));
	}
	
	@Test
	public void should_onCreateOptionsMenu_inflateMenu() {
		sut.onCreateOptionsMenu(any(Menu.class), any(MenuInflater.class));
	
		verify(view, times(1)).inflateMenu(any(Menu.class), any(MenuInflater.class));
	}
}
