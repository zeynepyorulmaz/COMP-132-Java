package resource;

public class ProceedingBook extends Resource {
	protected int numbers;
	protected int chapters;
	
	public ProceedingBook(String title, String field, int numPapers, int chapters) {
		super(title, field);
		
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public int getChapters() {
		return chapters;
	}

	public void setChapters(int chapters) {
		this.chapters = chapters;
	}
	

}
