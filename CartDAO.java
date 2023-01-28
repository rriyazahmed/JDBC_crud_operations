package com.ty.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.sql.Connection;
//import java.sql.Driver;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;

import com.ty.dto.CartDTO;

public class CartDAO {

	public String insertCart(int id, String email, String username, String password, String address) {

		try {
			// 1. Load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2.Establish the connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud_using_jdk11",
					"root", "root");
			// 3.prepare statement
			PreparedStatement ps = connection.prepareStatement("INSERT INTO cart VALUES(?,?,?,?,?)");

			ps.setInt(1, id);
			ps.setString(2, email);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.setString(5, address);
			ps.executeUpdate();
			System.out.println("saved");
			connection.close();

		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return "saved";
	}

	public CartDTO updateCart(CartDTO cart) {
//		 CartDTO cart=new CartDTO();

		try {
			// 1.Load and register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud_using_jdk11",
					"root", "root");
			// 3.prepare statement
			PreparedStatement ps = connection
					.prepareStatement("UPDATE cart set address=?, email=?, password=?, username=? where id=?");
			// CartDTO cart = new CartDTO();
			ps.setString(1, cart.getAddress());
			ps.setString(2, cart.getEmail());
			ps.setString(3, cart.getPassword());
			ps.setString(4, cart.getUsername());
			ps.setInt(5, cart.getId());
			int rows = ps.executeUpdate();
			if (rows == 1) {
				return cart;
			}

			// 5.Close the connection
			connection.close();
		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}

		return null;
	}

	public String deleteCart(int id) {

		try {
			// 1.Load and register driver
			// Class.forName("com.mysql.cj.jdbc.Driver");
			Driver d = new com.mysql.cj.jdbc.Driver();
			// 2.Establish the connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud_using_jdk11",
					"root", "root");
			PreparedStatement ps = connection.prepareStatement("Delete from cart where id=?");
			ps.setInt(1, id);
			ps.execute();
			// 5.Close the connection
			connection.close();
		}
		/*
		 * } catch (ClassNotFoundException e) { // // TODO Auto-generated catch block //
		 * e.printStackTrace(); }
		 */
		catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
		}
		return "deleted";

	}

	public CartDTO getCart(int id) {
		Connection connection = null;
		try {
			// 1.Load and register driver
			// Class.forName("com.mysql.cj.jdbc.Driver");
			Driver d = new com.mysql.cj.jdbc.Driver();
			// 2.Establish the connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud_using_jdk11", "root",
					"root");
			PreparedStatement ps = connection.prepareStatement("Select * from cart where id=?");
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery();
			if (res != null) {
				CartDTO cart = new CartDTO();
				while (res.next()) {
					cart.setId(res.getInt(1));
					cart.setEmail(res.getString(2));
					cart.setAddress(res.getString(3));
					cart.setUsername(res.getString(4));
					cart.setPassword(res.getString(5));
					return cart;
				}

			}
		}

		catch (SQLException ex) {
		} finally {
			try {

				// 5.Close the connection
				connection.close();
			} catch (SQLException e) {
			}
		}
		return null;

	}

	public List<CartDTO> getAllCart() {
		Connection connection = null;
		try {
			// 1.Load and register driver
			// Class.forName("com.mysql.cj.jdbc.Driver");
			Driver d = new com.mysql.cj.jdbc.Driver();
			// 2.Establish the connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud_using_jdk11", "root",
					"root");
			PreparedStatement ps = connection.prepareStatement("Select * from cart");

			ResultSet res = ps.executeQuery();
			List<CartDTO> lc = new ArrayList<>();
			if (res != null) {
				CartDTO cart = new CartDTO();
				while (res.next()) {
					cart.setId(res.getInt(1));
					cart.setEmail(res.getString(2));
					cart.setAddress(res.getString(3));
					cart.setUsername(res.getString(4));
					cart.setPassword(res.getString(5));
					lc.add(cart);
				}
				return lc;
			}
		}

		catch (SQLException ex) {
		} finally {
			try {
				// 5.Close the connection
				connection.close();
			} catch (SQLException e) {
			}
		}
		return null;

	}

}
