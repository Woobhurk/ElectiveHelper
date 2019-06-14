package tyfanch.electivehelper.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "CommonServlet")
public class CommonServlet extends HttpServlet {
    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        Class aClass = this.getClass();
        Method method;
        String action;

        //request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain; charset=utf-8");

        action = request.getParameter("action");

        if (action != null && !action.isEmpty()) {
            try {
                method = aClass.getMethod(action, HttpServletRequest.class,
                    HttpServletResponse.class);
                method.invoke(this, request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        this.doPost(request, response);
    }
}
