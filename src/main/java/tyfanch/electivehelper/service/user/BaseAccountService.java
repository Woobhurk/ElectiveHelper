package tyfanch.electivehelper.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import tyfanch.electivehelper.bean.User;
import tyfanch.electivehelper.bean.UserConst;
import tyfanch.electivehelper.bean.UserTypeConst;
import tyfanch.electivehelper.dao.user.AccountDao;
import tyfanch.electivehelper.utils.Base64Utils;
import tyfanch.electivehelper.utils.JsonUtils;
import tyfanch.electivehelper.utils.MyBatisUtils;
import tyfanch.electivehelper.utils.TyBeanUtils;
import tyfanch.electivehelper.utils.UuidUtils;
import tyfanch.electivehelper.view.vo.ResultInfo;
import tyfanch.electivehelper.view.vo.ResultInfoConst;
import tyfanch.electivehelper.view.vo.UserVo;
import tyfanch.electivehelper.view.vo.UserVoConst;

@SuppressWarnings("unchecked")
public abstract class BaseAccountService implements AccountService {
    @Override
    public ResultInfo login(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        String userVoJson;
        UserVo userVo;
        User user = new User();
        UserCheckService userCheckService = new UserCheckService();
        ResultInfo resultInfo = new ResultInfo();
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            userVoJson = request.getParameter(UserVoConst.NAME);
            userVo = JsonUtils.fromJson(Base64Utils.decode(userVoJson), UserVo.class);
            user.setType(userVo.getType());
            user.setUsername(userVo.getUsername());
            user.setEmail(userVo.getUsername());
            user.setPassword(userVo.getPassword());
            //user.setPassword(userVo.getPasswordEncrypted()
            //    ? userVo.getPassword()
            //    : Md5Utils.toMd5(userVo.getPassword()));

            // 管理员才需要验证码
            if (userVo.getType() == UserTypeConst.TYPE_ADMIN &&
                !userCheckService.checkCaptcha(request.getSession(), userVo.getCaptcha())) {
                // 验证码错误
                success = false;
                resultMsg = ResultInfoConst.CAPTCHA_ERROR;
            } else if (!accountDao.isUsernameExist(user)
                && !accountDao.isEmailExist(user)) {
                success = false;
                resultMsg = ResultInfoConst.ACCOUNT_NOT_EXIST;
            } else if (accountDao.find(user).isEmpty()) {
                success = false;
                resultMsg = ResultInfoConst.PASSWORD_ERROR;
            } else {
                // 登录成功
                success = true;
                resultMsg = ResultInfoConst.LOGIN_SUCCESS;
            }

            if (success) {
                List<User> userList;
                User currentUser;

                userList = accountDao.find(user);
                currentUser = userList.get(0);
                resultCode = 0;
                resultData = Base64Utils.encode(JsonUtils.toJson(currentUser));
            } else {
                resultCode = -1;
                resultData = null;
            }
        } catch (IOException e) {
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
    public ResultInfo loginByIdAndPassword(HttpServletRequest request,
        HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        String userJson;
        User user;
        ResultInfo resultInfo = new ResultInfo();
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            userJson = request.getParameter(UserConst.NAME);
            user = JsonUtils.fromJson(Base64Utils.decode(userJson), User.class);

            if (accountDao.findByIdAndPassword(user).isEmpty()) {
                success = false;
                resultMsg = ResultInfoConst.PASSWORD_ERROR;
            } else {
                success = true;
                resultMsg = ResultInfoConst.LOGIN_SUCCESS;
            }

            if (success) {
                List<User> userList;
                User currentUser;

                userList = accountDao.findByIdAndPassword(user);
                currentUser = userList.get(0);
                resultCode = 0;
                resultData = Base64Utils.encode(JsonUtils.toJson(currentUser));
            } else {
                resultCode = -1;
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
    public ResultInfo reg(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        String userVoJson;
        UserVo userVo;
        User user = new User();
        UserCheckService userCheckService = new UserCheckService();
        ResultInfo resultInfo = new ResultInfo();
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            userVoJson = request.getParameter(UserVoConst.NAME);
            userVo = JsonUtils.fromJson(Base64Utils.decode(userVoJson), UserVo.class);
            user.setType(userVo.getType());
            user.setUsername(userVo.getUsername());
            user.setEmail(userVo.getEmail());
            user.setPassword(userVo.getPassword());

            // 管理员才需要验证码
            if (userVo.getType() == UserTypeConst.TYPE_ADMIN &&
                !userCheckService.checkCaptcha(request.getSession(), userVo.getCaptcha())) {
                // 验证码错误
                success = false;
                resultMsg = ResultInfoConst.CAPTCHA_ERROR;
            } else if (!userCheckService.checkUsername(userVo.getUsername())) {
                // 用户名不合法
                success = false;
                resultMsg = ResultInfoConst.INVALID_USERNAME;
            } else if (!userCheckService.checkEmail(userVo.getEmail())) {
                // 邮箱不合法
                success = false;
                resultMsg = ResultInfoConst.INVALID_EMAIL;
            } else if (!userCheckService.checkPassword(userVo.getPassword())) {
                // 密码不合法
                success = false;
                resultMsg = ResultInfoConst.INVALID_PASSWORD;
            } else if (!userCheckService.checkConfPassword(userVo.getPassword(),
                userVo.getConfPassword())) {
                // 两次密码不一致
                success = false;
                resultMsg = ResultInfoConst.PASSWORD_NOT_MATCH;
            } else if (accountDao.isUsernameExist(user)) {
                // 用户已经存在
                success = false;
                resultMsg = ResultInfoConst.USER_ALREADY_EXIST;
            } else if (accountDao.isEmailExist(user)) {
                // 邮箱已经存在
                success = false;
                resultMsg = ResultInfoConst.EMAIL_ALREADY_EXIST;
            } else {
                // 信息无误，注册
                success = true;
                resultMsg = ResultInfoConst.REGISTER_SUCCESS;
            }

            // 成功则进行注册操作
            if (success) {
                List<User> userList;
                User currentUser;

                user.setUuid(UuidUtils.randUuid());
                accountDao.save(TyBeanUtils.toMap(user));
                userList = accountDao.find(user);
                currentUser = userList.get(0);
                resultCode = 0;
                resultData = Base64Utils.encode(JsonUtils.toJson(currentUser));
            } else {
                resultCode = -1;
                resultData = null;
            }
        } catch (IOException e) {
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
    public ResultInfo update(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        String userJson;
        User user;
        ResultInfo resultInfo = new ResultInfo();
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            userJson = request.getParameter(UserConst.NAME);
            user = JsonUtils.fromJson(Base64Utils.decode(userJson), User.class);
            accountDao.update(TyBeanUtils.toMap(user));
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.UPDATE_SUCCESS;
            resultData = userJson;
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
    public ResultInfo isUsernameExist(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        String userJson;
        User user;
        ResultInfo resultInfo = new ResultInfo();
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            userJson = request.getParameter(UserConst.NAME);
            user = JsonUtils.fromJson(Base64Utils.decode(userJson), User.class);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.USER_ALREADY_EXIST;
            resultData = accountDao.isUsernameExist(user);
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
    public ResultInfo isEmailExist(HttpServletRequest request, HttpServletResponse response) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        String userJson;
        User user;
        ResultInfo resultInfo = new ResultInfo();
        boolean success;
        int resultCode;
        String resultMsg;
        Object resultData;

        try {
            userJson = request.getParameter(UserConst.NAME);
            user = JsonUtils.fromJson(Base64Utils.decode(userJson), User.class);
            success = true;
            resultCode = 0;
            resultMsg = ResultInfoConst.EMAIL_ALREADY_EXIST;
            resultData = accountDao.isEmailExist(user);
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
    public boolean hasLogin(HttpServletRequest request, HttpServletResponse response) {
        User user;
        String userJson;
        boolean loggedIn;

        try {
            userJson = request.getParameter(UserConst.NAME);

            if (userJson != null && !userJson.isEmpty()) {
                user = JsonUtils.fromJson(Base64Utils.decode(userJson), User.class);
                // 如果用户信息存在并且数据和数据库内相符合则表示登录成功
                loggedIn = this.hasLogin(user);
            } else {
                loggedIn = false;
            }
        } catch (Exception e) {
            loggedIn = false;
            e.printStackTrace();
        }

        return loggedIn;
    }

    @Override
    public boolean hasLogin(User user) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        boolean loggedIn;

        loggedIn = (user != null) && !accountDao.find(user).isEmpty();

        sqlSession.close();

        return loggedIn;
    }

    /**
     * 登录成功，将当前会话id存入数据库，并返回当前用户数据
     *
     * @param user 当前用户数据
     * @return 当前用户数据
     */
    protected Object loginSuccess(User user) throws IOException {
        SqlSession sqlSession = MyBatisUtils.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        List<User> userList;
        User currentUser;
        String resultData;

        try {
            userList = accountDao.find(user);
            currentUser = userList.get(0);
            resultData = Base64Utils.encode(JsonUtils.toJson(currentUser));
        } finally {
            sqlSession.close();
        }

        return resultData;
    }

    /**
     * 注册成功，将当前会话id存入数据库，并返回当前用户信息
     *
     * @param user 注册的用户数据
     * @return 注册的用户数据
     */
    protected Object regSuccess(User user) throws IOException {
        SqlSession sqlSession = MyBatisUtils.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        List<User> userList;
        User currentUser;
        String resultData;

        try {
            user.setUuid(UuidUtils.randUuid());
            accountDao.save(TyBeanUtils.toMap(user));
            userList = accountDao.find(user);
            currentUser = userList.get(0);
            resultData = Base64Utils.encode(JsonUtils.toJson(currentUser));
        } finally {
            sqlSession.close();
        }

        return resultData;
    }

    /**
     * 获取用户类型
     *
     * @return 用户类型
     */
    protected abstract Integer getType();
}
