package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.MediaMethod;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.media.MediaComparatorByTitleCost;
import hust.soict.dsai.aims.store.Store;

public class Cart implements MediaMethod {
	private List<Media> Cart = new ArrayList<Media>();
	Store store = new Store();
	public Cart() {
		super();
	}
	
	public List<Media> getCart() {
		return Cart;
	}

	public void setCart(List<Media> cart) {
		Cart = cart;
	}

	public Store getStore() {
		return store;
	}
	
	@Override
	public List<Media> searchMedia (String title) {
		List<Media> Medias = new ArrayList<Media>();
		for (Media temp : Cart) {
			if (temp.getTitle().equals(title)) {
				Medias.add(temp);
			}
		} return Medias;
	}
	
	@Override
	public List<Media> searchMedia (int id) {
		List<Media> Medias = new ArrayList<Media>();
		for (Media temp : Cart) {
			if (temp.getId() == id) {
				Medias.add(temp);
			}
		} return Medias;
	}
	
	@Override
	public void removeMedia (Scanner scanner, String title) {
		List<Media> medias = searchMedia(title);
		if (medias.isEmpty()){
            System.out.println("No media found.");
		} else {
			for (Media temp : medias) {
            	temp.toString();
				System.out.println("Do you want to remove this media to cart ?");
                System.out.println("--------------------------------");
                System.out.print("1. Remove");
                System.out.print("2. Not remove");
                System.out.print("0. Back");
                System.out.print("Please choose a number: 0-1-2: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
				switch(choice) {
				case 1: 
					Cart.remove(temp);
		            System.out.println("Removed.");
		            break;
				case 2:
					break;
				case 0:
					return;
					
				default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
				}
			}
		}
	}	
	
	
	@Override
	public void displayMedia () {
		for (Media temp : Cart) {
			System.out.println(temp.toString());
		}
	}
	
	@Override
	public float totalCost() {
		float sum = 0;
		for (Media temp : Cart) {
			sum += temp.getCost();
		}
		return sum;
	}

	@Override
	public void sortByTitle() {
		Collections.sort(Cart, new MediaComparatorByTitleCost());
	}
	
	@Override
	public void sortByCost() {
		Collections.sort(Cart, new MediaComparatorByCostTitle());
	}
}
