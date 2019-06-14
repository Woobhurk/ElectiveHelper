package tyfanch.electivehelper.service.user;

import tyfanch.electivehelper.bean.UserTypeConst;

/**
 * 管理员账号业务实现类
 */
public class AdminAccountServiceImpl extends BaseAccountService {
    @Override
    protected Integer getType() {
        return UserTypeConst.TYPE_ADMIN;
    }
}
