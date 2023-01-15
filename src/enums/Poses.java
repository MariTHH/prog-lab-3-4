package enums;

public enum Poses {
    upsideDown("вниз головой"),
    lyingPosition("лежа"),
    stay("стоя");

    private String NamePoses;

    Poses(String name) {
        this.NamePoses = name;
    }

    public String getNamePoses() {
        return NamePoses;
    }
}

