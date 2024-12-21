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



              for(int i = 0; i < numCities; i++) {
              int currentCity = -1;
              int smallDistance = Integer.MAX_VALUE;
                  for(int j = 0; j < numCities; j++) {
                    if(!visitedCities[j] && cityDistance[j] < smallDistance){
                        smallDistance = cityDistance[j];
                        currentCity = j;
                }
            }

            if (currentCity == -1) break;
            visitedCities[currentCity] = true;

            for (int a = 0; a < numCities; a++) {
                if(routes[currentCity][a] > 0 && !visitedCities[a]) {
                    int distance = cityDistance[currentCity] + routes[currentCity][a];
                      if(distance < cityDistance[a]){
                        cityDistance[a] = distance;
                        previousCity[a] = currentCity;
                    } 
                }
            }
        }

    if(cityDistance[lastCityNum] == Integer.MAX_VALUE) {
        System.out.println("No path found");
        return;
    }

    String[] way = new String[numCities];
    int wayLength = 0;
    for(int i = lastCityNum; i != -1; i = previousCity[i]) {
        way[wayLength++] = cities[i].getCityName();
    }

    System.out.println("Shortest path: ");
    for(int i = wayLength - 1; i >= 0; i--) {
        System.out.println(way[i]);
          if (i > 0) {
            System.out.print(" -> ");
        }
    }
    System.out.println();
    System.out.println("Travel time: " + cityDistance[lastCityNum]);



    }
}
