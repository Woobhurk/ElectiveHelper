package tyfanch.electivehelper.service.user;

import javax.servlet.http.HttpSession;
import tyfanch.electivehelper.view.proceed.CaptchaProceed;

/**
 * 用户数据检查类
 */
public class UserCheckService {

    /**
     * 检验验证码是否正确
     *
     * @param session 当前会话
     * @param captcha 验证码
     * @return 验证码是否正确
     */
    public boolean checkCaptcha(HttpSession session, String captcha) {
        CaptchaProceed captchaProceed = new CaptchaProceed();
        boolean valid;

        valid = (captcha != null) && captchaProceed.checkCaptcha(session, captcha);

        return valid;
    }

    /**
     * 判断用户名是否合法
     *
     * @param username 用户名
     * @return 用户名是否合法
     */
    public boolean checkUsername(String username) {
        boolean valid;

        // 用户名至少6位且必须以字母开头
        //valid = username.matches("^[A-Za-z].{5,}$");
        valid = (username != null) && username.matches("^.{5,}$");

        System.out.println("---- checkUsername: " + valid);
        return valid;
    }

    /**
     * 判断邮箱格式是否合法
     *
     * @param email 邮箱
     * @return 邮箱是否合法
     */
    public boolean checkEmail(String email) {
        boolean valid;

        // 邮件地址必须带有@和.
        valid = (email != null) && email.matches("^\\w+@\\w+\\.\\w+$");

        System.out.println("---- checkEmail: " + valid);
        return valid;
    }

    /**
     * 判断用户密码是否合法
     *
     * @param password 密码
     * @return 密码是否合法
     */
    public boolean checkPassword(String password) {
        boolean valid;

        // 密码是任意字符且至少8位
        valid = (password != null) && password.matches("^.{8,}$");

        System.out.println("---- checkPassword: " + valid);
        return valid;
    }

    /**
     * 判断两次密码是否一致
     */
    public boolean checkConfPassword(String password, String confPassword) {
        boolean valid;

        valid = (confPassword != null) && confPassword.equalsIgnoreCase(password);

        return valid;
    }

    ///**
    // * 判断用户名是否存在
    // *
    // * @param username 用户名
    // * @return 用户是否存在
    // */
    //public boolean isUsernameExist(String username) throws Exception {
    //    QueryVo queryVo = new QueryVo(DbConfig.TABLE_USER, User.class);
    //    QueryDao queryDao = new QueryDao();
    //    boolean userExist;
    //
    //    queryVo.setColumns(UserConst.COLUMN_USERNAME);
    //    queryVo.setCompares(QueryVoConst.COMPARE_EQ);
    //    queryVo.setValues(username);
    //    userExist = !queryDao.queryDao(queryVo).isEmpty();
    //
    //    return userExist;
    //}
    //
    ///**
    // * 判断邮箱是否存在
    // *
    // * @param email 邮箱
    // * @return 是否存在
    // * @throws Exception 错误
    // */
    //public boolean isEmailExist(String email) throws Exception {
    //    QueryVo queryVo = new QueryVo(DbConfig.TABLE_USER, User.class);
    //    QueryDao queryDao = new QueryDao();
    //    boolean emailExist;
    //
    //    queryVo.setColumns(UserConst.COLUMN_EMAIL);
    //    queryVo.setCompares(QueryVoConst.COMPARE_EQ);
    //    queryVo.setValues(email);
    //    emailExist = !queryDao.queryDao(queryVo).isEmpty();
    //
    //    return emailExist;
    //}
    //
    ///**
    // * 判断用户名和密码是否正确
    // *
    // * @param username 用户名
    // * @param password 密码
    // * @return 是否正确
    // */
    //public boolean isUsernameAndPasswordCorrect(String username, String password)
    //    throws Exception {
    //    QueryVo queryVo = new QueryVo(DbConfig.TABLE_USER, User.class);
    //    QueryDao queryDao = new QueryDao();
    //    boolean usernameAndPasswordCorrect;
    //
    //    queryVo.setColumns(UserConst.COLUMN_USERNAME, UserConst.COLUMN_PASSWORD);
    //    queryVo.setCompares(QueryVoConst.COMPARE_EQ, QueryVoConst.COMPARE_EQ);
    //    queryVo.setValues(username, Md5Utils.toMd5(password));
    //    queryVo.setConnectors(QueryVoConst.CONNECTOR_AND);
    //    usernameAndPasswordCorrect = !queryDao.queryDao(queryVo).isEmpty();
    //
    //    return usernameAndPasswordCorrect;
    //}
    //
    ///**
    // * 判断邮箱和密码是否正确
    // *
    // * @param email 邮箱
    // * @param password 密码
    // * @return 是否正确
    // * @throws Exception 错误
    // */
    //public boolean isEmailAndPasswordCorrect(String email, String password)
    //    throws Exception {
    //    QueryVo queryVo = new QueryVo(DbConfig.TABLE_USER, User.class);
    //    QueryDao queryDao = new QueryDao();
    //    boolean emailAndPasswordCorrect;
    //
    //    queryVo.setColumns(UserConst.COLUMN_EMAIL, UserConst.COLUMN_PASSWORD);
    //    queryVo.setCompares(QueryVoConst.COMPARE_EQ, QueryVoConst.COMPARE_EQ);
    //    queryVo.setValues(email, Md5Utils.toMd5(password));
    //    queryVo.setConnectors(QueryVoConst.CONNECTOR_AND);
    //    emailAndPasswordCorrect = !queryDao.queryDao(queryVo).isEmpty();
    //
    //    return emailAndPasswordCorrect;
    //}
}
