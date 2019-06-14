package tyfanch.electivehelper.view.vo;

public class QueryVoConst {
    protected QueryVoConst() {}

    public static final String NAME = "queryVo";

    public static final int QUERY_ALL = 0;
    public static final int QUERY_ALL_COUNT = 1;
    public static final int QUERY_BY_COLUMN = 2;

    public static final String COMPARE_EQ = "=";
    public static final String COMPARE_NEQ = "<>";
    public static final String COMPARE_GT = ">";
    public static final String COMPARE_GT_EQ = ">=";
    public static final String COMPARE_LT = "<";
    public static final String COMPARE_LT_EQ = "<=";
    public static final String COMPARE_LIKE = "LIKE";

    public static final String CONNECTOR_AND = "AND";
    public static final String CONNECTOR_OR = "OR";

    public static final String ORDER_ASC = "ASC";
    public static final String ORDER_DESC = "DESC";

    public static final int RECORD_OFFSET = 0;
    public static final int RECORD_COUNT = 15;
}
