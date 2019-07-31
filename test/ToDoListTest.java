import org.junit.*;
import static org.junit.Assert.*;


import java.util.Collection;

public class ToDoListTest {
	private Task task1;
	private Task task2;
	private Task task3;
	private ToDoList todoList;
	
	public ToDoListTest() {
		super();
	}
	@Before
	 public void setUp() throws Exception{
		task1 = new Task ("desc 1");
		task2 = new Task ("desc 2");
		task3 = new Task ("desc 3");
		
		todoList = new ToDoList();
	}
	@After
	 public void tearDown() throws Exception{
		task1 = null;
		task2 = null;
		task3 = null;
		
		todoList = null;
	}

	@Test
	public void testAddTask() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertEquals(1, todoList.getAllTasks().size());
		assertEquals(task1, todoList.getTask(task1.getDescription()));
	}
	@Test
	public void testgetStatus() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertEquals(false, todoList.getStatus(task1.getDescription()));
		todoList.completeTask(task1.getDescription());
		assertEquals(true, todoList.getStatus(task1.getDescription()));
	}
	@Test
	public void testRemoveTask() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		todoList.addTask(task2);;
		
		todoList.removeTask(task1.getDescription());
		assertNull(todoList.getTask(task1.getDescription()));	
	}
	@Test
	public void testGetCompletedTasks() {
		task1.setComplete(true);
		task3.setComplete(true);
		todoList.addTask(task1);
		todoList.addTask(task2);
		todoList.addTask(task3);
		
		Collection<Task> tasks = todoList.getCompletedTasks();
		assertEquals(2, tasks.size());
	}
	@Test
	public void testResetStatusToInComplete() {
		task1.setComplete(true);
		task1.resetStatus();
		assertFalse(task1.isComplete());
	}

	@Test
	public void testGetUncompletedTasks() {
		task1.setComplete(true);
		todoList.addTask(task1);
		todoList.addTask(task2);
		todoList.addTask(task3);
		
		Collection<Task> tasks = todoList.getUncompletedTasks();
		assertEquals(2, tasks.size());

	}
	
	@Test
	public void testSetPriority() {
		task1.setPriority(1);
		task2.setPriority(2);
		task3.setPriority(3);
		
		assertEquals(1, task1.getPriority());
		assertEquals(2, task2.getPriority());
		assertEquals(3, task3.getPriority());
	
	}
	
	@Test
	public void testGetTasksByPriority() {
		task1.setPriority(1);
		task2.setPriority(1);
		task3.setPriority(3);
		todoList.addTask(task1);
		todoList.addTask(task2);
		todoList.addTask(task3);
		
		Collection<Task> tasks = todoList.getTasksByPriority(1);
		assertEquals(2, tasks.size());
	}
	@Test
	public void testEditTaskDescription() {
		String desc1 = "desc 1";
		todoList.addTask(task1);
		
		String desc1_get = todoList.getTask(desc1).getDescription();
		assertEquals(desc1, desc1_get);
		
		String desc4 = "desc 4";
		todoList.editTaskDescription(desc1, desc4);
		String desc4_get = todoList.getTask(desc1).getDescription();
		assertNotEquals(desc1_get, desc4_get);
		assertEquals(desc4, desc4_get);
		
	}
}
