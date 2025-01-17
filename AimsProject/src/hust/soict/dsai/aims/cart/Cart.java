package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    private float totalCost = 0.0f; 
    
    public void addMedia(Media media) {
        itemsOrdered.add(media);
        totalCost += media.getCost(); 
    }
    
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            totalCost -= media.getCost();
        } else {
            System.out.println("The media item is not in the cart.");
        }
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    
    public int getSize() {
        return itemsOrdered.size();  
    }
    
    public void setItemsOrdered(ObservableList<Media> itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }
    
    public float totalCost() {
        return totalCost;
    }
    
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
        System.out.println("Total cost: " + totalCost);
        System.out.println("******************************************************");
    }
    
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Result: ");
                System.out.println(media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Cannot find media with ID: " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Result: ");
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Cannot find media with title: " + title);
        }
    }
    
    public void clear() {
        itemsOrdered.clear(); 
        totalCost = 0.0f;      
        System.out.println("The cart has been cleared.");
    }
}
