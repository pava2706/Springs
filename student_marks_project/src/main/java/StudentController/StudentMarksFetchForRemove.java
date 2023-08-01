package StudentController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentDao.StudentMarksDao;
import studentDto.StudentMarks;

@WebServlet("/marksremove")
public class StudentMarksFetchForRemove extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		StudentMarksDao dao=new StudentMarksDao();
		List<StudentMarks> l1=dao.fetchAll();
		req.setAttribute("studentlist",l1);
	         RequestDispatcher rd=req.getRequestDispatcher("markscard2.jsp");
	         rd.forward(req, resp);
	         
	}
}
