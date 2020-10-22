package ru.mip.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mip.database.dto.StudentsDto;
import ru.mip.database.models.Groups;
import ru.mip.database.models.Students;
import ru.mip.database.services.StudentsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/students", produces = "application/json")
public class StudentsController {

    @Autowired private StudentsService studentsService;

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    @ResponseBody
    public List<StudentsDto> index(){
        return studentsService.listAllStudents().stream().map(Students::toDto).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/post")
    @ResponseBody
    public Students add(@RequestBody Students students){
        return studentsService.add(students);
    }

    @RequestMapping(method= RequestMethod.DELETE, value = "/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentsService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public Students update(@RequestBody Students students){
        return studentsService.update(students);
    }
}
