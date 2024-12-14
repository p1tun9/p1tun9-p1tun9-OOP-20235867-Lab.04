package hust.soict.dsai.aims;

import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.media.Media;

public interface MediaMethod {
	List<Media> searchMedia(String title);
	List<Media> searchMedia(int id);
	void removeMedia(Scanner scanner, String title);
	void displayMedia();	
	float totalCost();
	void sortByTitle();
	void sortByCost();
}
