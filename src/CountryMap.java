import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CountryMap {
    
    private City[] cities;
    private int[][] routes;
    private int cityCount;

    public CountryMap(int maxCities) {
        cities = new City[maxCities];
        routes = new int[maxCities][maxCities];
        cityCount = 0;
    }

    public void readFile(String fileName) throws IOException {
        Scanner scanner = new Scanner(new File(fileName)); 
        String line;

       
        int numCities = Integer.parseInt(scanner.nextLine().trim());
        cityCount = numCities;

        
        String[] cityNames = scanner.nextLine().trim().split(" ");
        for (int i = 0; i < numCities; i++) {
            cities[i] = new City(cityNames[i], i);
        }

        int numRoutes = Integer.parseInt(scanner.nextLine().trim());

        
        for (int i = 0; i < numRoutes; i++) {
            line = scanner.nextLine().trim();
            String[] routeInfo = line.split(" ");
            String city1 = routeInfo[0];
            String city2 = routeInfo[1];
            int time = Integer.parseInt(routeInfo[2]);

            
            int index1 = getCityIndex(city1);
            int index2 = getCityIndex(city2);

            routes[index1][index2] = time;
            routes[index2][index1] = time; 
        }

        scanner.close(); 
        System.out.println("File read is successful!");
    }


    private int getCityIndex(String name) {
        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getCityName().equals(name)) {
                return cities[i].getCityIndex();
            }
        }
        
        throw new IllegalArgumentException("City not found: " + name);
    }

        public City[] getCities() {
            return cities;
        }

        public int[][] getRoutes() {
            return routes;
        }
}