package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;

public class CartTest {

    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        Book book = new Book("The Great Gatsby", "Classic", 10.99f);
        cart.addMedia(book);

        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", "John Doe", 60, 19.99f, "Various Artists");
        Track track1 = new Track("Track 1", 180);
        Track track2 = new Track("Track 2", 200);
        cd.addTrack(track1);
        cd.addTrack(track2);
        cart.addMedia(cd);

        cart.print();

        System.out.println("\nSearching by ID:");

        System.out.println("\nSearching by Title:"); 
    }
}
