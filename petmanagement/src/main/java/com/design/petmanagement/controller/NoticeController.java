package com.design.petmanagement.controller;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Notice;
import com.design.petmanagement.pojo.Type;
import com.design.petmanagement.service.NoticeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.petmanagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * (Notice)表控制层
 *
 * @author makejava
 * @since 2022-11-03 12:12:31
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    /**
     * 服务对象
     */
    @Autowired
    private NoticeService noticeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById")
    public RestFulBean<Notice> queryById(Integer id) {
        return this.noticeService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param notice 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody  Notice notice) {
        return this.noticeService.insert(notice);
    }

    /**
     * 编辑数据
     *
     * @param notice 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Notice notice) {
        return this.noticeService.update(notice);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Notice notice) {
        return this.noticeService.deleteById(notice.getId());
    }
    /**
     * 分页获取信息列表
     *
     * @param
     * @return
     */
    @PostMapping("/get/page/list")
    public RestFulBean<Map<Object, Object>> getPageList(@RequestBody Page<Notice> page) throws Exception {
        return noticeService.getPageList(page);
    }

    /**
     * 是否显示
     *
     * @param notice 实体
     * @return 编辑结果
     */
    @PostMapping("/update/show")
    public RestFulBean<String> updateShow(@RequestBody Notice notice) {
        return this.noticeService.updateShow(notice);
    }

    /**
     * 获取最新公告信息
     *
     * @param notice 实体
     * @return 编辑结果
     */
    @PostMapping("/get/message")
    public RestFulBean<List<Notice>> getMessage() {
        return this.noticeService.getMessage();
    }
}
