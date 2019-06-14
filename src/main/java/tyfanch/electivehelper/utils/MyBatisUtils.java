package tyfanch.electivehelper.utils;

import java.io.InputStream;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tyfanch.electivehelper.constant.config.ConfigFiles;

/**
 * MyBatis工具类
 */
public class MyBatisUtils {
    private MyBatisUtils() {}

    private static SqlSessionFactory sqlSessionFactory = null;

    /**
     * 获取SessionFactory，是唯一的
     *
     * @param inputStream 配置文件输入流
     * @return 获取到的SessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory(InputStream inputStream) {
        if (sqlSessionFactory == null) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }

        return sqlSessionFactory;
    }

    /**
     * 获取SessionFactory，是唯一的
     *
     * @param configFile 配置文件名
     * @return 获取到的SessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory(String configFile) {
        if (sqlSessionFactory == null) {
            InputStream inputStream = MyBatisUtils.class.getResourceAsStream(configFile);
            getSqlSessionFactory(inputStream);
        }

        return sqlSessionFactory;
    }

    public static SqlSession openSession() {
        return openSession(true);
    }

    public static SqlSession openSession(boolean autoCommit) {
        if (sqlSessionFactory == null) {
            sqlSessionFactory = getSqlSessionFactory(ConfigFiles.MYBATIS);
        }

        return sqlSessionFactory.openSession(autoCommit);
    }
}
