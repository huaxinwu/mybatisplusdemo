package com.wxh.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxh.enums.CodeEnum;
import com.wxh.model.UserInfo;
import com.wxh.response.ResultInfo;
import com.wxh.service.UserInfoService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName: UserController
 * @Description: 用户信息控制器
 * @Author wxh
 * @Date: 2020/7/13 15:34
 * @Version V1.0.0
 * @Since 1.8
 */
@RestController
@RequestMapping(value = "/user")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    /**
     *  根据用户信息ID获取用户信息
     * @param param 参数对象
     * @return ResultInfo
     */
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public ResultInfo getUser(@RequestBody JSONObject param){
        ResultInfo result = new ResultInfo();
        String userId = param.getString("userId");
        UserInfo userInfo = userInfoService.getById(userId);
        if(ObjectUtils.isEmpty(userInfo)){
            result.setData(new UserInfo());
            result.setMsg(CodeEnum.FAILURE.getMsg());
            result.setSucceed(false);
            result.setCode(CodeEnum.FAILURE.getCode());
        }else{
            result.setData(userInfo);
            result.setMsg(CodeEnum.SUCCESS.getMsg());
            result.setSucceed(true);
            result.setCode(CodeEnum.SUCCESS.getCode());
        }
        return result;
    }

    /**
     *  查询所有用户信息
     * @return ResultInfo
     */
    @RequestMapping(value = "/listUser",method = RequestMethod.POST)
    public ResultInfo listUser(){
        ResultInfo result = new ResultInfo();
        List<UserInfo> list =  userInfoService.list();
        if(CollectionUtils.isEmpty(list)){
            result.setData(Collections.emptyList());
            result.setMsg(CodeEnum.FAILURE.getMsg());
            result.setSucceed(false);
            result.setCode(CodeEnum.FAILURE.getCode());
        }else{
            result.setData(list);
            result.setMsg(CodeEnum.SUCCESS.getMsg());
            result.setSucceed(true);
            result.setCode(CodeEnum.SUCCESS.getCode());
        }
        return result;
    }

    /**
     *  分页查询所有用户信息
     * @return ResultInfo
     */
    @RequestMapping(value = "/listByPage", method = RequestMethod.POST)
    public ResultInfo listByPage(){
        ResultInfo result = new ResultInfo();
        //  需要在Config配置类中配置分页插件
        IPage<UserInfo> page = new Page<>();
        // 当前页码
        page.setCurrent(5);
        // 每页显示多少条数据
        page.setSize(1);
        IPage<UserInfo> iPage = userInfoService.page(page);
        if(ObjectUtils.isEmpty(iPage)){
            result.setData(new Page<>());
            result.setMsg(CodeEnum.FAILURE.getMsg());
            result.setSucceed(false);
            result.setCode(CodeEnum.FAILURE.getCode());
        }else{
            result.setData(iPage);
            result.setMsg(CodeEnum.SUCCESS.getMsg());
            result.setSucceed(true);
            result.setCode(CodeEnum.SUCCESS.getCode());
        }
        return result;
    }

    /**
     *  根据指定字段查询所有用户信息
     * @return ResultInfo
     */
    @RequestMapping(value = "/listByMap", method = RequestMethod.POST)
    public ResultInfo listByMap(){
        ResultInfo result = new ResultInfo();
        Map<String,Object> map = new HashMap<>(10);
        map.put("age", 20);
        Collection<UserInfo> list = userInfoService.listByMap(map);
        if(CollectionUtils.isEmpty(list)){
            result.setData(Collections.emptyList());
            result.setMsg(CodeEnum.FAILURE.getMsg());
            result.setSucceed(false);
            result.setCode(CodeEnum.FAILURE.getCode());
        }else{
            result.setData(list);
            result.setMsg(CodeEnum.SUCCESS.getMsg());
            result.setSucceed(true);
            result.setCode(CodeEnum.SUCCESS.getCode());
        }
        return result;
    }

    /**
     *  新增单条用户信息
     * @return ResultInfo
     */
    @RequestMapping(value = "/insertUserInfo", method = RequestMethod.POST)
    public ResultInfo insertUserInfo(){
        ResultInfo result = new ResultInfo();
        UserInfo userInfo = new UserInfo();
        userInfo.setName("小龙");
        userInfo.setSkill("JAVA");
        userInfo.setAge(18);
        userInfo.setFraction(59L);
        userInfo.setEvaluate("该学生是一个在改BUG的码农");
        boolean flag = userInfoService.save(userInfo);
        if(flag){
            result.setData(flag);
            result.setMsg(CodeEnum.SUCCESS.getMsg());
            result.setSucceed(true);
            result.setCode(CodeEnum.SUCCESS.getCode());
        }else{
            result.setData(flag);
            result.setMsg(CodeEnum.FAILURE.getMsg());
            result.setSucceed(false);
            result.setCode(CodeEnum.FAILURE.getCode());
        }
        return result;
    }

    /**
     *  批量新增用户信息
     * @return ResultInfo
     */
    @RequestMapping(value = "/insertBatchUserInfo", method = RequestMethod.POST)
    public ResultInfo insertBatchUserInfo(){
        ResultInfo result = new ResultInfo();
        UserInfo userInfo = new UserInfo();
        userInfo.setName("Sans");
        userInfo.setSkill("睡觉");
        userInfo.setAge(18);
        userInfo.setFraction(60L);
        userInfo.setEvaluate("Sans是一个爱睡觉,并且身材较矮骨骼巨大的骷髅小胖子");

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setName("papyrus");
        userInfo2.setSkill("JAVA");
        userInfo2.setAge(18);
        userInfo2.setFraction(58L);
        userInfo2.setEvaluate("Papyrus是一个讲话大声、个性张扬的骷髅，给人自信、有魅力的骷髅小瘦子");

        // 添加到集合中
        List<UserInfo> list = new ArrayList<>();
        list.add(userInfo);
        list.add(userInfo2);

        boolean flag = userInfoService.saveBatch(list);
        if(flag){
            result.setData(flag);
            result.setMsg(CodeEnum.SUCCESS.getMsg());
            result.setSucceed(true);
            result.setCode(CodeEnum.SUCCESS.getCode());
        }else{
            result.setData(flag);
            result.setMsg(CodeEnum.FAILURE.getMsg());
            result.setSucceed(false);
            result.setCode(CodeEnum.FAILURE.getCode());
        }
        return result;
    }

    /**
     *  更新单条用户信息
     * @return ResultInfo
     */
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public ResultInfo updateUserInfo(){
        ResultInfo result = new ResultInfo();
        // 根据实体中的ID去更新,其他字段如果值为null则不会更新该字段,参考yml配置文件
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setAge(19);
        boolean flag = userInfoService.updateById(userInfo);
        if(flag){
            result.setData(flag);
            result.setMsg(CodeEnum.SUCCESS.getMsg());
            result.setSucceed(true);
            result.setCode(CodeEnum.SUCCESS.getCode());
        }else{
            result.setData(flag);
            result.setMsg(CodeEnum.FAILURE.getMsg());
            result.setSucceed(false);
            result.setCode(CodeEnum.FAILURE.getCode());
        }
        return result;
    }

    /**
     *  删除单条用户信息
     * @return ResultInfo
     */
    @RequestMapping(value = "/deleteUserInfo", method = RequestMethod.POST)
    public ResultInfo deleteUserInfo(@RequestBody JSONObject param){
        ResultInfo result = new ResultInfo();
        String userId = param.getString("userId");
        boolean flag = userInfoService.removeById(userId);
        if(flag){
            result.setData(flag);
            result.setMsg(CodeEnum.SUCCESS.getMsg());
            result.setSucceed(true);
            result.setCode(CodeEnum.SUCCESS.getCode());
        }else{
            result.setData(flag);
            result.setMsg(CodeEnum.FAILURE.getMsg());
            result.setSucceed(false);
            result.setCode(CodeEnum.FAILURE.getCode());
        }
        return result;
    }

    /**
     *  删除单条用户信息
     * @return ResultInfo
     */
    @RequestMapping(value = "/deleteByMap", method = RequestMethod.POST)
    public ResultInfo deleteByMap(){
        ResultInfo result = new ResultInfo();
        // kay是字段名 value是字段值
        Map<String,Object> map = new HashMap<>();
        map.put("skill","删除");
        map.put("fraction",10L);
        boolean flag = userInfoService.removeByMap(map);
        if(flag){
            result.setData(flag);
            result.setMsg(CodeEnum.SUCCESS.getMsg());
            result.setSucceed(true);
            result.setCode(CodeEnum.SUCCESS.getCode());
        }else{
            result.setData(flag);
            result.setMsg(CodeEnum.FAILURE.getMsg());
            result.setSucceed(false);
            result.setCode(CodeEnum.FAILURE.getCode());
        }
        return result;
    }
}
