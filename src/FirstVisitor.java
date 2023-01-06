public class FirstVisitor extends Character implements target,toCatch{

    public FirstVisitor(String name, int health, Location location, Gender gender, Personality personality) {
        super(name, health, location, gender, personality);
    }
    @Override
    public void toCatch(Items item, Location location){
        item.getLocation(Location.floor);
        item.location = Location.floor;
        if (item.location == Location.floor){
            Items.sun.location = Location.darkroom;
            System.out.println(name + " вцепился в " + item.getNameItem() + " отчего " + Items.sun.getNameItem() + Items.sun.location.getNamePlace());
        }
    }
    @Override
    public void target(Items item,Character character){
        item.getPersonality(Personality.pointAt);
        item.personality = Personality.pointAt;
        character.personality = Personality.atRisk;
        System.out.println(item.getNameItem() + " "+ item.personality.getNamePersonality()+ " " +character.getName());
        System.out.println(character.getName()+ " "+character.personality.getNamePersonality());
    }
}
