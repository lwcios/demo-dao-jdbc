package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;
	private PreparedStatement pst =null;
	private ResultSet rs = null;
	
	//criando a injeçao de dependencia da conexão através do construtor 
	public DepartmentDaoJDBC(Connection connection) {
		this.conn = connection;
	}

	
	
	
	@Override
	public void insert(Department department) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Department findById(Integer id) {
	    
		try {
			Department department = new Department();
			conn =DB.getConnection();
			pst =conn.prepareStatement("SELECT *FROM  department WHERE Id = ? ");
			pst.setInt(1, id);
			
			rs =pst.executeQuery();
			if(rs.next()) {
				department.setId(rs.getInt("Id"));
				department.setName(rs.getString("Name"));
				return department;
			}else {
				
				throw new DbException("Department no exist:");
			}
			
			
		}catch(SQLException e) {
			
			throw new DbException("Error caused by: " + e.getMessage()); 
		}finally {
			
			DB.closeResultSet(rs);
			DB.closeStatement(pst);
		}
		
		
		
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
