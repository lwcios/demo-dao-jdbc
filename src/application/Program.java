package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Seller;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		List<Seller> list = new ArrayList<Seller>();
		List<Department> list2 = new ArrayList<>();
		Department dep = new Department(4,"Books");
		
		String controle ="cont";
		
		do {
			
			System.out.println("------Bem vindo ao menu de opções----- ");
			System.out.println("Escolha uma das opções abaixo");  
			System.out.println("Trabalhar com seller opcao: 1");
			System.out.println("Trabalhar com department opcao: 2");
			
			int valor = sc.nextInt();
			
			switch(valor) {
			//operações com o Seller 
			case 1:
				String str = "seller";
				
				int val = subMenu(str, sc);
				
				switch(val) {
				
				case 1:
					
					SellerDao sellerDao = DaoFactory.createSellerDao();
					System.out.println("==== Test 1: seller findById  ====");
					System.out.println("ID: 3");
					Seller seller1 = sellerDao.findById(3);
					System.out.println(seller1);
					System.out.println("======================");
					System.out.println();  
					
					break;
					
				case 2:
					
					System.out.println("==== test 2: findAll ===");
					System.out.println("Dados ordenados"); 
					SellerDao sellerDao2 = DaoFactory.createSellerDao();
					list =sellerDao2.findAll();
					list.sort((p1,p2) -> p1.getId().compareTo(p2.getId()));
					list.forEach(System.out :: println);
					System.out.println();
					
					
					break;
					
					
				case 3:
					System.out.println("=== test 6 deletById ===");
					DaoFactory.createSellerDao().deleteById(7);
					SellerDao sellerDao4 =DaoFactory.createSellerDao();
					list = sellerDao4.findAll();
					list.sort((p1,p2) -> p1.getId().compareTo(p2.getId()));
					list.forEach(System.out :: println);
					
					
					break;
					
				case 4:
					
					System.out.println("=== test 4: update seller ===");
					Seller seller = new Seller(8,"Lúcio","lwcios@gmail.com",sdf.parse("10/12/1979"),200.00,dep);
					DaoFactory.createSellerDao().update(seller);
					SellerDao sellerDao3 = DaoFactory.createSellerDao();
					list =sellerDao3.findAll();
					list.sort((p1,p2) -> p1.getId().compareTo(p2.getId()));
					list.forEach(System.out :: println);
					System.out.println();
					
					break;
					
					
				case 5:
					
					System.out.println("=== teste 5 inser seller ====");
					Seller seller3 = new Seller(null,"Carmen", "carmen@gmail.com",sdf.parse("24/12/1986"), 2500.00, dep);
					DaoFactory.createSellerDao().insert(seller3);
					SellerDao sellerDao5 =DaoFactory.createSellerDao();
					list =sellerDao5.findAll();
					list.sort((p1,p2) -> p1.getId().compareTo(p2.getId()));
					list.forEach(System.out::println);
					
					
					break;
					
				case 6:
					
					System.out.println("==== test 6: seller findbyDepartment ===");
					SellerDao sellerDao1 = DaoFactory.createSellerDao();
					System.out.println("Department Name: " + dep.getName());
					list = sellerDao1.findByDepartment(dep);
					list.sort((p1,p2) -> p1.getId().compareTo(p2.getId()));
					System.out.println("printing list");
					list.forEach(System.out::println);
					System.out.println("=====================");
					System.out.println();
					
					
					break;
					
					
					default :
							
				System.out.println("voltando ao menu principal"); 
				
				}
				
							
				break;
				
			case 2:
				//operações com department
				String str2 ="department";
				int val2 =subMenu(str2, sc);
				
				switch(val2) {
				
				case 1:
					
					System.out.println("=== test 1 findById ===");
					Department department = new Department();
					DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
					department =departmentDao.findById(2);
					System.out.println(department.toString());
					System.out.println();
					
					
					break;
					
					
				case 2:
					
					System.out.println("=== teste 2 findAll ===");
					
					DepartmentDao departmentDao2 =DaoFactory.createDepartmentDao();
					list2 = departmentDao2.findAll();
					list2.sort((p1,p2) -> p1.getId().compareTo(p2.getId()));
					list2.forEach(System.out::println);
					System.out.println();
					
					
					break;
					
				case 3:
					
					System.out.println(" === teste 5 delet by Id ===");
					DepartmentDao departmentDao5 =DaoFactory.createDepartmentDao();
					departmentDao5.deleteById(8);
					list2 =departmentDao5.findAll();
					list2.sort((p1,p2) -> p1.getId().compareTo(p2.getId()));
					list2.forEach(System.out :: println);
					System.out.println(); 
					
					
					break;
					
				case 4:
					System.out.println(" === test 4 Update department ===");
					Department department1 = new Department(6,"international trade");
					DepartmentDao departmentDao4  =DaoFactory.createDepartmentDao();
					departmentDao4.update(department1);
					list2 = departmentDao4.findAll();
					list2.sort((p1,p2) -> p1.getId().compareTo(p2.getId()));
					list2.forEach(System.out :: println);
					System.out.println();
					
					
					break;
					
				case 5:
					System.out.println("=== test 3 insert department ===");
					Department department3 = new Department(8,"dtftdg");
					DepartmentDao departmentDao3 =DaoFactory.createDepartmentDao();
					departmentDao3.insert(department3);
					list2 =departmentDao3.findAll();
					list2.sort((p1,p2) -> p1.getId().compareTo(p2.getId()));
					list2.forEach(System.out :: println);
					System.out.println();                 
				
						
					break;
					
					default :
						
						System.out.println("voltando ao menu principal");
					
				}
							
				break;
				
			
				default :
			 System.out.println("Nenhuma opcao valida selecionada ");  
			
			}
				
		
		System.out.println("para continuar digite qualquer coisa e para sair digite: exit");
		controle =sc.next(); 
		}while(!controle.equals("exit"));
		
		
		sc.close();
		
		
	}
	
	public static int subMenu(String str , Scanner scan) {
		
		int opc = 0;
		System.out.println("--SubMenu:"+str+"--");
		System.out.println("==== Test 1: find" + str + "ById  ====");
		System.out.println("==== Test 2:" + str + " findAll  ====");
		System.out.println("==== Test 3: delete" + str +" ById  ====");
		System.out.println("==== Test 4: Update" + str +  "====");
		System.out.println("==== Teste 5 insert" + str + "===");
		System.out.println("==== Test 6: seller findbyDepartment opcao somente para seller ===");
		opc =scan.nextInt();
		
		
		return opc;
		
	}

}
