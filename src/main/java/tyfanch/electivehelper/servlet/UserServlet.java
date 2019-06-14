package tyfanch.electivehelper.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Objects;
import tyfanch.electivehelper.service.user.AccountService;
import tyfanch.electivehelper.service.user.CommonAccountServiceImpl;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.view.vo.ResultInfo;
import tyfanch.electivehelper.view.vo.ResultInfoConst;

@WebServlet(name = "UserServlet", urlPatterns = {"/User"})
public class UserServlet extends CommonServlet {
    /**
     * 用户登录
     *
     * @param request 请求
     * @param response 响应
     */
    public void login(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        AccountService accountService = new CommonAccountServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            // 登录
            resultInfo = accountService.login(request, response);
            // 将登录结果转换成json返回给前端
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loginByIdAndPassword(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        AccountService accountService = new CommonAccountServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            // 登录
            resultInfo = accountService.loginByIdAndPassword(request, response);
            // 将登录结果转换成json返回给前端
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 用户注册
     *
     * @param request 请求
     * @param response 响应
     */
    public void reg(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        AccountService accountService = new CommonAccountServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            // 注册
            resultInfo = accountService.reg(request, response);
            // 将注册结果转换成json返回给前端
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        AccountService accountService = new CommonAccountServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            // 注册
            resultInfo = accountService.update(request, response);
            // 将注册结果转换成json返回给前端
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void isUsernameExist(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        AccountService accountService = new CommonAccountServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            // 注册
            resultInfo = accountService.isUsernameExist(request, response);
            // 将注册结果转换成json返回给前端
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void isEmailExist(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        AccountService accountService = new CommonAccountServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            // 注册
            resultInfo = accountService.isEmailExist(request, response);
            // 将注册结果转换成json返回给前端
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断用户是否登录
     *
     * @param request 请求
     * @param response 响应
     */
    public void hasLogin(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        AccountService accountService = new CommonAccountServiceImpl();
        ResultInfo resultInfo = new ResultInfo();
        String resultInfoJson;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;
        PrintWriter writer;

        try {
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = accountService.hasLogin(request, response);
            resultInfo.setSuccess(success);
            resultInfo.setResultCode(resultCode);
            resultInfo.setResultMsg(resultMsg);
            resultInfo.setResultData(resultData);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
