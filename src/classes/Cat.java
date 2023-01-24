package classes;

import exceptions.ChangeHealthException;
import interfaces.*;
import enums.*;


public class Cat extends Character implements Drop, Target, ToCatch {
    public Cat() {
        super("Кот", 100, Location.mantel, Gender.animal, Personality.calm, Poses.stay);
    }

    @Override
    public void drop(Items thing, Character character) {
        if (thing.hashCode() == Items.primus.hashCode()) {
            if (thing.equals(Items.primus)) {
                thing.getLocation(Location.side);
                System.out.println(name + " отставил " + thing.location.getNamePlace() + " " + thing.getNameItem());
            }
        } else {
            thing.getLocation(Location.floor);
            System.out.println(thing.getNameItem() + " все еще там, где " + thing.location.getNamePlace());
        }

    }

    @Override
    public void shoot(Character character) {
        if (character.personality.hashCode() == Personality.atRisk.hashCode()) {
            if (character.personality.equals(Personality.atRisk)) {
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
    }

    @Override
    public void fallDown() throws ChangeHealthException {
        if (this.location == Location.mantel & (Items.browning.personality == Personality.pointAt || Items.mauser.personality == Personality.pointAt)) {
            this.poses = Poses.upsideDown;
            this.location = Location.floor;
            this.health = health - Math.round(Math.random() * 20);
            if (this.health < 0) {
                throw new ChangeHealthException("Error");
            }
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

    public void drink(Items drink) throws ChangeHealthException {
        if (drink == Items.petrol) {
            System.out.println(name + " выпил " + drink.getNameItem());
            double index = Math.random() * 100;
            health = (int) (health - Math.round(index));
            if (this.health < 0) {
                throw new ChangeHealthException("Здоровье не может быть отрицателен");
            }
            System.out.println(Math.round(health) + " изменилось на " + Math.round(index));
        } else {
            System.out.println(this.health + " не изменилось");
        }
    }

    public String blow(Items items) {
        return this.getName() + " подул на " + items.getNameItem();
    }

    public String spat(Items items) {
        items.getPersonality(Personality.wet);
        return this.getName() + " плюнул на " + items.getNameItem() + " теперь " + Personality.wet.getNamePersonality();
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

