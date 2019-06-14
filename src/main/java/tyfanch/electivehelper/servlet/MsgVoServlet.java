package tyfanch.electivehelper.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import tyfanch.electivehelper.service.msg.MsgVoService;
import tyfanch.electivehelper.service.msg.MsgVoServiceImpl;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.view.vo.ResultInfo;

@WebServlet(name = "MsgVoServlet", urlPatterns = {"/MsgVo"})
public class MsgVoServlet extends CommonServlet {
    public void findByPaired(HttpServletRequest request, HttpServletResponse response) {
        MsgVoService msgVoService = new MsgVoServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = msgVoService.findByPaired(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findBySingle(HttpServletRequest request, HttpServletResponse response) {
        MsgVoService msgVoService = new MsgVoServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = msgVoService.findBySingle(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
