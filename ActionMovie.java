package model;

public class ActionMovie extends Movie {
    private String stuntLevel;  // atribut tambahan
    private final String stuntCoordinator;

    public ActionMovie(int id, String title, String genre, int year, double rating, String stuntCoordinator) {
        super(id, title, genre, year, rating);
        this.stuntCoordinator = stuntCoordinator;
    }

    public String getStuntLevel() {
        return stuntLevel;
    }

    public void setStuntLevel(String stuntLevel) {
        this.stuntLevel = stuntLevel;
    }

    public String getStuntCoordinator() {
        return stuntCoordinator;
    }

    // Overriding method abstract getInfo()
    @Override
    public String getInfo() {
        return baseInfo() + " | Stunt Level: " 
                + (stuntLevel == null ? "N/A" : stuntLevel)
                + " | Coordinator: " + stuntCoordinator;
    }
}
