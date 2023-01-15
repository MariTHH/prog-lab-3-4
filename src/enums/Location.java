package enums;

public enum Location {
    floor("пол"),
    mantel("каминная полка"),
    pocket("карман"),
    cornice("карниз"),
    side("в сторону"),
    outofback("из-за спины"),
    behind("за спиной"),
    underthearm("под мышку"),
    chandelier("люстра"),
    darkroom(" в затененной комнате");

    private String NamePlace;
    protected Personality personality;

    Location(String name) {
        this.NamePlace = name;
    }

    public String getNamePlace() {
        return NamePlace;
    }

    public Personality getPersonality(Personality personality) {
        return this.personality = personality;
    }

}
