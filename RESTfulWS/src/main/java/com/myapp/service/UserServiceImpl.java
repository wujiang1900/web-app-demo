package com.myapp.service;

import org.springframework.stereotype.Service;
import javax.inject.Inject;

import com.myapp.domain.User;
import com.myapp.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

  @Inject
  UserDao userDao;

  public User getUser(String userName){
    return userDao.findUser(userName);
  }

}
