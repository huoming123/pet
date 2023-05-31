package com.design.petmanagement.service.impl;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Pet;
import com.design.petmanagement.mapper.PetMapper;
import com.design.petmanagement.pojo.Users;
import com.design.petmanagement.service.PetService;
import com.design.petmanagement.util.PageUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.design.petmanagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * (Pet)表服务实现类
 *
 * @author makejava
 * @since 2022-11-01 14:06:30
 */
@Service("petService")
public class PetServiceImpl implements PetService {
    @Autowired
    private PetMapper petMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Pet> queryById(Integer id) {
       Pet pet=this.petMapper.queryById(id);
        pet.setImageUrl("http://localhost:8087/file/"+pet.getImage());
        pet.setVaccinatImagesUrl("http://localhost:8087/file/"+pet.getVaccinatImages());
         return RestFulBean.succ(pet);
    }

    /**
     * 新增数据
     *
     * @param pet 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Pet pet) {
        if(pet.getPetName()==null){
            return RestFulBean.error("宠物名字不能为空");
        }
        if(pet.getImage()==null){
            return RestFulBean.error("宠物照片不能为空");
        }
        this.petMapper.insert(pet);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param pet 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Pet pet) {
        this.petMapper.update(pet);
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
        this.petMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Map<Object, Object>> getPageList(Page<Pet> page) throws Exception {
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Pet> list= petMapper.getPageListByCondition(page);
        for(Pet pet:list){
            pet.setImageUrl("http://localhost:8087/file/"+pet.getImage());
            pet.setVaccinatImagesUrl("http://localhost:8087/file/"+pet.getVaccinatImages());
        }
        //根据条件查询数据的条数
        Integer count = petMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }
}
