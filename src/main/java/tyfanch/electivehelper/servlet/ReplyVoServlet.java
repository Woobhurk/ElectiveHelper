package tyfanch.electivehelper.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import tyfanch.electivehelper.service.reply.ReplyVoService;
import tyfanch.electivehelper.service.reply.ReplyVoServiceImpl;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.view.vo.ResultInfo;

@WebServlet(urlPatterns = {"/ReplyVo"})
public class ReplyVoServlet extends CommonServlet {
    public void findByCourse(HttpServletRequest request, HttpServletResponse response) {
        ReplyVoService replyVoService = new ReplyVoServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = replyVoService.findByCourse(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findBySender(HttpServletRequest request, HttpServletResponse response) {
        ReplyVoService replyVoService = new ReplyVoServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = replyVoService.findBySender(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void findByReplyTo(HttpServletRequest request, HttpServletResponse response) {
        ReplyVoService replyVoService = new ReplyVoServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = replyVoService.findByReplyTo(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
