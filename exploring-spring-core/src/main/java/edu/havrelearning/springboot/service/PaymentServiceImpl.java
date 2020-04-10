package edu.havrelearning.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.havrelearning.springboot.dao.PaymentDAO;



@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentDAO dao;
	
	public PaymentDAO getDao() { return dao; }
	public void setDAO(PaymentDAO dao) { this.dao = dao; }

}
