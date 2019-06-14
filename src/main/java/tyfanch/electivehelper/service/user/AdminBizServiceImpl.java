package tyfanch.electivehelper.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import tyfanch.electivehelper.bean.Classroom;
import tyfanch.electivehelper.bean.Course;
import tyfanch.electivehelper.bean.Msg;
import tyfanch.electivehelper.bean.Reply;
import tyfanch.electivehelper.bean.Student;
import tyfanch.electivehelper.bean.StudentCourse;
import tyfanch.electivehelper.bean.Teacher;
import tyfanch.electivehelper.bean.User;
import tyfanch.electivehelper.bean.UserType;
import tyfanch.electivehelper.constant.config.DbConfig;
import tyfanch.electivehelper.dao.user.AdminProceedDao;
import tyfanch.electivehelper.dao.user.AdminProceedDaoImpl;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.view.vo.QueryVo;
import tyfanch.electivehelper.view.vo.QueryVoConst;
import tyfanch.electivehelper.view.vo.ResultInfo;
import tyfanch.electivehelper.view.vo.ResultInfoConst;
import tyfanch.electivehelper.view.vo.UpdateVo;
import tyfanch.electivehelper.view.vo.UpdateVoConst;

/**
 * 管理员处理业务实现类
 */
public class AdminBizServiceImpl implements AdminBizService {
    private AccountService accountService = new AdminAccountServiceImpl();
    private AdminProceedDao adminProceedDao = new AdminProceedDaoImpl();
    private ResultInfo resultInfo = new ResultInfo();

    @Override
    public ResultInfo queryTable(HttpServletRequest request, HttpServletResponse response) {
        String queryVoJson;
        QueryVo queryVo;
        List resultList;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            queryVoJson = request.getParameter(QueryVoConst.NAME);
            queryVo = JsonUtils.fromJson(queryVoJson, QueryVo.class);
            queryVo.setBeanClass(this.getBeanClass(queryVo.getTableName()));

            if (!this.accountService.hasLogin(request, response)) {
                success = false;
                resultCode = -1;
                resultMsg = ResultInfoConst.QUERY_ERROR;
                resultData = null;
            } else {
                switch (queryVo.getQueryMethod()) {
                case QueryVoConst.QUERY_ALL:
                    resultList = this.adminProceedDao.queryAll(queryVo);
                    resultCode = resultList.size();
                    resultData = JsonUtils.toJson(resultList);
                    break;
                case QueryVoConst.QUERY_ALL_COUNT:
                    resultList = this.adminProceedDao.queryAll(queryVo);
                    resultCode = resultList.size();
                    resultData = resultCode;
                    break;
                case QueryVoConst.QUERY_BY_COLUMN:
                    resultList = this.adminProceedDao.queryByColumn(queryVo);
                    resultCode = resultList.size();
                    resultData = JsonUtils.toJson(resultList);
                    break;
                default:
                    resultCode = -1;
                    resultData = null;
                }

                if (resultCode >= 0) {
                    success = true;
                    resultMsg = ResultInfoConst.QUERY_SUCCESS;
                } else {
                    success = false;
                    resultMsg = ResultInfoConst.QUERY_ERROR + JsonUtils.toJson(queryVo);
                    resultData = null;
                }
            }
        } catch (Exception e) {
            success = false;
            resultCode = -1;
            resultMsg = ResultInfoConst.QUERY_ERROR;
            resultData = null;
            e.printStackTrace();
        }

        this.resultInfo.setSuccess(success);
        this.resultInfo.setResultCode(resultCode);
        this.resultInfo.setResultMsg(resultMsg);
        this.resultInfo.setResultData(resultData);

        return this.resultInfo;
    }

    @Override
    public ResultInfo updateTable(HttpServletRequest request, HttpServletResponse response) {
        String updateVoJson;
        UpdateVo updateVo;
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            updateVoJson = request.getParameter(UpdateVoConst.NAME);
            updateVo = JsonUtils.fromJson(updateVoJson, UpdateVo.class);
            updateVo.setBeanClass(this.getBeanClass(updateVo.getTableName()));

            if (!this.accountService.hasLogin(request, response)) {
                success = false;
                resultCode = -1;
                resultMsg = ResultInfoConst.UPDATE_ERROR;
                resultData = null;
            } else {
                switch (updateVo.getUpdateMethod()) {
                case UpdateVoConst.UPDATE_INSERT:
                    resultCode = this.adminProceedDao.insert(updateVo);
                    break;
                case UpdateVoConst.UPDATE_DELETE:
                    resultCode = this.adminProceedDao.delete(updateVo);
                    break;
                case UpdateVoConst.UPDATE_MODIFY:
                    resultCode = this.adminProceedDao.update(updateVo);
                    break;
                default:
                    resultCode = -1;
                }

                if (resultCode >= 0) {
                    success = true;
                    resultMsg = ResultInfoConst.UPDATE_SUCCESS + resultCode;
                    resultData = resultCode;
                } else {
                    success = false;
                    resultMsg = ResultInfoConst.UPDATE_ERROR + JsonUtils.toJson(updateVo);
                    resultData = resultCode;
                }
            }
        } catch (Exception e) {
            success = false;
            resultCode = -1;
            resultMsg = ResultInfoConst.UPDATE_ERROR;
            resultData = null;
            e.printStackTrace();
        }

        this.resultInfo.setSuccess(success);
        this.resultInfo.setResultCode(resultCode);
        this.resultInfo.setResultMsg(resultMsg);
        this.resultInfo.setResultData(resultData);

        return this.resultInfo;
    }

    private Class getBeanClass(String tableName) {
        Class beanClass;

        switch (tableName.toLowerCase()) {
        case DbConfig.TABLE_USER:
            beanClass = User.class;
            break;
        case DbConfig.TABLE_USER_TYPE:
            beanClass = UserType.class;
            break;
        case DbConfig.TABLE_MSG:
            beanClass = Msg.class;
            break;
        case DbConfig.TABLE_COURSE:
            beanClass = Course.class;
            break;
        case DbConfig.TABLE_REPLY:
            beanClass = Reply.class;
            break;
        case DbConfig.TABLE_CLASSROOM:
            beanClass = Classroom.class;
            break;
        case DbConfig.TABLE_STUDENT:
            beanClass = Student.class;
            break;
        case DbConfig.TABLE_TEACHER:
            beanClass = Teacher.class;
            break;
        case DbConfig.TABLE_STUDENT_COURSE:
            beanClass = StudentCourse.class;
            break;
        default:
            beanClass = null;
        }

        return beanClass;
    }
}
