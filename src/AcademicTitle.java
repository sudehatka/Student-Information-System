public enum AcademicTitle {
    OGR_GOR("Öğr. Gör."),
    DR("Dr."),
    DR_OGR_UYESI("Dr. Öğr. Üyesi"),
    DOC_DR("Doç. Dr."),
    PROF_DR("Prof. Dr.");

    private final String titleText;

    AcademicTitle(String titleText) {
        this.titleText = titleText;
    }

    public String getTitleText() {
        return titleText;
    }

    @Override
    public String toString() {
        return titleText;
    }
}
