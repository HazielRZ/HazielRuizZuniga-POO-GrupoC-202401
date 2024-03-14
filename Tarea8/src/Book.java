public class Book { private String title;
    private boolean rented;

    public Book(String title) {
        this.title = title;
        this.rented = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}


