package tyfanch.electivehelper.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import tyfanch.electivehelper.service.online_course.OnlineCourseService;
import tyfanch.electivehelper.service.online_course.OnlineCourseServiceImpl;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.view.vo.ResultInfo;

@WebServlet(urlPatterns = {"/OnlineCourse"})
public class OnlineCourseServlet extends CommonServlet {
    public void findAll(HttpServletRequest request, HttpServletResponse response) {
        OnlineCourseService onlineCourseService = new OnlineCourseServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = onlineCourseService.findAll(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findByInterest(HttpServletRequest request, HttpServletResponse response) {
        OnlineCourseService onlineCourseService = new OnlineCourseServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = onlineCourseService.findByInterest(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findByKeywords(HttpServletRequest request, HttpServletResponse response) {
        OnlineCourseService onlineCourseService = new OnlineCourseServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = onlineCourseService.findByKeywords(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
