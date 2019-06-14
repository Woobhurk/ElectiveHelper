'use strict';

const WEB_ROOT = "/ElectiveHelper";

// admin_login
const METHOD_LOGIN = 0;
const METHOD_REG = 1;

// admin_management
const INDEX_TOTAL_COUNT = 9;
const INDEX_USER = 0;
const INDEX_USER_TYPE = 1;
const INDEX_MSG = 2;
const INDEX_COURSE = 3;
const INDEX_REPLY = 4;
const INDEX_CLASSROOM = 5;
const INDEX_STUDENT = 6;
const INDEX_TEACHER = 7;
const INDEX_STUDENT_COURSE = 8;

// ****************
// VO
// ****************
class QueryVo {
    tableName = "";
    queryMethod = 0;
    columns = [];
    compares = [];
    values = [];
    connectors = [];
    orderColumn = "";
    orderMethod = "";
    pageOffset = 0;
    recordOffset = 0;
    recordCount = 0;
}

class QueryVoConst {
    QUERY_VO = "queryVo";

    QUERY_ALL = 0;
    QUERY_ALL_COUNT = 1;
    QUERY_BY_COLUMN = 2;

    RECORD_OFFSET = 0;
    RECORD_COUNT = 15;

    COLUMN_NAMES = {};

    COMPARE_NAMES = {
        eq: ["=", "等于"],
        neq: ["<>", "不等于"],
        gt: [">", "大于"],
        gtEq: [">=", "大于等于"],
        lt: ["<", "小于"],
        ltEq: ["<=", "小于等于"],
        like: ["LIKE", "类似"]
    };

    CONNECTOR_NAMES = {
        and: ["AND", "且"],
        or: ["OR", "或"]
    };
}

class UpdateVo {
    tableName = "";
    updateMethod = 0;
    updateColumns = [];
    updateValues = [];
    columns = [];
    compares = [];
    values = [];
    connectors = [];
}

class UpdateVoConst {
    UPDATE_VO = "updateVo";

    UPDATE_INSERT = 0;
    UPDATE_DELETE = 1;
    UPDATE_MODIFY = 2;

    COLUMN_NAMES = {};

    COMPARE_NAMES = {
        eq: ["=", "等于"],
        neq: ["<>", "不等于"],
        gt: [">", "大于"],
        gtEq: [">=", "大于等于"],
        lt: ["<", "小于"],
        ltEq: ["<=", "小于等于"],
        like: ["LIKE", "类似"]
    };

    CONNECTOR_NAMES = {
        and: ["AND", "且"],
        or: ["OR", "或"]
    };
}

class UserVo {
    type = 0;
    username = "";
    email = "";
    password = "";
    confPassword = "";
    captcha = "";
    passwordEncrypted = false;
}

class UserQueryVo extends QueryVo {
    tableName = new UserConst().tableName;
}

class UserQueryVoConst extends QueryVoConst {
    COLUMN_NAMES = new UserConst().COLUMN_NAMES;
}

class UserUpdateVo extends UpdateVo {
    tableName = new UserConst().tableName;
}

class UserUpdateVoConst extends UpdateVoConst {
    COLUMN_NAMES = new UserConst().COLUMN_NAMES;
}

class UserTypeQueryVo extends QueryVo {
    tableName = new UserTypeConst().tableName;
}

class UserTypeQueryVoConst extends QueryVoConst {
    COLUMN_NAMES = new UserTypeConst().COLUMN_NAMES;
}

class UserTypeUpdateVo extends UpdateVo {
    tableName = new UserTypeConst().tableName;
}

class UserTypeUpdateVoConst extends UpdateVoConst {
    COLUMN_NAMES = new UserTypeConst().COLUMN_NAMES;
}

class MsgQueryVo extends QueryVo {
    tableName = new MsgConst().tableName;
}

class MsgQueryVoConst extends QueryVoConst {
    COLUMN_NAMES = new MsgConst().COLUMN_NAMES;
}

class MsgUpdateVo extends UpdateVo {
    tableName = new MsgConst().tableName;
}

class MsgUpdateVoConst extends UpdateVoConst {
    COLUMN_NAMES = new MsgConst().COLUMN_NAMES;
}

class CourseQueryVo extends QueryVo {
    tableName = new CourseConst().tableName;
}

class CourseQueryVoConst extends QueryVoConst {
    COLUMN_NAMES = new CourseConst().COLUMN_NAMES;
}

class CourseUpdateVo extends UpdateVo {
    tableName = new CourseConst().tableName;
}

class CourseUpdateVoConst extends UpdateVoConst {
    COLUMN_NAMES = new CourseConst().COLUMN_NAMES;
}

class ReplyQueryVo extends QueryVo {
    tableName = new ReplyConst().tableName;
}

class ReplyQueryVoConst extends QueryVoConst {
    COLUMN_NAMES = new ReplyConst().COLUMN_NAMES;
}

class ReplyUpdateVo extends UpdateVo {
    tableName = new ReplyConst().tableName;
}

class ReplyUpdateVoConst extends UpdateVoConst {
    COLUMN_NAMES = new ReplyConst().COLUMN_NAMES;
}

class ClassroomQueryVo extends QueryVo {
    tableName = new ClassroomConst().tableName;
}

class ClassroomQueryVoConst extends QueryVoConst {
    COLUMN_NAMES = new ClassroomConst().COLUMN_NAMES;
}

class ClassroomUpdateVo extends UpdateVo {
    tableName = new ClassroomConst().tableName;
}

class ClassroomUpdateVoConst extends UpdateVoConst {
    COLUMN_NAMES = new ClassroomConst().COLUMN_NAMES;
}

class StudentQueryVo extends QueryVo {
    tableName = new StudentConst().tableName;
}

