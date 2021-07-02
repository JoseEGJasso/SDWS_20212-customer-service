package com.dws.costumerservice.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dws.costumerservice.dto.Customer;
import com.dws.costumerservice.dto.RespuestaApi;
import com.dws.costumerservice.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.getCustomers();
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerRepository.getCustomer(id);
	}

	@Override
	public RespuestaApi createCustomer(Customer cliente) {
		// TODO Auto-generated method stub
		return customerRepository.createCustomer(cliente);
	}

	@Override
	public RespuestaApi updateCustomer(int id, Customer cliente) {
		// TODO Auto-generated method stub
		return customerRepository.updateCustomer(id, cliente);
	}

	@Override
	public RespuestaApi deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return customerRepository.deleteCustomer(id);
	}

}
