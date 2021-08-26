package com.jly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jly.bean.User;

public interface UserDao {
	public List<User> querryAllUser();
	public User querryUserById(@Param("id") int id);
}
