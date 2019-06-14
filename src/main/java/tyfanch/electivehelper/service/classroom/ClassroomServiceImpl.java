package tyfanch.electivehelper.service.classroom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import tyfanch.electivehelper.bean.Course;
import tyfanch.electivehelper.dao.classroom.ClassroomDao;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.utils.MyBatisUtils;
import tyfanch.electivehelper.view.vo.ResultInfo;
import tyfanch.electivehelper.view.vo.ResultInfoConst;

@SuppressWarnings("unchecked")
public class ClassroomServiceImpl implements ClassroomService {
    @Override
    public ResultInfo findAll(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        ClassroomDao classroomDao = sqlSession.getMapper(ClassroomDao.class);
        ResultInfo resultInfo = new ResultInfo();
        List<Course> courseList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            courseList = classroomDao.findAll();
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
}
