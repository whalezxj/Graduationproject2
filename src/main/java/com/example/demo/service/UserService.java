package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.enums.UserStatus;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.utils.Args;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

/**
 * @author
 * @date 2020/8/26
 **/
@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    @Autowired
    private UserMapper userMapper;


    public String submitLogin(User user) {
        User user1 = userMapper.select(user);
        if (user1 == null) {
            return "用户不存在";
        }
        return user1.toString();
    }

    public User getByUserName(String username) {
        Integer id = userMapper.getByUserName(username);
        User user = userMapper.selectById(id);
        return user;
    }

    @Transactional
    public void registUser(Args registargs) {
        Integer id = userMapper.getByUserName(registargs.getUsername());
        if (id == null) {
            registargs.setId(new Integer(String.valueOf(new Random().nextInt(999999))));
            userMapper.save(registargs);
        } else {
            userMapper.deleteById(id);
            registargs.setId(id);
            userMapper.save(registargs);
        }
    }

    @Transactional
    public void saveOrUpdate(Args args) {
        Integer id = userMapper.getByUserName(args.getUsername());
        if (id == null) {
            args.setId(new Integer(String.valueOf(new Random().nextInt(999999))));
            userMapper.save(args);
        } else {
            userMapper.deleteById(id);
            args.setId(id);
            userMapper.save(args);
        }
    }

    public List<User> queryPage() {
        List<User> list = userMapper.queryPage();
        list.forEach(item->{
            item.setStatus(UserStatus.getByValue(item.getStatus()).getName());
        });
        return list;
    }


    @Transactional
    public void deleteById(int id) {
        userMapper.deleteById(id);
    }

    @Transactional
    public void activiteById(int id) {
        userMapper.activiteById(id);
    }

    public User getById(int id) {
        User user = userMapper.getById(id);
        return user;
    }
}
