package classes;

import enums.*;
import exceptions.ChangeHealthException;
import exceptions.IllogicalLocationException;

import java.util.Objects;


public abstract class Character {
    protected String name;
    protected double health = 100;
    protected Personality personality;
    protected Location location;
    protected Items item1;
    protected final Gender gender;
    protected Poses poses;

    public Character(String name, int health, Location location, Gender gender, Personality personality, Poses poses) {
        this.name = name;
        this.health = health;
        this.location = location;
        this.gender = gender;
        this.personality = personality;
        this.poses = poses;
    }

    public String getName() {
        return name;
    }

    public Location getLocation(Location location) {
        return this.location = location;
    }

    @Override
    public String toString() {
        return "персонаж " + this.getName();
    }


    public void shoot(Character character) {
        // локальный класс
        class Shooting {
            final String shooting = "стрельба";

            public void start() {
                System.out.println(shooting + " началась");
            }

            public void end() {
                System.out.println(shooting + " закончилась");
            }

        }
        Shooting shooting = new Shooting();
        shooting.start();
        if (character.personality == Personality.atRisk) {
            if (character.health == 0) {
                System.out.println(name + " застрелил " + character.getName() + ". ");
            } else {
                System.out.println(character.getName() + " успел увернуться ");
            }
        } else {
            Items.debris.location = Location.floor;
            Items.mirror.personality = Personality.broken;
            Items.dust.location = Location.floor;
            Items.sleeve.location = Location.floor;
            Items.glass.personality = Personality.broken;
            Items.petrol.location = Location.floor;
        }
        shooting.end();
    }

    // статический вложенный класс
    public static class Safety {
        public void keep() {
            String safety = "безопасность";
            System.out.println("обеспечена " + safety);
        }
    }

    public void keepSafe() {
        Safety safety = new Safety();
        safety.keep();
        System.out.println("для " + this.name);
    }

    public void fallDown() throws IllogicalLocationException, ChangeHealthException {
        if (this.location == Location.mantel) {
            this.location = Location.floor;
            this.health = health - Math.round(Math.random() * 20);
            if (this.health < 0) {
                throw new ChangeHealthException("Здоровье не может быть отрицателен");
            }
            System.out.println(name + " шлепнулся на " + this.location.getNamePlace());
        } else if (this.location == Location.pocket) {
            throw new IllogicalLocationException("Животному или человеку невозможно упасть в карман");
        }
    }

    public void jumpTo(Location location) throws ChangeHealthException {
        if (this.gender == Gender.animal) {
            this.location = location;
            System.out.println(name + " прыгнул на " + this.location.getNamePlace());
        } else if (this.gender == Gender.human & (location == Location.cornice || location == Location.chandelier)) {
            Items.chandelier.personality = Personality.broken;
            this.health = health - Math.round(Math.random() * 90);
            if (this.health < 0) {
                throw new ChangeHealthException("Error");
            }
            System.out.println(name + " прыгнул и " + Items.chandelier.getNameItem() + " " + Items.chandelier.personality.getNamePersonality());
        }
    }

    public String hill() {
        this.health = 100;
        return name + " вылечился";
    }

    public void testforhealth() throws ChangeHealthException {
        this.health = this.health - 101;
        System.out.println(name + " здоровье меньше 0");
        if (this.health < 0) {
            throw new ChangeHealthException("Error");
        }
    }

    public String testcrowd(Character character, Character character2) {
        if (character2.hashCode() == character.hashCode()) {
            if (equals(character2) == equals(character)) {
                return " they are npc and they are just a crowd";
            }
        } else {
            return " they are main characters ";
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Character)) {
            return false;
        }
        Character character = (Character) obj;
        return personality == character.personality && location == character.location && item1 == character.item1 && poses == character.poses;
    }

    @Override
    public int hashCode() {
        return Objects.hash(health, personality, location, item1, poses);
    }
}
