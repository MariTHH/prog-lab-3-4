import classes.*;
import classes.Character;
import enums.Items;
import enums.Location;
import exceptions.ChangeHealthException;
import exceptions.IllogicalLocationException;
import helperclasses.TheSameFirstVisitor;
import helperclasses.TheSameSecondVisitor;
import interfaces.Pretense;

public class Main {
    public static void main(String[] args) {
        try {
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
            cat.getLocation(Location.cornice);
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
            TheSameFirstVisitor theSameFirstVisitor = new TheSameFirstVisitor();
            TheSameSecondVisitor theSameSecondVisitor = new TheSameSecondVisitor();
            System.out.println(theSameFirstVisitor.hashCode() == theSameSecondVisitor.hashCode());
            System.out.println(theSameFirstVisitor.equals(theSameSecondVisitor));
            System.out.println(theSameFirstVisitor.testcrowd(theSameSecondVisitor, theSameFirstVisitor));
            Pretense pretense = (items, character) -> System.out.println(character.getName() + " , его питье " + items.getNameItem() + " было притворством ");
            pretense.drink(Items.petrol, cat);
            cat.hill();
            System.out.println(cat.blow(Items.browning));
            System.out.println(cat.spat(Items.pow));
            WhoCame whoCame = new WhoCame();
            WhoCame.Somebody somebody = whoCame.new Somebody();
            whoCame.makeshooting(cat);
            whoCame.shoot(cat);
            cat.keepSafe();
            Character.Safety safety = new Character.Safety();
            safety.keep();
            whoCame.gaining(cat);
        } catch (IllogicalLocationException ile) {
            System.out.println(ile.getMessage());
        } catch (ChangeHealthException che) {
            System.out.println(che.getMessage());
        } finally {
            System.out.println("the end");
        }
    }
}
