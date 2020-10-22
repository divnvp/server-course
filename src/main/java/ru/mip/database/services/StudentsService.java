package ru.mip.database.services;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mip.database.exceptions.ResourceNotFoundException;
import ru.mip.database.exceptions.ThrowException;
import ru.mip.database.models.Groups;
import ru.mip.database.models.Students;
import ru.mip.database.repositories.StudentsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private GroupsService groupsService;

    public List<Students> listAllStudents(){
        ArrayList<Students> students = new ArrayList<>();
        studentsRepository.findAll().forEach(students::add);
        return students;
    }

    public Students save(Students students) {
        return studentsRepository.save(students);
    }

    public void delete(Long id){
         studentsRepository.deleteById(id);
    }

    public Students add(Students students){
        if (students.getGroups()==null || students.getGroups().getId()==null){
            throw new ThrowException("Группа не задана");
        }
        Groups groups = groupsService.get(students.getGroups().getId()).orElseThrow(
                () -> new ResourceNotFoundException("Группа не найдена")
        );
        students.setGroups(groups);
        return studentsRepository.save(students);
    }

    public Students update(Students students){
        return studentsRepository.save(students);
    }
}
