package org.laybe.proxymate.android.fragments.presenters;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.inject.Inject;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.laybe.proxymate.android.fragments.MainFragment;
import org.laybe.proxymate.android.services.LoginManager;
import org.laybe.proxymate.android.widgets.DrawerTogglePresenter;

import dagger.ObjectGraph;

public abstract class MainBaseFragmentPresenterTest extends TestCase {

	@Inject
	MainFragment view;
	
	@Inject
	LoginManager loginManager;
	
	protected abstract List<Object> getModules();

	@Before
	public void setUp() throws Exception {
		super.setUp();
		
		ObjectGraph graph = ObjectGraph.create(getModules().toArray());
		graph.inject(this);
		
		when(view.getDrawerTogglePresenter()).thenReturn(mock(DrawerTogglePresenter.class));
	}
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		view = null;
		loginManager = null;
	}
}
