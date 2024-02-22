import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        int choice, idCity, currentHumidity, currentTemperature, currentWindSpeed;
        String Cityname;
        do {
            System.out.println("\t\t\t||========================================================||");
            System.out.println("\t\t\t||                       MENU                             ||");
            System.out.println("\t\t\t||========================================================||");
            System.out.println("\t\t\t||              1: Add City                               ||");
            System.out.println("\t\t\t||              2: Update City                            ||");
            System.out.println("\t\t\t||              3: Delete City                            ||");
            System.out.println("\t\t\t||              4: Display All Cities                     ||");
            System.out.println("\t\t\t||              5: Add the historical Data of the city    ||");
            System.out.println("\t\t\t||              6: Update the historical Data of the city ||");
            System.out.println("\t\t\t||              7: Delete the historical Data of the city ||");
            System.out.println("\t\t\t||              8: Display  historical Data of all cities ||");
            System.out.println("\t\t\t||              0: Exit application ^_^                   ||");
            System.out.println("\t\t\t||========================================================||");
            System.out.println("Enter your choice: ");
            choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the ID of the City : ");
                    idCity = new Scanner(System.in).nextInt();
                    System.out.print("Enter the name of the city : ");
                    Cityname = new Scanner(System.in).nextLine();
                    System.out.print("Enter the current Humidity : ");
                    currentHumidity = new Scanner(System.in).nextInt();
                    System.out.print("Enter the current Temperature : ");
                    currentTemperature = new Scanner(System.in).nextInt();
                    System.out.print("Enter the current Wind Speed : ");
                    currentWindSpeed = new Scanner(System.in).nextInt();
                    City.addcity(new City(idCity, Cityname, currentTemperature, currentHumidity, currentWindSpeed));
                    break;
                case 2:
                    System.out.print("Enter the ID of the City : ");
                    idCity = new Scanner(System.in).nextInt();
                    System.out.print("Enter the name of the city: ");
                    Cityname = new Scanner(System.in).nextLine();
                    System.out.print("Enter the current Humidity: ");
                    currentHumidity = new Scanner(System.in).nextInt();
                    System.out.print("Enter the current Temperature: ");
                    currentTemperature = new Scanner(System.in).nextInt();
                    System.out.print("Enter the current Wind Speed : ");
                    currentWindSpeed = new Scanner(System.in).nextInt();
                    City.updateCity(new City(idCity, Cityname, currentTemperature, currentHumidity, currentWindSpeed));
                    break;
                case 3:
                    System.out.print("Enter City ID to delete: ");
                    idCity = new Scanner(System.in).nextInt();
                    City.deleteCity(idCity);
                    break;
                case 4:
                    System.out.println("All cities:");
                    for (City ville : City.infocities()) {
                        System.out.println(ville);
                    }
                    break;
                case 5:
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter the ID of the history City : ");
                    int histrycityid = scanner.nextInt();
                    System.out.println("Enter the ID of the city");
                    int cityid = scanner.nextInt();

                    System.out.println("Please enter a date (format: yyyy-MM-dd): ");
                    String eventdate = scanner.next();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        Date date = dateFormat.parse(eventdate);
                        System.out.println("Entered Date: " + dateFormat.format(date));
                    } catch (ParseException e) {
                        System.out.println("Incorrect date format. Please enter a date in yyyy-MM-dd format.");
                    }
                    System.out.println("Enter the temperature of the city");
                    int temperature = scanner.nextInt();
                    CityHistory.addcityhistory(new CityHistory(histrycityid, cityid, eventdate, temperature));
                    break;
                case 6:

                    break;
                case 7:
                    System.out.print("Enter  IDhistory to delete the history city: ");
                    int idCityh = new Scanner(System.in).nextInt();
                    CityHistory.deleteCityhistory(idCityh);
                    break;
                case 8:
                    System.out.println("All cities:");
                    for (CityHistory infocityhistory : CityHistory.cityhistoryinfo()) {
                        System.out.println(infocityhistory);
                    }
                    break;

            }


        } while (choice != 0);


    }
}