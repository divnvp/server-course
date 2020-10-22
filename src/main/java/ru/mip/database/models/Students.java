package ru.mip.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.mip.database.dto.StudentsDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Students")
public class Students implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator( name = "native", strategy = "native")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "score")
    private double score;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "sex")
    private String sex;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "groups_id", nullable = false)
    private Groups groups;

    public Students(String name, Groups classname, double score, Date birthday, String sex) {
        this.name = name;
        this.groups = classname;
        this.score = score;
        this.birthday = birthday;
        this.sex = sex;
    }

    public Students() {
    }

    public Students(StudentsDto studentsDto) {
        this.name = studentsDto.getName();
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public StudentsDto toDto(){
        StudentsDto studentsDto = new StudentsDto();
        studentsDto.setId(id);
        studentsDto.setName(name);
        studentsDto.setGroups(groups);
        studentsDto.setScore(score);
        studentsDto.setSex(sex);
        studentsDto.setBirthday(birthday);
        return studentsDto;
    }
}
