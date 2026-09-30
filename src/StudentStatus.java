public enum StudentStatus {
    AKTIF("Aktif"),
    MEZUN("Mezun"),
    ASKI("Kayıt Donduruldu"),
    AYRILDI("Ayrıldı");

    private final String label;

    StudentStatus(String label) {
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
