package com.design.petmanagement.controller;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Type;
import com.design.petmanagement.pojo.Users;
import com.design.petmanagement.service.TypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.petmanagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * (Type)表控制层
 *
 * @author makejava
 * @since 2022-11-03 09:30:34
 */
@RestController
@RequestMapping("/type")
public class TypeController {
    /**
     * 服务对象
     */
    @Autowired
    private TypeService typeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/queryById")
    public RestFulBean<Type> queryById(@RequestBody  Type type) {
        return this.typeService.queryById(type.getId());
    }

    /**
     * 新增数据
     *
     * @param type 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody  Type type) {
        return this.typeService.insert(type);
    }

    /**
     * 编辑数据
     *
     * @param type 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody  Type type) {
        return this.typeService.update(type);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody  Type type) {
        return this.typeService.deleteById(type.getId());
    }

    /**
     * 获取物种下拉数据
     *
     * @param
     * @return
     */
    @PostMapping("/get/type/list")
    public RestFulBean<List<Type>> getTypeList() throws Exception {
        return typeService.getTypeList();
    }

    /**
     * 分页获取物种下拉数据
     *
     * @param
     * @return
     */
    @PostMapping("/get/page/list")
    public RestFulBean<Map<Object, Object>> getPageList(@RequestBody Page<Type> page) throws Exception {
        return typeService.getPageList(page);
    }

}
