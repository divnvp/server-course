package ru.mip.database.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.mip.database.models.Users;
import ru.mip.database.services.UsersService;

import java.util.Random;

@Component
public class UsersConfiguration implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(UsersConfiguration.class);

    @Autowired
    private UsersService usersService;

    private final String[] firstname = new String[]{
            "Diana", "Jenya", "Anatoliy"
    };

    private final String[] lastname = new String[]{
            "Pimenova", "Alekseeva", "Kudryavtsev"
    };

    private final String[] fathername = new String[]{
            "Pavlovna", "Ivanovna", "Igorevitch"
    };

    private final String[] status = new String[]{
            "customer", "student"
    };

    private final String[] username = new String[]{
            "diana", "jenya", "tolya"
    };

    private final String[] password = new String[]{
            "diana", "jenya", "tolya"
    };

    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();
        for (int i = 0; i < 10; i++){
            Users users = new Users(
                    firstname[random.nextInt(firstname.length)],
                    lastname[random.nextInt(lastname.length)],
                    fathername[random.nextInt(fathername.length)],
                    username[random.nextInt(username.length)],
                    status[random.nextInt(status.length)],
                    password[random.nextInt(password.length)]
            );
            usersService.save(users);
        }
    }
}
