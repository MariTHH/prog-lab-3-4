package classes;

import enums.*;
import interfaces.Gain;


public class WhoCame extends Character {
    public WhoCame() {
        super("Пришедшие", 100, Location.floor, Gender.human, Personality.calm, Poses.stay);
    }

    // вложенный класс
    public class Somebody {
        public void shooting() {
            String name = "кто-то";
            System.out.println(name + " стреляет ");
        }

    }

    public void makeshooting(Character character) {
        Somebody somebody = new Somebody();
        somebody.shooting();
        System.out.println("в " + character.getName());

    }
    // анонимный класс
    public void gaining(Character character){
        Gain attempt = new Gain() {
            public void gain() {
                String attempt = "попытка";
                System.out.println(attempt +" добыть " + character.getName());
            }
        };
        attempt.gain();
    }
}
