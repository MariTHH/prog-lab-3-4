package enums;

public enum Items {
    sun("солнце"),
    net("сеть"),
    jug("кувшин"),
    primus("примус"),
    doortodinner("дверь в столовую"),
    browning("браунинг"),
    mauser("маузер"),
    petrol("бензин"),
    curtain("гардина"),
    glass("стекло"),
    chandelier("люстра"),
    sleeve("гильза"),
    dust("пыль"),
    mirror("зеркало"),
    debris("обломки");
    private String name;
    public Location location;
    public Personality personality;

    Items(String name) {
        this.name = name;
    }

    public String getNameItem() {
        return name;
    }

    public Location getLocation(Location location) {
        return this.location = location;
    }

    public Personality getPersonality(Personality personality) {
        return this.personality = personality;
    }

}
