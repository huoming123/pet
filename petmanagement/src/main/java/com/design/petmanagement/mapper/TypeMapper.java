package com.design.petmanagement.mapper;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Type;
import com.design.petmanagement.pojo.Users;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Type)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-03 09:30:34
 */
public interface TypeMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Type queryById(Integer id);


    /**
     * 新增数据
     *
     * @param type 实例对象
     * @return 影响行数
     */
    int insert(Type type);


    /**
     * 修改数据
     *
     * @param type 实例对象
     * @return 影响行数
     */
    int update(Type type);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Type> getTypeList();

    List<Type> getPageListByCondition(@Param("page") Page<Type> page);

    Integer getPageListCount(@Param("page")  Page<Type> page);
}
