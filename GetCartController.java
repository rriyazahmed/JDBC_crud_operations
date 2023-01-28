package com.ty.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.CartDTO;

public class GetCartController {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("To fetch a perticular cart details: enter 1 \nTo fetch all the inserted carts: enter 2 ");
		int yourChoice = sc.nextInt();
		if (yourChoice == 1) {

			CartDAO cdao = new CartDAO();

			System.out.println("enter the id ");
			int id = sc.nextInt();

			CartDTO result = cdao.getCart(id);
			System.out.println("Fetched selected cart details successfully");
			System.out.println(result);
		} else if (yourChoice == 2) {
			CartDAO cdao = new CartDAO();

			List<CartDTO> result = cdao.getAllCart();
			System.out.println("Successfully Fetched all available carts details ");
			System.out.println(result);

		} else {
			System.out.println("Oops....please try again with a valid input");

		}

	}

}
