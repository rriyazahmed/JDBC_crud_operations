package com.ty.controller;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.CartDTO;

public class DeleteCartController {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		CartDTO cdto = new CartDTO();
		CartDAO cdao = new CartDAO();

		System.out.println("enter the id ");
		int id = sc.nextInt();

		String result = cdao.deleteCart(id);
		System.out.println("DELETED");

	}

}
