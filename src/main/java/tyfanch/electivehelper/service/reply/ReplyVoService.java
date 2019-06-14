package tyfanch.electivehelper.service.reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tyfanch.electivehelper.view.vo.ResultInfo;

public interface ReplyVoService {
    ResultInfo findByCourse(HttpServletRequest request, HttpServletResponse response);

    ResultInfo findBySender(HttpServletRequest request, HttpServletResponse response);

    ResultInfo findByReplyTo(HttpServletRequest request, HttpServletResponse response);

}
