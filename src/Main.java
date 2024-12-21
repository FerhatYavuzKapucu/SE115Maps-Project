import java.io.IOException;

public class Main {
     public static void main(String[] args) {
        try {
            
            CountryMap map = new CountryMap(10);
            map.readFile("map1.txt");

            // WayFinder ile kısa yolu bul
            WayFinder wayFinder = new WayFinder(map);
            wayFinder.findPath(map.getFirstCity(), map.getLastCity());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
