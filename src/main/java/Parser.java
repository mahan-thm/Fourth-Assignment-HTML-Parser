import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Parser{
    static List<Country> countries = new ArrayList<>();


    public static List<Country> sortByName() {
        List<Country> sortedByName = new ArrayList<>(countries);
        // Sort countries alphabetically (least)
        //TODO

        Collections.sort(sortedByName, new Comparator<>() {
            @Override
            public int compare(Country country1, Country country2) {
                return country1.getName().compareTo(country2.getName());
            }
        });
        return sortedByName;

    }

    public static List<Country> sortByPopulation() {
        List<Country> sortedByPopulation = new ArrayList<>(countries);
        // Sort countries by population (most)
        //TODO

        Collections.sort(sortedByPopulation, new Comparator<Country>() {
            @Override
            public int compare(Country country1, Country country2) {
                return Integer.compare(country1.getPopulation(), country2.getPopulation());
            }
        });
        return sortedByPopulation;
    }

    public static List<Country> sortByArea() {
        List<Country> sortedByArea = new ArrayList<>(countries);
        // Sort countries by area (most)
        //TODO

        Collections.sort(sortedByArea, new Comparator<Country>() {
            @Override
            public int compare(Country country1, Country country2) {
                return Double.compare(country1.getArea(), country2.getArea());
            }
        });
        return sortedByArea;
    }
    public static List<Country> sortByCapital() {
        List<Country> sortByCapital = new ArrayList<>(countries);
        // Sort countries by area (most)
        //TODO

        Collections.sort(sortByCapital, new Comparator<Country>() {
            @Override
            public int compare(Country country1, Country country2) {
                return country1.getCapital().compareTo(country2.getCapital());
            }
        });
        return sortByCapital;
    }

    public static void setUp() throws IOException {
        File inputFile = new File("src/Resources/country-list.html");
        Document doc = Jsoup.parse(inputFile, "UTF-8");

        Elements links = doc.select(".country");

        for (Element link : links) {
            Country theCountry = new Country(
                    link.select(".country-name").text(),
                    link.select(".country-capital").text(),
                    Integer.parseInt(link.select(".country-population").text()),
                    Double.parseDouble(link.select(".country-area").text()));

            countries.add(theCountry);
        }
    }


    //Parse the HTML file using Jsoup
    //TODO

    // Extract data from the HTML
    //TODO

    // Iterate through each country div to extract country data
    //TODO


    public static void main (String[] args) throws IOException {
        //you can test your code here before you run the unit tests ;)
        setUp();
        for (Country country : sortByName()){
            System.out.println(country.getName());
        }
        for (Country country : sortByArea()){
            System.out.println(country.getArea());
        }
        for (Country country : sortByCapital()){
            System.out.println(country.getCapital());
        }
        for (Country country : sortByPopulation()){
            System.out.println(country.getPopulation());
        }

    }
}
