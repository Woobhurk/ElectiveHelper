package tyfanch.electivehelper.service.uni_user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import tyfanch.electivehelper.bean.UniUser;
import tyfanch.electivehelper.bean.UniUserConst;
import tyfanch.electivehelper.bean.User;
import tyfanch.electivehelper.bean.UserConst;
import tyfanch.electivehelper.constant.config.DbConfig;
import tyfanch.electivehelper.dao.uni_user.UniAccountDao;
import tyfanch.electivehelper.service.user.AccountService;
import tyfanch.electivehelper.service.user.CommonAccountServiceImpl;
import tyfanch.electivehelper.utils.Base64Utils;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.utils.MyBatisUtils;
import tyfanch.electivehelper.utils.TyBeanUtils;
import tyfanch.electivehelper.view.vo.ResultInfo;
import tyfanch.electivehelper.view.vo.ResultInfoConst;
import tyfanch.electivehelper.view.vo.UniUserVo;
import tyfanch.electivehelper.view.vo.UniUserVoConst;

@SuppressWarnings("unchecked")
public abstract class BaseUniAccountService implements UniAccountService {
    @Override
    public ResultInfo login(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        UniAccountDao uniAccountDao = sqlSession.getMapper(UniAccountDao.class);
        String userJson;
        User user;
        String uniUserVoJson;
        UniUserVo uniUserVo;
        List<UniUser> uniUserList;
        UniUser uniUser = new UniUser();
        ResultInfo resultInfo = new ResultInfo();
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            userJson = request.getParameter(UserConst.NAME);
            user = JsonUtils.fromJson(Base64Utils.decode(userJson), User.class);
            uniUserVoJson = request.getParameter(UniUserVoConst.NAME);
            uniUserVo = JsonUtils.fromJson(Base64Utils.decode(uniUserVoJson), UniUserVo.class);

            uniUser.setType(uniUser.getType());
            uniUser.setAccount(uniUserVo.getAccount());
            uniUser.setPassword(uniUserVo.getPassword());
            //uniUser.setPassword(uniUserVo.getPasswordEncrypted()
            //    ? uniUserVo.getPassword()
            //    : Md5Utils.toMd5(uniUserVo.getPassword()));
            uniUserList = uniAccountDao.find(this.getTableName(), uniUser);

            if (uniUserList.isEmpty()) {
                success = false;
                resultMsg = ResultInfoConst.UNI_ACCOUNT_ERROR;
            } else {
                success = true;
                resultMsg = ResultInfoConst.LOGIN_SUCCESS;
            }

            if (success) {
                UniUser currentUniUser;

                currentUniUser = uniUserList.get(0);
                currentUniUser.setUserId(user.getId());
                uniAccountDao.clearUserId(DbConfig.TABLE_STUDENT, user.getId());
                uniAccountDao.clearUserId(DbConfig.TABLE_TEACHER, user.getId());
                uniAccountDao.update(this.getTableName(), TyBeanUtils.toMap(currentUniUser));
                resultCode = 0;
                resultData = Base64Utils.encode(JsonUtils.toJson(currentUniUser));
            } else {
                resultCode = -1;
                resultData = null;
            }
        } catch (Exception e) {
            success = false;
            resultCode = -1;
            resultMsg = ResultInfoConst.LOGIN_FAIL;
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
    public ResultInfo findUserByUniUserId(HttpServletRequest request,
        HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        UniAccountDao uniAccountDao = sqlSession.getMapper(UniAccountDao.class);
        String uniUserJson;
        UniUser uniUser;
        List<User> userList;
        ResultInfo resultInfo = new ResultInfo();
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            uniUserJson = request.getParameter(UniUserConst.NAME);
            uniUser = JsonUtils.fromJson(Base64Utils.decode(uniUserJson), UniUser.class);
            userList = uniAccountDao.findUserByUniUserId(uniUser);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(userList);
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
    public ResultInfo findUniUserByUserId(HttpServletRequest request,
        HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        UniAccountDao uniAccountDao = sqlSession.getMapper(UniAccountDao.class);
        String userJson;
        User user;
        List<UniUser> uniUserList;
        ResultInfo resultInfo = new ResultInfo();
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            userJson = request.getParameter(UniUserConst.NAME);
            user = JsonUtils.fromJson(Base64Utils.decode(userJson), User.class);
            uniUserList = uniAccountDao.findUniUserByUserId(DbConfig.TABLE_TEACHER, user);

            if (uniUserList.isEmpty()) {
                uniUserList = uniAccountDao.findUniUserByUserId(DbConfig.TABLE_STUDENT, user);
            }

            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.REQUEST_SUCCESS;
            resultData = JsonUtils.toJson(uniUserList);
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
    public boolean hasLogin(HttpServletRequest request, HttpServletResponse response) {
        UniUser uniUser;
        String uniUserJson;
        boolean login;

        uniUserJson = request.getParameter(UniUserConst.NAME);

        try {
            if (uniUserJson != null && !uniUserJson.isEmpty()) {
                uniUser = JsonUtils.fromJson(Base64Utils.decode(uniUserJson), UniUser.class);
                login = this.hasLogin(uniUser);
            } else {
                login = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            login = false;
        }

        return login;
    }

    @Override
    public boolean hasLogin(UniUser uniUser) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        UniAccountDao uniAccountDao = sqlSession.getMapper(UniAccountDao.class);
        boolean loggedIn;

        loggedIn = (uniUser != null)
            && !uniAccountDao.find(this.getTableName(), uniUser).isEmpty();

        sqlSession.close();

        return loggedIn;
    }

    protected Object loginSuccess(User user, UniUser uniUser) throws Exception {
        SqlSession sqlSession = MyBatisUtils.openSession();
        AccountService accountService = new CommonAccountServiceImpl();
        //AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        UniAccountDao uniAccountDao = sqlSession.getMapper(UniAccountDao.class);
        List<UniUser> uniUserList;
        UniUser currentUniUser;
        String resultData;

        try {
            // 将视图层数据转化成Bean
            uniUserList = uniAccountDao.find(this.getTableName(), uniUser);
            currentUniUser = uniUserList.get(0);

            // 如果请求参数中的用户信息有效则将学校用户的userId设置成用户id，将二者关联
            if (accountService.hasLogin(user)) {
                // 设置用户类型为对应的类型
                //user.setType(currentUniUser.getType());
                //accountDao.update(TyBeanUtils.toMap(user));
                // 绑定学校用户和用户id
                currentUniUser.setUserId(user.getId());
                uniAccountDao.clearUserId(this.getTableName(), user.getId());
                uniAccountDao.update(this.getTableName(), TyBeanUtils.toMap(currentUniUser));
                resultData = Base64Utils.encode(JsonUtils.toJson(currentUniUser));
            } else {
                System.out.println("---- BaseUniAccountService.loginSuccess: Fail.");
                resultData = null;
            }
        } finally {
            sqlSession.close();
        }

        return resultData;
    }

    /**
     * 获取用户表
     *
     * @return 用户表
     */
    protected abstract String getTableName();

    /**
     * 获取用户类型
     *
     * @return 用户类型
     */
    protected abstract Integer getType();
}
