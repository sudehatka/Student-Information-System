/**
 * Cinsiyet Enum Tanımı (STUDENTS tablosu - gender alanı)
 * Veritabanı şemasındaki enum(E, K) ile tam uyumludur.
 * Kolaylık açısından MALE ve FEMALE sabitleri de desteklenmektedir.
 */
public enum Gender {
    E("Erkek"),
    K("Kadın"),
    MALE("Erkek"),
    FEMALE("Kadın");

    private final String label;

    Gender(String label) {
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
