public class NearbyVisitor extends Character{

    public NearbyVisitor(String name, int health, Location location, Gender gender, Personality personality) {
        super(name, health, location, gender, personality);
    }
    public String fire(){
        this.health = health - Math.round(Math.random()*35);
        return " у " + name + " полыхнуло огнем";
    }
}
