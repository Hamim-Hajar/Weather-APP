import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Databasesaver {
    private static final String URL = "jdbc:mysql://localhost:3306/weather";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "jujuRO55";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static List<City> infocities() throws SQLException {
        List<City> infocity = new ArrayList<>();
        String sql = "SELECT * FROM city";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int ID = resultSet.getInt("ID");
            String cityName = resultSet.getString("cityName");
            int currentTemperature = resultSet.getInt("currentTemperature");
            int currentHumidity = resultSet.getInt("currentHumidity");
            int currentWindSpeed = resultSet.getInt("currentWindSpeed");
            infocity.add(new City(ID, cityName, currentTemperature,currentHumidity,currentWindSpeed));
        }
        connection.close();
        statement.close();
        resultSet.close();
        return infocity;
    }
    public static void addcity(City city) throws SQLException {
        String sql = "INSERT INTO city (ID, cityName, currentTemperature,currentHumidity,currentWindSpeed) VALUES (?, ?, ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,city.getCityId());
        statement.setString(2, city.getCityName());
        statement.setInt(3,city.getCurrentTemperature());
        statement.setInt(4,city.getCurrentHumidity());
        statement.setInt(5,city.getCurrentWindSpeed());
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("Student added successfully!");
    }
    public static void updateCity(City city) throws SQLException {
        String sql = "UPDATE city SET CityName = ?, city = ?,CurrentTemperature = ?,CurrentHumidity = ?,CurrentWindSpeed = ? WHERE ID = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, city.getCityName());
        statement.setInt(3,city.getCurrentTemperature());
        statement.setInt(4,city.getCurrentHumidity());
        statement.setInt(5,city.getCurrentWindSpeed());
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("Student updated successfully!");
    }
}



