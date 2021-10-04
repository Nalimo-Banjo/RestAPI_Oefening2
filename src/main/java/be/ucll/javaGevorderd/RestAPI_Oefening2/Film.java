package be.ucll.javaGevorderd.RestAPI_Oefening2;

public class Film {
    private String titel;
    private int jaar;
    private int persoonlijkeScore;
    private String verandtwoording;

    public Film(String titel, int jaar, int persoonlijkeScore, String verandtwoording) {
        this.titel = titel;
        this.jaar = jaar;
        this.persoonlijkeScore = persoonlijkeScore;
        this.verandtwoording = verandtwoording;
    }

    public String getTitel() {
        return titel;
    }

    public int getJaar() {
        return jaar;
    }

    public int getPersoonlijkeScore() {
        return persoonlijkeScore;
    }

    public String getVerandtwoording() {
        return verandtwoording;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setJaar(int jaar) {
        this.jaar = jaar;
    }

    public void setPersoonlijkeScore(int persoonlijkeScore) {
        this.persoonlijkeScore = persoonlijkeScore;
    }

    public void setVerandtwoording(String verandtwoording) {
        this.verandtwoording = verandtwoording;
    }
}
