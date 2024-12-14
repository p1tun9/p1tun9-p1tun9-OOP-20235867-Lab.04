package hust.soict.dsai.aims;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

import java.util.List;
import java.util.Scanner;

public class Aims {
	public static Store store = new Store();
	public static Cart cart = new Cart();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    storeMenu(scanner);
                    break;
                case 2:
                    updateStore(scanner);
                    break;
                case 3:
                    cartMenu(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu(Scanner scanner) {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    seeMediaDetails(scanner);
                    break;
                case 2:
                    addMediaToCart(scanner);
                    break;
                case 3:
                    playMedia(scanner, "store");
                    break;
                case 4:
                    cartMenu(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void cartMenu(Scanner scanner) {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4-5: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    filterMediaInCart(scanner);
                    break;
                case 2:
                    sortMediaInCart(scanner);
                    break;
                case 3:
                    removeMediaFromCart(scanner);
                    break;
                case 4:
                    playMedia(scanner, "cart");
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void seeMediaDetails(Scanner scanner) {
        System.out.print("Enter title of the media: ");
        String title = scanner.nextLine();
        List<Media> media = store.searchMedia(title);
        if (!media.isEmpty()) {
        	for (Media temp : media) {
        		System.out.println(temp.toString());
        	}
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void addMediaToCart(Scanner scanner) {
        System.out.print("Enter title of the media to add to cart: ");
        String title = scanner.nextLine();
        List<Media> medias = store.searchMedia(title);
        if (!medias.isEmpty()) {
            for (Media temp : medias) {
            	System.out.println(temp.toString());
                System.out.println("Do you want to add this media to cart ?");
                System.out.println("--------------------------------");
                System.out.println("1. Add");
                System.out.println("2. Not add");
                System.out.println("0. Back");
                System.out.println("Please choose a number: 0-1-2: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch(choice) {
                case 1: 
                	cart.getCart().add(temp);
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
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia(Scanner scanner, String type) {
        if (type.equals("store")) {
        	System.out.print("Enter title of the media to play: ");
            String title = scanner.nextLine();
            List<Media> medias = store.searchMedia(title);
            if (!medias.isEmpty()) {
            	for (Media temp : medias) {
            		temp.play();
            	}
            } else {
                System.out.println("Media not found.");
            }
        } else {
        	System.out.print("Enter title of the media to play: ");
            String title = scanner.nextLine();
            List<Media> medias = cart.searchMedia(title);
            if (!medias.isEmpty()) {
            	for (Media temp : medias) {
            		temp.play();
            	}
            } else {
                System.out.println("Media not found.");
            }
        }
    }

    public static void filterMediaInCart(Scanner scanner) {
        System.out.println("Filter by:");
        System.out.println("1. By ID");
        System.out.println("2. By Title");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Enter ID to filter: ");
                int id = scanner.nextInt();
                List<Media> mediaById = cart.searchMedia(id);
                if (!mediaById.isEmpty()) {
                	for (Media temp : mediaById) {
                		System.out.println(temp.toString());
                	}
                } else {
                    System.out.println("No media found with that ID.");
                }
                break;
            case 2:
                System.out.print("Enter title to filter: ");
                String title = scanner.nextLine();
                List<Media> mediaByTitle = cart.searchMedia(title);
                if (!mediaByTitle.isEmpty()) {
                	for (Media temp : mediaByTitle) {
                		System.out.println(temp.toString());
                	}
                } else {
                    System.out.println("No media found with that title.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public static void sortMediaInCart(Scanner scanner) {
        System.out.println("Sort by:");
        System.out.println("1. By title");
        System.out.println("2. By cost");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                cart.sortByTitle();
                System.out.println("Sorted by title.");
                break;
            case 2:
            	cart.sortByCost();
                System.out.println("Sorted by cost.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public static void removeMediaFromCart(Scanner scanner) {
        System.out.print("Enter title of the media to remove: ");
        String title = scanner.nextLine();
        cart.removeMedia(scanner, title);
    }

    public static void placeOrder() {
    	cart.displayMedia();
    	System.out.println("You have to pay: " + cart.totalCost() + "$.");
        System.out.println("Order placed successfully!");
        cart.getCart().clear();
    }

    public static void updateStore(Scanner scanner) {
    	boolean exit = false;
        while (!exit) {
            System.out.println("1. Add media to store");
            System.out.println("2. Remove media in store");
            System.out.println("3. Display store");
            System.out.println("0. Back");
            System.out.print("Please choose a number: 0-1-2-3: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
            case 1:
                System.out.println("What are you going to add ?");
               	System.out.println("1. Add DVD to Store");
               	System.out.println("2. Add book to Store");
               	System.out.println("3. Add compact disc to Store");
                System.out.println("0. Back");
                System.out.print("Please choose a number: 0-1-2-3: ");
                addMediaInStore(scanner);
                break;

            case 2:
                System.out.print("Enter media Title to remove: ");
               	String temp = scanner.nextLine();
                store.removeMedia(scanner, temp);
                break;

            case 3:
                store.displayMedia();
                break;
                
            case 0:
                exit = true;
                System.out.println("Backing.");
                break;

            default:
                System.out.println("Invalid choice.");
                break;
            }
        }
    }
    
    
    public static void addMediaInStore(Scanner scanner) {
        int choice = scanner.nextInt();
        scanner.nextLine();
    	switch(choice) {
		case 1:
			DigitalVideoDisc DVD = new DigitalVideoDisc();
			System.out.print("Enter title: ");
			String title1 = scanner.nextLine();
			if (title1.isEmpty()) {
				System.out.println("Title can't be empty.");
				return;
			}
			DVD.setTitle(title1);
			System.out.print("Enter director: ");
			String director = scanner.nextLine();
			if (director.isEmpty()) {
				director = "Unknown";
			}
			DVD.setDirector(director);
			
			System.out.print("Enter category: ");
			String category1 = scanner.nextLine();
			if (category1.isEmpty()) {
				category1 = "Unknown";
			}
			DVD.setCategory(category1);
			
			System.out.print("Enter length: ");
			int length1 = 0;
			if (scanner.hasNextInt()) {
				length1 = scanner.nextInt();
			} 
			DVD.setLength(length1);
			
			System.out.print("Enter cost: ");
			float cost1 = 0;
			if (scanner.hasNextFloat()) {
				cost1 = scanner.nextFloat();
			} 
			DVD.setCost(cost1);
			if (Store.List.contains(DVD)) {
				System.out.println("This media has already been added in the store.");
				Media.nbMedia--;
				return;
			}
			Store.List.add(DVD);
			System.out.println("Added.");
			break;
			
		case 2:
			Book book = new Book();
			System.out.print("Enter title: ");
			String title2 = scanner.nextLine();
			if (title2.isEmpty()) {
				System.out.println("Title can't be empty.");
				return;
			}
			book.setTitle(title2);
			
			System.out.print("Enter category: ");
			String category2 = scanner.nextLine();
			if (category2.isEmpty()) {
				category2 = "Unknown";
			}
			book.setCategory(category2);
			
			System.out.print("Enter cost: ");
			float cost2 = 0;
			if (scanner.hasNextFloat()) {
				cost2 = scanner.nextFloat();
			} 
			book.setCost(cost2);
			
			boolean exit2 = false;
			while (!exit2) {
				System.out.println("1. Add author's name");
				System.out.println("2. Remove author's name");
				System.out.println("3. Display author's name");
				System.out.println("0. Back");
                System.out.print("Please choose a number: 0-1-2-3: ");
				int choice2 = scanner.nextInt();
				scanner.nextLine();
				switch (choice2) {
				case 1: 
					System.out.print("Enter author's name: ");
					book.addAuthor(scanner.nextLine());
					break;	
				case 2:
					book.removeAuthor(scanner.nextLine());
					break;
				case 3:
					book.displayAuthors();
					break;
				case 0:
					exit2 = true;
					break;
				}
			}
			if (Store.List.contains(book)) {
				System.out.println("This book has already been added in the store.");
				Media.nbMedia--;
				return;
			}
			Store.List.add(book);
			System.out.println("Added.");
			break;
		
		case 3:
			CompactDisc temp = new CompactDisc();
			System.out.print("Enter title: ");
			String title3 = scanner.nextLine();
			if (title3.isEmpty()) {
				System.out.println("Title can't be empty.");
				return;
			}
			temp.setTitle(title3);
			
			System.out.print("Enter artist: ");
			String artist = scanner.nextLine();
			if (artist.isEmpty()) {
				artist = "Unknown";
			}
			temp.setArtist(artist);
			
			System.out.print("Enter category: ");
			String category3 = scanner.nextLine();
			if (category3.isEmpty()) {
				category3 = "Unknown";
			}
			temp.setCategory(category3);
			
			System.out.print("Enter cost: ");
			float cost3 = 0;
			if (scanner.hasNextFloat()) {
				cost3 = scanner.nextFloat();
			} 
			temp.setCost(cost3);
			
			boolean exit3 = false;
			while (!exit3) {
				System.out.println("1. Add Track to List");
				System.out.println("2. Remove Track to List");
				System.out.println("3. Display Tracks");
				System.out.println("0. Exit");
                System.out.print("Please choose a number: 0-1-2-3: ");
				int choice3 = scanner.nextInt();
				scanner.nextLine();
				switch (choice3) {
				case 1: 
					Track track = new Track();
					track.fillTrack(scanner);
					temp.addTrack(track);
					break;	
					
				case 2:
					System.out.println("Enter title: ");
					String titleTrack = scanner.nextLine();
					System.out.println("Enter length: ");
					int lengthTrack = scanner.nextInt();
					Track rmTrack = temp.search(titleTrack, lengthTrack);
					if (rmTrack != null) {
						temp.removeTrack(rmTrack);
						System.out.println("Removed.");
					} else {
						System.out.println("No matching track.");
					}
					break;
					
				case 3:
					System.out.println("Track's title - Track length: ");
					System.out.println(temp.getTracks());
					break;
					
				case 0:
					exit3 = true;
					break;
				}
			}
			if (Store.List.contains(temp)) {
				System.out.println("This compact disc has already been added in the store.");
				Media.nbMedia--;
				return;
			}
			Store.List.add(temp);
			System.out.println("Added.");
			break;
			
		case 0:
			return;
			
		default:
			System.out.println("Invalid.");
			break;
		}
	}
    
}
