package tyfanch.electivehelper.dao.msg;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import tyfanch.electivehelper.bean.Msg;

/**
 * 消息处理DAO
 */
public interface MsgDao {
    List findBySender(@Param("msg") Msg msg);

    List findByReceiver(@Param("msg") Msg msg);

    List findBySingle(@Param("msg") Msg msg);

    List findByPaired(@Param("msg") Msg msg);

    int save(@Param("msgMap") Map<String, Object> msgMap);

    int deleteByIds(@Param("ids") Integer[] ids);
}
