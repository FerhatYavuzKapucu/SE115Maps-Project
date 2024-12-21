import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the input file name: ");
            String fileName = input.nextLine();

            
            CountryMap map = new CountryMap(10);
            map.readFile(fileName);

            
            WayFinder wayFinder = new WayFinder(map);
            wayFinder.findPath(map.getFirstCity(), map.getLastCity());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
