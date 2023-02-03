package com.mohibul.projectweather;

public class URL {
    private static String city_url;
    private final String link;

    public URL() {
        link = "https://api.openweathermap.org/data/2.5/onecall?exclude=minutely&lat="
                + LocationCooridinate.lat + "&lon=" + LocationCooridinate.lon + "&appid=" + LocationCooridinate.API_KEY;
    }
    public static void setCity_url(String cityName) {
        city_url = "https://api.openweathermap.org/data/2.5/weather?&q=" + cityName + "&appid=" + LocationCooridinate.API_KEY;
    }
    public static String getCity_url() {

        return city_url;
    }
    public String getLink() {
        return link;
    }

}