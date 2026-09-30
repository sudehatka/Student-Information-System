public enum DegreeLevel {
    ONLISANS("Önlisans"),
    LISANS("Lisans"),
    YUKSEK_LISANS("Yüksek Lisans"),
    DOKTORA("Doktora");

    private final String label;

    DegreeLevel(String label) {
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
