package tyfanch.electivehelper.service.course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import tyfanch.electivehelper.bean.UniUser;
import tyfanch.electivehelper.view.vo.ResultInfo;

public interface CourseService {
    ResultInfo findAll(HttpServletRequest request, HttpServletResponse response);

    ResultInfo findByTeacher(HttpServletRequest request, HttpServletResponse response);

    ResultInfo findByStudent(HttpServletRequest request, HttpServletResponse response);

    ResultInfo findTeacherKeywords(HttpServletRequest request, HttpServletResponse response);

    ResultInfo findStudentKeywords(HttpServletRequest request, HttpServletResponse response);

    List<String> findTeacherKeywords(UniUser uniUser);

    List<String> findStudentKeywords(UniUser uniUser);

    ResultInfo save(HttpServletRequest request, HttpServletResponse response);

    ResultInfo update(HttpServletRequest request, HttpServletResponse response);

    ResultInfo deleteById(HttpServletRequest request, HttpServletResponse response);
}
