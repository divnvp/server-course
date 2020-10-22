package ru.mip.database.dto;

public class GroupsDto {

    private Long id;
    private String className;
    private String faculty;

    public void setId(Long id) {
        this.id = id;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Long getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public String getFaculty() {
        return faculty;
    }
}
