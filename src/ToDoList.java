import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;

public class ToDoList {

	private HashMap<String, Task> tasks = new HashMap<String, Task>();
	
	public void addTask (Task task) {
		tasks.put(task.getDescription(), task);
	}
	public void completeTask(String description) {
		Task task = null;
		if ((task = tasks.get(description)) != null){
			task.setComplete(true);
		};
	}
	public boolean getStatus(String description) {
		Task task = null;
		if ((task = tasks.get(description)) != null){
			return task.isComplete();
		};
		return false;
	}
	public Task getTask(String description) {
		return tasks.get(description);
	}
	public Task removeTask(String description) {
		return tasks.remove(description);
	}
	public Collection<Task> getAllTasks() {
		return tasks.values();
	}
	public Collection<Task> getCompletedTasks() {
		Collection<Task> completedTasks = new ArrayList<Task> ();
		Collection<Task> allTasks = new ArrayList<Task> ();
		allTasks = getAllTasks();
		for (Task task: allTasks) 
			if (task.isComplete() == true) completedTasks.add(task);
		return completedTasks;
	}
	public Collection<Task> getUncompletedTasks() {
		Collection<Task> uncompletedTasks = new ArrayList<Task> ();
		Collection<Task> allTasks = new ArrayList<Task> ();
		allTasks = getAllTasks();
		for (Task task: allTasks)
		{
			if (task.isComplete() == false)
			{
				uncompletedTasks.add(task);
			}
		}
		return uncompletedTasks;
	}
	public Collection<Task> getTasksByPriority(int priority){
		Collection<Task> requiredTasks = new ArrayList<Task> ();
		Collection<Task> allTasks = new ArrayList<Task> ();
		allTasks = getAllTasks();
		for (Task task: allTasks)
		{
			if (task.getPriority() == priority)
			{
				requiredTasks.add(task);
			}
		}
		return requiredTasks;
	}
	public void editTaskDescription(String description, String description_new) {

	Collection<Task> allTasks = new ArrayList<Task> ();
	allTasks = getAllTasks();
	for (Task task: allTasks) {
		if (task.getDescription() == description) {
			task.setDescription(description_new);
			tasks.put(description, task);
		}
		
	}
}
}
