package com.crud.controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.Medicine;
import com.db.HibernateDatabseConnection;

@Controller
public class DashboardController {
	@RequestMapping("/dashboard")
	public String loadDashboard(Model m,HttpServletRequest req,HttpServletResponse res) throws IOException {
		if(req.getSession().getAttribute("username")==null){
			res.sendRedirect("login");
		}
		
		Session session = null;
		session = HibernateDatabseConnection.getSessionFactory().openSession();
		Query query2 = session.createQuery("FROM Medicine");
		List meds = ((org.hibernate.query.Query) query2).list();
		
		
		m.addAttribute("medicine_list",meds);
		//System.out.println(meds);

		return "view/dashboard.jsp";
	}
	
}
