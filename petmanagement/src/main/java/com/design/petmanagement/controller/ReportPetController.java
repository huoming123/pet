package com.design.petmanagement.controller;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Pet;
import com.design.petmanagement.pojo.ReportPet;
import com.design.petmanagement.pojo.Variety;
import com.design.petmanagement.service.ReportPetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.petmanagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * (ReportPet)表控制层
 *
 * @author makejava
 * @since 2022-11-02 09:32:55
 */
@RestController
@RequestMapping("/reportPet")
public class ReportPetController {
    /**
     * 服务对象
     */
    @Autowired
    private ReportPetService reportPetService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/queryById")
    public RestFulBean<ReportPet> queryById(@RequestBody ReportPet reportPet) {
        return this.reportPetService.queryById(reportPet.getId());
    }

    /**
     * 新增数据
     *
     * @param reportPet 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody  ReportPet reportPet) {
        return this.reportPetService.insert(reportPet);
    }

    /**
     * 编辑数据
     *
     * @param reportPet 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody ReportPet reportPet) {
        return this.reportPetService.update(reportPet);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody ReportPet reportPet) {
        return this.reportPetService.deleteById(reportPet.getId());
    }

    //上传图片接口
    @PostMapping("/upload/image")
    public RestFulBean<Map> upload(@RequestParam(value = "coverFile",required = false) MultipartFile coverFile ) throws Exception  {
        return reportPetService.upload(coverFile);
    }
    /**
     * 分页搜索获取宠物列表数据
     *
     * @param
     * @return
     */
    @PostMapping("/get/page/list")
    public RestFulBean<Map<Object, Object>> getPageList(@RequestBody Page<ReportPet> page) throws Exception {
        return reportPetService.getPageList(page);
    }
}
