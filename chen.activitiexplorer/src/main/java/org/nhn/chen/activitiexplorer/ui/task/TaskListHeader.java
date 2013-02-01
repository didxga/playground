package org.nhn.chen.activitiexplorer.ui.task;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.nhn.chen.activitiexplorer.ExplorerApp;
import org.nhn.chen.activitiexplorer.ui.ExplorerConstant;

import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

public class TaskListHeader extends Panel {

	private HorizontalLayout layout;
	private TextField text;
	
	private TaskService taskService;
	
	public TaskListHeader() {
		layout = new HorizontalLayout();
		layout.setWidth(99, UNITS_PERCENTAGE);
		layout.setHeight(36, UNITS_PIXELS);
		initInputField();
		initkeypressHandler();
		setContent(layout);
	}


	private void initInputField() {
		CssLayout csslayout = new CssLayout();
		csslayout.setWidth(100, UNITS_PERCENTAGE);
		csslayout.setHeight(24, UNITS_PIXELS);
		
		text = new TextField();
		text.setWidth(100, UNITS_PERCENTAGE);
		text.setStyleName(ExplorerConstant.STYLE_SEARCH_BOX);
		text.setInputPrompt("create new task");
		csslayout.addComponent(text);
		layout.addComponent(csslayout);
		layout.setExpandRatio(csslayout, 1.0F);
	}
	
	
	private void initkeypressHandler() {
		addActionHandler(new Handler() {
		      public void handleAction(Action action, Object sender, Object target) {
		        if (text.getValue() != null && !"".equals(text.getValue().toString())) {
		          
		          // Create task
		          Task task = taskService.newTask();
		          task.setName(text.getValue().toString());
		          task.setOwner(ExplorerApp.get().getLoggedInUser().getId());
		          taskService.saveTask(task);
		          
		          // Switch to the new task
		         // ExplorerApp.get().getViewManager().showTasksPage(task.getId());
		        }
		      }
		      public Action[] getActions(Object target, Object sender) {
		        return new Action[] {new ShortcutAction("enter", ShortcutAction.KeyCode.ENTER, null)};
		      }
		    });
	}
}
