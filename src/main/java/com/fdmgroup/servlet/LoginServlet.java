package com.fdmgroup.servlet;

import java.io.IOException;
import java.util.Random;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.DAO.UserDao;
import com.fdmgroup.Entities.User;

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//req.setAttribute("lucky_number", new int[] {1, 2, 3, 4});
		
		String[] gemArr = {"Diamond", "Carbonado", "Morganite", "Jade", "Zircon", 
							"Amethyst", "Benitoite", "Neptunite", "Rutile", "Obsidian",
							"Alexandrite", "Euclase", "Peridot", "Antarcticite", "Sphene", 
							"Sapphire", "Ruby", "Tourmaline", "Cinnabar", "Phosphophyllite"};
		
		Random r = new Random();
		int randomInt = r.nextInt(20);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("website");
		UserDao uDao = new UserDao(emf);
		User expected = uDao.get(username);
		
		//better to call a login service class here
		RequestDispatcher rb = null;
		if (expected == null) {
			
			rb = req.getRequestDispatcher("login.jsp");
			req.setAttribute("fail_msg", "invaild username");
			
		}else if (!password.equals(expected.getPassword())) {
			
			rb = req.getRequestDispatcher("login.jsp");
			req.setAttribute("fail_msg", "invaild password");
		}
		
		else {
			
			req.setAttribute("lucky_gem", gemArr[randomInt]);
			rb = req.getRequestDispatcher("home.jsp");
			
			//remember user during the entire session
			HttpSession session = req.getSession();
			session.setAttribute("active_user", username);
		}
		rb.forward(req, resp);
	}
	
	
}
