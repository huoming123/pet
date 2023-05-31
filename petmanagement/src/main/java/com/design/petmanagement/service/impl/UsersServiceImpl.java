package com.design.petmanagement.service.impl;

import com.design.petmanagement.dto.Page;
import com.design.petmanagement.pojo.Users;
import com.design.petmanagement.mapper.UsersMapper;
import com.design.petmanagement.pojo.Variety;
import com.design.petmanagement.service.UsersService;
import com.design.petmanagement.util.FileUtil;
import com.design.petmanagement.util.JwtUtils;
import com.design.petmanagement.util.PageUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.design.petmanagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (Users)表服务实现类
 *
 * @author makejava
 * @since 2022-11-01 09:40:21
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Users> queryById(Integer id) {
       Users users=this.usersMapper.queryById(id); //根据id获取用户信息
        users.setImageUrl("http://localhost:8087/file/"+users.getImage()); //照片
         return RestFulBean.succ(users);
    }

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Users users) {
        if(users.getCardId()==null){//对前端传过来的值进行判空处理，如果为空，就返回对应的报错信息
            return RestFulBean.error("身份证号码不能为空");
        }
        if(users.getUserName()==null){
            return RestFulBean.error("用户名不能为空");
        }
        if(users.getAddress()==null){
            return RestFulBean.error("居住地址不能为空");
        }
        if(users.getImage()==null){
            return RestFulBean.error("图片不能为空");
        }
        if(users.getAge()==null){
            return RestFulBean.error("年龄不能为空");
        }
        if(users.getBirthday()==null){
            return RestFulBean.error("出生日期不能为空");
        }
        if(users.getMaritalStatus()==null){
            return RestFulBean.error("婚宴状况不能为空");
        }
        if(users.getNation()==null){
            return RestFulBean.error("民族不能为空");
        }
        if(users.getNativePlace()==null){
            return RestFulBean.error("籍贯不能为空");
        }
        if(users.getPolitical()==null){
            return RestFulBean.error("政治面貌不能为空");
        }
        if(users.getTelephone()==null){
            return RestFulBean.error("手机号码不能为空");
        }
        if(users.getProfession()==null){
            return RestFulBean.error("职业不能为空");
        }
        if(users.getCardId().trim().length()!=18){
            return RestFulBean.error("请输入18位身份证号码");
        }
        if(users.getTelephone().trim().length()!=11){
            return RestFulBean.error("请输入11位手机号码");
        }
        //手机号码只能是数字 用正则法则判断
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher isNum = pattern.matcher(users.getTelephone().trim());
        if(!isNum.matches()){  //如果不等于true 则进去条件
            return RestFulBean.error("手机号码只能是数字"); //不是数字
        }
        try{
            //users.getCardId().trim()拿字符串去空
            String cardId=users.getCardId().trim();
            Users user = usersMapper.getByCardId(cardId);//根据身份证cardId查询用户
            if(user!=null){ //身份证唯一
                return RestFulBean.error("该身份证已经录入,请不要重复录入");
            }
            if(users.getRole().equals("worker")) //工作人员才需要员工编号跟密码
            {
                //时间戳作为员工编号 不可能重复
                long timeMillis=System.currentTimeMillis(); //当前系统时间戳
                //取前八位作为一个员工编号
                String userNo=String.valueOf(timeMillis).substring(0,8);
                users.setUserNo(String.valueOf(userNo));
                users.setPassword("123456");//将密码设为123456 初始密码 后面用户可以在个人中心修改
            }

            this.usersMapper.insert(users);
        }
        catch (Exception e){
            return RestFulBean.error("请求异常");//执行新增的sql语句
        }
        return RestFulBean.succ("新增成功");
    }

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Users users) {
        this.usersMapper.update(users);
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
        this.usersMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Map<String, Object>> login(Users users) {
        if(users.getUserNo()==null)//对前端传过来的值进行判空处理，如果为空，就返回对应的报错信息
        {
            return RestFulBean.error("员工编号不能为空");
        }
        if(users.getPassword()==null)
        {
            return RestFulBean.error("密码不能为空");
        }

        Users user =usersMapper.getByUserNo(users.getUserNo(),users.getRole());//根据员工编号跟角色获取用户数据
        //new 一个map对象 用于返回数据给前端
        Map<String,Object> result =new HashMap<>();
        //用户不为空
        if (user!=null){
            //如果密码跟数据库一样
            if(users.getPassword().equals(user.getPassword()))
            {
                //返回一个map对象
                //返回userName 把这个值在前端存起来
                result.put("userName",user.getUserName());
                //返回userId 在前端存起来
                result.put("userId",user.getId());
                //返回role 角色在前端存起来
                result.put("role",user.getRole());
                return RestFulBean.succ(result);//将数据返回给前端
            }
            else{
                return RestFulBean.error("密码错误");
            }

        }
        return RestFulBean.error("用户不存在");
    }

    @Override
    public RestFulBean<List<Users>> getWorkerList(Users users) {
        List<Users> list =usersMapper.getWorkerList(users); //获取优秀员工数据
        for(Users user:list){ //for 循环处理数据 返回完整的本地照片路劲
            user.setImage("http://localhost:8087/file/"+user.getImage());
        }
        return RestFulBean.succ(list);
    }

    @Override
    public RestFulBean<String> updateRole(Users users) {
        this.usersMapper.updateRole(users);
        return RestFulBean.succ("修改成功");
    }

    @Override
    public RestFulBean<String> updatePassword(Users users) {
        this.usersMapper.updatePassword(users);
        return RestFulBean.succ("修改成功");
    }

    @Override
    public RestFulBean<Map> getPeterAnalyseList() {
        Map result =new HashMap();
        List peterList =new ArrayList<>();
        List ageList = new ArrayList<>();//20-30的年龄数组
        List ageList1 = new ArrayList<>();//30-40的年龄数组
        List ageList2 = new ArrayList<>();//40-50的年龄数组
        List ageList3 = new ArrayList<>();//50-60的年龄数组
        List ageList4 = new ArrayList<>();//60-70的年龄数组
        List<Users> list  =usersMapper.getPeterList(); //获取监护人数据
        for(Users users:list){
            Integer age =users.getAge();
            if(20 < age && age<30 ){
                ageList.add(age);
            }
            if(30 < age && age<40 ){
                ageList1.add(age);
            }
            if(40 < age && age<50 ){
                ageList2.add(age);
            }
            if(50 < age && age<60 ){
                ageList3.add(age);
            }
            if(60 < age && age<70 ){
                ageList4.add(age);
            }
        }
        for(int i=2;i<7;i++){
            Map map =new HashMap();
            if(i==2){
                map.put("name","20-30");
                map.put("value",ageList.size());
            }
            if(i==3){
                map.put("name","30-40");
                map.put("value",ageList1.size());
            }
            if(i==4){
                map.put("name","40-50");
                map.put("value",ageList2.size());
            }

            if(i==5){
                map.put("name","50-60");
                map.put("value",ageList3.size());
            }
            if(i==6){
                map.put("name","60-70");
                map.put("value",ageList4.size());
            }
            peterList.add(map);
        }

        result.put("peterList",peterList);
        return RestFulBean.succ(result);
    }

    @Override
    public RestFulBean<Map<Object, Object>> getPageList(Page<Users> page) throws Exception {
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Users> list= usersMapper.getPageListByCondition(page);
        for(Users users : list){
            users.setImageUrl("http://localhost:8087/file/"+users.getImage());
        }
        //根据条件查询数据的条数
        Integer count = usersMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }

    @Override
    public RestFulBean<List<Users>> getPeterList() {
        List<Users> list =usersMapper.getPeterList();
        return RestFulBean.succ(list);
    }

    @Override
    public RestFulBean<Map> upload(MultipartFile coverFile) throws Exception {
        String destPath ="C:\\design\\images\\";//自定义一个路径
        // 存图片
        try{//用一个file文件上传的方法上传照片
            FileUtil.saveFile(coverFile, destPath,coverFile.getOriginalFilename());//上传图片的方法
        }
        catch(Exception e){
            return RestFulBean.error("请求异常");
        }
        Map map =new HashMap();//定义一个map对象
        //返回一个完整的本地照片路径用于前端显示
        map.put("url","http://localhost:8087/file/"+coverFile.getOriginalFilename());
        //把照片的名字重新返回给前端用于保存到数据库users表的images字段中
        map.put("imageName",coverFile.getOriginalFilename());
        return RestFulBean.succ(map);
    }
}
