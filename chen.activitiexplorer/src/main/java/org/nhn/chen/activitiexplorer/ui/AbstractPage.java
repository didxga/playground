package org.nhn.chen.activitiexplorer.ui;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public abstract class AbstractPage extends CustomComponent {
	
	//general layout for application is a 3(cols)*2(rows) grid
	private GridLayout grid;
	
	public AbstractPage() {
		initUI();
	}

	protected void initUI() {
		setSizeFull();
		grid = new GridLayout(3, 3);
		grid.setSizeFull();
		grid.setRowExpandRatio(0, .10F);
		grid.setRowExpandRatio(1, .05F);
		grid.setRowExpandRatio(2, .85F);
		grid.setColumnExpandRatio(0, .25F);
		grid.setColumnExpandRatio(1, .52F);
		grid.setColumnExpandRatio(2, .23F);
		setCompositionRoot(grid);
		initAppNavigator();
		
		initMainComponent(grid);
	}

	protected abstract void initMainComponent(GridLayout grid);

	//init application navigation bar 
	private void initAppNavigator() {
		HorizontalLayout layout = new HorizontalLayout();
		layout.addStyleName(ExplorerConstant.STYLE_MAIN_NAV);
		layout.setSizeFull();
		grid.addComponent(layout, 0, 0, 2, 0);
		Label logo = new Label();
		logo.setCaption("NHN WF Explorer");
		layout.addComponent(logo);
	}
}
