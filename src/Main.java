import classes.*;
import enums.Items;
import enums.Location;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.getLocation(Location.floor);
        Thrower thrower = new Thrower();
        thrower.drop(Items.net, cat);
        cat.drop(Items.primus, cat);
        cat.toCatch(Items.browning, Location.outofback);
        NearbyVisitor nearbyVisitor = new NearbyVisitor();
        cat.target(Items.browning, nearbyVisitor);
        System.out.println(nearbyVisitor.fire());
        cat.shoot(nearbyVisitor);
        cat.fallDown();
        System.out.println(cat.look(Items.doortodinner));
        cat.toCatch(Items.primus, Location.underthearm);
        cat.location = Location.cornice;
        FirstVisitor firstVisitor = new FirstVisitor();
        cat.drink(Items.petrol);
        System.out.println(cat.hill());
        cat.jumpTo(Location.cornice);
        cat.toCatch(Items.browning, Location.chandelier);
        firstVisitor.toCatch(Items.curtain, Location.floor);
        Items.primus.location = Location.chandelier;
        cat.target(Items.browning, firstVisitor);
        SecondVisitor secondVisitor = new SecondVisitor();
        cat.shoot(secondVisitor);
        firstVisitor.target(Items.mauser, cat);
        secondVisitor.target(Items.mauser, cat);
        firstVisitor.shoot(cat);
        cat.jumpTo(Location.chandelier);
        cat.shoot(thrower);
    }
}