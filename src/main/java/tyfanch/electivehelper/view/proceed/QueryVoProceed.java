package tyfanch.electivehelper.view.proceed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tyfanch.electivehelper.view.vo.QueryVo;

public class QueryVoProceed {
    /**
     * 根据查询数据生成完整的SQL语句
     *
     * @param queryVo 查询数据
     * @return 生成的SQL语句
     */
    public String genQuerySql(QueryVo queryVo) {
        String selectSql;

        this.trimConditions(queryVo);
        selectSql = String.format("SELECT * FROM %%s %s;", this.genExtraSql(queryVo));

        return selectSql;
    }

    /**
     * 根据查询数据生成附加SQL片段（条件、排序、记录数量）
     *
     * @param queryVo 查询数据
     * @return 生成的附加SQL片段
     */
    public String genExtraSql(QueryVo queryVo) {
        String extraSql;

        extraSql = String.format("%s %s %s",
            this.genConditionSql(queryVo),
            this.genOrderSql(queryVo),
            this.genLimitSql(queryVo));

        return extraSql;
    }

    /**
     * 根据查询数据生成条件SQL片段
     *
     * @param queryVo 查询数据
     * @return 生成的条件SQL片段
     */
    public String genConditionSql(QueryVo queryVo) {
        String[] columns = queryVo.getColumns();
        String[] compares = queryVo.getCompares();
        Object[] values = queryVo.getValues();
        String[] connectors = queryVo.getConnectors();
        int conditionLength;
        int connectorLength;
        int conditionIndex;
        StringBuilder conditionSqlSb = new StringBuilder();
        String conditionSql;

        conditionLength = Math.min(Math.min(columns.length, compares.length), values.length);
        //connectorLength = Math.min(conditionLength - 1, connectors.length);
        connectorLength = conditionLength - 1;

        if (conditionLength > 0) {
            conditionSqlSb.append("WHERE ");
        }

        for (conditionIndex = 0; conditionIndex < connectorLength; conditionIndex++) {
            conditionSqlSb.append(columns[conditionIndex]);
            conditionSqlSb.append(" ").append(compares[conditionIndex]).append(" ");
            //conditionSqlSb.append(valueList.get(conditionIndex));
            conditionSqlSb.append("?");
            conditionSqlSb.append(" ").append(connectors[conditionIndex]).append(" ");
        }

        if (conditionLength > 0) {
            conditionSqlSb.append(columns[conditionIndex]);
            conditionSqlSb.append(" ").append(compares[conditionIndex]).append(" ");
            //conditionSqlSb.append(valueList.get(conditionIndex));
            conditionSqlSb.append("?");
        }

        conditionSql = conditionSqlSb.toString();

        return conditionSql;
    }

    /**
     * 根据查询数据生成排序SQL片段
     *
     * @param queryVo 查询数据
     * @return 生成的排序SQL片段
     */
    public String genOrderSql(QueryVo queryVo) {
        String orderColumn = queryVo.getOrderColumn();
        String orderMethod = queryVo.getOrderMethod();
        StringBuilder orderSqlSb = new StringBuilder();
        String orderSql;

        if (!orderColumn.isEmpty()) {
            orderSqlSb.append("ORDER BY ");
            orderSqlSb.append(orderColumn).append(" ");
            orderSqlSb.append(orderMethod);
        }

        orderSql = orderSqlSb.toString();

        return orderSql;
    }

    /**
     * 根据查询数据生成记录数量SQL片段
     *
     * @param queryVo 查询数据
     * @return 生成的记录数量SQL片段
     */
    public String genLimitSql(QueryVo queryVo) {
        Integer pageOffset = queryVo.getPageOffset();
        Integer recordOffset = queryVo.getRecordOffset();
        Integer recordCount = queryVo.getRecordCount();
        StringBuilder limitSqlSb = new StringBuilder();
        String limitSql;

        if (pageOffset >= 0 && recordCount > 0) {
            limitSqlSb.append("LIMIT ");
            limitSqlSb.append(pageOffset * recordCount).append(", ");
            limitSqlSb.append(recordCount);
        }

        //if (recordOffset >= 0 && recordCount >= 0) {
        //    limitSqlSb.append("LIMIT ");
        //    limitSqlSb.append(recordOffset).append(",");
        //    limitSqlSb.append(recordCount);
        //}

        limitSql = limitSqlSb.toString();

        return limitSql;
    }

    /**
     * 移除查询数据中无效的条件
     *
     * @param queryVo 查询数据
     */
    private void trimConditions(QueryVo queryVo) {
        List<String> columnList = new ArrayList<>(Arrays.asList(queryVo.getColumns()));
        List<String> compareList = new ArrayList<>(Arrays.asList(queryVo.getCompares()));
        List<Object> valueList = new ArrayList<>(Arrays.asList(queryVo.getValues()));
        List<String> connectorList = new ArrayList<>(Arrays.asList(queryVo.getConnectors()));
        List<String> newColumnList;
        List<String> newCompareList;
        List<Object> newValueList;
        List<String> newConnectorList;
        //int conditionLength = Math.min(Math.min(columnList.size(), compareList.size()),
        //    valueList.size());
        int newConditionLength;

        //for (int i = conditionLength - 1; i >= 0; i--) {
        //    // 方法1：如果有任意一个列表的元素不符合要求则其他列表都要删除同下标元素
        //    if (columnList.get(i) == null
        //        || compareList.get(i) == null
        //        || columnList.get(i).isEmpty()
        //        || compareList.get(i).isEmpty()) {
        //        columnList.remove(i);
        //        compareList.remove(i);
        //    }
        //}

        // 删除参数里面无用元素，但不能修改values值
        // 删除columns列名中无用元素
        columnList.removeIf(t -> t == null || t.isEmpty());
        // 删除compares比较符中无用元素
        compareList.removeIf(t -> t == null || t.isEmpty());
        // 删除connectors连接词中无用元素
        connectorList.removeIf(t -> t == null || t.isEmpty());

        newConditionLength = Math.min(Math.min(columnList.size(), compareList.size()),
            valueList.size());
        newColumnList = columnList.subList(0, newConditionLength);
        newCompareList = compareList.subList(0, newConditionLength);
        newValueList = valueList.subList(0, newConditionLength);

        if (newConditionLength > 0) {
            newConnectorList = connectorList.subList(0, newConditionLength - 1);
        } else {
            newConnectorList = connectorList.subList(0, 0);
        }

        // 把删除之后的条件设置回原查找数据
        queryVo.setColumns(newColumnList.toArray(new String[0]));
        queryVo.setCompares(newCompareList.toArray(new String[0]));
        queryVo.setValues(newValueList.toArray());
        queryVo.setConnectors(newConnectorList.toArray(new String[0]));
    }
}
