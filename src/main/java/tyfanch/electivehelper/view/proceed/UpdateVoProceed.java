package tyfanch.electivehelper.view.proceed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tyfanch.electivehelper.view.vo.UpdateVo;
import tyfanch.electivehelper.view.vo.UpdateVoConst;

public class UpdateVoProceed {
    /**
     * 根据更新数据生成相应的SQL更新语句
     *
     * @param updateVo 更新数据
     * @return 生成的SQL更新语句
     */
    public String genUpdateSql(UpdateVo updateVo) {
        String updateSql;

        switch (updateVo.getUpdateMethod()) {
        case UpdateVoConst.UPDATE_INSERT:
            updateSql = this.genInsertSql(updateVo);
            break;
        case UpdateVoConst.UPDATE_DELETE:
            updateSql = this.genDeleteSql(updateVo);
            break;
        default:
            updateSql = this.genModifySql(updateVo);
        }

        return updateSql;
    }

    /**
     * 根据更新数据生成完整的SQL插入语句
     *
     * @param updateVo 更新数据
     * @return 生成的SQL语句
     */
    public String genInsertSql(UpdateVo updateVo) {
        String columnsSql;
        String valuesSql;
        String insertSql;

        this.trimConditions(updateVo);
        valuesSql = this.genInsertValuesSql(updateVo);
        columnsSql = this.genInsertColumnsSql(updateVo);
        insertSql = String.format("INSERT INTO %%s (%s) VALUES (%s);", columnsSql, valuesSql);

        return insertSql;
    }

    /**
     * 根据更新数据生成完整的SQL删除语句
     *
     * @param updateVo 更新数据
     * @return 生成的SQL语句
     */
    public String genDeleteSql(UpdateVo updateVo) {
        String deleteSql;

        this.trimConditions(updateVo);
        deleteSql = String.format("DELETE FROM %%s %s;", this.genExtraSql(updateVo));

        return deleteSql;
    }

    /**
     * 根据更新数据生成完整的SQL修改语句
     *
     * @param updateVo 更新数据
     * @return 生成的SQL语句
     */
    public String genModifySql(UpdateVo updateVo) {
        String modifySql;

        this.trimConditions(updateVo);
        modifySql = String.format("UPDATE %%s SET %s %s;",
            this.genModifySetsSql(updateVo),
            this.genExtraSql(updateVo));

        return modifySql;
    }

    /**
     * 根据查询数据生成附加SQL片段（条件、排序、记录数量）
     *
     * @param updateVo 查询数据
     * @return 生成的附加SQL片段
     */
    public String genExtraSql(UpdateVo updateVo) {
        String extraSql;

        extraSql = this.genConditionSql(updateVo);

        return extraSql;
    }

