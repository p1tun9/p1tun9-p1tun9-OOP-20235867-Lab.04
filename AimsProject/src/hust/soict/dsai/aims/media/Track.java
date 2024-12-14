package hust.soict.dsai.aims.media;

import java.util.Scanner;

public class Track implements Playable {
	private String title = new String();
	private int length;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	@Override
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("DVD track: " + this.getLength());		
	}
	
	public void fillTrack(Scanner scanner) {
		System.out.print("Enter title: ");
		String title = scanner.nextLine();
		if (title.isEmpty()) {
			System.out.println("Title can't be empty.");
			return;
		}
		this.setTitle(title);
		
		System.out.print("Enter length: ");
		int length = 0;
		if (scanner.hasNextInt()) {
			length = scanner.nextInt();
		} 
		this.setLength(length);
	}
	
	@Override
	public String toString() {
	    StringBuilder builder = new StringBuilder();
	    builder.append(this.getTitle())
	           .append(" - ")
	           .append(this.getLength())
	           .append(".");
	    return builder.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Track track = (Track) obj;
	    return (this.title.equals(track.getTitle()) && this.length == track.getLength());
	}
}
