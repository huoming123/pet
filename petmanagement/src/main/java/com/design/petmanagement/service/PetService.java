package com.design.petmanagement.service;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Pet;
import com.design.petmanagement.pojo.res.RestFulBean;

import java.util.Map;

/**
 * (Pet)表服务接口
 *
 * @author makejava
 * @since 2022-11-01 14:06:30
 */
public interface PetService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Pet> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param pet 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Pet pet);

    /**
     * 修改数据
     *
     * @param pet 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Pet pet);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map<Object, Object>> getPageList(Page<Pet> page) throws Exception;
}
