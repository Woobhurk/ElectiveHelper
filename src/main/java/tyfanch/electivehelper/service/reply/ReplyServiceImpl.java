package tyfanch.electivehelper.service.reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import tyfanch.electivehelper.bean.Reply;
import tyfanch.electivehelper.bean.ReplyConst;
import tyfanch.electivehelper.dao.reply.ReplyDao;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.utils.MyBatisUtils;
import tyfanch.electivehelper.utils.TyBeanUtils;
import tyfanch.electivehelper.view.vo.ResultInfo;
import tyfanch.electivehelper.view.vo.ResultInfoConst;

@SuppressWarnings("unchecked")
public class ReplyServiceImpl implements ReplyService {
    @Override
    public ResultInfo findByCourse(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        ReplyDao replyDao = sqlSession.getMapper(ReplyDao.class);
        ResultInfo resultInfo = new ResultInfo();
        Reply reply;
        String replyJson;
        List<Reply> replyList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            replyJson = request.getParameter(ReplyConst.NAME);
            reply = JsonUtils.fromJson(replyJson, Reply.class);
            replyList = replyDao.findByCourse(reply);
            success = true;
            resultCode = 0;
            resultMsg = "";
            resultData = JsonUtils.toJson(replyList);
        } catch (IOException e) {
            success = false;
            resultCode = -1;
            resultMsg = e.getMessage();
            resultData = null;
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        resultInfo.setSuccess(success);
        resultInfo.setResultCode(resultCode);
        resultInfo.setResultMsg(resultMsg);
        resultInfo.setResultData(resultData);

        return resultInfo;
    }

    @Override
    public ResultInfo findBySender(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        ReplyDao replyDao = sqlSession.getMapper(ReplyDao.class);
        ResultInfo resultInfo = new ResultInfo();
        Reply reply;
        String replyJson;
        List<Reply> replyList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            replyJson = request.getParameter(ReplyConst.NAME);
            reply = JsonUtils.fromJson(replyJson, Reply.class);
            replyList = replyDao.findBySender(reply);
            success = true;
            resultCode = 0;
            resultMsg = "";
            resultData = JsonUtils.toJson(replyList);
        } catch (IOException e) {
            success = false;
            resultCode = -1;
            resultMsg = e.getMessage();
            resultData = null;
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        resultInfo.setSuccess(success);
        resultInfo.setResultCode(resultCode);
        resultInfo.setResultMsg(resultMsg);
        resultInfo.setResultData(resultData);

        return resultInfo;
    }

    @Override
    public ResultInfo findByReplyTo(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        ReplyDao replyDao = sqlSession.getMapper(ReplyDao.class);
        ResultInfo resultInfo = new ResultInfo();
        Reply reply;
        String replyJson;
        List<Reply> replyList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            replyJson = request.getParameter(ReplyConst.NAME);
            reply = JsonUtils.fromJson(replyJson, Reply.class);
            replyList = replyDao.findByReplyTo(reply);
            success = true;
            resultCode = 0;
            resultMsg = "";
            resultData = JsonUtils.toJson(replyList);
        } catch (IOException e) {
            success = false;
            resultCode = -1;
            resultMsg = e.getMessage();
            resultData = null;
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        resultInfo.setSuccess(success);
        resultInfo.setResultCode(resultCode);
        resultInfo.setResultMsg(resultMsg);
        resultInfo.setResultData(resultData);

        return resultInfo;
    }

    @Override
    public ResultInfo save(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        ReplyDao replyDao = sqlSession.getMapper(ReplyDao.class);
        ResultInfo resultInfo = new ResultInfo();
        Reply reply;
        String replyJson;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            replyJson = request.getParameter(ReplyConst.NAME);
            reply = JsonUtils.fromJson(replyJson, Reply.class);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = replyDao.save(TyBeanUtils.toMap(reply));
        } catch (IOException e) {
            success = false;
            resultCode = -1;
            resultMsg = e.getMessage();
            resultData = null;
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        resultInfo.setSuccess(success);
        resultInfo.setResultCode(resultCode);
        resultInfo.setResultMsg(resultMsg);
        resultInfo.setResultData(resultData);

        return resultInfo;
    }

    @Override
    public ResultInfo deleteById(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        ReplyDao replyDao = sqlSession.getMapper(ReplyDao.class);
        ResultInfo resultInfo = new ResultInfo();
        Reply reply;
        String replyJson;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            replyJson = request.getParameter(ReplyConst.NAME);
            reply = JsonUtils.fromJson(replyJson, Reply.class);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = replyDao.deleteById(reply);
        } catch (IOException e) {
            success = false;
            resultCode = -1;
            resultMsg = e.getMessage();
            resultData = null;
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        resultInfo.setSuccess(success);
        resultInfo.setResultCode(resultCode);
        resultInfo.setResultMsg(resultMsg);
        resultInfo.setResultData(resultData);

        return resultInfo;
    }
}
