package tyfanch.electivehelper.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import tyfanch.electivehelper.service.msg.MsgService;
import tyfanch.electivehelper.service.msg.MsgServiceImpl;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.view.vo.ResultInfo;

@WebServlet(name = "MsgServlet", urlPatterns = {"/Msg"})
public class MsgServlet extends CommonServlet {
    public void findByPaired(HttpServletRequest request, HttpServletResponse response) {
        MsgService msgService = new MsgServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = msgService.findByPaired(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findBySingle(HttpServletRequest request, HttpServletResponse response) {
        MsgService msgService = new MsgServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = msgService.findBySingle(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(HttpServletRequest request, HttpServletResponse response) {
        MsgService msgService = new MsgServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = msgService.save(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 聊天记录发送
     *
     * @param request 请求
     * @param response 响应
     */
    public void send(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        ResultInfo resultInfo;
        String resultInfoJson = "";
        PrintWriter writer;

        try {
            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 聊天记录接收
     *
     * @param request 请求
     * @param response 响应
     */
    public void recv(HttpServletRequest request, HttpServletResponse response) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(response);

        ResultInfo resultInfo;
        String resultInfoJson = "";
        PrintWriter writer;

        try {
            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
