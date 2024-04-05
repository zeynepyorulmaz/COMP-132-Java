package course;

public class Course {
	private String code;
    private String title;
    private int capacity;
    private boolean isOffered;

    public Course(String code, String title, int capacity, boolean isOffered) {
        this.code = code;
        this.title = title;
        this.capacity = capacity;
        this.isOffered = isOffered;
    }

	public String getCode() {
		return code;
	}


	public String getTitle() {
		return title;
	}


	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isOffered() {
		return isOffered;
	}

}