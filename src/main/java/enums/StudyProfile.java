package enums;

public enum StudyProfile {
    COMPUTER_SCIENCE("Информатика"),
    ECONOMY("Экономика"),
    PHYSICS("Физика"),
    MATHEMATICS("Математика"),
    MEDICINE("Медицина"),
    LINGUISTICS("Лингвистика");
    private final String profileName;

    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}