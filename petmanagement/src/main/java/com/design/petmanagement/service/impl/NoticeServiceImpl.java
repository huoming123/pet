package com.design.petmanagement.service.impl;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Notice;
import com.design.petmanagement.mapper.NoticeMapper;
import com.design.petmanagement.pojo.Users;
import com.design.petmanagement.service.NoticeService;
import com.design.petmanagement.util.PageUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.design.petmanagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * (Notice)表服务实现类
 *
 * @author makejava
 * @since 2022-11-03 12:12:31
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Notice> queryById(Integer id) {
       Notice notice=this.noticeMapper.queryById(id);
         return RestFulBean.succ(notice);
    }

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Notice notice) {
        this.noticeMapper.insert(notice);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Notice notice) {
        this.noticeMapper.update(notice);
        return RestFulBean.succ("修改成功");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> deleteById(Integer id) {
        this.noticeMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Map<Object, Object>> getPageList(Page<Notice> page) throws Exception {
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Users> list= noticeMapper.getPageListByCondition(page);
        //根据条件查询数据的条数
        Integer count = noticeMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }

    @Override
    public RestFulBean<String> updateShow(Notice notice) {
        this.noticeMapper.updateShow(notice);
        return RestFulBean.succ("修改成功");
    }

    @Override
    public RestFulBean<List<Notice>> getMessage() {
        List<Notice> list =noticeMapper.getMessage();
        return RestFulBean.succ(list);
    }
}
