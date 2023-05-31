package com.design.petmanagement.mapper;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.ReportPet;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ReportPet)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-02 09:32:55
 */
public interface ReportPetMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReportPet queryById(Integer id);


    /**
     * 新增数据
     *
     * @param reportPet 实例对象
     * @return 影响行数
     */
    int insert(ReportPet reportPet);


    /**
     * 修改数据
     *
     * @param reportPet 实例对象
     * @return 影响行数
     */
    int update(ReportPet reportPet);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<ReportPet> getPageListByCondition(@Param("page") Page<ReportPet> page);

    Integer getPageListCount(@Param("page") Page<ReportPet> page);
}
