public enum Gender {
    human("человек"),
    animal("животное");
    private String NameGender;

    Gender(String name) {
        this.NameGender = name;
    }

    public String getNameGender() {
        return NameGender;
    }
}
