package model;

public class RomanceMovie extends Movie {
    private String loveTheme;  // atribut tambahan
    private final String leadCouple;

    public RomanceMovie(int id, String title, String genre, int year, double rating, String leadCouple) {
        super(id, title, genre, year, rating);
        this.leadCouple = leadCouple;
    }

    public String getLoveTheme() {
        return loveTheme;
    }

    public void setLoveTheme(String loveTheme) {
        this.loveTheme = loveTheme;
    }

    public String getLeadCouple() {
        return leadCouple;
    }

    // Overriding method abstract getInfo()
    @Override
    public String getInfo() {
        return baseInfo() + " | Tema Cinta: " 
                + (loveTheme == null ? "Belum ditentukan" : loveTheme)
                + " | Lead Couple: " + leadCouple;
    }
}
