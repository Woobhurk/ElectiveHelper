package tyfanch.electivehelper.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tyfanch.electivehelper.bean.User;
import tyfanch.electivehelper.view.vo.ResultInfo;

/**
 * 用户账号业务
 */
public interface AccountService {
    /**
     * 用户登录
     *
     * @param request 请求
     * @param response 响应
     * @return 返回登录结果，封装成响应数据
     */
    ResultInfo login(HttpServletRequest request, HttpServletResponse response);

    ResultInfo loginByIdAndPassword(HttpServletRequest request, HttpServletResponse response);

    /**
     * 用户注册
     *
     * @param request 请求
     * @param response 响应
     * @return 返回注册结果，封装成响应数据
     */
    ResultInfo reg(HttpServletRequest request, HttpServletResponse response);

    ResultInfo update(HttpServletRequest request, HttpServletResponse response);

    ResultInfo isUsernameExist(HttpServletRequest request, HttpServletResponse response);

    ResultInfo isEmailExist(HttpServletRequest request, HttpServletResponse response);

    /**
     * 判断用户是否登录
     *
     * @param request 请求
     * @param response 响应
     * @return 是否登录
     */
    boolean hasLogin(HttpServletRequest request, HttpServletResponse response);

    /**
     * 判断用户是否登录
     *
     * @param user 用户
     * @return 是否登录
     */
    boolean hasLogin(User user);
}
