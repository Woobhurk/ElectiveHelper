package tyfanch.electivehelper.dao.course;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tyfanch.electivehelper.bean.UniUser;
import tyfanch.electivehelper.view.vo.CourseVo;

public interface CourseVoDao {
    List findAll();

    List findByColumn(@Param("courseVo") CourseVo courseVo);

    List findByTeacherAndColumn(@Param("teacher") UniUser uniUser,
        @Param("courseVo") CourseVo courseVo);

    List findByStudentAndColumn(@Param("student") UniUser uniUser,
        @Param("courseVo") CourseVo courseVo);
}
