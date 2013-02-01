package org.nhn.chen.activitiexplorer.ui.task;

import org.nhn.chen.activitiexplorer.ui.AbstractPage;
import org.nhn.chen.activitiexplorer.ui.ExplorerConstant;

import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class TaskPage extends AbstractPage {
	
	private Table table;

	@Override
	protected void initMainComponent(GridLayout grid) {
		initLeftMenubar(grid);
		initLeft(grid);
		initCentral(grid);
		initRight(grid);
	}

	private void initLeftMenubar(GridLayout grid) {
		HorizontalLayout layout = new HorizontalLayout();
		layout.setStyleName(ExplorerConstant.STYLE_MAIN_MENU_BAR);
		grid.addComponent(layout, 0, 1, 1, 1);
		layout.setSizeFull();
		layout.addComponent(new Label("abc"));
	}

	private void initRight(GridLayout grid) {
		VerticalLayout layout = new VerticalLayout();
		layout.setStyleName(ExplorerConstant.STYLE_MAIN_RIGHT);
		grid.addComponent(layout, 2, 2);
		layout.setSizeFull();
		layout.addComponent(new Label("abc"));
	}

	private void initCentral(GridLayout grid) {
		VerticalLayout layout = new VerticalLayout();
		layout.setStyleName(ExplorerConstant.STYLE_MAIN_CENTRAL);
		grid.addComponent(layout, 1, 2);
		layout.setSizeFull();
		layout.addComponent(new Label("abc"));
	}

	private void initLeft(GridLayout grid) {
		VerticalLayout layout = new VerticalLayout();
		layout.setStyleName(ExplorerConstant.STYLE_MAIN_LEFT);
		grid.addComponent(layout, 0, 2);
		layout.setSizeFull();
		TaskListHeader header = new TaskListHeader();
		table = new Table();
		layout.addComponent(header);
		//layout.setExpandRatio(header, .05f);
		layout.addComponent(table);
	}

}
