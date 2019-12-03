package com.vehicle.vehicle.services;

import com.vehicle.vehicle.security.UserRepository;
import com.vehicle.vehicle.security.model.User;
import com.vehicle.vehicle.security.util.PassWordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired private UserRepository userRepository;

    @Override
    public User save(User user) {
        String password = PassWordUtil.getHashedPassword(user.getPassword());
        user.setPassword(password);
        user.setCreatedDate(new Date());
        return userRepository.save(user);
    }
}
