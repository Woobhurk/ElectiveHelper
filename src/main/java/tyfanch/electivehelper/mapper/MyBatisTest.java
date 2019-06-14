package tyfanch.electivehelper.mapper;

import org.apache.ibatis.session.SqlSession;
import tyfanch.electivehelper.bean.Course;
import tyfanch.electivehelper.bean.Msg;
import tyfanch.electivehelper.bean.Reply;
import tyfanch.electivehelper.bean.Student;
import tyfanch.electivehelper.bean.StudentCourse;
import tyfanch.electivehelper.bean.Teacher;
import tyfanch.electivehelper.bean.User;
import tyfanch.electivehelper.bean.UserConst;
import tyfanch.electivehelper.bean.UserType;
import tyfanch.electivehelper.bean.UserTypeConst;
import tyfanch.electivehelper.constant.config.DbConfig;
import tyfanch.electivehelper.dao.course.CourseDao;
import tyfanch.electivehelper.dao.course.CourseVoDao;
import tyfanch.electivehelper.dao.msg.MsgDao;
import tyfanch.electivehelper.dao.reply.ReplyDao;
import tyfanch.electivehelper.dao.reply.ReplyVoDao;
import tyfanch.electivehelper.dao.uni_user.UniAccountDao;
import tyfanch.electivehelper.dao.uni_user.UniBizDao;
import tyfanch.electivehelper.utils.Md5Utils;
import tyfanch.electivehelper.utils.MyBatisUtils;
import tyfanch.electivehelper.view.vo.CourseVo;
import tyfanch.electivehelper.view.vo.QueryVo;
import tyfanch.electivehelper.view.vo.ReplyVo;
import tyfanch.electivehelper.view.vo.UpdateVo;

public class MyBatisTest {
    public static void main(String[] args) {
        MyBatisTest myBatisTest = new MyBatisTest();
        SqlSession sqlSession = MyBatisUtils.openSession();

        //myBatisTest.testQueryVo(sqlSession);
        //myBatisTest.testUpdateVo(sqlSession);
        //myBatisTest.testAdminAccountDao(sqlSession);
        //myBatisTest.testMsgDao(sqlSession);
        //myBatisTest.testCourseDao(sqlSession);
        //myBatisTest.testReplyDao(sqlSession);
        myBatisTest.testReplyVoDao(sqlSession);
        //myBatisTest.testStudentAccountDao(sqlSession);
        //myBatisTest.testUniUserAccountDao(sqlSession);
        //myBatisTest.testUniBizDao(sqlSession);
        //myBatisTest.testCourseVoDao(sqlSession);
        sqlSession.close();
    }
    private void testQueryVo(SqlSession sqlSession) {
        System.out.println("---- testQueryVo: ");

        QueryVoMapper queryVoMapper = sqlSession.getMapper(QueryVoMapper.class);
        QueryVo queryVo = new QueryVo(DbConfig.TABLE_USER, User.class);
        queryVo.setColumns(UserConst.COLUMN_ID, UserConst.COLUMN_ID);
        queryVo.setCompares(">", "<");
        queryVo.setValues(10, 100);
        queryVo.setConnectors("AND");
        queryVo.setPageOffset(1);
        queryVo.setRecordCount(5);

        System.out.println(queryVoMapper.queryByColumn(queryVo));
    }

    private void testUpdateVo(SqlSession sqlSession) {
        System.out.println("---- testUpdateVo: ");

        UpdateVoMapper updateVoMapper = sqlSession.getMapper(UpdateVoMapper.class);
        UpdateVo updateVo = new UpdateVo(DbConfig.TABLE_USER_TYPE, UserType.class);
        updateVo.setUpdateColumns(UserTypeConst.COLUMN_TYPE, UserTypeConst.COLUMN_TYPE_NAME);
        updateVo.setUpdateValues(3, "null");
        updateVo.setColumns(UserTypeConst.COLUMN_TYPE);
        updateVo.setCompares("=");
        updateVo.setValues(3);
        updateVoMapper.insert(updateVo);
        updateVoMapper.update(updateVo);
        updateVoMapper.delete(updateVo);
    }

    private void testMsgDao(SqlSession sqlSession) {
        MsgDao msgDao = sqlSession.getMapper(MsgDao.class);

        Msg msg = new Msg();

        msg.setSenderId(92);
        System.out.println(msgDao.findBySingle(msg));
    }

    private void testCourseDao(SqlSession sqlSession) {
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        Course course = new Course();

        course.setName("00");
        course.setDayOfWeek(1);
        course.setClassOfDay(1);
        //System.out.println(courseDao.findByName(course));
    }

    private void testReplyDao(SqlSession sqlSession) {
        ReplyDao replyDao = sqlSession.getMapper(ReplyDao.class);
        Reply reply = new Reply();

        reply.setCourseId(52);
        reply.setSenderId(1);

        System.out.println(replyDao.findBySender(reply));
    }

    private void testReplyVoDao(SqlSession sqlSession) {
        ReplyVoDao replyVoDao = sqlSession.getMapper(ReplyVoDao.class);
        Reply reply = new Reply();

        reply.setCourseId(51);
        System.out.println(((ReplyVo) replyVoDao.findByCourse(reply).get(0)).getReplyTo());
    }

    //private void testStudentAccountDao(SqlSession sqlSession) {
    //    StudentAccountDao studentAccountDao = sqlSession.getMapper(StudentAccountDao.class);
    //    Student student = new Student();
    //
    //    student.setAccount("20172270607");
    //    student.setPassword(Md5Utils.toMd5("20172270607.."));
    //    //System.out.println(studentAccountDao.find(student));
    //    System.out.println(studentAccountDao.findByIds(new int[]{1, 4, 6, 30, 10}));
    //}

    private void testUniUserAccountDao(SqlSession sqlSession) {
        UniAccountDao uniAccountDao = sqlSession.getMapper(UniAccountDao.class);
        //UniUser uniUser = new UniUser();
        Student student = new Student();

        student.setAccount("20172270607");
        student.setPassword(Md5Utils.toMd5("20172270607.."));
        System.out.println(uniAccountDao.find(DbConfig.TABLE_STUDENT, student));
    }

    private void testUniBizDao(SqlSession sqlSession) {
        UniBizDao uniBizDao = sqlSession.getMapper(UniBizDao.class);
        StudentCourse studentCourse = new StudentCourse();

        studentCourse.setStudentId(21);
        studentCourse.setCourseId(51);
        System.out.println(uniBizDao.findByStudentAndCourse(studentCourse));
    }

    private void testCourseVoDao(SqlSession sqlSession) {
        CourseVoDao courseVoDao = sqlSession.getMapper(CourseVoDao.class);
        Course course = new Course();
        Teacher teacher = new Teacher();
        CourseVo courseVo = new CourseVo();

        //course.setName("00");
        //System.out.println(courseVoDao.findByName(course));
        //teacher.setName("11");
        //courseVo.setName("6");
        //courseVo.setTeacher(teacher);
        System.out.println(courseVoDao.findByColumn(courseVo));
    }
}
