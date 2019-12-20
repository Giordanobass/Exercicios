package br.com.giordano.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import br.com.giordano.entities.Employee;
import br.com.giordano.entities.ImportedProduct;
import br.com.giordano.entities.Product;
import br.com.giordano.entities.UsedProduct;

public class Program2 {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		
		System.out.println("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used of imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("price: ");
			double price = sc.nextDouble();
			
			if(ch=='c') {
				list.add(new Product(name, price));
			}
			if(ch=='u') {
				System.out.print("Manufacture date (dd/mm/yyyy): ");
				Date manufactureDate = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, manufactureDate));
			}
			if(ch=='i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for(Product product: list) {
			System.out.println(product.priceTag());
		}
		sc.close();
	}

}
