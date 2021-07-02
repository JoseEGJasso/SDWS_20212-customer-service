package com.dws.costumerservice.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dws.costumerservice.dto.Customer;
import com.dws.costumerservice.dto.Region;
import com.dws.costumerservice.dto.RespuestaApi;

@Repository
public class CustomerRepository {
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	public List<Customer> getCustomers(){
		List<Customer> customers = new ArrayList<>();
		String consulta = "SELECT * FROM customer c, region r WHERE c.id_region = r.id;";
		customers = jdbctemplate.query(consulta, new RowMapper<Customer>() {
			
			@Override
			public Customer mapRow(ResultSet rs, int rownum) throws SQLException {
				Customer customer = new Customer();
				
				customer.setId(rs.getInt(1));
				customer.setNombre(rs.getString(2));
				customer.setApellidos(rs.getString(3));
				customer.setRfc(rs.getString(4));
				customer.setCorreo(rs.getString(5));
				
				Region region = new Region();
				region.setId(rs.getInt(7));
				region.setRegion(rs.getString(8));
				
				customer.setRegion(region);
				
				return customer; 
			}

		});
		return customers;
	}
	
	public Customer getCustomer(int id){
		Customer customer = new Customer();
		String consulta = "SELECT * FROM customer c, region r WHERE c.id_region = r.id AND c.id = " + id + ";";
		customer = jdbctemplate.queryForObject(consulta, new RowMapper<Customer>() {
			
			@Override
			public Customer mapRow(ResultSet rs, int rownum) throws SQLException {
				Customer customer = new Customer();
				
				customer.setId(rs.getInt(1));
				customer.setNombre(rs.getString(2));
				customer.setApellidos(rs.getString(3));
				customer.setRfc(rs.getString(4));
				customer.setCorreo(rs.getString(5));
				
				Region region = new Region();
				region.setId(rs.getInt(7));
				region.setRegion(rs.getString(8));
				
				customer.setRegion(region);
				
				return customer; 
			}

		});
		return customer;
	}
	
	public RespuestaApi createCustomer(Customer customer){
		String consulta = "INSERT INTO customer (nombre, apellidos, rfc, correo, id_region) VALUES(" 
				+ "'" + customer.getNombre() + "',"
				+ "'" + customer.getApellidos() + "',"
				+ "'" + customer.getRfc() + "',"
				+ "'" + customer.getCorreo() + "',"
				+ customer.getRegion().getId() + ");";
		
		jdbctemplate.update(consulta);
		
		RespuestaApi msg = new RespuestaApi();
		msg.setMessage("El cliente ha sido registrado");
		
		return msg;
	}
	
	public RespuestaApi updateCustomer(int id, Customer customer){
		String consulta = "UPDATE customer SET " 
				+ "nombre = '" + customer.getNombre() + "',"
				+ "apellidos = '" + customer.getApellidos() + "',"
				+ "rfc = '" + customer.getRfc() + "',"
				+ "correo = '" + customer.getCorreo() + "',"
				+ "id_region = " + customer.getRegion().getId() + " "
				+ "WHERE id = " + id +";";
		
		jdbctemplate.update(consulta);
		
		RespuestaApi msg = new RespuestaApi();
		msg.setMessage("El cliente ha sido actualizado");
		
		return msg;
	}
	
	public RespuestaApi deleteCustomer(int id){
		String consulta = "DELETE FROM customer WHERE id = " + id + ";";
		
		jdbctemplate.update(consulta);
		
		RespuestaApi msg = new RespuestaApi();
		msg.setMessage("El cliente ha sido eliminado");
		
		return msg;
	}
}
