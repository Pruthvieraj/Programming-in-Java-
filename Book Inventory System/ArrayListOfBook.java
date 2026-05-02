import java.util.ArrayList;

public class ArrayListOfBook {

    public static void main(String[] args) {

        //Create an ArrayList to store Book objects
        ArrayList<Book> alb = new ArrayList<Book>();

        try{
        
        //Create Book objects using the parameterized constructor
        Book b1 = new Book("The Great Gatsby", 10.99, "978-0743273565", "Classic", "F. Scott Fitzgerald");
        Book b2 = new Book("To Kill a Mockingbird", 7.99, "978-0060935467", "Classic", "Harper Lee");
        alb.add(b1);     //Add books to the ArrayList
        alb.add(b2);

        //Create a Book object using the default constructor
        Book b3 = new Book();

        //Manually assign values to the book attributes
        b3.title = "1984";
        b3.author = "George Orwell";
        b3.genre = "Dystopian";
        b3.price = 8.99;
        b3.ISBN = "978-0451524935";
        alb.add(b3);

        Book b4 = new Book(b1);          //Create a copy of b1 using the copy constructor
        b4.title = "Beauty and the Beast";
        alb.add(b4);

        Book b5 = new Book("The Catcher in the Rye", "J.D. Salinger");
        alb.add(b5);

        //Display all books in the ArrayList
        System.out.println("===Book details from the ArrayList=== ");
        for(Book b : alb){
            b.display();
        }

        // Display total number of books in the list
        System.out.println("Total number of books in the list: " + alb.size());
        System.out.println("Is array list empty? " + alb.isEmpty());

        Book b6 = new Book("The Queen of Hearts", 11.29, "978-0741173565", "Fantasy", "Lewis Carroll");
        
        //Create a second ArrayList
        ArrayList<Book> alb2 = new ArrayList<>();
        alb2.add(b6);

        //Add all elements from alb2 into alb
        alb.addAll(alb2);

        System.out.println("=====Book details from the ArrayList after adding another book=====");
        for(Book b : alb){
            b.display();
        }
        } 
        catch(InvalidPriceException ipe){
            System.out.println(ipe.getMessage());
        }
        
        catch(InvalidBookGenreException ibge){
            System.out.println(ibge.getMessage());
       }

        double temp = 0;   
        int classicCount = 0;


        System.out.println("Classic Book:");
        //Loop to count Classic books and display them
        for(Book b : alb){
            if(b.genre.equals("Classic")){
                System.out.println("------------------");
                b.display();
                System.out.println("------------------");

                classicCount +=1;
            }
        }
        System.out.println("Number of Classic books: " + classicCount);

        int len = 0;
        //Loop to calculate total price and count books
        for(Book b : alb){
                len +=1;
                temp += b.price;
            }
        System.out.println("Average price: " + temp/len);

        /*
        Alternate way to calculate avg price
        double[] sum = {0};
        
        alb.forEach(b -> sum[0] += b.price);
        System.out.println("Average price of all books: $" + (sum[0] / alb.size()));
        */

    }
}
