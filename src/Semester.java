public enum Semester {
    GUZ("Güz"),
    BAHAR("Bahar"),
    YAZ("Yaz Okulu");

    private final String description;

    Semester(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
