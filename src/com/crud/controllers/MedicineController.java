package com.crud.controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.Medicine;
import com.db.HibernateDatabseConnection;

@Controller
public class MedicineController {

	@RequestMapping("/add_medicine")
	public String getAddMedicineForm() {
		return "view/medicine_add_form.jsp";
	}
	
	@RequestMapping(value="add_medicine_action",method=RequestMethod.POST)
	public void addMedicine(HttpServletResponse res, 
			@ModelAttribute("medicine") Medicine meds) throws IOException {
		
		System.out.println(meds.getName());
		
		Session session = null;
		session=HibernateDatabseConnection.getSessionFactory().openSession();
		
		Transaction t=session.beginTransaction();
		session.save(meds);
		t.commit();
		
		res.sendRedirect("dashboard");
	}
	
	@RequestMapping(value="edit_medicine_action",method=RequestMethod.POST)
	public void editMedicine(HttpServletResponse res, 
			@ModelAttribute("medicine") Medicine meds) throws IOException {
		
		Session session = null;
		session=HibernateDatabseConnection.getSessionFactory().openSession();
		
		Transaction t=session.beginTransaction();
		session.saveOrUpdate(meds);
		t.commit();
		
		res.sendRedirect("dashboard");
	}
	
	@RequestMapping("/delete")
	public void deleteUser(HttpServletResponse res,
			@RequestParam("id") int id) throws IOException{
		
		Session session = null;
		session=HibernateDatabseConnection.getSessionFactory().openSession();
		
		Transaction t=session.beginTransaction();
		
		Medicine m=new Medicine();
		m.setId(id);
		
		session.delete(m);
		
		t.commit();
		
		res.sendRedirect("dashboard");
	}
	
	@RequestMapping("/edit")
	public String getEditForm(HttpServletResponse res,
			Model m,
			@RequestParam("id") int id) throws IOException{

		Session session=null;
		session = HibernateDatabseConnection.getSessionFactory().openSession();
		Query query2 = session.createQuery("FROM Medicine WHERE id=:id");
	    query2.setParameter("id",id);
		
	    Medicine m_object=(Medicine)query2.getSingleResult();
	    
		m.addAttribute("medicine",m_object);
		return "view/medicine_edit_form.jsp";
	}
}
