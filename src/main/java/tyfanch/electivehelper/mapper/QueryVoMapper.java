package tyfanch.electivehelper.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tyfanch.electivehelper.view.vo.QueryVo;

public interface QueryVoMapper {
    List queryAll(@Param("queryVo") QueryVo queryVo);

    List queryByColumn(@Param("queryVo") QueryVo queryVo);
}
