package com.design.petmanagement.service.impl;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Pet;
import com.design.petmanagement.pojo.ReportPet;
import com.design.petmanagement.mapper.ReportPetMapper;
import com.design.petmanagement.service.ReportPetService;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (ReportPet)表服务实现类
 *
 * @author makejava
 * @since 2022-11-02 09:32:55
 */
@Service("reportPetService")
public class ReportPetServiceImpl implements ReportPetService {
    @Autowired
    private ReportPetMapper reportPetMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<ReportPet> queryById(Integer id) {
       ReportPet reportPet=this.reportPetMapper.queryById(id);
        reportPet.setImageUrl("http://localhost:8087/file/"+reportPet.getImage());
         return RestFulBean.succ(reportPet);
    }

    /**
     * 新增数据
     *
     * @param reportPet 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(ReportPet reportPet) {
        if(reportPet.getPetName()==null){
            return RestFulBean.error("宠物名称不能为空");
        }
        if(reportPet.getImage()==null){
            return RestFulBean.error("图片不能为空");
        }
        if(reportPet.getSex()==null){
            return RestFulBean.error("性别不能为空");
        }
        if(reportPet.getVarietyId()==null){
            return RestFulBean.error("品种不能为空");
        }
        if(reportPet.getReporter()==null){
            return RestFulBean.error("挂失人不能为空");
        }

        if(reportPet.getTelephone()==null){
            return RestFulBean.error("手机号码不能为空");
        }
        if(reportPet.getAddress()==null){
            return RestFulBean.error("居住地址不能为空");
        }
        if(reportPet.getTelephone().trim().length()!=11){
            return RestFulBean.error("请输入11位手机号码");
        }
        //手机号码只能是数字 用正则法则判断
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher isNum = pattern.matcher(reportPet.getTelephone().trim());
        if(!isNum.matches()){  //如果不等于true 则进去条件
            return RestFulBean.error("手机号码只能是数字"); //不是数字
        }
        this.reportPetMapper.insert(reportPet);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param reportPet 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(ReportPet reportPet) {
        this.reportPetMapper.update(reportPet);
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
        this.reportPetMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
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

    @Override
    public RestFulBean<Map<Object, Object>> getPageList(Page<ReportPet> page) throws Exception {
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<ReportPet> list= reportPetMapper.getPageListByCondition(page);
        for(ReportPet reportPet:list){
            reportPet.setImageUrl("http://localhost:8087/file/"+reportPet.getImage());
        }
        //根据条件查询数据的条数
        Integer count = reportPetMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }


}
