package tyfanch.electivehelper.constant.config;

public class OnlineCourseConfig {
    private OnlineCourseConfig() {}

    public static final String REQUEST_URL = "https://study.163.com/p/search/studycourse.json";
    public static final String COURSE_URL = "https://study.163.com/course/introduction/%d.htm";
    public static final String OUT_FILE = "./163Course.json";
    public static final int ONLINE_COURSE_COUNT = 64;
}
