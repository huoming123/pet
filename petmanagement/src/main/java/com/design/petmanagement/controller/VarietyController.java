package com.design.petmanagement.controller;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.ReportPet;
import com.design.petmanagement.pojo.Type;
import com.design.petmanagement.pojo.Users;
import com.design.petmanagement.pojo.Variety;
import com.design.petmanagement.service.VarietyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.petmanagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * (Variety)表控制层
 *
 * @author makejava
 * @since 2022-11-01 14:26:31
 */
@RestController
@RequestMapping("/variety")
public class VarietyController {
    /**
     * 服务对象
     */
    @Autowired
    private VarietyService varietyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/queryById")
    public RestFulBean<Variety> queryById(@RequestBody Variety variety) {
        return this.varietyService.queryById(variety.getId());
    }

    /**
     * 新增数据
     *
     * @param variety 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Variety variety) {
        return this.varietyService.insert(variety);
    }

    /**
     * 编辑数据
     *
     * @param variety 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Variety variety) {
        return this.varietyService.update(variety);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Variety variety) {
        return this.varietyService.deleteById(variety.getId());
    }
    /**
     * 获取品种数据
     *
     * @param
     * @return
     */
    @PostMapping("/get/variety/list")
    public RestFulBean<List<Variety>> getVarietyList(@RequestBody Variety variety) throws Exception {
        return varietyService.getVarietyList(variety.getTypeId());
    }
    /**
     * 宠物数据分析
     *
     * @param
     * @return
     */
    @PostMapping("/get/analyse/list")
    public RestFulBean<Map> getAnalyseList(@RequestBody Variety variety) throws Exception {
        return varietyService.getAnalyseList(variety.getTypeId());
    }
    /**
     * 宠物挂失数据分析
     *
     * @param
     * @return
     */
    @PostMapping("/get/report/analyse/list")
    public RestFulBean<Map> getReportAnalyseList(@RequestBody Variety variety) throws Exception {
        return varietyService.getReportAnalyseList(variety.getTypeId());
    }
    /**
     * 分页获取物种下拉数据
     *
     * @param
     * @return
     */
    @PostMapping("/get/page/list")
    public RestFulBean<Map<Object, Object>> getPageList(@RequestBody Page<Variety> page) throws Exception {
        return varietyService.getPageList(page);
    }
    //上传图片接口
    @PostMapping("/upload/image")
    public RestFulBean<Map> upload(@RequestParam(value = "coverFile",required = false) MultipartFile coverFile ) throws Exception  {
        return varietyService.upload(coverFile);
    }
}
