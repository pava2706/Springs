package StudentController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentDao.StudentMarksDao;
import studentDto.StudentMarks;


@WebServlet("/login")
public class StudentMarksFetchByID extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		String regno = req.getParameter("regno");
		//int regno = Integer.parseInt(reg);
		String dob = req.getParameter("dob");

		StudentMarksDao dao=new StudentMarksDao();
		StudentMarks d1 = dao.login(regno);
		if (d1 != null) {
			if (d1.getDate_of_Birth().equals(dob)) {
				req.setAttribute("studentmarks",d1);
		         RequestDispatcher rd=req.getRequestDispatcher("studentmarkscard.jsp");
		         rd.forward(req, resp);
		         
				
			} else {
				resp.getWriter().print("<h1> Invalid Details</h1>");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
				dispatcher.include(req, resp);
			}
		}
	}
}
