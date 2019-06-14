package tyfanch.electivehelper.service.classroom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tyfanch.electivehelper.view.vo.ResultInfo;

public interface ClassroomService {
    ResultInfo findAll(HttpServletRequest request, HttpServletResponse response);
}
