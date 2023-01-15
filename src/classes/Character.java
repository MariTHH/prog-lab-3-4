package classes;

import enums.*;

public abstract class Character {
    protected String name;
    protected double health = 100;
    protected Personality personality;
    public Location location;
    protected Items item1;
    protected Items item2;
    protected Gender gender;
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
    }

    public void fallDown() {
        if (this.location == Location.mantel) {
            this.location = Location.floor;
            this.health = health - Math.round(Math.random() * 20);
            System.out.println(name + " шлепнулся на " + this.location.getNamePlace());
        }
    }

    public void jumpTo(Location location) {
        if (this.gender == Gender.animal) {
            this.location = location;
            System.out.println(name + " прыгнул на " + this.location.getNamePlace());
        } else if (this.gender == Gender.human & (location == Location.cornice || location == Location.chandelier)) {
            Items.chandelier.personality = Personality.broken;
            this.health = health - Math.round(Math.random() * 90);
            System.out.println(name + " прыгнул и " + Items.chandelier.getNameItem() + Items.chandelier.personality.getNamePersonality());
        }
    }

    public String hill() {
        this.health = 100;
        return name + " вылечился";
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
        return this.name.equals(character.name) && super.equals(obj);
    }
}