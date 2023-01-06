public class Main{
    public static void main(String[] args){
        Cat cat = new Cat("Кот",100,Location.mantel, Gender.animal, Personality.calm);
        cat.drop(Items.primus,cat);
        cat.getLocation();
        Thrower thrower = new Thrower("Бросавший", 100, Location.floor, Gender.human, Personality.calm);
        thrower.drop(Items.net, cat);
        cat.drink(Items.petrol);
        cat.toCatch(Items.browning, Location.outofback);
        NearbyVisitor nearbyVisitor = new NearbyVisitor("ближстоящий",100,Location.floor, Gender.human,Personality.calm);
        cat.target(Items.browning,nearbyVisitor);
        cat.shoot(nearbyVisitor);
        System.out.println(nearbyVisitor.fire());
        System.out.println(cat.look(Items.doortodinner));
        cat.toCatch(Items.primus, Location.underthearm);
        cat.location = Location.mantel;
        cat.location = Location.cornice;
        FirstVisitor firstVisitor = new FirstVisitor("Вошедший", 100, Location.floor, Gender.human, Personality.calm);
        firstVisitor.toCatch(Items.curtain, Location.floor);
        System.out.println(cat.hill());
        cat.jumpto(cat);
        cat.toCatch(Items.browning, Location.chandelier);
        Items.primus.location = Location.chandelier;
        cat.target(Items.browning, firstVisitor);
        SecondVisitor secondVisitor = new SecondVisitor("еще Вошедший",100,Location.floor, Gender.human, Personality.calm);
        cat.shoot(secondVisitor);
        firstVisitor.target(Items.mauser,cat);
        secondVisitor.target(Items.mauser,cat);
        firstVisitor.shoot(cat);

    }
}