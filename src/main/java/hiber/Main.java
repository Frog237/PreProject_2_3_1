package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add((new User("Nikita", "Skutin", (byte) 25)));
        userService.add((new User("Nikita", "Skutin", (byte) 26)));
        userService.add((new User("Nikita", "Skutin", (byte) 27)));
        userService.add((new User("Nikita", "Skutin", (byte) 28)));

        userService.findAll().forEach(System.out::println);

    }
}

