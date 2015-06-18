package com.myapp.dao;

import com.myapp.domain.User;

public interface UserDao {

  public User findUser(String userName);

}
