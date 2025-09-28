package model;

public abstract class Movie {
    private int id;
    private String title;
    private String genre;
    private int year;
    private double rating;

    public Movie(int id, String title, String genre, int year, double rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    // Encapsulation (Getter & Setter)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    // Abstract method
    public abstract String getInfo();
    
    @Override
    public String toString() {
        return getInfo();
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // baseInfo dibuat protected biar bisa dipakai subclass
    protected String baseInfo() {
        return String.format("ID: %d | %s (%d) | Genre: %s | Rating: %.1f",
                id, title, year, genre, rating);
    }
}