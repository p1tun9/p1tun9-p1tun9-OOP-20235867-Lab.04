package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	
	public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
		super(id, title, category, cost, director, length);
	}
	public DigitalVideoDisc() {
		super();
	}
	
	@Override
	public String toString() {
	    StringBuilder builder = new StringBuilder();
	    builder.append(this.getId())
	           .append(". DVD - ")
	           .append(this.getTitle())
	           .append(" - ")
	           .append(this.getCategory())
	           .append(" - ")
	           .append(this.getDirector())
	           .append(" - ")
	           .append(this.getLength())
	           .append(": ")
	           .append(this.getCost())
	           .append("$.");
	    return builder.toString();
	}

	
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());		
	}
	
	@Override
	public String type() {
		return "DVD";
	}
	
}

