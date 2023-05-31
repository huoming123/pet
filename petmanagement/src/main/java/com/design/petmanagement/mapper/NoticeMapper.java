package com.design.petmanagement.mapper;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Notice;
import com.design.petmanagement.pojo.Users;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Notice)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-03 12:12:31
 */
public interface NoticeMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Notice queryById(Integer id);


    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 影响行数
     */
    int insert(Notice notice);


    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 影响行数
     */
    int update(Notice notice);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Users> getPageListByCondition(@Param("page") Page<Notice> page);

    Integer getPageListCount(@Param("page")  Page<Notice> page);

    void updateShow(Notice notice);

    List<Notice> getMessage();
}
