package classes;

import interfaces.*;
import enums.*;

public class FirstVisitor extends Character implements Target, ToCatch {

    public FirstVisitor() {
        super("Вошедший", 100, Location.floor, Gender.human, Personality.calm, Poses.stay);
    }

    @Override
    public void toCatch(Items item, Location location) {
        item.getLocation(Location.floor);
        item.location = Location.floor;
        if (item.location == Location.floor) {
            Items.sun.location = Location.darkroom;
            System.out.println(name + " вцепился в " + item.getNameItem() + " отчего " + Items.sun.getNameItem() + Items.sun.location.getNamePlace());
        }
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
