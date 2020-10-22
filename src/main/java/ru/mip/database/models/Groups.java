package ru.mip.database.models;

import ru.mip.database.dto.GroupsDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Groups")
public class Groups implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "class_name")
    private String className;

    @Column(name = "faculty")
    private String faculty;

    public Groups() {
    }

    public Groups(String className, String faculty) {
        this.className = className;
        this.faculty = faculty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public GroupsDto toDto(){
        GroupsDto groupsDto = new GroupsDto();
        groupsDto.setId(id);
        groupsDto.setClassName(className);
        groupsDto.setFaculty(faculty);
        return groupsDto;
    }
}
