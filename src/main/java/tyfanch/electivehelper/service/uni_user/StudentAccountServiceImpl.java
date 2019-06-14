package tyfanch.electivehelper.service.uni_user;

import tyfanch.electivehelper.bean.UserTypeConst;
import tyfanch.electivehelper.constant.config.DbConfig;

public class StudentAccountServiceImpl extends BaseUniAccountService {
    @Override
    protected String getTableName() {
        return DbConfig.TABLE_STUDENT;
    }

    @Override
    protected Integer getType() {
        return UserTypeConst.TYPE_PRIMARY;
    }
}
