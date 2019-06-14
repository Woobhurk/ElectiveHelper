package tyfanch.electivehelper.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tyfanch.electivehelper.view.vo.ResultInfo;

/**
 * 管理员处理业务
 */
public interface AdminBizService {
    /**
     * 查询表
     *
     * @param request 请求
     * @param response 响应
     * @return 查询到的数据，封装成响应数据
     */
    ResultInfo queryTable(HttpServletRequest request, HttpServletResponse response);

    /**
     * 更新表
     *
     * @param request 请求
     * @param response 响应
     * @return 受影响的行数，封装成响应数据
     */
    ResultInfo updateTable(HttpServletRequest request, HttpServletResponse response);
}
