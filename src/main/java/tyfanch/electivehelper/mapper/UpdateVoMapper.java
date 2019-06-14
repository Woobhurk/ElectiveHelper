package tyfanch.electivehelper.mapper;

import org.apache.ibatis.annotations.Param;
import tyfanch.electivehelper.view.vo.UpdateVo;

public interface UpdateVoMapper {
    int insert(@Param("updateVo") UpdateVo updateVo);

    int delete(@Param("updateVo") UpdateVo updateVo);

    int update(@Param("updateVo") UpdateVo updateVo);
}
