package com.duoer.campus.dao;

import com.duoer.campus.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    // select username and status
    @Select("select username, status from user_info where username = #{username} and password = #{password}")
    User checkUser(User u);

    // select username and status
    @Select("select username from user_info where username = #{username}")
    User selectUserByUsername(User u);

    @Insert("insert into user_info values (#{username}, #{password}, 1)")
    void insertUser(User u);

    void updateUser(User u);

    @Delete("delete from user_info where username = #{username} and password = #{password}")
    void deleteUser(User u);
}
