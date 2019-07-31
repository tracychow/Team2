
public class Task {
	public static final int	LOW = 1;
	public static final int MEDIUM = 2;
	public static final int	HIGH = 3;	
	
	private String description = null;
	private boolean isComplete = false;
	private int priority = 1;
		
	public Task(String description) {
		super();
		this.description = description;
	}
	
	public Task(String description, boolean isComplete) {
		super();
		this.description = description;
		this.isComplete = isComplete;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	public void resetStatus() {
		isComplete = false;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}

}
