package tyfanch.electivehelper.servlet;

import javax.servlet.annotation.WebServlet;
import tyfanch.electivehelper.service.uni_user.StudentAccountServiceImpl;
import tyfanch.electivehelper.service.uni_user.UniAccountService;
import tyfanch.electivehelper.service.uni_user.UniBizService;
import tyfanch.electivehelper.service.uni_user.UniBizServiceImpl;

@WebServlet(name = "StudentServlet", urlPatterns = {"/Student"})
public class StudentServlet extends UniUserServlet {
    @Override
    protected UniAccountService getUniAccountService() {
        return new StudentAccountServiceImpl();
    }

    @Override
    protected UniBizService getUniBizService() {
        return new UniBizServiceImpl();
    }
}
