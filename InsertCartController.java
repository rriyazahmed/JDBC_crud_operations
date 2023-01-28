package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDAO;

public class InsertCartController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CartDAO cdao = new CartDAO();
		System.out.println("enter the id ");
		int id = sc.nextInt();
		System.out.println("enter the email ");
		String email = sc.next();
		System.out.println("enter the username  ");
		String username = sc.next();
		System.out.println("enter the password ");
		String password = sc.next();
		System.out.println("enter the address ");
		String address = sc.next();
		String result = cdao.insertCart(id, email, username, password, address);
		System.out.println("INSERTED");
	}
}
