package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entities.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		List<Seller> list = new ArrayList<Seller>();
				
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("==== Test 1: seller findById  ====");
		System.out.println("ID: 3");
		Seller seller1 = sellerDao.findById(3);
		System.out.println(seller1);
		System.out.println("======================");
		System.out.println();  
		
		
		System.out.println("==== test 2: seller findbyDepartment ===");
		Department dep = new Department(4,"Books");
		SellerDao sellerDao1 = DaoFactory.createSellerDao();
		System.out.println("Department Name: " + dep.getName());
		list = sellerDao1.findByDepartment(dep);
		list.sort((p1,p2) -> p1.getId().compareTo(p2.getId()));
		System.out.println("printing list");
		list.forEach(System.out::println);
		System.out.println("=====================");
		System.out.println();
		
		
		System.out.println("==== test 3: findAll ===");
		System.out.println("Dados ordenados"); 
		SellerDao sellerDao2 = DaoFactory.createSellerDao();
		list =sellerDao2.findAll();
		list.sort((p1,p2) -> p1.getId().compareTo(p2.getId()));
		list.forEach(System.out :: println);
		System.out.println();
		
		
		System.out.println("=== test 5: update seller ===");
		Seller seller = new Seller(8,"Lúcio","lwcios@gmail.com",sdf.parse("10/12/1979"),200.00,dep);
		DaoFactory.createSellerDao().update(seller);
		SellerDao sellerDao3 = DaoFactory.createSellerDao();
		list =sellerDao3.findAll();
		list.sort((p1,p2) -> p1.getId().compareTo(p2.getId()));
		list.forEach(System.out :: println);
		System.out.println();
		
		
		System.out.println("=== test 6 deletById ===");
		DaoFactory.createSellerDao().deleteById(7);
		SellerDao sellerDao4 =DaoFactory.createSellerDao();
		list = sellerDao4.findAll();
		list.sort((p1,p2) -> p1.getId().compareTo(p2.getId()));
		list.forEach(System.out :: println);
		
		
		System.out.println("=== teste 7 inser seller ====");
		Seller seller3 = new Seller(null,"Carmen", "carmen@gmail.com",sdf.parse("24/12/1986"), 2500.00, dep);
		DaoFactory.createSellerDao().insert(seller3);
		SellerDao sellerDao5 =DaoFactory.createSellerDao();
		list =sellerDao5.findAll();
		list.sort((p1,p2) -> p1.getId().compareTo(p2.getId()));
		list.forEach(System.out::println);
		
		
		
	}

}
