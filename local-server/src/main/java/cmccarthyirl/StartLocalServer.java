package cmccarthyirl;

import cmccarthyirl.models.Hero;
import cmccarthyirl.storage.HeroList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StartLocalServer {
    public static void main(String[] args) {
        SpringApplication.run(StartLocalServer.class, args);

        try {
            Hero hero = new Hero(1, "Achilles", 27, "Sword & Shield", "Super speed");
            Hero hero1 = new Hero(2, "Spartacus", 55, "Sword", "Incredible strength");
            Hero hero2 = new Hero(3, "Bruce Lee", 30, "Fists", "Super fast");
            Hero hero3 = new Hero(4, "Dead Pool", 100, "Guns", "Can't die");

            List<Hero> list = new ArrayList<>();
            list.add(hero);
            list.add(hero1);
            list.add(hero2);
            list.add(hero3);
            HeroList.setListOfHeros(list);

        } catch (Exception ex) {
            System.out.println("ex = " + ex);
        }
    }
}
