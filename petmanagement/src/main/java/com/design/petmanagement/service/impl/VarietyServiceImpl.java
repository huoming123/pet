package com.design.petmanagement.service.impl;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Type;
import com.design.petmanagement.pojo.Users;
import com.design.petmanagement.pojo.Variety;
import com.design.petmanagement.mapper.VarietyMapper;
import com.design.petmanagement.service.VarietyService;
import com.design.petmanagement.util.FileUtil;
import com.design.petmanagement.util.PageUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.design.petmanagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Variety)表服务实现类
 *
 * @author makejava
 * @since 2022-11-01 14:26:31
 */
@Service("varietyService")
public class VarietyServiceImpl implements VarietyService {
    @Autowired
    private VarietyMapper varietyMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Variety> queryById(Integer id) {
       Variety variety=this.varietyMapper.queryById(id);
         return RestFulBean.succ(variety);
    }

    /**
     * 新增数据
     *
     * @param variety 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Variety variety) {
        this.varietyMapper.insert(variety);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param variety 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Variety variety) {
        this.varietyMapper.update(variety);
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
        this.varietyMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Variety>> getVarietyList(Integer typeId) {
        List<Variety> list =varietyMapper.getVarietyList(typeId);
        return RestFulBean.succ(list);
    }

    @Override
    public RestFulBean<Map> getAnalyseList(Integer typeId) {
        Map result =new HashMap(); //定义map对象
        List<String> petList = new ArrayList<>(); //定义宠物名字数组
        List<Integer> countList = new ArrayList<>(); //定义数量数组
        List<Variety> list  =varietyMapper.getAnalyseList(typeId); //根据物种id获取登记的宠物数量
        for(Variety variety:list){
            petList.add(variety.getName());  //宠物名字
            countList.add(variety.getCount()); //宠物数量
        }
        //将数据返回给前端
        result.put("petList",petList);
        result.put("countList",countList);
        return RestFulBean.succ(result);
    }

    @Override
    public RestFulBean<Map> getReportAnalyseList(Integer typeId) {
        Map result =new HashMap();  //定义一个map对象
        List reportList = new ArrayList<>(); //定义一个数组
        List<Variety> list  =varietyMapper.getReportAnalyseList(typeId); //根据物种获取丢失宠物数据
        for(Variety variety:list){
            Map report =new HashMap();
            report.put("value",variety.getCount()); //品种丢失的数量
            report.put("name",variety.getName()); //品种名称
            reportList.add(report);
        }
        result.put("reportList",reportList); //将值返回给前端
        return RestFulBean.succ(result);
    }

    @Override
    public RestFulBean<Map<Object, Object>> getPageList(Page<Variety> page) throws Exception {

        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Variety> list= varietyMapper.getPageListByCondition(page);
        for(Variety variety:list){
            variety.setImageUrl("http://localhost:8087/file/"+variety.getImage());
        }
        //根据条件查询数据的条数
        Integer count = varietyMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }

    @Override
    public RestFulBean<Map> upload(MultipartFile coverFile) throws Exception {
        String destPath ="C:\\design\\pet\\"; //上传图片路劲
        // 存图片
        try{  //,coverFile.getOriginalFilename() 图片名字
            FileUtil.saveFile(coverFile, destPath,coverFile.getOriginalFilename());
        }
        catch(Exception e){
            return RestFulBean.error("请求异常");
        }
        //定义一个map对象
        Map map =new HashMap();
        //将图片名字返回 用于录入用户的时候 把这个值保存到image字段中
        map.put("imageName",coverFile.getOriginalFilename());
        //图片路劲
        map.put("url","http://localhost:8087/file/"+coverFile.getOriginalFilename());
        return RestFulBean.succ(map);
    }
}
