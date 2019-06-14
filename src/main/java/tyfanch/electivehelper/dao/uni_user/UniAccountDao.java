package tyfanch.electivehelper.dao.uni_user;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import tyfanch.electivehelper.bean.UniUser;
import tyfanch.electivehelper.bean.User;

/**
 * 学校用户账号DAO
 */
public interface UniAccountDao {
    /**
     * 根据学号和密码查找用户
     *
     * @param tableName 表名
     * @param uniUser 学校用户信息
     * @return 查找到的用户列表
     */
    List find(@Param("tableName") String tableName, @Param("uniUser") UniUser uniUser);

    List findUserByUniUserId(@Param("uniUser") UniUser uniUser);

    List findUniUserByUserId(@Param("tableName") String tableName, @Param("user") User user);

    /**
     * 保存学校用户
     *
     * @param tableName 表名
     * @param uniUserMap 学校用户信息对应的map
     * @return 受影响的行数
     */
    int save(@Param("tableName") String tableName,
        @Param("uniUserMap") Map<String, Object> uniUserMap);

    int update(@Param("tableName") String tableName,
        @Param("uniUserMap") Map<String, Object> uniUserMap);

    int clearUserId(@Param("tableName") String tableName, @Param("userId") int userId);
}
