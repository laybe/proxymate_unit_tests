package org.laybe.proxymate.android.activities.presenters;


import static org.mockito.Mockito.mock;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.laybe.proxymate.android.activities.ActivityView;
import org.laybe.proxymate.android.activities.presenters.MainActivityPresenter;
import org.laybe.proxymate.android.activities.presenters.MainActivityPresenterImpl;
import org.laybe.proxymate.android.modules.MockAppModule;
import org.robolectric.RobolectricTestRunner;

import dagger.ObjectGraph;
import dagger.Provides;

@RunWith(RobolectricTestRunner.class)
public class MainActivityPresenterImplTest extends TestCase {
	
	@dagger.Module(
			injects = MainActivityPresenterImpl.class,
			addsTo = MockAppModule.class
			)
	class Module {
		
		@Provides
		ActivityView provideActivityView() {
			return mock(ActivityView.class);
		};
		
	}
	
	private MainActivityPresenter sut;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		
		ObjectGraph graph = ObjectGraph.create(new MockAppModule(), new Module());
		sut = graph.get(MainActivityPresenterImpl.class);
	}
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		sut = null;
	}
	
	public void testOnCreateSetsFragment() {
		// TODO
	}
	
	public void testOnCreateSetsEventBus() {
		// TODO
	}

	@Test
	public void testNotNull() {
		assertNotNull(sut);
	}
}
