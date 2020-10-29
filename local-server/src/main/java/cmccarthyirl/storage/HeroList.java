package cmccarthyirl.storage;

import cmccarthyirl.models.Hero;

import java.util.List;

public class HeroList {

    private static List<Hero> listOfHeros;

    public HeroList(List<Hero> listOfHeroValues) {
        HeroList.listOfHeros = listOfHeroValues;
    }

    public static List<Hero> getListOfHeros() {
        return listOfHeros;
    }

    public static void setListOfHeros(List<Hero> listOfHeroValues) {
        HeroList.listOfHeros = listOfHeroValues;
    }

    public static Hero getHero(int id) {
        Hero anotherHero = null;
        for (Hero listOfHero : listOfHeros) {
            if (listOfHero.getId() == id) {
                anotherHero = listOfHero;
            }
        }
        return anotherHero;
    }

//    public static Hero getHero(String name) {
//        Hero anotherHero = null;
//        for (Hero listOfHero : listOfHeros) {
//            if (listOfHero.getName().equals(name)) {
//                anotherHero = listOfHero;
//            }
//        }
//        return anotherHero;
//    }

//    public static void updateHero(int id, String name, int age, String weapon, String specialPower) {
//        if (getHero(id) != null) {
//            listOfHeros.remove(getHero(id));
//            listOfHeros.add(new Hero(id, name, age, weapon, specialPower));
//        }
//    }

    public static void updateHero(Hero newHero, int id) {
        if (getHero(id) != null) {
            listOfHeros.remove(getHero(id));
            listOfHeros.add(new Hero(id, newHero.getName(), newHero.getAge(), newHero.getWeapon(), newHero.getSpecialPower()));
        }
    }
}
