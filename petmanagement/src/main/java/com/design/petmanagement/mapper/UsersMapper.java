package com.design.petmanagement.mapper;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Users;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Users)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-01 09:40:21
 */
public interface UsersMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Users queryById(Integer id);


    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int insert(Users users);


    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    Users getByUserNo(String userNo, String role);

    List<Users> getWorkerList(Users users);

    List<Users> getPageListByCondition(@Param("page") Page<Users> page);

    Integer getPageListCount(@Param("page") Page<Users> page);


    Users getByCardId(String cardId);

    List<Users> getPeterList();

    void updateRole(Users users);

    void updatePassword(Users users);
}
