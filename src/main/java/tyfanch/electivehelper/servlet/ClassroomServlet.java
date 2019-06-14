package tyfanch.electivehelper.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import tyfanch.electivehelper.service.classroom.ClassroomService;
import tyfanch.electivehelper.service.classroom.ClassroomServiceImpl;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.view.vo.ResultInfo;

@WebServlet(name = "ClassroomServlet", urlPatterns = {"/Classroom"})
public class ClassroomServlet extends CommonServlet {
    public void findAll(HttpServletRequest request, HttpServletResponse response) {
        ClassroomService classroomService = new ClassroomServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = classroomService.findAll(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
