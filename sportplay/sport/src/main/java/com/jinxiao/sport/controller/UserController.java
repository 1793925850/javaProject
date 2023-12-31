package com.jinxiao.sport.controller;

import com.alibaba.fastjson.JSON;
import com.jinxiao.sport.bean.QueryInfo;
import com.jinxiao.sport.bean.User;
import com.jinxiao.sport.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao udao;

    @RequestMapping("/alluser")
    public String getUserList(QueryInfo queryInfo) {
        // 获取最大列表数和当前编号
        int numbers = udao.getUserCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();

        List<User> users = udao.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers", numbers);
        res.put("data", users);

        return JSON.toJSONString(res);
    }

    @RequestMapping("/userstate")
    public String updateUserState(@RequestParam("id") Integer id,
                                  @RequestParam("state") Boolean state) {
        int i = udao.updateState(id, state);

        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/adduser")
    public String addUser(@RequestBody User user) {
        user.setRole("普通用户");
        user.setState(false);
        int i = udao.addUser(user);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/deleteuser")
    public String deleteUser(int id) {
        int i = udao.deleteUser(id);

        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/getupdateuser")
    public String getUpdateUser(int id) {
        User user = udao.getUpdateUser(id);

        return JSON.toJSONString(user);
    }

    @RequestMapping("/updateuser")
    public String updateUser(@RequestBody User user) {
        int i = udao.updateUser(user);

        return i > 0 ? "success" : "error";
    }
}
