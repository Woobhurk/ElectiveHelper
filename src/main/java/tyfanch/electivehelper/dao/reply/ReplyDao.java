package tyfanch.electivehelper.dao.reply;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import tyfanch.electivehelper.bean.Reply;

public interface ReplyDao {
    List findById(@Param("reply") Reply reply);

    List findByCourse(@Param("reply") Reply reply);

    List findBySender(@Param("reply") Reply reply);

    List findByReplyTo(@Param("reply") Reply reply);

    int save(@Param("replyMap") Map<String, Object> replyMap);

    int deleteById(@Param("reply") Reply reply);
}
