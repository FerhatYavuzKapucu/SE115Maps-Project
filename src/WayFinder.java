public class WayFinder {
    private CountryMap map;

    public WayFinder(CountryMap map) {
        this.map = map;
    }

    public void findPath(String firstCity, String lastCity) {
        int[][] routes = map.getRoutes();
        City[] cities = map.getCities();

        int firstCityNum = map.getCityIndex(firstCity);
        int lastCityNum = map.getCityIndex(lastCity);
            
        
          int numCities = cities.length;

          int[] cityDistance = new int[numCities];
          boolean[] visitedCities = new boolean[numCities];
          int[] previousCity = new int[numCities];



          for(int i = 0; i <numCities; i++) {
            cityDistance[i] = Integer.MAX_VALUE;
            visitedCities[i] = false;
            previousCity[i] = -1;
          }

          cityDistance[firstCityNum] = 0;



          
    }
}
