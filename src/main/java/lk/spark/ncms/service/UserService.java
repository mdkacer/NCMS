package lk.spark.ncms.service;

import lk.spark.ncms.dao.User;

public interface UserService {

    public String signinUser(String userName, String password);

    public String signupUser(User userInformation);
}