    /**
     * 根据查询数据生成条件SQL片段
     *
     * @param updateVo 查询数据
     * @return 生成的条件SQL片段
     */
    public String genConditionSql(UpdateVo updateVo) {
        String[] columns = updateVo.getColumns();
        String[] compares = updateVo.getCompares();
        Object[] values = updateVo.getValues();
        String[] connectors = updateVo.getConnectors();
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
     * 生成SQL插入语句的列名
     *
     * @param updateVo 更新数据
     * @return 生成的SQL片段
     */
    private String genInsertColumnsSql(UpdateVo updateVo) {
        String columnsSql;

        columnsSql = String.join(", ", updateVo.getUpdateColumns());

        return columnsSql;
    }

    /**
     * 生成SQL插入语句的值
     *
     * @param updateVo 更新数据
     * @return 生成的SQL片段
     */
    private String genInsertValuesSql(UpdateVo updateVo) {
        int valuesLength = updateVo.getUpdateValues().length;
        String[] values = new String[valuesLength];
        String valuesSql;

        Arrays.fill(values, "?");
        valuesSql = String.join(", ", values);

        return valuesSql;
    }

    /**
     * 生成SQL修改语句的SET片段
     *
     * @param updateVo 更新数据
     * @return 生成的SQL语句片段
     */
    private String genModifySetsSql(UpdateVo updateVo) {
        String[] updateColumns = updateVo.getUpdateColumns();
        //Object[] updateValues = updateVo.getUpdateValues();
        int modifyColumnLength = updateColumns.length;
        int modifyColumnIndex;
        StringBuilder modifySetsSqlSb = new StringBuilder();
        String modifySetsSql;

        for (modifyColumnIndex = 0; modifyColumnIndex < modifyColumnLength - 1;
             modifyColumnIndex++) {
            modifySetsSqlSb.append(updateColumns[modifyColumnIndex]);
            modifySetsSqlSb.append(" = ");
            modifySetsSqlSb.append("?");
            //modifySetsSqlSb.append(updateValues[modifyColumnIndex]);
            modifySetsSqlSb.append(", ");
        }

        if (modifyColumnLength > 0) {
            modifySetsSqlSb.append(updateColumns[modifyColumnIndex]);
            modifySetsSqlSb.append(" = ");
            modifySetsSqlSb.append("?");
            //modifySetsSqlSb.append(updateValues[modifyColumnIndex]);
        }

        modifySetsSql = modifySetsSqlSb.toString();

        return modifySetsSql;
    }

    /**
     * 移除查询数据中无效的条件
     *
     * @param updateVo 查询数据
     */
    private void trimConditions(UpdateVo updateVo) {
        List<String> updateColumnList = new ArrayList<>(Arrays.asList(updateVo.getUpdateColumns()));
        List<Object> updateValueList = new ArrayList<>(Arrays.asList(updateVo.getUpdateValues()));
        List<String> columnList = new ArrayList<>(Arrays.asList(updateVo.getColumns()));
        List<String> compareList = new ArrayList<>(Arrays.asList(updateVo.getCompares()));
        List<Object> valueList = new ArrayList<>(Arrays.asList(updateVo.getValues()));
        List<String> connectorList = new ArrayList<>(Arrays.asList(updateVo.getConnectors()));
        List<String> newUpdateColumnList;
        List<Object> newUpdateValueList;
        List<String> newColumnList;
        List<String> newCompareList;
        List<Object> newValueList;
        List<String> newConnectorList;
        //int conditionLength = Math.min(Math.min(columnList.size(), compareList.size()),
        //    valueList.size());
        int newUpdateLength;
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
        // 删除updateColumns更新列中无用元素
        updateColumnList.removeIf(t -> t == null || t.isEmpty());
        // 删除columns列名中无用元素
        columnList.removeIf(t -> t == null || t.isEmpty());
        // 删除compares比较符中无用元素
        compareList.removeIf(t -> t == null || t.isEmpty());
        // 删除connectors连接词中无用元素
        connectorList.removeIf(t -> t == null || t.isEmpty());

        newUpdateLength = Math.min(updateColumnList.size(), updateValueList.size());
        newConditionLength = Math.min(Math.min(columnList.size(), compareList.size()),
            valueList.size());
        newUpdateColumnList = updateColumnList.subList(0, newUpdateLength);
        newUpdateValueList = updateValueList.subList(0, newUpdateLength);
        newColumnList = columnList.subList(0, newConditionLength);
        newCompareList = compareList.subList(0, newConditionLength);
        newValueList = valueList.subList(0, newConditionLength);

        if (newConditionLength > 0) {
            newConnectorList = connectorList.subList(0, newConditionLength - 1);
        } else {
            newConnectorList = connectorList.subList(0, 0);
        }

        // 把删除之后的条件设置回原查找数据
        updateVo.setUpdateColumns(newUpdateColumnList.toArray(new String[0]));
        updateVo.setUpdateValues(newUpdateValueList.toArray(new Object[0]));
        updateVo.setColumns(newColumnList.toArray(new String[0]));
        updateVo.setCompares(newCompareList.toArray(new String[0]));
        updateVo.setValues(newValueList.toArray());
        updateVo.setConnectors(newConnectorList.toArray(new String[0]));
    }
}
