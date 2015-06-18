package com.myapp.dao;

import javax.inject.Inject;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.myapp.domain.User;


@Repository
public class UserDaoImpl implements UserDao {

  @Inject
  MongoOperations mongoOperator;

  public User findUser(String userName){

  Query searchUserQuery = new Query(Criteria.where("userName").is(userName));

  User user = mongoOperator.findOne(searchUserQuery, User.class);
  System.out.println("2. find - savedUser : " + user);
    return user;
  }

}
