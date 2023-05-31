package com.design.petmanagement.controller;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Pet;
import com.design.petmanagement.pojo.Users;
import com.design.petmanagement.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.petmanagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * (Pet)表控制层
 *
 * @author makejava
 * @since 2022-11-01 14:06:30
 */
@RestController
@RequestMapping("/pet")
public class PetController {
    /**
     * 服务对象
     */
    @Autowired
    private PetService petService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/queryById")
    public RestFulBean<Pet> queryById(@RequestBody Pet pet) {
        return this.petService.queryById(pet.getId());
    }

    /**
     * 新增数据
     *
     * @param pet 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Pet pet) {
        return this.petService.insert(pet);
    }

    /**
     * 编辑数据
     *
     * @param pet 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Pet pet) {
        return this.petService.update(pet);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Pet pet) {
        return this.petService.deleteById(pet.getId());
    }
    /**
     * 获取宠物列表数据
     *
     * @param
     * @return
     */
    @PostMapping("/get/page/list")
    public RestFulBean<Map<Object, Object>> getPageList(@RequestBody Page<Pet> page) throws Exception {
        return petService.getPageList(page);
    }
}
