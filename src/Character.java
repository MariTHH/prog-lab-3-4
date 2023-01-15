public abstract class Character {
    protected String name;
    protected double health = 100;
    protected Personality personality;
    protected Location location;
    protected Items item1;
    protected Items item2;
    protected Gender gender;

    public Character(String name, int health, Location location, Gender gender, Personality personality) {
        this.name = name;
        this.health = health;
        this.location = location;
        this.gender = gender;
        this.personality = personality;
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
            if (this.location == Location.mantel) {
                this.location = Location.floor;
                this.health = health - Math.round(Math.random() * 20);
                Items.browning.location = Location.floor;
                Items.primus.location = Location.floor;
                System.out.println(name + " шлепнулся на " + this.location.getNamePlace());
            }

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

    public void jumpto(Character character) {
        if (character.gender == Gender.animal) {
            character.location = Location.chandelier;
            System.out.println(name + " " + character.location.getNamePlace());
        } else {
            Items.chandelier.personality = Personality.broken;
            Items.chandelier.location = Location.floor;
            character.health = health - Math.round(Math.random() * 90);
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
