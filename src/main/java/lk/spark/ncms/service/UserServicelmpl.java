package lk.spark.ncms.service;

import lk.spark.ncms.dao.User;
import lk.spark.ncms.repository.UserRepository;

public class UserServicelmpl implements UserService {

    @Override
    public String signinUser(String username, String password){

        UserRepository userRepository = new UserRepository();
        String result = userRepository.userSignin(username, password);
        return result;
    }

    @Override
    public String signupUser(User userInformation){

        UserRepository userRepository = new UserRepository();
        String result = userRepository.userSignup(userInformation);
        return result;
    }
}
