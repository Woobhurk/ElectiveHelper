package tyfanch.electivehelper.dao.user;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import tyfanch.electivehelper.bean.User;

/**
 * 用户账户DAO
 */
public interface AccountDao {
    /**
     * 根据用户信息查找用户。使用用户名/邮箱和密码进行查找。
     *
     * @param user 用户信息
     * @return 查找到的用户列表
     */
    List find(@Param("user") User user);

    List findByIdAndPassword(@Param("user") User user);

    /**
     * 将用户数据保存到数据库。
     *
     * @param userMap 用户信息对应的map
     * @return 受影响的行数
     */
    int save(@Param("userMap") Map<String, Object> userMap);

    int update(@Param("userMap") Map<String, Object> userMap);

    /**
     * 根据用户信息内的用户名判断用户是否存在
     *
     * @param user 用户信息，包含用户名
     * @return 是否存在
     */
    boolean isUsernameExist(@Param("user") User user);

    /**
     * 根据用户信息内的邮箱判断用户是否存在
     *
     * @param user 用户信息
     * @return 是否存在
     */
    boolean isEmailExist(@Param("user") User user);
}
