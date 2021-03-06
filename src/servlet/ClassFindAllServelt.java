package servlet;

import entity.Course;
import service.CourseService;
import service.Impl.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ClassFindAllServelt extends HttpServlet {
    private CourseService courseService = new CourseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        List<Course> courseServiceAll = courseService.findAll();
        req.setAttribute("courseServiceAll",courseServiceAll);
        Object user = req.getAttribute("user");
        req.setAttribute("user",user);
        req.getRequestDispatcher("classFindAllServlet.jsp").forward(req,resp);
    }
}
