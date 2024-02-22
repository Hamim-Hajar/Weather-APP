import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        int choice, idCity, currentHumidity, currentTemperature, currentWindSpeed;
        String Cityname;
        do {
            System.out.println("\t\t\t||=======================================||");
            System.out.println("\t\t\t||                 MENU                  ||");
            System.out.println("\t\t\t||=======================================||");
            System.out.println("\t\t\t||              1: Add City              ||");
            System.out.println("\t\t\t||                2: Update City         ||");
            System.out.println("\t\t\t||                3: Delete City         ||");
            System.out.println("\t\t\t||                4: Display All City    ||");
            System.out.println("\t\t\t||                5: Quitter application ||");
            System.out.println("\t\t\t||=======================================||");
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
            }
        } while (choice != 5);
    }

}