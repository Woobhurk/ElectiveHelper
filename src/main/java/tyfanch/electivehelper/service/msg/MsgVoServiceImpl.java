package tyfanch.electivehelper.service.msg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import tyfanch.electivehelper.bean.Msg;
import tyfanch.electivehelper.bean.MsgConst;
import tyfanch.electivehelper.dao.msg.MsgVoDao;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.utils.MyBatisUtils;
import tyfanch.electivehelper.view.vo.MsgVo;
import tyfanch.electivehelper.view.vo.ResultInfo;
import tyfanch.electivehelper.view.vo.ResultInfoConst;

@SuppressWarnings("unchecked")
public class MsgVoServiceImpl implements MsgVoService {
    @Override
    public ResultInfo findBySender(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        MsgVoDao msgVoDao = sqlSession.getMapper(MsgVoDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String msgJson;
        Msg msg;
        List<MsgVo> msgVoList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            msgJson = request.getParameter(MsgConst.NAME);
            msg = JsonUtils.fromJson(msgJson, Msg.class);
            msgVoList = msgVoDao.findBySender(msg);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(msgVoList);
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
    public ResultInfo findByReceiver(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        MsgVoDao msgVoDao = sqlSession.getMapper(MsgVoDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String msgJson;
        Msg msg;
        List<MsgVo> msgVoList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            msgJson = request.getParameter(MsgConst.NAME);
            msg = JsonUtils.fromJson(msgJson, Msg.class);
            msgVoList = msgVoDao.findByReceiver(msg);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(msgVoList);
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
    public ResultInfo findBySingle(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        MsgVoDao msgVoDao = sqlSession.getMapper(MsgVoDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String msgJson;
        Msg msg;
        List<MsgVo> msgVoList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            msgJson = request.getParameter(MsgConst.NAME);
            msg = JsonUtils.fromJson(msgJson, Msg.class);
            msgVoList = msgVoDao.findBySingle(msg);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(msgVoList);
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
    public ResultInfo findByPaired(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        MsgVoDao msgVoDao = sqlSession.getMapper(MsgVoDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String msgJson;
        Msg msg;
        List<MsgVo> msgVoList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            msgJson = request.getParameter(MsgConst.NAME);
            msg = JsonUtils.fromJson(msgJson, Msg.class);
            msgVoList = msgVoDao.findByPaired(msg);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(msgVoList);
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
