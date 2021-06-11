package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;

public class Program {

	public static void main(String[] args) throws ParseException {
		
				
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("==== Test 1: seller findById  ====");
		Seller seller1 = sellerDao.findById(3);
		System.out.println(seller1);
		System.out.println("======================");
		
		
		
		
		
		
		
	}

}
