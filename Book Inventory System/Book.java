public class Book {

    public String title;
    public double price;
    public String ISBN;
    public String genre;
    public String author;

    //Default constructor
    public Book() {
        title = "Not Assigned";
        price = 0.0;
        ISBN = "N/A";
        genre = "Unknown";
        author = "Unknown";
    }

    //Parameterized constructor
    public Book(String title, double price, String ISBN, String genre, String author) throws InvalidPriceException, InvalidBookGenreException {
        this.title = title;

        if(price<0)
            throw new InvalidPriceException("Price cannot be negative");

        this.price = price;

        this.ISBN = ISBN;
        if (!genre.equals("Classic") && !genre.equals("Fantasy") && !genre.equals("Dystopian")) {
            throw new InvalidBookGenreException("Invalid genre: " + genre);
        }

        this.genre = genre;
        this.author = author;
    }
    
    //Parameterized constructor2
    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.price = 0.0;
        this.ISBN = "N/A";
        this.genre = "Unknown";
    }

    //Copy constructor
    public Book(Book b) throws InvalidBookGenreException, InvalidPriceException {
        if (b != null) {
            this.title = b.title;
            if(b.price<0)
                throw new InvalidPriceException("Price cannot be negative");
            this.price = b.price;
            this.ISBN = b.ISBN;
            if (!b.genre.equals("Classic") && !b.genre.equals("Fantasy") && !b.genre.equals("Dystopian")) {
            throw new InvalidBookGenreException("Invalid genre: " + b.genre);
            }
            this.genre = b.genre;
            this.author = b.author;
        }
    }


    //Getters
    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    //Display method
    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Genre: " + genre);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Price: $" + price);
        System.out.println("----------------------x----------------------");
    }
}

