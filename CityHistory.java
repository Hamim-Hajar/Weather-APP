import java.util.ArrayList;

import java.sql.*;
import java.util.List;



public class CityHistory {
    private int historicalDataId;
    private int cityId;
    private String eventDate;
    private int temperature;

    public int getHistoricalDataId() {
        return historicalDataId;
    }

    public void setHistoricalDataId(int historicalDataId) {
        this.historicalDataId = historicalDataId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getEventDate() {
        return  eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public CityHistory(int historicalDataId, int cityId, String eventDate, int temperature) {
        this.historicalDataId = historicalDataId;
        this.cityId = cityId;
        this.eventDate = eventDate;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "CityHistory{" +
                "historicalDataId=" + historicalDataId +
                ", cityId=" + cityId +
                ", eventDate=" + eventDate +
                ", temperature=" + temperature +
                '}';
    }
    private static final String URL="jdbc:mysql://localhost:3306/weather";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "jujuRO55";
    public static Connection getconnection() throws SQLException{
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
    public static void addcityhistory(CityHistory cityHistory) throws SQLException{
        String sql="INSERT INTO CityHistory (historicalDataId ,cityId ,eventDate ,temperature ) VALUES (?, ?, ?, ?)";
        Connection connection=getconnection();
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setInt(1,cityHistory.getHistoricalDataId());
        statement.setInt(2,cityHistory.getCityId());
        statement.setString(3,cityHistory.getEventDate());
        statement.setInt(4,cityHistory.getTemperature());
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("The information regarding the city's history has been successfully incorporated");
    }
    public static List<CityHistory> cityhistoryinfo() throws SQLException{
        List<CityHistory> infocityhistory=new ArrayList<>();
        String sql="SELECT * FROM CityHistory";
        Connection connection=getconnection();
        PreparedStatement statement=connection.prepareStatement(sql);
        ResultSet resultSet=statement.executeQuery();
        while (resultSet.next()){
            int historicalDataId= resultSet.getInt("historicalDataId");
            int cityId=resultSet.getInt("cityId");
            String eventDate=resultSet.getString("eventDate");
            int Temperature=resultSet.getInt("Temperature");
            infocityhistory.add(new CityHistory(historicalDataId,cityId,eventDate,Temperature));
            System.out.println("Here are all the informations");
        }
        connection.close();
        statement.close();
        resultSet.close();
        return infocityhistory;
    }
    public static void updatecityhistory(CityHistory cityHistory) throws SQLException{
        String sql ="UPDATE CityHistory SET historicalDataId=?,cityId=?,eventDate=?, Temperature=? WHERE historicalDataId=? ";
       Connection connection=getconnection();
       PreparedStatement statement=connection.prepareStatement(sql);
       statement.setInt(1,cityHistory.getHistoricalDataId());
       statement.setInt(2,cityHistory.getCityId());
       statement.setString(3,cityHistory.getEventDate());
       statement.setInt(4,cityHistory.getTemperature());
       statement.executeUpdate();
       connection.close();
       statement.close();
        System.out.println("The information regarding the city's history has been successfully updated ");
    }
    public static void deleteCityhistory(int id) throws SQLException {
        String sql = "DELETE FROM CityHistory WHERE historicalDataId  = ?";
        Connection connection = getconnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("city deleted successfully!");
    }
}

