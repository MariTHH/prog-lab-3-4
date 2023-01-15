public enum Personality {
    caught("пойман"),
    load("со звоном"),
    pointAt("направлен на"),
    atRisk("под угрозой"),

    calm("спокойный"),
    surprised("к полному удивлению всех"),
    broken("разбился");

    private String NamePersonality;

    Personality(String name) {
        this.NamePersonality = name;
    }

    public String getNamePersonality() {
        return NamePersonality;
    }
}
