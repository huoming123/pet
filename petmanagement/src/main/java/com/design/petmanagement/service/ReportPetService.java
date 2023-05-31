package com.design.petmanagement.service;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.ReportPet;
import com.design.petmanagement.pojo.res.RestFulBean;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * (ReportPet)表服务接口
 *
 * @author makejava
 * @since 2022-11-02 09:32:55
 */
public interface ReportPetService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<ReportPet> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param reportPet 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(ReportPet reportPet);

    /**
     * 修改数据
     *
     * @param reportPet 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(ReportPet reportPet);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map> upload(MultipartFile coverFile) throws Exception;

    RestFulBean<Map<Object, Object>> getPageList(Page<ReportPet> page) throws Exception;


}
