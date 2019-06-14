package tyfanch.electivehelper.service.course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import tyfanch.electivehelper.bean.UniUser;
import tyfanch.electivehelper.bean.UniUserConst;
import tyfanch.electivehelper.dao.course.CourseVoDao;
import tyfanch.electivehelper.utils.Base64Utils;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.utils.MyBatisUtils;
import tyfanch.electivehelper.view.vo.CourseVo;
import tyfanch.electivehelper.view.vo.CourseVoConst;
import tyfanch.electivehelper.view.vo.ResultInfo;
import tyfanch.electivehelper.view.vo.ResultInfoConst;

@SuppressWarnings("unchecked")
public class CourseVoServiceImpl implements CourseVoService {
    @Override
    public ResultInfo findAll(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        CourseVoDao courseVoDao = sqlSession.getMapper(CourseVoDao.class);
        ResultInfo resultInfo = new ResultInfo();
        List<CourseVo> courseVoList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            courseVoList = courseVoDao.findAll();
            success = true;
            resultCode = 0;
            resultMsg = "";
            resultData = JsonUtils.toJson(courseVoList);
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
    public ResultInfo findByColumn(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        CourseVoDao courseVoDao = sqlSession.getMapper(CourseVoDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String courseVoJson;
        CourseVo courseVo;
        List<CourseVo> courseVoList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            courseVoJson = request.getParameter(CourseVoConst.NAME);
            courseVo = JsonUtils.fromJson(courseVoJson, CourseVo.class);
            courseVoList = courseVoDao.findByColumn(courseVo);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(courseVoList);
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
    public ResultInfo findByTeacherAndColumn(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        CourseVoDao courseVoDao = sqlSession.getMapper(CourseVoDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String uniUserJson;
        String courseVoJson;
        UniUser uniUser;
        CourseVo courseVo;
        List<CourseVo> courseVoList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            uniUserJson = request.getParameter(UniUserConst.NAME);
            courseVoJson = request.getParameter(CourseVoConst.NAME);
            uniUser = JsonUtils.fromJson(Base64Utils.decode(uniUserJson), UniUser.class);
            courseVo = JsonUtils.fromJson(courseVoJson, CourseVo.class);
            courseVoList = courseVoDao.findByTeacherAndColumn(uniUser, courseVo);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(courseVoList);
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
    public ResultInfo findByStudentAndColumn(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        CourseVoDao courseVoDao = sqlSession.getMapper(CourseVoDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String uniUserJson;
        String courseVoJson;
        UniUser uniUser;
        CourseVo courseVo;
        List<CourseVo> courseVoList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            uniUserJson = request.getParameter(UniUserConst.NAME);
            courseVoJson = request.getParameter(CourseVoConst.NAME);
            uniUser = JsonUtils.fromJson(Base64Utils.decode(uniUserJson), UniUser.class);
            courseVo = JsonUtils.fromJson(courseVoJson, CourseVo.class);
            courseVoList = courseVoDao.findByStudentAndColumn(uniUser, courseVo);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(courseVoList);
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
