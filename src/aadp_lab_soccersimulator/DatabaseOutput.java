/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadp_lab_soccersimulator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author dacsa
 */
public class DatabaseOutput implements DataOutputInterface {

    @Override
    public void outputData(List<PlayerData> player) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        //Creating database and tables --------------
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        String dbName = "world_cup";
        String[] teams = {"Ireland", "Brazil", "Argentina", "Japan", "Mexico", "Senegal", "Tunisia", "Qatar"};
        String DB_URL = "jdbc:mysql://localhost/" + dbName;
        String USER = "football";
        String PASS = "Java is almost as good as football";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/", USER, PASS);
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE SCHEMA IF NOT EXISTS " + dbName + ";");
            stmt.execute("USE " + dbName + ";");
            for (String team : teams) {
                stmt.execute(
                        "CREATE TABLE IF NOT EXISTS " + team + " ("
                        + "name VARCHAR(30) NOT NULL,"
                        + "number INT NOT NULL PRIMARY KEY,"
                        + "birth VARCHAR(30),"
                        + "position VARCHAR(30),"
                        + "goalsScored INT,"
                        + "background TEXT(1000));");
                String sql;
                for (PlayerData data : player) {
                    sql = String.format("INSERT INTO " + team + "(name, number, birth, position, goalsScored, background) values ('%s', %d, '%s', '%s', %d, '%s');",
                    data.name, data.number, data.birth, data.position, data.goalsScored, data.background);
                    stmt.executeUpdate(sql);
                }
                System.out.println("Successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
