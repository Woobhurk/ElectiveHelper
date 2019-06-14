package tyfanch.electivehelper.dao.reply;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tyfanch.electivehelper.bean.Reply;

public interface ReplyVoDao {
    List findById(@Param("reply") Reply reply);

    List findByCourse(@Param("reply") Reply reply);

    List findBySender(@Param("reply") Reply reply);

    List findByReplyTo(@Param("reply") Reply reply);
}
