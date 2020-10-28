package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.User;
import com.example.demo.utils.Args;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author
 * @date 2020/8/26
 **/
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select a.* from user a where a.username = #{user.username} and  a.password = #{user.password} and a.status !=1")
    User select(@Param("user") User user);

    @Insert("insert into user(id,username,password,phone,gender,mail) value (#{registArgs.id},#{registArgs.username},#{registArgs.password},#{registArgs.phone},#{registArgs.gender},#{registArgs.mail})")
    void save(@Param("registArgs") Args args);

    @Select("select a.id from user a where a.username = #{username} and a.status !=1")
    Integer getByUserName(@Param("username") String username);

    @Select("select a.* from user a ")//where a.status !=1
    List<User> queryPage();

    @Update("update a.*from user a where a.id =#{id} ")
    User updateById(@Param("id") Integer id);

    @Update("update  user a  set a.status = 0 where a.id =#{id} ")
    void resumeById(@Param("id") Integer id);

    @Update("update  user a  set a.status = 1 where a.id =#{id} ")
    void deleteById(@Param("id") Integer id);

    @Update("update  user a  set a.status = 0 where a.id =#{id} ")
    void activiteById(@Param("id") Integer id);

    @Select("select a.* from user a where a.id = #{id} and a.status !=1")
    User selectById(@Param("id") Integer id);

    @Select("select a.* from  user a where a.id = #{id}")
    User getById(@Param("id") Integer id);
}
