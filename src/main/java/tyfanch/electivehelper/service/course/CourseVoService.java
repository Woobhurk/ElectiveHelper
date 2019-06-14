package tyfanch.electivehelper.service.course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tyfanch.electivehelper.view.vo.ResultInfo;

public interface CourseVoService {
    ResultInfo findAll(HttpServletRequest request, HttpServletResponse response);

    ResultInfo findByColumn(HttpServletRequest request, HttpServletResponse response);

    ResultInfo findByTeacherAndColumn(HttpServletRequest request, HttpServletResponse response);

    ResultInfo findByStudentAndColumn(HttpServletRequest request, HttpServletResponse response);
}
