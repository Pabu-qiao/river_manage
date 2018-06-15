package com.rivermanage.mapper.base;

import com.rivermanage.pojo.base.WqWqmonitorB;
import com.rivermanage.pojo.base.WqWqmonitorBExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WqWqmonitorBMapper {
    long countByExample(WqWqmonitorBExample example);

    int deleteByExample(WqWqmonitorBExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WqWqmonitorB record);

    int insertSelective(WqWqmonitorB record);

    List<WqWqmonitorB> selectByExample(WqWqmonitorBExample example);

    WqWqmonitorB selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WqWqmonitorB record, @Param("example") WqWqmonitorBExample example);

    int updateByExample(@Param("record") WqWqmonitorB record, @Param("example") WqWqmonitorBExample example);

    int updateByPrimaryKeySelective(WqWqmonitorB record);

    int updateByPrimaryKey(WqWqmonitorB record);
}