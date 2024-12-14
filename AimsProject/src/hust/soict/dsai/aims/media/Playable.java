package hust.soict.dsai.aims.media;

public interface Playable {
	public default void play() {
		System.out.println("You haven't added anything to play.");
	}
}
