package ru.mip.database.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mip.database.models.Groups;
import ru.mip.database.models.Users;
import ru.mip.database.repositories.GroupsRepository;
import ru.mip.database.repositories.UsersRepository;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GroupsService {

    @Autowired
    GroupsRepository groupsRepository;

    @Transactional(readOnly = true)
    public List<Groups> listAllGroups(){
        ArrayList<Groups> groups = new ArrayList<>();
        groupsRepository.findAll().forEach(groups::add);
        return groups;
    }

    public Optional<Groups> get(long id){
        return groupsRepository.findById(id);
    }

    public Groups save(Groups groups) {
        return groupsRepository.save(groups);
    }

    public void delete(long id){
        groupsRepository.deleteById(id);
    }

    public Groups update(Groups groups){
        return groupsRepository.save(groups);
    }
}
