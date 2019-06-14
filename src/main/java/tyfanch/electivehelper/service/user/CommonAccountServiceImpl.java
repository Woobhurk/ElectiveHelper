package tyfanch.electivehelper.service.user;

import tyfanch.electivehelper.bean.UserTypeConst;

/**
 * 普通用户账号业务实现类
 */
public class CommonAccountServiceImpl extends BaseAccountService {
    @Override
    protected Integer getType() {
        return UserTypeConst.TYPE_PRIMARY;
    }
}
