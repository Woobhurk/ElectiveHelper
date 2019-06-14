package tyfanch.electivehelper.dao.uni_user;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import tyfanch.electivehelper.bean.StudentCourse;

public interface UniBizDao {
    List findByStudentAndCourse(@Param("studentCourse") StudentCourse studentCourse);

    List findStudentsOfCourse(@Param("studentCourse") StudentCourse studentCourse);

    int selectCourse(@Param("studentCourseMap") Map<String, Object> studentCourseMap);

    int deselectCourse(@Param("studentCourse") StudentCourse studentCourse);

    boolean isCourseConflict(@Param("studentCourse") StudentCourse studentCourse);
}
