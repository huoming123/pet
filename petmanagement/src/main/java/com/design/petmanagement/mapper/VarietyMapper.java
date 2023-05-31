package com.design.petmanagement.mapper;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Variety;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Variety)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-01 14:26:31
 */
public interface VarietyMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Variety queryById(Integer id);


    /**
     * 新增数据
     *
     * @param variety 实例对象
     * @return 影响行数
     */
    int insert(Variety variety);


    /**
     * 修改数据
     *
     * @param variety 实例对象
     * @return 影响行数
     */
    int update(Variety variety);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Variety> getVarietyList(@Param("typeId") Integer typeId);

    List<Variety> getPageListByCondition(@Param("page") Page<Variety> page);

    Integer getPageListCount(@Param("page") Page<Variety> page);

    List<Variety> queryByTypeId(Integer id);

    List<Variety> getAnalyseList(Integer typeId);

    List<Variety> getReportAnalyseList(Integer typeId);
}
