package com.design.petmanagement.service;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Notice;
import com.design.petmanagement.pojo.res.RestFulBean;

import java.util.List;
import java.util.Map;

/**
 * (Notice)表服务接口
 *
 * @author makejava
 * @since 2022-11-03 12:12:31
 */
public interface NoticeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Notice> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Notice notice);

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Notice notice);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map<Object, Object>> getPageList(Page<Notice> page) throws  Exception;

    RestFulBean<String> updateShow(Notice notice);

    RestFulBean<List<Notice>> getMessage();
}
