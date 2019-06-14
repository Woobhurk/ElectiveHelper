package tyfanch.electivehelper.view.vo;

import java.io.Serializable;
import java.util.Arrays;

public class QueryVo implements Serializable {
    private String tableName = "";
    // 查找方法
    private Integer queryMethod = 0;
    // 条件字段
    private String[] columns = {};
    // 比较方法
    private String[] compares = {};
    // 比较值
    private Object[] values = {};
    // 连接词
    private String[] connectors = {};
    // 排序的字段
    private String orderColumn = "";
    // 排序方法
    private String orderMethod = "";
    // 查询的当前页数（以0开始）
    private Integer pageOffset = 0;
    // 查询的记录起始位置
    private Integer recordOffset = 0;
    // 查询的记录数量
    private Integer recordCount = 0;
    // 数据
    private Object bean = null;
    // 数据类型
    private Class beanClass;

    public QueryVo() {}

    public QueryVo(String tableName, Class beanClass) {
        this.tableName = tableName;
        this.beanClass = beanClass;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getQueryMethod() {
        return this.queryMethod;
    }

    public void setQueryMethod(Integer queryMethod) {
        this.queryMethod = queryMethod;
    }

    public String[] getColumns() {
        return this.columns;
    }

    public void setColumns(String... columns) {
        this.columns = columns;
    }

    public String[] getCompares() {
        return this.compares;
    }

    public void setCompares(String... compares) {
        this.compares = compares;
    }

    public Object[] getValues() {
        return this.values;
    }

    public void setValues(Object... values) {
        this.values = values;
    }

    public String[] getConnectors() {
        return this.connectors;
    }

    public void setConnectors(String... connectors) {
        this.connectors = connectors;
    }

    public String getOrderColumn() {
        return this.orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getOrderMethod() {
        return this.orderMethod;
    }

    public void setOrderMethod(String orderMethod) {
        this.orderMethod = orderMethod;
    }

    public Integer getPageOffset() {
        return this.pageOffset;
    }

    public void setPageOffset(Integer pageOffset) {
        this.pageOffset = pageOffset;
    }

    public Integer getRecordOffset() {
        return this.recordOffset;
    }

    public void setRecordOffset(Integer recordOffset) {
        this.recordOffset = recordOffset;
    }

    public Integer getRecordCount() {
        return this.recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public Object getBean() {
        return this.bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return this.beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
            "tableName='" + this.tableName + '\'' +
            ", queryMethod=" + this.queryMethod +
            ", columns=" + Arrays.toString(this.columns) +
            ", compares=" + Arrays.toString(this.compares) +
            ", values=" + Arrays.toString(this.values) +
            ", connectors=" + Arrays.toString(this.connectors) +
            ", orderColumn='" + this.orderColumn + '\'' +
            ", orderMethod='" + this.orderMethod + '\'' +
            ", pageOffset=" + this.pageOffset +
            ", recordOffset=" + this.recordOffset +
            ", recordCount=" + this.recordCount +
            ", bean=" + this.bean +
            ", beanClass=" + this.beanClass +
            '}';
    }
}
