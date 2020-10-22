package ru.mip.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mip.database.dto.GroupsDto;
import ru.mip.database.dto.UsersDto;
import ru.mip.database.models.Groups;
import ru.mip.database.models.Students;
import ru.mip.database.models.Users;
import ru.mip.database.services.GroupsService;
import ru.mip.database.services.StudentsService;
import ru.mip.database.services.UsersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/groups")
public class GroupsController {

    @Autowired
    private GroupsService groupsService;

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public List<GroupsDto> index(){
        return groupsService.listAllGroups()
                .stream().map(Groups::toDto).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/post")
    @ResponseBody
    public void add(@RequestBody Groups groups){
        groupsService.save(groups);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable long id){
        groupsService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public Groups update(@RequestBody Groups groups){
        return groupsService.update(groups);
    }
}
