package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.MediaMethod;
import hust.soict.dsai.aims.media.*;


public class Store implements MediaMethod {
	public static List<Media> List = new ArrayList<Media>();
		
	public static List<Media> getList() {
		return List;
	}
		
	@Override
	public List<Media> searchMedia (String title) {
		List<Media> Medias = new ArrayList<Media>();
		for (Media temp : List) {
			if (temp.getTitle().equals(title)) {
				Medias.add(temp);
			}
		} return Medias;
	}
	
	@Override
	public List<Media> searchMedia (int id) {
		List<Media> Medias = new ArrayList<Media>();
		for (Media temp : List) {
			if (temp.getId() == id) {
				Medias.add(temp);
			}
		} return Medias;
	}
	
	@Override
	public void removeMedia(Scanner scanner, String title) {
	    List<Media> medias = searchMedia(title);
	    if (medias.isEmpty()) {
	        System.out.println("No media found.");
	    } else {
	        for (Media temp : medias) {
	            System.out.println(temp.toString());
	            System.out.println("Do you want to remove this media from the store?");
	            System.out.println("--------------------------------");
	            System.out.println("1. Remove");
	            System.out.println("2. Not remove");
	            System.out.println("0. Back");
	            System.out.print("Please choose a number: 0-1-2: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();
	            switch (choice) {
	            	case 1:
	            		List.remove(temp);
	                    System.out.println("Removed.");
	                    break;
	                case 2:
	                    break;
	                case 0:
	                    return;
	                default:
	                	System.out.println("Invalid choice. Please try again.");
	             }
	        }
	    }
	}

	
	@Override
	public void displayMedia () {
		for (Media temp : List) {
			System.out.println(temp.toString());
		}
	}
	
	@Override
	public float totalCost() {
		float sum = 0;
		for (Media temp : List) {
			sum += temp.getCost();
		}
		return sum;
	}
	
	@Override
	public void sortByTitle() {
		Collections.sort(List, new MediaComparatorByTitleCost());
	}
	
	@Override
	public void sortByCost() {
		Collections.sort(List, new MediaComparatorByCostTitle());
	}
}

