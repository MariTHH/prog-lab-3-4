public class Cat extends Character implements drop,target, toCatch{
    public Cat(String name, int health, Location location, Gender gender, Personality personality){
        super(name, health, location, gender, personality);
    }
    @Override
    public void drop(Items thing, Character character){
        if (thing == Items.primus){
            //thing.getLocation(Location.side);
            this.location=Location.side;
            System.out.println(name+ " отставив " + location.getNamePlace() + " " + thing.getNameItem() );
        }
    }
    @Override
    public void shoot(Character character){
        if (character.personality == Personality.atRisk){
            if (this.location == Location.mantel){
                this.location = Location.floor;
                this.health = health - Math.round(Math.random()*20);
                Items.browning.location = Location.floor;
                Items.primus.location = Location.floor;
                System.out.println(name + " шлепнулся на " + this.location.getNamePlace());}

            if(character.health == 0){
                System.out.println(name + " застрелил " + character.getName() + ". ");
            }
            else {
                System.out.println(character.getName() + " успел увернуться " );
            }
        }
        else {
            Items.debris.location = Location.floor;
            Items.mirror.personality = Personality.broken;
            Items.dust.location = Location.floor;
            Items.sleeve.location = Location.floor;
            Items.glass.personality = Personality.broken;
            Items.petrol.location = Location.floor;
        }
    }

    @Override
    public Location getLocation(){return Location.mantel;}

    public String look(Items item){
        return name + " посмотрел на " + item.getNameItem();}

    public void drink(Items drink){
        if(drink == Items.petrol){
            System.out.println(name+ " выпил " + drink.getNameItem());
            double index = Math.random()*100;
            health = health - Math.round(index);
            System.out.println(Math.round(health) + " изменилось на " + Math.round(index));
        }
        else{
            health = health;
        }
    }

    @Override
    public void toCatch(Items item, Location location){
        item.getLocation(location);
        item.location = location;
        System.out.println(name + " выхватил " + item.getNameItem() + " " + item.location.getNamePlace() );
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
