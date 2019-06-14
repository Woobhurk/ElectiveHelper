package tyfanch.electivehelper.servlet;

import javax.servlet.annotation.WebServlet;
import tyfanch.electivehelper.service.uni_user.TeacherAccountServiceImpl;
import tyfanch.electivehelper.service.uni_user.UniAccountService;
import tyfanch.electivehelper.service.uni_user.UniBizService;
import tyfanch.electivehelper.service.uni_user.UniBizServiceImpl;

@WebServlet(name = "TeacherServlet", urlPatterns = {"/Teacher"})
public class TeacherServlet extends UniUserServlet {
    @Override
    protected UniAccountService getUniAccountService() {
        return new TeacherAccountServiceImpl();
    }

    @Override
    protected UniBizService getUniBizService() {
        return new UniBizServiceImpl();
    }
}
