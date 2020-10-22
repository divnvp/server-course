package ru.mip.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.mip.database.dto.UsersDto;
import ru.mip.database.models.Users;
import ru.mip.database.services.UsersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(method = RequestMethod.GET)
    public List<UsersDto> index(){
        return usersService.listAllUsers()
                .stream().map(Users::toDto).collect(Collectors.toList());
    }
}
