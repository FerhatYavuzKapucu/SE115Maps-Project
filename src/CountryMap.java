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



    }




}