class StudentQueryVoConst extends QueryVoConst {
    COLUMN_NAMES = new StudentConst().COLUMN_NAMES;
}

class StudentUpdateVo extends UpdateVo {
    tableName = new StudentConst().tableName;
}

class StudentUpdateVoConst extends UpdateVoConst {
    COLUMN_NAMES = new StudentConst().COLUMN_NAMES;
}

class TeacherQueryVo extends QueryVo {
    tableName = new TeacherConst().tableName;
}

class TeacherQueryVoConst extends QueryVoConst {
    COLUMN_NAMES = new TeacherConst().COLUMN_NAMES;
}

class TeacherUpdateVo extends UpdateVo {
    tableName = new TeacherConst().tableName;
}

class TeacherUpdateVoConst extends UpdateVoConst {
    COLUMN_NAMES = new TeacherConst().COLUMN_NAMES;
}

class StudentCourseQueryVo extends QueryVo {
    tableName = new StudentCourseConst().tableName;
}

class StudentCourseQueryVoConst extends QueryVoConst {
    COLUMN_NAMES = new StudentCourseConst().COLUMN_NAMES;
}

class StudentCourseUpdateVo extends UpdateVo {
    tableName = new StudentCourseConst().tableName;
}

class StudentCourseUpdateVoConst extends UpdateVoConst {
    COLUMN_NAMES = new StudentCourseConst().COLUMN_NAMES;
}


/**
 * 响应数据类
 * */
class ResultInfo {
    success = false;
    resultCode = 0;
    resultMsg = "";
    resultData = null;
}

class ResultInfoConst {
    COLUMN_NAMES = {
        success: ["success", "成功状态"],
        resultCode: ["resultCode", "状态码"],
        resultMsg: ["resultMsg", "状态信息"],
        resultData: ["resultData", "响应数据"]
    };
}


// **************
// DBO
// **************
class BeanConst {
    tableName = "";

    COLUMN_NAMES = {};
}

//class User {
//    // 用户ID
//    id = 0;
//    // 用户类型
//    type = 0;
//    // 用户名
//    username = "";
//    // 邮箱
//    email = "";
//    // 密码
//    password = "";
//    // 其他信息
//    comment = "";
//    // Session Id
//    sessionId = "";
//}

class UserConst extends BeanConst {
    tableName = "user";

    COLUMN_NAMES = {
        id: ["id", "ID"],
        uuid: ["uuid", "UUID"],
        type: ["type", "类型"],
        username: ["username", "用户名"],
        email: ["email", "邮箱"],
        password: ["password", "密码"],
        comment: ["comment", "备注"],
    };
}

class UserTypeConst extends BeanConst {
    tableName = "user_type";

    COLUMN_NAMES = {
        id: ["id", "ID"],
        type: ["type", "类型"],
        typeName: ["typeName", "类型名"]
    };
}

//class Msg {
//    // 聊天记录ID
//    id = 0;
//    // 发送方id
//    senderId = 0;
//    // 接收方id
//    receiverId = 0;
//    // 聊天记录时间
//    msgTime = "";
//    // 聊天记录内容
//    msgText = "";
//}

class MsgConst extends BeanConst {
    tableName = "msg";

    COLUMN_NAMES = {
        id: ["id", "ID"],
        senderId: ["senderId", "发送方"],
        receiverId: ["receiverId", "接收方"],
        msgTime: ["msgTime", "记录时间"],
        msgText: ["msgText", "记录内容"]
    };
}

class CourseConst extends BeanConst {
    tableName = "course";

    COLUMN_NAMES = {
        id: ["id", "ID"],
        teacherId: ["teacherId", "教师ID"],
        name: ["name", "课程名"],
        description: ["description", "描述"],
        keywords: ["keywords", "关键词"],
        startTime: ["startTime", "起始时间"],
        endTime: ["endTime", "结束时间"],
        classroomId: ["classroomId", "教室ID"],
        dayOfWeek: ["dayOfWeek", "上课时间"],
        classOfDay: ["classOfDay", "上课节数"],
        rateTotal: ["rateTotal", "总评分"],
        rateCount: ["rateCount", "评分人数"]
    };
}

class ReplyConst extends BeanConst {
    tableName = "reply";

    COLUMN_NAMES = {
        id: ["id", "ID"],
        courseId: ["courseId", "课程ID"],
        senderId: ["senderId", "发送者ID"],
        replyTo: ["replyTo", "回复到"],
        replyTime: ["replyTime", "时间"],
        replyText: ["replyText", "内容"]
    };
}

class ClassroomConst extends BeanConst {
    tableName = "classroom";

    COLUMN_NAMES = {
        id: ["id", "ID"],
        building: ["building", "楼栋"],
        room: ["room", "教室"]
    };
}

class StudentConst extends BeanConst {
    tableName = "student";

    COLUMN_NAMES = {
        id: ["id", "ID"],
        type: ["type", "类型"],
        account: ["account", "账号"],
        password: ["password", "密码"],
        userId: ["userId", "关联用户"],
        name: ["name", "姓名"],
        school: ["school", "学院"],
        major: ["major", "专业"]
    };
}

class TeacherConst extends BeanConst {
    tableName = "teacher";

    COLUMN_NAMES = {
        id: ["id", "ID"],
        type: ["type", "类型"],
        account: ["account", "账号"],
        password: ["password", "密码"],
        userId: ["userId", "关联用户"],
        name: ["name", "姓名"],
        school: ["school", "学院"],
        major: ["major", "专业"]
    };
}

class StudentCourseConst extends BeanConst {
    tableName = "student_course";

    COLUMN_NAMES = {
        id: ["id", "ID"],
        studentId: ["studentId", "学生ID"],
        courseId: ["courseId", "课程ID"]
    };
}
