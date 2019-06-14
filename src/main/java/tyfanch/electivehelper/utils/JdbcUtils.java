package tyfanch.electivehelper.utils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import tyfanch.electivehelper.constant.config.ConfigFiles;

/**
 * JDBC工具类
 */
public class JdbcUtils {
    //private static final Object SYNC_LOCK = Object.class;

    private static DataSource dataSource = null;
    private static JdbcTemplate jdbcTemplate = null;

    private JdbcUtils() {}

    /**
     * 获取连接池，连接池是唯一的
     *
     * @return 连接池
     * @throws Exception 错误
     */
    public static DataSource getDataSource() throws Exception {
        if (dataSource == null) {
            InputStream inputStream = JdbcUtils.class.getResourceAsStream(
                ConfigFiles.DRUID);
            Properties properties = new Properties();

            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }

        return dataSource;
    }

    /**
     * 获取JdbcTemplate，是唯一的
     *
     * @return 获取到的JdbcTemplate
     * @throws Exception 错误
     */
    public static JdbcTemplate getJdbcTemplate() throws Exception {
        getDataSource();

        if (jdbcTemplate == null) {
            jdbcTemplate = new JdbcTemplate(dataSource);
        }

        return jdbcTemplate;
    }

    /**
     * 获取连接
     *
     * @return 连接
     * @throws Exception 错误
     */
    public static Connection getConnection() throws Exception {
        getDataSource();

        return dataSource.getConnection();
    }

    /**
     * 关闭资源
     *
     * @param resultSet 要关闭的结果集
     * @param statement 要关闭的语句
     * @param connection 要关闭的连接
     * @throws SQLException 错误
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection)
        throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }

        if (statement != null) {
            statement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }

    /**
     * 查询数据
     *
     * @param sql SQL语句
     * @param mappedClass 映射到的数据类型
     * @param args SQL参数
     * @param <T> 结果集的类型
     * @return 查询到的结果集
     * @throws Exception 错误
     */
    public static <T> List<T> query(String sql, Class<T> mappedClass, Object... args)
        throws Exception {
        List<T> resultList;

        getJdbcTemplate();
        resultList = jdbcTemplate.query(
            sql, BeanPropertyRowMapper.newInstance(mappedClass), args);

        return resultList;
    }

    /**
     * 更新数据
     *
     * @param sql SQL语句
     * @param args SQL语句参数
     * @return 受影响的行数
     * @throws Exception 错误
     */
    public static int update(String sql, Object... args) throws Exception {
        int affectedRow;

        getJdbcTemplate();
        affectedRow = jdbcTemplate.update(sql, args);

        return affectedRow;
    }
}
