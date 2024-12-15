import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        line = reader.readLine();
        int numCities = Integer.parseInt(line);
        cityCount = numCities;

        line = reader.readLine();
        String[] cityNames = line.split(" ");
        for(int i = 0; i < numCities; i++) {
            cities[i] = new City(cityNames[i], i);
        }

        line = reader.readLine();
        int numRoutes = Integer.parseInt(line);

        for(int i = 0; i < numRoutes; i++) {
            line = reader.readLine();
            String[] routeInfo = line.split(" ");
            String city1 = routeInfo[0];
            String city2 = routeInfo[1];
            int time = Integer.parseInt(routeInfo[2]);
            
           addRoute(city1, city2, time);
            
        }

        System.out.println("File read is succesfull");
                        
    }

    public void addRoute(String city1, String city2, int time) {
        int index1 = getCityIndex(city1);
        int index2 = getCityIndex(city2);

        routes[index1][index2] = time;
        routes[index2][index1] = time;
    }

    private int getCityIndex(String name) {
        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getCityName().equals(name)) {
                return cities[i].getCityIndex();
            }
        }
        
        throw new IllegalArgumentException("City not found: " + name);
    }
}