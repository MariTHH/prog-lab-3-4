public class SecondVisitor extends Character implements target {

    public SecondVisitor() {
        super("еще Ближстоящий", 100, Location.floor, Gender.human, Personality.calm);
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
