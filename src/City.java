public class City {
    private String cityName;
    private int cityIndex;  

    public City(String cityName, int cityIndex) {
        this.cityName = cityName;
        this.cityIndex = cityIndex;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getCityName() {
        return cityName;
    }

    
    public void setCityIndex(int cityIndex) {
        this.cityIndex = cityIndex;
    }
    public int getCityIndex() {
        return cityIndex;
    }

    public String toString() {
        return "City{name = " + cityName + ". index = " + cityIndex + "}";
    }
}
