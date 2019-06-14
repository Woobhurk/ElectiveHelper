package tyfanch.electivehelper.service.uni_user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tyfanch.electivehelper.view.vo.ResultInfo;

public interface UniBizService {
    ResultInfo findStudentsOfCourse(HttpServletRequest request, HttpServletResponse response);

    ResultInfo findByStudentAndCourse(HttpServletRequest request, HttpServletResponse response);

    boolean hasSelected(HttpServletRequest request, HttpServletResponse response);

    ResultInfo selectCourse(HttpServletRequest request, HttpServletResponse response);

    ResultInfo deselectCourse(HttpServletRequest request, HttpServletResponse response);
}
