public class NearbyVisitor extends Character {

    public NearbyVisitor() {
        super("Ближстоящий", 100, Location.floor, Gender.human, Personality.calm);
    }

    public String fire() {
        this.health = health - Math.round(Math.random() * 35);
        return " у " + name + " полыхнуло огнем";
    }
}
