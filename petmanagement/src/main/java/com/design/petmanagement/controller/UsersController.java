package com.design.petmanagement.controller;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.MainMenu;
import com.design.petmanagement.pojo.Users;
import com.design.petmanagement.pojo.Variety;
import com.design.petmanagement.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.petmanagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * (Users)表控制层
 *
 * @author makejava
 * @since 2022-11-01 09:40:21
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    /**
     * 服务对象
     */
    @Autowired
    private UsersService usersService;
    /**
     * 登录
     *
     * @param
     * @return
     */
    @PostMapping("/login")
    public RestFulBean<Map<String,Object>> login(@RequestBody Users Users) throws Exception {
        return usersService.login(Users);
    }
    /**
     * 修改密码
     *
     * @param
     * @return
     */
    @PostMapping("/update/password")
    public RestFulBean<String> updatePassword(@RequestBody Users Users) throws Exception {
        return usersService.updatePassword(Users);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/queryById")
    public RestFulBean<Users> queryById(@RequestBody Users Users) {
        return this.usersService.queryById(Users.getId());
    }

    /**
     * 新增数据
     *
     * @param users 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Users users) {
        return this.usersService.insert(users);
    }

    /**
     * 编辑数据
     *
     * @param users 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Users users) {
        return this.usersService.update(users);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Users users) {
        return this.usersService.deleteById(users.getId());
    }

    /**
     * 获取员工数据
     *
     * @param
     * @return
     */
    @PostMapping("/get/worker/list")
    public RestFulBean<List<Users>> getWorkerList(@RequestBody Users users) throws Exception {
        return usersService.getWorkerList(users);
    }
    /**
     * 获取监护人数据
     *
     * @param
     * @return
     */
    @PostMapping("/get/peter/list")
    public RestFulBean<List<Users>> getPeterList() throws Exception {
        return usersService.getPeterList();
    }

    /**
     * 获取user表数据 根据角色不同获取不同的数据
     *
     * @param
     * @return
     */
    @PostMapping("/get/page/list")
    public RestFulBean<Map<Object, Object>> getPageList(@RequestBody Page<Users> page) throws Exception {
        return usersService.getPageList(page);
    }
    //上传图片接口
    @PostMapping("/upload/image")
    public RestFulBean<Map> upload(@RequestParam(value = "coverFile",required = false) MultipartFile coverFile ) throws Exception  {
        return usersService.upload(coverFile);
    }
    //更改角色
    @PostMapping("/update/role")
    public RestFulBean<String> updateRole(@RequestBody Users users ) throws Exception  {
        return usersService.updateRole(users);
    }

    /**
     * 监护人数据分析
     *
     * @param
     * @return
     */
    @PostMapping("/get/peter/analyse/list")
    public RestFulBean<Map> getPeterAnalyseList() throws Exception {
        return usersService.getPeterAnalyseList();
    }
}
