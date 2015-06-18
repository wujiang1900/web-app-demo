package com.myapp.dao;

import org.springframework.stereotype.Repository;
import com.myapp.domain.User;


@Repository
public class UserDaoImpl implements UserDao {

  public User findUser(String userName){
    return new User();
  }

}
