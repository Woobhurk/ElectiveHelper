package tyfanch.electivehelper.service.course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import tyfanch.electivehelper.bean.Course;
import tyfanch.electivehelper.bean.CourseConst;
import tyfanch.electivehelper.bean.UniUser;
import tyfanch.electivehelper.bean.UniUserConst;
import tyfanch.electivehelper.dao.course.CourseDao;
import tyfanch.electivehelper.utils.Base64Utils;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.utils.MyBatisUtils;
import tyfanch.electivehelper.utils.TyBeanUtils;
import tyfanch.electivehelper.view.vo.ResultInfo;
import tyfanch.electivehelper.view.vo.ResultInfoConst;

@SuppressWarnings("unchecked")
public class CourseServiceImpl implements CourseService {
    @Override
    public ResultInfo findAll(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        ResultInfo resultInfo = new ResultInfo();
        List<Course> courseList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            courseList = courseDao.findAll();
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(courseList);
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
    public ResultInfo findByTeacher(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String uniUserJson;
        UniUser uniUser;
        List<Course> courseList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            uniUserJson = request.getParameter(UniUserConst.NAME);
            uniUser = JsonUtils.fromJson(Base64Utils.decode(uniUserJson), UniUser.class);
            courseList = courseDao.findByTeacher(uniUser);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(courseList);
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
    public ResultInfo findByStudent(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String uniUserJson;
        UniUser uniUser;
        List<Course> courseList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            uniUserJson = request.getParameter(UniUserConst.NAME);
            uniUser = JsonUtils.fromJson(Base64Utils.decode(uniUserJson), UniUser.class);
            courseList = courseDao.findByStudent(uniUser);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(courseList);
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
    public ResultInfo findTeacherKeywords(HttpServletRequest request,
        HttpServletResponse response) {
        ResultInfo resultInfo = new ResultInfo();
        String uniUserJson;
        UniUser uniUser;
        List<String> keywordsList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            uniUserJson = request.getParameter(UniUserConst.NAME);
            uniUser = JsonUtils.fromJson(Base64Utils.decode(uniUserJson), UniUser.class);
            keywordsList = this.findTeacherKeywords(uniUser);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(keywordsList);
        } catch (IOException e) {
            success = false;
            resultCode = -1;
            resultMsg = e.getMessage();
            resultData = null;
            e.printStackTrace();
        }

        resultInfo.setSuccess(success);
        resultInfo.setResultCode(resultCode);
        resultInfo.setResultMsg(resultMsg);
        resultInfo.setResultData(resultData);

        return resultInfo;
    }

    @Override
    public ResultInfo findStudentKeywords(HttpServletRequest request,
        HttpServletResponse response) {
        ResultInfo resultInfo = new ResultInfo();
        String uniUserJson;
        UniUser uniUser;
        List<String> keywordsList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            uniUserJson = request.getParameter(UniUserConst.NAME);
            uniUser = JsonUtils.fromJson(Base64Utils.decode(uniUserJson), UniUser.class);
            keywordsList = this.findStudentKeywords(uniUser);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(keywordsList);
        } catch (IOException e) {
            success = false;
            resultCode = -1;
            resultMsg = e.getMessage();
            resultData = null;
            e.printStackTrace();
        }

        resultInfo.setSuccess(success);
        resultInfo.setResultCode(resultCode);
        resultInfo.setResultMsg(resultMsg);
        resultInfo.setResultData(resultData);

        return resultInfo;
    }

    @Override
    public List<String> findTeacherKeywords(UniUser uniUser) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        List<String> keywordsList;

        try {
            keywordsList = courseDao.findTeacherKeywords(uniUser);
        } finally {
            sqlSession.close();
        }

        return keywordsList;
    }

    @Override
    public List<String> findStudentKeywords(UniUser uniUser) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        List<String> keywordsList;

        try {
            keywordsList = courseDao.findStudentKeywords(uniUser);
        } finally {
            sqlSession.close();
        }

        return keywordsList;
    }

    @Override
    public ResultInfo save(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String courseJson;
        Course course;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            courseJson = request.getParameter(CourseConst.NAME);
            course = JsonUtils.fromJson(courseJson, Course.class);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = courseDao.save(TyBeanUtils.toMap(course));
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
    public ResultInfo update(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String courseJson;
        Course course;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            courseJson = request.getParameter(CourseConst.NAME);
            course = JsonUtils.fromJson(courseJson, Course.class);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = courseDao.update(TyBeanUtils.toMap(course));
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
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String courseJson;
        Course course;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            courseJson = request.getParameter(CourseConst.NAME);
            course = JsonUtils.fromJson(courseJson, Course.class);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = courseDao.deleteById(course);
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
