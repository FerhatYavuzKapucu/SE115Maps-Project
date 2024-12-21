public class WayFinder {
    private CountryMap map;

    public WayFinder(CountryMap map) {
        this.map = map;
    }

    public void findPath(String firstCity, String lastClity) {
        int[][] routes = map.getRoutes();
        City[] cities = map.getCities();

        
    }
}
