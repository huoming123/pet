package com.design.petmanagement.service;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Users;
import com.design.petmanagement.pojo.res.RestFulBean;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * (Users)表服务接口
 *
 * @author makejava
 * @since 2022-11-01 09:40:21
 */
public interface UsersService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Users> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Users users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map<String, Object>> login(Users users);



    //上传照片
    RestFulBean<Map> upload(MultipartFile coverFile) throws Exception;

    RestFulBean<Map<Object, Object>> getPageList(Page<Users> page) throws Exception;

    RestFulBean<List<Users>> getPeterList();

    RestFulBean<List<Users>> getWorkerList(Users users);

    RestFulBean<String> updateRole(Users users);

    RestFulBean<String> updatePassword(Users users);

    RestFulBean<Map> getPeterAnalyseList();
}
