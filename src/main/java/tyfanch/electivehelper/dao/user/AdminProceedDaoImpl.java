package tyfanch.electivehelper.dao.user;

import java.util.List;
import tyfanch.electivehelper.view.proceed.QueryVoProceed;
import tyfanch.electivehelper.view.proceed.UpdateVoProceed;
import tyfanch.electivehelper.view.vo.QueryVo;
import tyfanch.electivehelper.view.vo.UpdateVo;

/**
 * 管理员业务DAO实现类
 */
public class AdminProceedDaoImpl implements AdminProceedDao {
    @Override
    public List queryAll(QueryVo queryVo) throws Exception {
        List resultList;

        // 自动将查找数据里面没用的信息去除
        queryVo.setRecordCount(0);
        resultList = this.queryByColumn(queryVo);

        return resultList;
    }

    @Override
    public List queryByColumn(QueryVo queryVo) throws Exception {
        String tableName = queryVo.getTableName();
        String sql;
        Class beanClass = queryVo.getBeanClass();
        Object[] args = queryVo.getValues();
        List resultList;

        sql = new QueryVoProceed().genQuerySql(queryVo);
        resultList = this.query(tableName, sql, beanClass, args);

        return resultList;
    }

    @Override
    public int insert(UpdateVo updateVo) throws Exception {
        String tableName = updateVo.getTableName();
        String sql = new UpdateVoProceed().genUpdateSql(updateVo);
        Object[] args = updateVo.getUpdateValues();
        int affectedRow;

        affectedRow = this.insert(tableName, sql, args);

        return affectedRow;
    }

    @Override
    public int delete(UpdateVo updateVo) throws Exception {
        String tableName = updateVo.getTableName();
        String sql = new UpdateVoProceed().genUpdateSql(updateVo);
        Object[] args = updateVo.getValues();
        int affectedRow;

        affectedRow = this.delete(tableName, sql, args);

        return affectedRow;
    }

    @Override
    public int update(UpdateVo updateVo) throws Exception {
        String tableName = updateVo.getTableName();
        String sql = new UpdateVoProceed().genUpdateSql(updateVo);
        Object[] args = this.combineArgs(updateVo.getUpdateValues(), updateVo.getValues());
        int affectedRow;

        affectedRow = this.update(tableName, sql, args);

        return affectedRow;
    }

    /**
     * 将可变参数里多个数组合并成一个数组，便于传值给JdbcUtils
     *
     * @param args 可变参数
     * @return 合并后的可变参数
     */
    private Object[] combineArgs(Object... args) {
        Object[] combinedArgs;
        int argsCount = 0;
        int argsOffset = 0;

        // 计算args内所有参数的个数
        for (Object arg : args) {
            if (arg instanceof Object[]) {
                argsCount += ((Object[]) arg).length;
            } else {
                argsCount++;
            }
        }

        combinedArgs = new Object[argsCount];

        // 将args内数组和元素复制到合并后的数组里面
        for (Object arg : args) {
            if (arg instanceof Object[]) {
                System.arraycopy((Object[]) arg, 0, combinedArgs,
                    argsOffset, ((Object[]) arg).length);
                argsOffset += ((Object[]) arg).length;
            } else {
                combinedArgs[argsOffset] = arg;
                argsOffset++;
            }
        }

        return combinedArgs;
    }
}
