package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private String artist = new String();
	List<Track> tracks = new ArrayList<Track>();

	public CompactDisc(int id, String title, String category, float cost, String artist, int length, List<Track> tracks) {
		super(id, title, category, cost, artist, length);
		this.tracks = tracks;
	}
	
	public CompactDisc() {
		super();
	}

	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public List<Track> getTracks() {
		return tracks;
	}
	
	public void addTrack(Track track) {
		if (this.getTracks().contains(track)) {
			System.out.println("This track has already been added in the list");
			return;
		}
		this.tracks.add(track);
	}
	
	public Track search(String title, int length) {
		Track track = new Track();
		track.setTitle(title); track.setLength(length);
		for (Track temp : this.getTracks()) {
			if (temp.equals(track)) {
				return temp;
			}
		}
		return null;
	}
	
	public void removeTrack(Track track) {
		if (this.getTracks().contains(track)) {
			this.getTracks().remove(track);
			return;
		}
		System.out.println("This track wasn't added in the list.");
	}
	
	@Override
	public int getLength() {
		int ans = 0;
		for (Track temp : this.getTracks()) {
			ans += temp.getLength();
		} 
		return ans;
	}
	
	@Override
	public void play() {
		System.out.println("This is " + this.getArtist() + "'s list.");
		for (Track temp : this.getTracks()) {
			temp.play();
		}
	}

	@Override
	public String toString() {
	    StringBuilder builder = new StringBuilder();
	    builder.append(this.getId())
	           .append(". Compact disc - ")
	           .append(this.getTitle())
	           .append(" - ")
	           .append(this.getArtist())
	           .append(" - ")
	           .append(this.getCategory())
	           .append(": ")
	           .append(this.getCost())
	           .append("$.");
	    for (Track temp : this.tracks) {
	        builder.append("\nDisplay information about tracks: ").append(temp.toString());
	    }
	    
	    return builder.toString();
	}

	
	@Override
	public String type() {
		return "CompactDisc";
	}
	
}
