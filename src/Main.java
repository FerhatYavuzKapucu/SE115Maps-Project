import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter full path of the input file: ");
            String filePath = scanner.nextLine(); // Kullanıcıdan tam dosya yolunu al

            CountryMap map = new CountryMap(10);
            map.readFile(filePath);

            WayFinder wayFinder = new WayFinder(map);
            wayFinder.findPath(map.getFirstCity(), map.getLastCity());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}