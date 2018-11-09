package com.fdmgroup.servlet;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.DAO.UserDao;
import com.fdmgroup.Entities.User;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("website");
		UserDao uDao = new UserDao(emf);
		User expected = uDao.get(username);
		
		//better to call a register service class here
		RequestDispatcher rb = null;
		
		if (expected != null) {
			
			rb = req.getRequestDispatcher("register.jsp");
			
			req.setAttribute("fail_msg", "username already exists!");
		
		}else if (!password.equals(password.toLowerCase()) && 
				!password.equals(password.toUpperCase()) && 
				password.matches(".*\\d.*") && 
				!password.matches("[a-zA-Z0-9 ]*") &&
				password.length() >= 8) {
			
			rb = req.getRequestDispatcher("login.jsp");
			
			User newUser = new User();
			newUser.setUsername(username);
			newUser.setPassword(password);
			
			uDao.add(newUser);
			req.setAttribute("success_msg", "You have sucessfully registered, please now login.");
		
		}else {
			
			String failMsg = "Your password should contain ";
			int wrongTime = 0;
			
			if(password.equals(password.toLowerCase())) {
				
				if (wrongTime != 0) {
					
					failMsg += ", ";
				}
				failMsg += "at least ONE uppercase letter";
				wrongTime++;
			}
			
			if(password.equals(password.toUpperCase())) {
				
				if (wrongTime != 0) {
					
					failMsg += ", ";
				}
				
				failMsg += "at least ONE lowercase letter";
				wrongTime++;
			}
			
			if(!password.matches(".*\\d.*")) {

				if (wrongTime != 0) {
					
					failMsg += ", ";
				}
				
				failMsg += "at least ONE number";
				wrongTime++;
			}
			
			if(password.matches("[a-zA-Z0-9 ]*")) {
				
				if (wrongTime != 0) {
					
					failMsg += ", ";
				}
				
				failMsg += "at least ONE special symbol";
				wrongTime++;
			}
			
			if(password.length() < 8) {

				if (wrongTime != 0) {
					
					failMsg += ", ";
				}
				
				failMsg += "at least EIGHT characters";
			}
			failMsg += ".";
			
			rb = req.getRequestDispatcher("register.jsp");
			
			req.setAttribute("fail_msg", failMsg);
		}
		rb.forward(req, resp);
	}
}
