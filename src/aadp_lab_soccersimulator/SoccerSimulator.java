/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadp_lab_soccersimulator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author dacsa
 */
public class SoccerSimulator {
    
    public void SimulateMatches() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        

        //Menu -------------
        int option;
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Welcome! What would you like to do today? Please enter the number corresponding to your choice.");
            System.out.println("1. Enter a new player to a team.");
            System.out.println("2. See the players on a team.");
            System.out.println("3. Simulate a number of matches.");
            System.out.println("4. Exit the programme.");
            try {
                //read option
                option = Integer.parseInt(sc.nextLine());
                //Op 1 - Add player -------------
                switch (option) {
                    case 1: {
                        boolean validTeam = false;
                        String teamName;
                        System.out.println("Please follow the instructions to enter player data.");
                        do {
                            System.out.println("For which team would you like to enter data?");
                            teamName = sc.nextLine();

                            //Team validation ------------
                            
                            for (String team : teams) {
                                if (teamName.toLowerCase().equals(team.toLowerCase())) {
                                    validTeam = true;
                                    break;
                                }
                            }
                            if (teamName.toLowerCase().equals("exit")) {
                                break;
                            }
                            if (!validTeam) {
                                System.out.println("That is not one of the teams. Please try again!");
                            }
                        } // Team validation ------------
                        // Inserting player data -----
                        while (!validTeam);
                        
                        String name;
                        int number = 0;
                        String birth;
                        String position;
                        int goalsScored = 0;
                        String background;
                        
                        // Player validation --------
                        boolean validPlayer = false;
                        System.out.println("Please enter the player's name: ");
                        name = sc.nextLine();
                        System.out.println("Please enter the player's number: ");
                        do {
                            try {
                                number = Integer.parseInt(sc.nextLine());
                                // Number validation --------
                                if (number < 1) {
                                    System.out.println("Please enter a positive integer");
                                } else {
                                    validPlayer = true;
                                }

                            } catch (Exception e) {
                                System.out.println("That is not a number. please try again!");
                            }
                        } while (!validPlayer);

                        // No date, string or int validation here --------
                        System.out.println("Please enter the player's date of birth: ");
                        birth = sc.nextLine();
                        System.out.println("Please enter the player's position: ");
                        position = sc.nextLine();
                        //Goals scored used playernumbervalidator too
                        System.out.println("Please enter the number of goals the player has scored: ");
                        // No date, string or int validation here --------

                        validPlayer = false;
                        do {
                            try {
                                //Number validation ----------
                                goalsScored = Integer.parseInt(sc.nextLine());
                                if (goalsScored < 1) {
                                    System.out.println("Please enter a positive integer");
                                } else {
                                    validPlayer = true;
                                }

                            } catch (Exception e) {
                                System.out.println("That is not a number. please try again!");
                            }
                        } while (!validPlayer);
                        System.out.println("Please enter the player's background: ");
                        background = sc.nextLine();
                        System.out.println("Thank you for entering a player");
                        // Inserting into database -----------
                        try {
                            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                            Statement stmt = conn.createStatement();
                            stmt.execute(
                                    String.format("INSERT INTO %s (name, number, birth, position, goalsScored, background) "
                                            + "VALUES (\"%s\", %d, \"%s\", \"%s\", %d,  \"%s\") ;",
                                            teamName, name, number, birth, position, goalsScored, background)
                            );
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    //  ------------- Op 1 - Add player 

                    // op 2 - see players in a team ---------------
                    case 2: {
                        //Team validation ---------
                        boolean validTeam = false;
                        String teamName;
                        System.out.println("Please follow the instructions to get player data.");
                        do {
                            System.out.println("For which team would you like to get player data?");
                            teamName = sc.nextLine();
                            for (String team : teams) {
                                if (teamName.toLowerCase().equals(team.toLowerCase())) {
                                    validTeam = true;
                                    break;
                                }
                            }
                            if (teamName.toLowerCase().equals("exit")) {
                                break;
                            }
                            if (!validTeam) {
                                System.out.println("That is not one of the teams. Please try again!");
                            }
                        } // --------- Team validation 
                        // Bring team info ----------------
                        while (!validTeam);
                        try {
                            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                            Statement stmt = conn.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT * from " + teamName + ";");
                            String name;
                            int number;
                            String birth;
                            String position;
                            int goalsScored;
                            String background;
                            while (rs.next()) {
                                name = rs.getString("name");
                                number = rs.getInt("number");
                                birth = rs.getString("birth");
                                position = rs.getString("position");
                                goalsScored = rs.getInt("goalsScored");
                                background = rs.getString("background");
                                System.out.println(String.format("Name: %s -- Number: %d -- DoB: %s -- Position: %s -- Number of goals scored: %d", name, number, birth, position, goalsScored));
                                System.out.println("Background:");
                                System.out.println(background);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }

                    // --------------- op 2 - see players in a team
                    // Op 3 - Simulate matches ------------
                    case 3:
                        System.out.println("How many matches would you like to simulate?");
                        Boolean validNum = false;
                        int numMatches = 0;
                        do {
                            try { // Number validation --------
                                numMatches = Integer.parseInt(sc.nextLine());
                                if (numMatches < 1) {
                                    System.out.println("Please enter a positive integer");
                                } else {
                                    validNum = true;
                                }

                            } catch (Exception e) {
                                System.out.println("That is not a number. please try again!");
                            }
                        } while (!validNum);
                        
                        // Matches generation ------------
                        for (int matchNum = 1; matchNum <= numMatches; matchNum++) {
                            int team1Num = (int) (Math.floor(Math.random() * teams.length));
                            String team1 = teams[team1Num];
                            int team2Num;
                            do {
                                team2Num = (int) (Math.floor(Math.random() * teams.length));
                            } while (team1Num == team2Num);
                            String team2 = teams[team2Num];
                            int team1Score = (int) (Math.floor(Math.random() * 6));
                            int team2Score = (int) (Math.floor(Math.random() * 6));
                            System.out.println("Time for mathch: " + matchNum);
                            if (team1Score > team2Score) {
                                System.out.println(String.format("Congratulation %s! %s scored %d goals and %s scored %d goals.", team1, team1, team1Score, team2, team2Score));
                            } else if (team1Score < team2Score) {
                                System.out.println(String.format("Congratulation %s! %s scored %d goals and %s scored %d goals.", team2, team1, team1Score, team2, team2Score));
                            } else {
                                System.out.println(String.format("It was a draw!! %s scored %d goals and %s scored %d goals.", team1, team1Score, team2, team2Score));
                            }
                        }
                        break;

                    // ------------ Op 3 - Simulate matches
                    // Op 4 - Exit --------------
                    case 4:
                        System.out.println("Goodbye, and thank you for using the SoccerSimulator!");
                        exit = true;
                        break;
                    default:
                        System.out.println("That is an invalid number. Please try again!");
                        break;
                }
                // -------------- Op 4 - Exit 

            } catch (Exception e) {
                System.out.println("That is not a number. Please try again!");
            }
        } while (!exit);
    }
}
