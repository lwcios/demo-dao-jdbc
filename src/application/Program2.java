package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		System.out.println("=== test 1 findById ===");
		Department department = new Department();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		department =departmentDao.findById(2);
		System.out.println(department.toString());
		System.out.println();
		
		
		
		System.out.println("=== teste 2 findAll ===");
		List<Department> list = new ArrayList<>();
		DepartmentDao departmentDao2 =DaoFactory.createDepartmentDao();
		list = departmentDao2.findAll();
		list.sort((p1,p2) -> p1.getId().compareTo(p2.getId()));
		list.forEach(System.out::println);
		System.out.println();
		
		
		
		System.out.println("=== test 3 insert department ===");
		Department department3 = new Department(7,"Ecommerce");
		DepartmentDao departmentDao3 =DaoFactory.createDepartmentDao();
		departmentDao3.insert(department3);
		list =departmentDao3.findAll();
		list.sort((p1,p2) -> p1.getId().compareTo(p2.getId()));
		list.forEach(System.out :: println);
		System.out.println();
	

	}

}
