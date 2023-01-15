

public class Thrower extends Character implements drop {

    public Thrower() {
        super("Бросавший", 100, Location.floor, Gender.human, Personality.calm);
    }

    @Override
    public void drop(Items thing, Character cat) {
        if (thing == Items.net & location == Location.mantel) {
            cat.personality = personality.caught;
        } else if (thing == Items.net & location != Location.mantel) {
            cat.personality = personality.calm;
            this.personality = personality.surprised;
            System.out.println(name + " " + this.personality.getNamePersonality() + " промахнулся ");
            Items.jug.getLocation(Location.floor);
            Items.jug.getPersonality(Personality.broken);
            this.personality = personality.broken;
            Location.floor.getPersonality(Personality.load);
            System.out.println(Items.jug.getNameItem() + " " + personality.getNamePersonality());

        }
    }
}
