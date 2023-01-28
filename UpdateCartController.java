package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.CartDTO;

public class UpdateCartController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		CartDTO cdto = new CartDTO();
		CartDAO cdao = new CartDAO();

		System.out.println("enter the id ");
		int id = sc.nextInt();
		System.out.println("enter the new address");
		String address = sc.next();
		System.out.println(("enter new email"));
		String email = sc.next();
		System.out.println(("enter new password"));
		String password = sc.next();
		System.out.println("enter new username");
		String username = sc.next();

		cdto.setId(id);
		cdto.setAddress(address);
		cdto.setEmail(email);
		cdto.setPassword(password);
		cdto.setUsername(username);

		CartDTO result = cdao.updateCart(cdto);
		System.out.println("UPDATED");

	}

}
