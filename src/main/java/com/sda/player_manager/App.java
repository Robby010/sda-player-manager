package com.sda.player_manager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
	private static final Logger log = LogManager.getLogger(App.class);
	
	private static final String dbUrl = "jdbc:mysql://192.168.1.106:3306/players?&serverTimezone=EST5EDT";
		private static final String dbUser = "appuser";
		private static final String dbPass = "n3wP4$$";
	
    public static void main( String[] args )
    {
    	if(log.isDebugEnabled()) {
    	log.debug("main(): IN: ");
    	}
    	
        System.out.println( "Hello World!" );
        
        App app = new App();
        app.parseAllPlayers();
        
        if(log.isDebugEnabled()) {
        log.debug("main():OUT:");
        }
    }
    
    
    public void parseAllPlayers() {
    	if(log.isDebugEnabled()) {
    		log.debug("parseAllPlayers():IN");
    	}
    	
    	
    	try {
			Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from players.players where id > 1");
			while(rs.next()) {
			 int id = rs.getInt("id");
			 String accountName = rs.getString("account_name");
			 String firstName = rs.getString("first_name");
			 String lastName = rs.getString("last_name");
			 Timestamp birthDate = rs.getTimestamp("birth_date");
			 
			 log.info("Players: " +id + "," + accountName + "," + firstName + "," + lastName + "," + birthDate + ",");
			}
			
		} catch (SQLException e) {
			log.error("Excepton while parsing players: " + e.getMessage(), e);
			
		}finally {
			
		}
			
		
    	if(log.isDebugEnabled()) {
    		log.debug("parseAllPlayers():OUT");
    	}
    	
    }
}
