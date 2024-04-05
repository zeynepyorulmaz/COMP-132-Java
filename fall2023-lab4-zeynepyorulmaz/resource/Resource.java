package resource;

public class Resource {
	
	public Resource(String title, String field) {
		//constructor
	}
	protected String title;
	protected String field;
	protected int numDwnld;
	protected int likes;
	
	 
	
	public String getField() {
		return field;
	}



	public void setField(String field) {
		this.field = field;
	}



	public int getNumDwnld() {
		return numDwnld;
	}



	public void setNumDwnld(int numDwnld) {
		this.numDwnld = numDwnld;
	}



	public int getLikes() {
		return likes;
	}



	public void setLikes(int likes) {
		this.likes = likes;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getTitle() {
		return title;
	}
	
	public void addNumDwnld(boolean like) {
		numDwnld +=1;
		if (like) {
			likes+=1;
		}
	}
	
	public double getRating() {
		if (numDwnld != 0) {
		return likes/numDwnld;
		}
		return 0;
	}
	
	

}
