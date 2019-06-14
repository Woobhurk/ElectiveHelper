package tyfanch.electivehelper.service.uni_user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tyfanch.electivehelper.bean.UniUser;
import tyfanch.electivehelper.view.vo.ResultInfo;

public interface UniAccountService {
    ResultInfo login(HttpServletRequest request, HttpServletResponse response);

    ResultInfo findUserByUniUserId(HttpServletRequest request, HttpServletResponse response);

    ResultInfo findUniUserByUserId(HttpServletRequest request, HttpServletResponse response);

    boolean hasLogin(HttpServletRequest request, HttpServletResponse response);

    boolean hasLogin(UniUser uniUser);
}
