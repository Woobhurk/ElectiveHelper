package tyfanch.electivehelper.dao.user;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import tyfanch.electivehelper.utils.JdbcUtils;
import tyfanch.electivehelper.view.vo.QueryVo;
import tyfanch.electivehelper.view.vo.UpdateVo;

/**
 * 管理员处理DAO
 */
public interface AdminProceedDao {
    /**
     * 根据指定列查询所有结果，会忽略recordCount参数
     *
     * @param queryVo 查找数据
     * @return 查找到的结果集
     * @throws Exception 错误
     */
    List queryAll(QueryVo queryVo) throws Exception;

    /**
     * 根据指定列查找结果
     *
     * @param queryVo 查找数据
     * @return 查找到的结果集
     * @throws Exception 错误
     */
    List queryByColumn(QueryVo queryVo) throws Exception;
    /**
     * 插入记录
     *
     * @param updateVo 更新数据
     * @return 受影响的行数
     * @throws Exception 错误
     */
    int insert(UpdateVo updateVo) throws Exception;

    /**
     * 删除记录
     *
     * @param updateVo 更新数据
     * @return 受影响的行数
     * @throws Exception 错误
     */
    int delete(UpdateVo updateVo) throws Exception;

    /**
     * 修改记录
     *
     * @param updateVo 更新数据
     * @return 受影响的行数
     * @throws Exception 错误
     */
    int update(UpdateVo updateVo) throws Exception;

    /**
     * 查询记录
     *
     * @param tableName 表名
     * @param beanClass 映射到的记录类型
     * @param args SQL参数
     * @param <T> 数据类型
     * @return 查询结果集
     * @throws Exception 错误
     */
    default <T> List<T> query(String tableName, String sql, Class<T> beanClass, Object... args)
        throws Exception {
        String formattedSql;
        List<T> resultList;

        formattedSql = String.format(sql, tableName);
        System.out.println("---- AdminProceedDao.queryTable: " + formattedSql);
        System.out.println("---- AdminProceedDao.queryTable: args=" + Arrays.toString(args));
        resultList = JdbcUtils.query(formattedSql, beanClass, args);

        return resultList;
    }

    /**
     * 添加记录
     *
     * @param tableName 表名
     * @param sql 字段名
     * @param args SQL参数
     * @return 受影响的行数
     * @throws Exception 错误
     */
    default int insert(String tableName, String sql, Object... args) throws Exception {
        String formattedSql;
        int affectedRow;

        formattedSql = String.format(sql, tableName);

        System.out.println("---- AdminProceedDao.insert: " + formattedSql);
        System.out.println("---- AdminProceedDao.insert: args=" + Arrays.toString(args));
        affectedRow = JdbcUtils.update(formattedSql, args);

        return affectedRow;
    }

    /**
     * 删除记录
     *
     * @param tableName 表名
     * @param sql 添加条件
     * @param args SQL参数
     * @return 受影响的行数
     * @throws Exception 错误
     */
    default int delete(String tableName, String sql, Object... args) throws Exception {
        Objects.requireNonNull(sql);

        String formattedSql;
        int affectedRow;

        formattedSql = String.format(sql, tableName);
        System.out.println("---- AdminProceedDao.delete: " + formattedSql);
        System.out.println("---- AdminProceedDao.delete: args=" + Arrays.toString(args));
        affectedRow = JdbcUtils.update(formattedSql, args);

        return affectedRow;
    }

    /**
     * 修改表
     *
     * @param tableName 表名
     * @param sql 修改的列
     * @param args SQL参数
     * @return 受影响的行数
     * @throws Exception 错误
     */
    default int update(String tableName, String sql, Object... args) throws Exception {
        String formattedSql;
        int affectedRow;

        formattedSql = String.format(sql, tableName);
        System.out.println("---- AdminProceedDao.update: " + formattedSql);
        System.out.println("---- AdminProceedDao.update: args=" + Arrays.toString(args));
        affectedRow = JdbcUtils.update(formattedSql, args);

        return affectedRow;
    }
}
