package com.design.petmanagement.service.impl;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.mapper.VarietyMapper;
import com.design.petmanagement.pojo.Type;
import com.design.petmanagement.mapper.TypeMapper;
import com.design.petmanagement.pojo.Users;
import com.design.petmanagement.pojo.Variety;
import com.design.petmanagement.service.TypeService;
import com.design.petmanagement.util.PageUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.design.petmanagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * (Type)表服务实现类
 *
 * @author makejava
 * @since 2022-11-03 09:30:34
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private VarietyMapper varietyMapper;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Type> queryById(Integer id) {
       Type type=this.typeMapper.queryById(id);
         return RestFulBean.succ(type);
    }

    /**
     * 新增数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Type type) {
        if(type.getName()==null){
            return RestFulBean.error("名字不能为空");
        }
        this.typeMapper.insert(type);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Type type) {
        this.typeMapper.update(type);
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
       List<Variety> list = varietyMapper.queryByTypeId(id);
       if(list.size()>0){
           return RestFulBean.error("该物种已有品种数据，请先删除品种数据");
       }
        this.typeMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Type>> getTypeList() {
        List<Type> list =typeMapper.getTypeList();
        return RestFulBean.succ(list);
    }

    @Override
    public RestFulBean<Map<Object, Object>> getPageList(Page<Type> page) throws Exception{

        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Type> list= typeMapper.getPageListByCondition(page);
        //根据条件查询数据的条数
        Integer count = typeMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }
}
