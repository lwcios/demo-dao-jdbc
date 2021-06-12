package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import entities.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		List<Seller> list = new ArrayList<Seller>();
				
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("==== Test 1: seller findById  ====");
		Seller seller1 = sellerDao.findById(3);
		System.out.println(seller1);
		System.out.println("======================");
		
		
		
		System.out.println("==== test 2: seller findbyDepartment ===");
		Department dep = new Department(4,"Books");
		SellerDao sellerDao1 = DaoFactory.createSellerDao();
		list = sellerDao1.findByDepartment(dep);
		System.out.println("printing list");
		list.forEach(System.out::println);
		System.out.println("=====================");
		
		
		
		System.out.println("==== test 3: findAll ===");
		SellerDao sellerDao2 = DaoFactory.createSellerDao();
		list =sellerDao2.findAll();
		list.forEach(System.out :: println);
		
		
		
		
		
		
	}

}
