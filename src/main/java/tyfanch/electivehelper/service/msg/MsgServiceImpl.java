package tyfanch.electivehelper.service.msg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.ibatis.session.SqlSession;
import tyfanch.electivehelper.bean.Msg;
import tyfanch.electivehelper.bean.MsgConst;
import tyfanch.electivehelper.dao.msg.MsgDao;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.utils.MyBatisUtils;
import tyfanch.electivehelper.utils.TyBeanUtils;
import tyfanch.electivehelper.view.vo.ResultInfo;
import tyfanch.electivehelper.view.vo.ResultInfoConst;

@SuppressWarnings("unchecked")
public class MsgServiceImpl implements MsgService {
    @Override
    public ResultInfo findBySender(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        MsgDao msgDao = sqlSession.getMapper(MsgDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String msgJson;
        Msg msg;
        List<Msg> msgList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            msgJson = request.getParameter(MsgConst.NAME);
            msg = JsonUtils.fromJson(msgJson, Msg.class);
            msgList = msgDao.findBySender(msg);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(msgList);
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
        MsgDao msgDao = sqlSession.getMapper(MsgDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String msgJson;
        Msg msg;
        List<Msg> msgList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            msgJson = request.getParameter(MsgConst.NAME);
            msg = JsonUtils.fromJson(msgJson, Msg.class);
            msgList = msgDao.findByReceiver(msg);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(msgList);
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
        MsgDao msgDao = sqlSession.getMapper(MsgDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String msgJson;
        Msg msg;
        List<Msg> msgList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            msgJson = request.getParameter(MsgConst.NAME);
            msg = JsonUtils.fromJson(msgJson, Msg.class);
            msgList = msgDao.findBySingle(msg);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(msgList);
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
        MsgDao msgDao = sqlSession.getMapper(MsgDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String msgJson;
        Msg msg;
        List<Msg> msgList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            msgJson = request.getParameter(MsgConst.NAME);
            msg = JsonUtils.fromJson(msgJson, Msg.class);
            msgList = msgDao.findByPaired(msg);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(msgList);
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
        MsgDao msgDao = sqlSession.getMapper(MsgDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String msgJson;
        Msg msg;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            msgJson = request.getParameter(MsgConst.NAME);
            msg = JsonUtils.fromJson(msgJson, Msg.class);

            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = msgDao.save(TyBeanUtils.toMap(msg));
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
    public ResultInfo deleteByIds(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        MsgDao msgDao = sqlSession.getMapper(MsgDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String idsJson;
        Integer[] ids;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            idsJson = request.getParameter(MsgConst.NAME);
            ids = JsonUtils.fromJson(idsJson, new TypeReference<Integer[]>() {});
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = msgDao.deleteByIds(ids);
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
