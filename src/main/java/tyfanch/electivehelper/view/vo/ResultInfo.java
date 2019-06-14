package tyfanch.electivehelper.view.vo;

import java.io.Serializable;

/**
 * 响应数据
 */
public class ResultInfo implements Serializable {
    private Boolean success = false;
    private Integer resultCode = 0;
    private String resultMsg = "";
    private Object resultData;

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getResultData() {
        return this.resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
            "success=" + this.success +
            ", resultCode=" + this.resultCode +
            ", resultMsg='" + this.resultMsg + '\'' +
            ", resultData=" + this.resultData +
            '}';
    }
}
