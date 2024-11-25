package com.automation.actions;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnectionActions {

	private String username;
	private String password;
	private String url;

	public DBConnectionActions() {
		this.username = "admin";
		this.password = "admin";
		this.url = "jdbc:mysql://localhost:3306/DBA";
	}

	public List<String> executeQuery(String query) {
		List<String> results = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
				while (rs.next()) {
					results.add(rs.getString(1));
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}

	public List<String> executeQueryAndReturnResult(String query, String columnName) {
		List<String> results = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
				while (rs.next()) {
					results.add(rs.getString(columnName));
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}
}
