package tyfanch.electivehelper.service.uni_user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import tyfanch.electivehelper.bean.StudentCourse;
import tyfanch.electivehelper.bean.StudentCourseConst;
import tyfanch.electivehelper.bean.UniUser;
import tyfanch.electivehelper.dao.uni_user.UniBizDao;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.utils.MyBatisUtils;
import tyfanch.electivehelper.utils.TyBeanUtils;
import tyfanch.electivehelper.view.vo.ResultInfo;
import tyfanch.electivehelper.view.vo.ResultInfoConst;

@SuppressWarnings("unchecked")
public class UniBizServiceImpl implements UniBizService {
    @Override
    public ResultInfo findStudentsOfCourse(HttpServletRequest request,
        HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        UniBizDao uniBizDao = sqlSession.getMapper(UniBizDao.class);
        ResultInfo resultInfo = new ResultInfo();
        StudentCourse studentCourse;
        List<UniUser> uniUserList;
        String studentCourseJson;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            studentCourseJson = request.getParameter(StudentCourseConst.NAME);
            studentCourse = JsonUtils.fromJson(studentCourseJson, StudentCourse.class);
            uniUserList = uniBizDao.findStudentsOfCourse(studentCourse);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(uniUserList);
        } catch (IOException e) {
            e.printStackTrace();
            success = false;
            resultCode = -1;
            resultMsg = e.getMessage();
            resultData = null;
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
    public ResultInfo findByStudentAndCourse(HttpServletRequest request,
        HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        UniBizDao uniBizDao = sqlSession.getMapper(UniBizDao.class);
        ResultInfo resultInfo = new ResultInfo();
        StudentCourse studentCourse;
        List<StudentCourse> studentCourseList;
        String studentCourseJson;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            studentCourseJson = request.getParameter(StudentCourseConst.NAME);
            studentCourse = JsonUtils.fromJson(studentCourseJson, StudentCourse.class);
            studentCourseList = uniBizDao.findByStudentAndCourse(studentCourse);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(studentCourseList);
        } catch (IOException e) {
            e.printStackTrace();
            success = false;
            resultCode = -1;
            resultMsg = e.getMessage();
            resultData = null;
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
    public boolean hasSelected(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        UniBizDao uniBizDao = sqlSession.getMapper(UniBizDao.class);
        StudentCourse studentCourse;
        String studentCourseJson;
        boolean selected;

        try {
            studentCourseJson = request.getParameter(StudentCourseConst.NAME);

            if (studentCourseJson != null && !studentCourseJson.isEmpty()) {
                studentCourse = JsonUtils.fromJson(studentCourseJson, StudentCourse.class);
                selected = (studentCourse != null)
                    && !uniBizDao.findByStudentAndCourse(studentCourse).isEmpty();
            } else {
                selected = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            selected = false;
        } finally {
            sqlSession.close();
        }

        return selected;
    }

    @Override
    public ResultInfo selectCourse(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        UniBizDao uniBizDao = sqlSession.getMapper(UniBizDao.class);
        ResultInfo resultInfo = new ResultInfo();
        StudentCourse studentCourse;
        String studentCourseJson;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            studentCourseJson = request.getParameter(StudentCourseConst.NAME);
            studentCourse = JsonUtils.fromJson(studentCourseJson, StudentCourse.class);
            success = !uniBizDao.isCourseConflict(studentCourse);

            if (success) {
                resultCode = 0;
                resultMsg = ResultInfoConst.REQUEST_SUCCESS;
                resultData = uniBizDao.selectCourse(TyBeanUtils.toMap(studentCourse));
            } else {
                resultCode = -1;
                resultMsg = ResultInfoConst.UNI_COURSE_CONFLICT;
                resultData = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            success = false;
            resultCode = -1;
            resultMsg = e.getMessage();
            resultData = null;
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
    public ResultInfo deselectCourse(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        UniBizDao uniBizDao = sqlSession.getMapper(UniBizDao.class);
        ResultInfo resultInfo = new ResultInfo();
        StudentCourse studentCourse;
        String studentCourseJson;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            studentCourseJson = request.getParameter(StudentCourseConst.NAME);
            studentCourse = JsonUtils.fromJson(studentCourseJson, StudentCourse.class);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = uniBizDao.deselectCourse(studentCourse);
        } catch (IOException e) {
            e.printStackTrace();
            success = false;
            resultCode = -1;
            resultMsg = e.getMessage();
            resultData = null;
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
