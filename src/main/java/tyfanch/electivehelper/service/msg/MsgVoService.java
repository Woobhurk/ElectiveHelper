package tyfanch.electivehelper.service.msg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tyfanch.electivehelper.view.vo.ResultInfo;

public interface MsgVoService {
    ResultInfo findBySender(HttpServletRequest request, HttpServletResponse response);

    ResultInfo findByReceiver(HttpServletRequest request, HttpServletResponse response);

    ResultInfo findBySingle(HttpServletRequest request, HttpServletResponse response);

    ResultInfo findByPaired(HttpServletRequest request, HttpServletResponse response);
}
