package org.nhn.chen.activitiexplorer;

import org.nhn.chen.activitiexplorer.ui.ExplorerConstant;
import org.nhn.chen.activitiexplorer.ui.task.TaskPage;

import com.vaadin.Application;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class ExplorerApp extends Application {

	private Window mainWin;
	private static ThreadLocal<ExplorerApp> app = new ThreadLocal<ExplorerApp>();
	
	@Override
	public void init() {
		mainWin = new Window("explorer app");
		mainWin.setStyleName(ExplorerConstant.STYLE_MAIN_WIN);
		initMainWindow();
		this.setMainWindow(mainWin);
		this.setTheme(ExplorerConstant.THEME_NHNWF);
		app.set(this);
	}

	private void initMainWindow() {
		TaskPage taskpage = new TaskPage();
		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.setSizeFull();
		mainWin.setContent(mainLayout);
		mainWin.addComponent(taskpage);
	}
	
	
	public static ExplorerApp get() {
		return app.get();
	}
	
}
