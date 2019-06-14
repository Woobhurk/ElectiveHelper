package tyfanch.electivehelper.dao.msg;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tyfanch.electivehelper.bean.Msg;

public interface MsgVoDao {
    List findBySender(@Param("msg") Msg msg);

    List findByReceiver(@Param("msg") Msg msg);

    List findBySingle(@Param("msg") Msg msg);

    List findByPaired(@Param("msg") Msg msg);
}
