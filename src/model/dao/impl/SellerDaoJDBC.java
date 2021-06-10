package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import entities.Seller;
import model.dao.SellerDao;

public class SellerDaoJDBC implements SellerDao {

	SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
	@Override
	public void insert(Seller seller) {
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DB.getConnection();
			conn.setAutoCommit(false);
			
			Seller sellerDao = seller;
			
			pst = conn.prepareStatement("INSERT INTO seller "
					+"(Name,Email,BithDate,BaseSalary,DepatmentId)"
					+"VALUES"
					+ "(?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS );
			//transformando data em string
			String data =sdf.format(( sellerDao.getBirthDate()));
			
			pst.setString(1,sellerDao.getName());
			pst.setString(2,sellerDao.getEmail());
			
			//inserindo a data no db
			try {
				pst.setDate(3, new java.sql.Date(sdf.parse(data).getTime()));
			} catch (ParseException e) {
				throw new DbException(e.getMessage());	
			}
			
			pst.setDouble(3,sellerDao.getBaseSalary() );
			pst.setInt(5, sellerDao.getDepartment().getId());
			
			
			conn.commit();
			
		  int ArrowsAffected = pst.executeUpdate();
		  System.out.println("Arrows Effected " + ArrowsAffected);
		  
		}catch(SQLException e) {
			
			try {
				conn.rollback();
				throw new DbIntegrityException("Process Error caused by "+ e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error rolling back cused by" + e1.getMessage() );
				
			}
			
			
		}finally {
			DB.closeStatement(pst);
			DB.closeConnection();
			
		}
		
	}

	@Override
	public void update(Seller seller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
