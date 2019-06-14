package tyfanch.electivehelper.dao.online_course;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import tyfanch.electivehelper.bean.OnlineCourse;

public interface OnlineCourseDao {
    List findAll();

    List findById(@Param("onlineCourse") OnlineCourse onlineCourse);

    List findByName(@Param("onlineCourse") OnlineCourse onlineCourse, @Param("count") int count);

    List findRandomly(@Param("count") int count);

    int save(@Param("onlineCourseMap") Map<String, Object> onlineCourseMap);

    int update(@Param("onlineCourseMap") Map<String, Object> onlineCourseMap);
}
