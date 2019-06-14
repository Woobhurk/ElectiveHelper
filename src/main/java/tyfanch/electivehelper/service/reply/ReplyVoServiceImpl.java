package tyfanch.electivehelper.service.reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import tyfanch.electivehelper.bean.Reply;
import tyfanch.electivehelper.bean.ReplyConst;
import tyfanch.electivehelper.dao.reply.ReplyVoDao;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.utils.MyBatisUtils;
import tyfanch.electivehelper.view.vo.ReplyVo;
import tyfanch.electivehelper.view.vo.ResultInfo;
import tyfanch.electivehelper.view.vo.ResultInfoConst;

@SuppressWarnings("unchecked")
public class ReplyVoServiceImpl implements ReplyVoService {
    @Override
    public ResultInfo findByCourse(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        ReplyVoDao replyVoDao = sqlSession.getMapper(ReplyVoDao.class);
        ResultInfo resultInfo = new ResultInfo();
        Reply reply;
        String replyJson;
        List<ReplyVo> replyVoList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            replyJson = request.getParameter(ReplyConst.NAME);
            reply = JsonUtils.fromJson(replyJson, Reply.class);
            replyVoList = this.findInnerReplyById(replyVoDao, replyVoDao.findByCourse(reply));
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(replyVoList);
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
        ReplyVoDao replyVoDao = sqlSession.getMapper(ReplyVoDao.class);
        ResultInfo resultInfo = new ResultInfo();
        Reply reply;
        String replyJson;
        List<ReplyVo> replyVoList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            replyJson = request.getParameter(ReplyConst.NAME);
            reply = JsonUtils.fromJson(replyJson, Reply.class);
            replyVoList = replyVoDao.findBySender(reply);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(replyVoList);
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
        ReplyVoDao replyVoDao = sqlSession.getMapper(ReplyVoDao.class);
        ResultInfo resultInfo = new ResultInfo();
        Reply reply;
        String replyJson;
        List<ReplyVo> replyVoList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            replyJson = request.getParameter(ReplyConst.NAME);
            reply = JsonUtils.fromJson(replyJson, Reply.class);
            replyVoList = replyVoDao.findByReplyTo(reply);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(replyVoList);
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

    private List<ReplyVo> findInnerReplyById(ReplyVoDao replyVoDao, List<ReplyVo> replyVoList) {
        for (ReplyVo replyVo : replyVoList) {
            Reply reply = new Reply();

            if (replyVo.getReplyToId() != null && replyVo.getReplyToId() > 0) {
                reply.setId(replyVo.getReplyToId());
                replyVo.setReplyTo((ReplyVo) replyVoDao.findById(reply).get(0));
            } else {
                replyVo.setReplyTo(null);
            }
        }

        return replyVoList;
    }
}
