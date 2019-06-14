package tyfanch.electivehelper.dao.course;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import tyfanch.electivehelper.bean.Course;
import tyfanch.electivehelper.bean.UniUser;

public interface CourseDao {
    List findAll();

    List findByTeacher(@Param("teacher") UniUser uniUser);

    List findByStudent(@Param("student") UniUser uniUser);

    List findTeacherKeywords(@Param("teacher") UniUser uniUser);

    List findStudentKeywords(@Param("student") UniUser uniUser);

    int save(@Param("courseMap") Map<String, Object> courseMap);

    int update(@Param("courseMap") Map<String, Object> courseMap);

    int deleteById(@Param("course") Course course);
}
