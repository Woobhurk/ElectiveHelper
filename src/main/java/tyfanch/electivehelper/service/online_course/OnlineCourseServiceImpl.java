package tyfanch.electivehelper.service.online_course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.ibatis.session.SqlSession;
import tyfanch.electivehelper.bean.OnlineCourse;
import tyfanch.electivehelper.bean.OnlineCourseConst;
import tyfanch.electivehelper.bean.UniUser;
import tyfanch.electivehelper.bean.UniUserConst;
import tyfanch.electivehelper.bean.UserTypeConst;
import tyfanch.electivehelper.constant.config.OnlineCourseConfig;
import tyfanch.electivehelper.dao.online_course.OnlineCourseDao;
import tyfanch.electivehelper.service.course.CourseService;
import tyfanch.electivehelper.service.course.CourseServiceImpl;
import tyfanch.electivehelper.utils.Base64Utils;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.utils.MyBatisUtils;
import tyfanch.electivehelper.view.vo.ResultInfo;
import tyfanch.electivehelper.view.vo.ResultInfoConst;

@SuppressWarnings("unchecked")
public class OnlineCourseServiceImpl implements OnlineCourseService {
    @Override
    public ResultInfo findAll(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        OnlineCourseDao onlineCourseDao = sqlSession.getMapper(OnlineCourseDao.class);
        ResultInfo resultInfo = new ResultInfo();
        List<OnlineCourse> onlineCourseList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            onlineCourseList = onlineCourseDao.findAll();
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(onlineCourseList);
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
    public ResultInfo findByInterest(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        OnlineCourseDao onlineCourseDao = sqlSession.getMapper(OnlineCourseDao.class);
        CourseService courseService = new CourseServiceImpl();
        String uniUserJson;
        UniUser uniUser;
        ResultInfo resultInfo = new ResultInfo();
        List<String> keywordsList;
        Set<String> keywordsSet;
        String[] keywords;
        String[] mergedKeywords;
        String keywordsStr;
        int courseCount;
        OnlineCourse onlineCourse = new OnlineCourse();
        List<OnlineCourse> onlineCourseList = new ArrayList<>();
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            uniUserJson = request.getParameter(UniUserConst.NAME);

            if (uniUserJson != null && !uniUserJson.isEmpty()) {
                uniUser = JsonUtils.fromJson(Base64Utils.decode(uniUserJson), UniUser.class);
            } else {
                uniUser = new UniUser();
                uniUser.setType(UserTypeConst.TYPE_PRIMARY);
                uniUser.setId(0);
            }

            if (uniUser.getType() == UserTypeConst.TYPE_PRIMARY) {
                keywordsList = courseService.findStudentKeywords(uniUser);
            } else {
                keywordsList = courseService.findTeacherKeywords(uniUser);
            }

            if (!keywordsList.isEmpty()) {
                // 如果有关键词就找出相关课程
                // 将所有课程关键词连接
                keywordsStr = String.join(",", keywordsList);
                // 分开所有关键词，可能包含重复关键词
                keywords = keywordsStr.split(",");
                // 将关键词的前后空格去掉，然后去重
                keywordsSet = new HashSet<>(Arrays.asList(keywords));
                // 再次转换为没有重复关键词的数组
                mergedKeywords = keywordsSet.toArray(new String[0]);
                courseCount = OnlineCourseConfig.ONLINE_COURSE_COUNT / mergedKeywords.length + 1;

                for (String keyword : mergedKeywords) {
                    onlineCourse.setName(keyword.trim());
                    onlineCourseList.addAll(
                        onlineCourseDao.findByName(onlineCourse, courseCount));
                }

                if (onlineCourseList.isEmpty()) {
                    // 没有找到相关内容就随机找
                    onlineCourseList.addAll(onlineCourseDao.findRandomly(
                        OnlineCourseConfig.ONLINE_COURSE_COUNT));
                }
            } else {
                // 没有关键词就随机找
                onlineCourseList.addAll(onlineCourseDao.findRandomly(
                    OnlineCourseConfig.ONLINE_COURSE_COUNT));
            }

            onlineCourseList.sort((o1, o2) -> o2.getScore().compareTo(o1.getScore()));
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(onlineCourseList);
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
    public ResultInfo findByKeywords(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        OnlineCourseDao onlineCourseDao = sqlSession.getMapper(OnlineCourseDao.class);
        ResultInfo resultInfo = new ResultInfo();
        String keywordsJson;
        String[] keywords;
        int courseCount;
        OnlineCourse onlineCourse = new OnlineCourse();
        List<OnlineCourse> onlineCourseList = new ArrayList<>();
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            keywordsJson = request.getParameter(OnlineCourseConst.NAME);
            keywords = JsonUtils.fromJson(keywordsJson, new TypeReference<String[]>() {});
            courseCount = OnlineCourseConfig.ONLINE_COURSE_COUNT / keywords.length;

            for (String keyword : keywords) {
                onlineCourse.setName(keyword.trim());
                onlineCourseList.addAll(onlineCourseDao.findByName(onlineCourse, courseCount));
            }

            onlineCourseList.sort((o1, o2) -> o2.getScore().compareTo(o1.getScore()));
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(onlineCourseList);
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
