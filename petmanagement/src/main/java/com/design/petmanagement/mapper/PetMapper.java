package com.design.petmanagement.mapper;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Pet;
import com.design.petmanagement.pojo.Users;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Pet)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-01 14:06:31
 */
public interface PetMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Pet queryById(Integer id);


    /**
     * 新增数据
     *
     * @param pet 实例对象
     * @return 影响行数
     */
    int insert(Pet pet);


    /**
     * 修改数据
     *
     * @param pet 实例对象
     * @return 影响行数
     */
    int update(Pet pet);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Pet> getPageListByCondition(@Param("page") Page<Pet> page);

    Integer getPageListCount(@Param("page") Page<Pet> page);
}
