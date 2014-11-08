package com.apokal.gestoman.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.apokal.gestoman.model.Supply;

/**
 * Responsible for writing data to the hard drive and loading it.
 * @author Alexander Stahl
 */
public class DataHandler {
	public static final String SUPPLY_DB_NAME = "supply";
	private static final String SQL_CREATE_SUPPLY_DB = 
			"CREATE TABLE supply (id INT AUTOINCREMENT PRIMARY KEY, sid INT NOT NULL, lid INT, amount DOUBLE, comment VARCHAR(10000), FOREIGN KEY(sid) REFERENCES substance(id), FOREIGN KEY(lid) REFERENCES location(id));";

	public static final String SUBSTANCE_DB_NAME = "substance";
	private static final String SQL_CREATE_SUBSTANCE_DB = 
			"CREATE TABLE substance (id INT AUTOINCREMENT PRIMARY KEY, name VARCHAR(50), hs BIT(7), ghs BIT(9), formula VARCHAR(50), meltingpoint DOUBLE,boilingpoint DOUBLE);";

	public static final String LOCATION_DB_NAME = "location";
	private static final String SQL_CREATE_LOCATION_DB = 
			"CREATE TABLE location (id INT AUTOINCREMENT PRIMARY KEY, name VARCHAR(59), temperature DOUBLE, pressure DOUBLE, comment VARCHAR(10000));";
		
	public final String DB_NAME = "database.db";
	private static DataHandler instance = null;
	private Connection conn;
	
	private DataHandler () {
		initializeDb();
	}
	
	/**
	 * Returns the instance of the Singleton class DataHandler.
	 * @return Actual instance of DataHandler
	 */
	public static DataHandler getInstance () {
		if (instance != null) {
			instance = new DataHandler();
		}
		return instance;
	}
	
	/**
	 * Connects the class to the database. Stores the connection reference in the attribute conn.
	 */
	public void dbConnect () {
		Connection c = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME);

			conn = c;
		} catch ( Exception e ) {
			conn = null;
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		
		System.out.println("Opened database successfully");
	}
	
	/**
	 * Closes the connection to the database.
	 */
	private void dbDisconnect () {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sends a SQL query to the database and returns the resulting output.
	 * @param query SQL query to use on the database
	 * @return Resulting output as a ResultSet object
	 */
	public ResultSet executeQuery (String query) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			st = null;
		}
		
		return rs;
	}
	
	/**
	 * Converts a given ResultSet into a human-readable String.
	 * @param rs ResultSet which is to be converted
	 * @return String which contains all data from the ResultSet as text
	 */
	public String ResultSetToString (ResultSet rs) {
		String s  = "";
		
		try {
			ResultSetMetaData md = rs.getMetaData();
			int n = md.getColumnCount();
			
			while (rs.next()) {
				for (int i = 0; i <= n; i++) {
					s += rs.getString(i);
				}
				s += String.format("%n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	/**
	 * Sets the DataHandler to a state, where he is ready to read and store data.
	 */
	private void initializeDb () {
		executeQuery(SQL_CREATE_SUBSTANCE_DB);
		executeQuery(SQL_CREATE_LOCATION_DB);
		executeQuery(SQL_CREATE_SUPPLY_DB);
	}

	/**
	 * Reads all supply database entries from the database and constructs Supply objects.
	 * @return ArrayList of all Supply objects.
	 */
	public ArrayList<Supply> fetchSupplies () {
		ArrayList<Supply> list = new ArrayList<Supply>();
		
		ResultSet rs = executeQuery ("SELECT * FROM supplies;");
		
		return null;
	}
	
	/**
	 * Loads a text file and returns the text.
	 * @param file Absolute path of a text file
	 * @return Content of the specified text file
	 * @deprecated Use database functions for data storing and reading instead.
	 */
	public static String loadAsString (String file) {
		String result = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = reader.readLine()) != null) {
				result += line + "\n";
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
