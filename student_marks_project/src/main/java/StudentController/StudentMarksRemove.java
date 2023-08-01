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




@WebServlet("/delete")
public class StudentMarksRemove extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String cid=req.getParameter("id");
		//int cid=Integer.parseInt(id);
		
		StudentMarksDao dao=new StudentMarksDao();
		dao.remove(cid);
		 List<StudentMarks> l1 =dao.fetchAll();
		 req.setAttribute("studentlist",l1 );
		 resp.getWriter().print("<h1>Data is deleted sucessfully......</h1>");
		 
		RequestDispatcher dispatcher=req.getRequestDispatcher("markscard.jsp");
		dispatcher.include(req, resp);
	}
}
