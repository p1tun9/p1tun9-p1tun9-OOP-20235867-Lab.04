package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();

	public Book(int id, String title, String category, float cost, List<String> authors) {
		super(id, title, category, cost);
		this.authors = authors;
	}
	public Book() {
		super();
	}
	
	public void addAuthor(String author) {
		if (this.authors.contains(author)) {
			System.out.println("This author's name has already been added in the list");
			return;
		}
		this.authors.add(author);
	}

	public void removeAuthor(String author) {
		if (this.authors.contains(author)) {
			this.authors.remove(author);
			return;
		}
		System.out.println("This author's name wasn't added in the list.");
	}
	
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public void displayAuthors() {
		System.out.println(authors);
	}
	
	@Override
	public String toString() {
	    StringBuilder builder = new StringBuilder();
	    builder.append(this.getId())
	           .append(". Book - ")
	           .append(this.getTitle())
	           .append(" - ")
	           .append(this.getCategory())
	           .append(" - ")
	           .append(this.getAuthors())
	           .append(": ")
	           .append(this.getCost())
	           .append("$.");
	    return builder.toString();
	}

	
	@Override
	public String type() {
		return "Book";
	}
}
