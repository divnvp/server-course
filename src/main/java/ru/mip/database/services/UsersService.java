package ru.mip.database.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mip.database.models.Users;
import ru.mip.database.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Transactional(readOnly = true)
    public List<Users> listAllUsers(){
        ArrayList<Users> users = new ArrayList<>();
        usersRepository.findAll().forEach(users::add);
        return users;
    }

    public Users save(Users users) {
        return usersRepository.save(users);
    }
}
