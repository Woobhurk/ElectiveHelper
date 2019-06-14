package tyfanch.electivehelper.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import tyfanch.electivehelper.service.reply.ReplyService;
import tyfanch.electivehelper.service.reply.ReplyServiceImpl;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.view.vo.ResultInfo;

@WebServlet(name = "ReplyServlet", urlPatterns = {"/Reply"})
public class ReplyServlet extends CommonServlet {
    public void findByCourse(HttpServletRequest request, HttpServletResponse response) {
        ReplyService replyService = new ReplyServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = replyService.findByCourse(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findBySender(HttpServletRequest request, HttpServletResponse response) {
        ReplyService replyService = new ReplyServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = replyService.findBySender(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findByReplyTo(HttpServletRequest request, HttpServletResponse response) {
        ReplyService replyService = new ReplyServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = replyService.findByReplyTo(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(HttpServletRequest request, HttpServletResponse response) {
        ReplyService replyService = new ReplyServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = replyService.save(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) {
        ReplyService replyService = new ReplyServiceImpl();
        ResultInfo resultInfo;
        String resultInfoJson;
        PrintWriter writer;

        try {
            resultInfo = replyService.deleteById(request, response);
            resultInfoJson = JsonUtils.toJson(resultInfo);

            writer = response.getWriter();
            writer.write(resultInfoJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
