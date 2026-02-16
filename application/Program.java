package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date clientBirthDate = sdf.parse(sc.next());
		
		Client client = new Client(clientName, clientEmail, clientBirthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next().toUpperCase());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		if (n <= 0) {
			System.out.print("Enter a valid quantity: ");
			n = sc.nextInt();
			sc.nextLine();
		}
		
		for (int i=0; i<n; i++) {
			
			System.out.println("Enter #" + (i+1) + " item data:");
			System.out.print("Prodct name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			if (productPrice <= 0) {
				System.out.print("Enter a valid price: ");
				productPrice = sc.nextDouble();
			}
			
			Product product = new Product(productName, productPrice);
		
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			sc.nextLine();
			
			if (productQuantity <= 0) {
				System.out.print("Enter a valid quantity: ");
				productQuantity = sc.nextInt();
			}
			
			OrderItem orderItem = new OrderItem(productQuantity, product);

			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
				
	}
}
