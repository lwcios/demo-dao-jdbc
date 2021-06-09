package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Seller;
import model.entities.Department;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat fds = new SimpleDateFormat("dd/MM/yyyy");
		Department obj = new Department(01, "Books");
		
		Seller seller =new Seller(02,"Carlos","carlos@gmail.com",fds.parse("09/06/2021") , 200.00, obj);
		
		
		
		System.out.println(seller.toString());
		
		
		
	}

}
