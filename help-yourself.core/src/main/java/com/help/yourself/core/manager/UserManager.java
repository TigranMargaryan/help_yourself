package com.help.yourself.core.manager;

import com.help.yourself.core.data.User;
import com.help.yourself.core.manager.IManager.IUserManager;
import com.help.yourself.core.repository.UserRepository;
import com.help.yourself.core.repository.UserSkillRepository;
import javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements IUserManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSkillRepository userSkillRepository;

    @Override
    public User getById(String email) {
        User user = userRepository.findById(email);

        if(user == null){
            throw new NullPointerException("user with this email don't exist");
        }
        return user;
    }

    @Override
    public void create(User user) throws DuplicateMemberException {
        User userFound = userRepository.findByEmail(user.getEmail());

        if (userFound != null){
            throw new DuplicateMemberException("user with this email already exist");
        }

        user.setId();
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

}
