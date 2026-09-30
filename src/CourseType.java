public enum CourseType {
    ZORUNLU("Zorunlu"),
    SECMELI("Seçmeli"),
    ASD("Alan Dışı");

    private final String label;

    CourseType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
