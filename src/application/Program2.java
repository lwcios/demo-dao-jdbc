package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		System.out.println("===findById ===");
		Department department = new Department();
		DepartmentDao department1 = DaoFactory.createDepartmentDao();
		department =department1.findById(5);
		System.out.println(department.toString());
		System.out.println();

	}

}
