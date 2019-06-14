package tyfanch.electivehelper.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import tyfanch.electivehelper.service.uni_user.UniAccountService;
import tyfanch.electivehelper.service.uni_user.UniBizService;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.view.vo.ResultInfo;
import tyfanch.electivehelper.view.vo.ResultInfoConst;

public abstract class UniUserServlet extends CommonServlet {
    public void login(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        UniAccountService uniAccountService = this.getUniAccountService();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            // 登录
            resultInfo = uniAccountService.login(request, response);
            // 将结果转换成json返回给前端
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findUserByUniUserId(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        UniAccountService uniAccountService = this.getUniAccountService();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = uniAccountService.findUserByUniUserId(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findUniUserByUserId(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        UniAccountService uniAccountService = this.getUniAccountService();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = uniAccountService.findUniUserByUserId(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hasLogin(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        UniAccountService uniAccountService = this.getUniAccountService();
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
            resultData = uniAccountService.hasLogin(request, response);
            resultInfo.setSuccess(success);
            resultInfo.setResultCode(resultCode);
            resultInfo.setResultMsg(resultMsg);
            resultInfo.setResultData(resultData);
            // 将结果转换成json返回给前端
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findStudentsOfCourse(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        UniBizService uniBizService = this.getUniBizService();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = uniBizService.findStudentsOfCourse(request, response);
            // 将结果转换成json返回给前端
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hasSelected(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        UniBizService uniBizService = this.getUniBizService();
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
            resultData = uniBizService.hasSelected(request, response);
            resultInfo.setSuccess(success);
            resultInfo.setResultCode(resultCode);
            resultInfo.setResultMsg(resultMsg);
            resultInfo.setResultData(resultData);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.print(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectCourse(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        UniBizService uniBizService = this.getUniBizService();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = uniBizService.selectCourse(request, response);
            // 将结果转换成json返回给前端
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deselectCourse(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        UniBizService uniBizService = this.getUniBizService();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = uniBizService.deselectCourse(request, response);
            // 将结果转换成json返回给前端
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract UniAccountService getUniAccountService();

    protected abstract UniBizService getUniBizService();
}
