package tyfanch.electivehelper.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import tyfanch.electivehelper.service.course.CourseService;
import tyfanch.electivehelper.service.course.CourseServiceImpl;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.view.vo.ResultInfo;

@WebServlet(name = "CourseServlet", urlPatterns = {"/Course"})
public class CourseServlet extends CommonServlet {
    public void findAll(HttpServletRequest request, HttpServletResponse response) {
        CourseService courseService = new CourseServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = courseService.findAll(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findByTeacher(HttpServletRequest request, HttpServletResponse response) {
        CourseService courseService = new CourseServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = courseService.findByTeacher(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findByStudent(HttpServletRequest request, HttpServletResponse response) {
        CourseService courseService = new CourseServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = courseService.findByStudent(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(HttpServletRequest request, HttpServletResponse response) {
        CourseService courseService = new CourseServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = courseService.save(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response) {
        CourseService courseService = new CourseServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = courseService.update(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) {
        CourseService courseService = new CourseServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = courseService.deleteById(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
