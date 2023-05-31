package com.design.petmanagement.service;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Type;
import com.design.petmanagement.pojo.Users;
import com.design.petmanagement.pojo.res.RestFulBean;

import java.util.List;
import java.util.Map;

/**
 * (Type)表服务接口
 *
 * @author makejava
 * @since 2022-11-03 09:30:34
 */
public interface TypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Type> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Type type);

    /**
     * 修改数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Type type);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<List<Type>> getTypeList();

    RestFulBean<Map<Object, Object>> getPageList(Page<Type> page)throws  Exception;
}
