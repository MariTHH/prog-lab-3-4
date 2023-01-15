package classes;

import interfaces.*;
import enums.*;

public class Cat extends Character implements Drop, Target, ToCatch {
    public Cat() {
        super("Кот", 100, Location.mantel, Gender.animal, Personality.calm, Poses.stay);
    }

    @Override
    public void drop(Items thing, Character character) {
        if (thing.equals(Items.primus) == true) {
            thing.getLocation(Location.side);
            System.out.println(name + " отставил " + thing.location.getNamePlace() + " " + thing.getNameItem());
        } else {
            thing.getLocation(Location.floor);
            System.out.println(thing.getNameItem() + " все еще там, где " + thing.location.getNamePlace());
        }
    }

    @Override
    public void shoot(Character character) {
        if (character.personality == Personality.atRisk) {
            if (character.health == 0) {
                System.out.println(name + " застрелил " + character.getName() + ". ");
            } else {
                System.out.println(name + " выстрелил, но " + character.getName() + " успел увернуться ");
            }
        } else {
            Items.debris.location = Location.floor;
            Items.mirror.personality = Personality.broken;
            Items.dust.location = Location.floor;
            Items.sleeve.location = Location.floor;
            Items.glass.personality = Personality.broken;
            Items.petrol.location = Location.floor;
            System.out.println(name + " стреляет, разбивая " + Items.mirror.getNameItem() + " " + Items.glass.getNameItem());
        }
    }

    @Override
    public void fallDown() {
        if (this.location == Location.mantel & (Items.browning.personality == Personality.pointAt || Items.mauser.personality == Personality.pointAt)) {
            this.poses = Poses.upsideDown;
            this.location = Location.floor;
            this.health = health - Math.round(Math.random() * 20);
            Items.browning.location = Location.floor;
            Items.primus.location = Location.floor;
            System.out.println(name + " " + this.poses.getNamePoses() + " шлепнулся на " + this.location.getNamePlace());
            this.poses = Poses.lyingPosition;
        }
    }

    @Override
    public Location getLocation(Location location) {
        return this.location = Location.mantel;
    }

    public String look(Items item) {
        return name + " посмотрел на " + item.getNameItem();
    }

    public void drink(Items drink) {
        if (drink == Items.petrol) {
            System.out.println(name + " выпил " + drink.getNameItem());
            double index = Math.random() * 100;
            health = health - Math.round(index);
            System.out.println(Math.round(health) + " изменилось на " + Math.round(index));
        } else {
            health = health;
        }
    }

    @Override
    public void toCatch(Items item, Location location) {
        item.getLocation(location);
        item.location = location;
        System.out.println(name + " выхватил " + item.getNameItem());
    }

    @Override
    public void target(Items item, Character character) {
        item.getPersonality(Personality.pointAt);
        item.personality = Personality.pointAt;
        character.personality = Personality.atRisk;
        System.out.println(item.getNameItem() + " " + item.personality.getNamePersonality() + " " + character.getName());
        System.out.println(character.getName() + " " + character.personality.getNamePersonality());
    }
}
