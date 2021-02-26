package ru.mip.database.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.mip.database.models.Groups;
import ru.mip.database.models.Role;
import ru.mip.database.models.Students;
import ru.mip.database.models.User;
import ru.mip.database.services.GroupsService;
import ru.mip.database.services.RoleService;
import ru.mip.database.services.StudentsService;
import ru.mip.database.services.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

@Component
public class GroupsConfiguration implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(GroupsConfiguration.class);

    @Autowired
    private GroupsService groupsService;

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    private final String[] className = new String[]{
            "3A", "3B", "3C"
    };

    private final String[] faculty = new String[]{
            "FMF", "PPF", "FVS"
    };

    private final String[] name = new String[]{
            "Pimenova Diana Pavlovna", "Alekseeva Evgeniya Ivanovna", "Kudryavtsev Anatoliy Igorevitch"
    };

    private final Double[] score = new Double[]{
            4.5, 5.0, 4.7
    };

    private final Date[] birthday = new Date[]{
            getDateFromString("25/11/2000"),
            getDateFromString("12/02/2001"),
            getDateFromString("19/07/2000"),
    };

    private Date getDateFromString(String s) {
        SimpleDateFormat dateFormat
                = new SimpleDateFormat("dd/MM/yyyy");
        Date invalidDate = new Date(0);
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            return invalidDate;
        }
    }

    private final String[] sex = new String[]{
            "M", "W"
    };

    @Override
    public void run(String... args) {
        Groups groups = new Groups(
                className[0],
                faculty[0]
        );
        groupsService.save(groups);

        Groups groups1 = new Groups(
                className[1],
                faculty[1]
        );
        groupsService.save(groups1);

        Groups groups2 = new Groups(
                className[2],
                faculty[2]
        );
        groupsService.save(groups2);

        Students students = new Students(
                name[0],
                groups,
                score[0],
                birthday[0],
                sex[1]
        );

        Students students1 = new Students(
                name[1],
                groups1,
                score[1],
                birthday[1],
                sex[1]
        );

        Students students2 = new Students(
                name[2],
                groups2,
                score[2],
                birthday[2],
                sex[0]
        );

        studentsService.save(students);
        studentsService.save(students1);
        studentsService.save(students2);

        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        roleService.save(adminRole);

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRoles(Collections.singleton(adminRole));
        userService.saveUser(admin);
    }
}

