package tyfanch.electivehelper.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Objects;
import tyfanch.electivehelper.service.user.AccountService;
import tyfanch.electivehelper.service.user.AdminAccountServiceImpl;
import tyfanch.electivehelper.service.user.AdminBizService;
import tyfanch.electivehelper.service.user.AdminBizServiceImpl;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.view.vo.ResultInfo;

@WebServlet(name = "AdminServlet", urlPatterns = {"/Admin"})
public class AdminServlet extends CommonServlet {
    /**
     * 管理员登录
     *
     * @param request 请求
     * @param response 响应
     */
    public void login(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        AccountService accountService = new AdminAccountServiceImpl();
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

    /**
     * 管理员注册
     *
     * @param request 请求
     * @param response 响应
     */
    public void reg(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        AccountService accountService = new AdminAccountServiceImpl();
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

    /**
     * 查询
     *
     * @param request 请求
     * @param response 响应
     */
    public void queryTable(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        AdminBizService adminBizService = new AdminBizServiceImpl();
        String resultInfoJson;
        ResultInfo resultInfo;
        PrintWriter writer;

        try {
            resultInfo = adminBizService.queryTable(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新
     *
     * @param request 请求
     * @param response 响应
     */
    public void updateTable(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        AdminBizService adminBizService = new AdminBizServiceImpl();
        String resultInfoJson;
        ResultInfo resultInfo;
        PrintWriter writer;

        try {
            resultInfo = adminBizService.updateTable(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
