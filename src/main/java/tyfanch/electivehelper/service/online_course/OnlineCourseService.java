package tyfanch.electivehelper.service.online_course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tyfanch.electivehelper.view.vo.ResultInfo;

public interface OnlineCourseService {
    ResultInfo findAll(HttpServletRequest request, HttpServletResponse response);

    ResultInfo findByInterest(HttpServletRequest request, HttpServletResponse response);

    ResultInfo findByKeywords(HttpServletRequest request, HttpServletResponse response);
}
