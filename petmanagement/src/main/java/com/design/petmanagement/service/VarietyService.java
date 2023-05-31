package com.design.petmanagement.service;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Users;
import com.design.petmanagement.pojo.Variety;
import com.design.petmanagement.pojo.res.RestFulBean;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * (Variety)表服务接口
 *
 * @author makejava
 * @since 2022-11-01 14:26:31
 */
public interface VarietyService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Variety> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param variety 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Variety variety);

    /**
     * 修改数据
     *
     * @param variety 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Variety variety);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);



    RestFulBean<Map<Object, Object>> getPageList(Page<Variety> page)throws Exception;

    RestFulBean<Map> upload(MultipartFile coverFile)throws Exception;


    RestFulBean<List<Variety>> getVarietyList(Integer typeId);

    RestFulBean<Map> getAnalyseList(Integer typeId);

    RestFulBean<Map> getReportAnalyseList(Integer typeId);
}
