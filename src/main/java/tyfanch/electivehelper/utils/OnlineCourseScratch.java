package tyfanch.electivehelper.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import tyfanch.electivehelper.bean.OnlineCourse;
import tyfanch.electivehelper.constant.config.OnlineCourseConfig;
import tyfanch.electivehelper.dao.online_course.OnlineCourseDao;

public class OnlineCourseScratch {
    private OnlineCourseScratch() {}

    public static void main(String[] args) {
        List<String> resultList = scratchAllCourse(null, 1, 50,
            100);
        List<OnlineCourse> onlineCourseList = buildAllCourseList(resultList);
        saveCourse(onlineCourseList);
    }

    public static List<String> scratchAllCourse(String outFileName, int pageStartIndex,
        int pageSize, int pageCount) {
        StringBuilder resultSb = new StringBuilder();
        List<String> resultList = new ArrayList<>();
        String result;

        for (int i = 0; i < pageCount; i++) {
            result = scratchOneCourse(pageStartIndex + i, pageSize);
            resultSb.append(result);
            resultList.add(result);
        }

        if (outFileName != null) {
            Path path = Paths.get(outFileName);
            try (FileWriter fileWriter = new FileWriter(path.toFile(), true)) {
                fileWriter.write(resultSb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return resultList;
    }

    private static String scratchOneCourse(int pageIndex, int pageSize) {
        URL url;
        HttpURLConnection connection;
        String postBody;
        OutputStream outputStream;
        InputStream inputStream;
        String result;
        byte[] resultBuffer = new byte[1024];
        byte[] resultBytes = new byte[0];
        int resultLength;

        try {
            url = new URL(OnlineCourseConfig.REQUEST_URL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Host", "study.163.com");
            connection.setRequestProperty("Origin", "https://study.163.com");
            connection.setRequestProperty("Referer", "https://study.163.com/courses");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");

            System.out.println("---------------------------- page " + pageIndex);
            System.out.println("---- scratchOneCourse.Connecting...");
            connection.connect();
            postBody = String.format("{" +
                "\"keyword\":\"\"," +
                "\"pageIndex\":%d," +
                "\"pageSize\":%d," +
                "\"relativeOffset\":0," +
                "\"searchTimeType\":-1," +
                "\"orderType\":50," +
                "\"priceType\":-1," +
                "\"activityId\":0," +
                "\"qualityType\":0" +
                "}", pageIndex, pageSize);

            System.out.println("---- scratchOneCourse.Posting...");
            outputStream = connection.getOutputStream();
            outputStream.write(postBody.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();

            System.out.println("---- scratchOneCourse.Reading...");
            inputStream = connection.getInputStream();

            while ((resultLength = inputStream.read(resultBuffer)) != -1) {
                resultBytes = Arrays.copyOf(resultBytes,
                    resultBytes.length + resultLength);
                System.arraycopy(resultBuffer, 0, resultBytes,
                    resultBytes.length - resultLength, resultLength);
            }

            System.out.println("---- scratchOneCourse.Finished.");
            result = new String(resultBytes, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
            result = "";
        }

        return result;
    }

    public static List<OnlineCourse> buildAllCourseList(List<String> courseJsonList) {
        List<OnlineCourse> allOnlineCourseList = new ArrayList<>();

        for (String courseJson : courseJsonList) {
            allOnlineCourseList.addAll(buildOneCourseList(courseJson));
        }

        return allOnlineCourseList;
    }

    private static List<OnlineCourse> buildOneCourseList(String courseJson) {
        List<OnlineCourse> onlineCourseList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode root = mapper.readTree(courseJson);
            JsonNode courseNodes = root.path("result").path("list");

            for (JsonNode courseNode : courseNodes) {
                OnlineCourse onlineCourse = new OnlineCourse();

                onlineCourse.setId(null);
                onlineCourse.setProductId(courseNode.path("productId").asLong());
                onlineCourse.setCourseId(courseNode.path("courseId").asLong());
                onlineCourse.setName(courseNode.path("productName").asText());
                onlineCourse.setDescription(courseNode.path("description").asText());
                onlineCourse.setImageUrl(courseNode.path("imgUrl").asText());
                onlineCourse.setProvider(courseNode.path("provider").asText());
                onlineCourse.setScore(courseNode.path("score").asDouble());
                onlineCourseList.add(onlineCourse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return onlineCourseList;
    }

    public static void saveCourse(List<OnlineCourse> onlineCourseList) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        OnlineCourseDao onlineCourseDao = sqlSession.getMapper(OnlineCourseDao.class);

        System.out.println("---- Saving to Database..." + onlineCourseList.size());

        for (OnlineCourse onlineCourse : onlineCourseList) {
            if (onlineCourseDao.findById(onlineCourse).isEmpty()) {
                onlineCourseDao.save(TyBeanUtils.toMap(onlineCourse));
            } else {
                OnlineCourse existedOnlineCourse = (OnlineCourse) onlineCourseDao.findById(onlineCourse).get(0);

                onlineCourse.setId(existedOnlineCourse.getId());
                onlineCourseDao.update(TyBeanUtils.toMap(onlineCourse));
            }
        }

        sqlSession.close();
    }
}
