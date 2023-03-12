
import java.util.ArrayList;
/**
 * Write a description of class Buddy here.
 *
 * @author (Jasmine)
 * @version (a version number or a date)
 */
public class Buddy
{
    // instance variables - replace the example below with your own
    private ArrayList <Book> wants;
    private ArrayList <Book> haves;
    private String name;
    private String email;
    private String phoneNumber;
    private EmailAddress userEmail;

    /**
     * Constructor for objects of class Buddy
     */
    public Buddy(String yourName, String yourEmail, String yourNumber)
    {
        yourName = name;
        yourNumber = phoneNumber;
        wants = new ArrayList<Book>();
        haves = new ArrayList<Book>();
        EmailAddress userEmail = new EmailAddress(yourEmail);
        if (!userEmail.isValid()){
            System.out.println("This email is not valid");
            return;
        } else {
            yourEmail = email;
        }
        if (yourNumber.length() >= 15){
            System.out.println("This phone number is not valid");
            return;
        }
    }

    /**
     * Accessor method for name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Accessor method for email
     */
    public String getEmail(){
        return email;
    }
    
    /**
     * Accessor method for phone number
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    /**
     * Mutator method for name
     */
    public void setName(String newName){
        name = newName;
    }
    
    /**
     * Mutator method for email
     */
    public void setEmail(String newEmail){
        email = newEmail;
    }
    
    /**
     * Mutator method for phone number
     */
    public void setPhoneNumber(String newPhoneNumber){
        phoneNumber = newPhoneNumber;
    }
    public String getInformation(){
        return "User name is: " + name +
        "\nUser email is: " + email +
        "\nUser phone number is: " + phoneNumber;
    }
    
    
    /**
     * Add a book to the Arraylist of your wants
     */
    public void addWantsBook(Book wantedBook){
        if(! wants.contains(wantedBook)){
            wants.add(wantedBook);
        }
        else{
            System.out.println("You already have that book in your Wants list!");
        }
    }
    
    /**
     * Add a book to the Arraylist
     */
    public void addHavesBook(Book haveBook){
        if(! haves.contains(haveBook)){
            haves.add(haveBook);
        }
        else{
            System.out.println("You already have that book in your Haves list!");
        }
    }
    
    /**
     * Print the names of all the books in wants
     */
    public void viewWants(){
        if(wants.size() == 0){
            System.out.println("There are no books on your Wants list");
        }
        else{
            System.out.println("The books on your Wants list are:");
            for(Book item : wants){
                System.out.println(item.getName());
            }
        }
    }
    
    /** 
     * Print the names of all the books in haves
     */
    public void viewHaves(){
        if(haves.size() == 0){
            System.out.println("There are no books on your Haves list");
        }
        else{
            System.out.println("The books on your Haves list are:");
            for(Book item : haves){
                System.out.println(item.getName());
            }
        }
    }
    
    /**
     * Remove a book from your wants 
     */
    public void removeFromWants(String bookName){
        if(wants.size() == 0){
            System.out.println("There are no books on your Wants list to remove!");
        }
        ArrayList<Book> tempWants = new ArrayList<>();
        for(Book item : wants){
            if(!(item.getName().equals(bookName))){
                tempWants.add(item);
            }
        }
        wants = tempWants;
    }
    
    /**
     * Remove a book from your haves
     */
    public void removeFromHaves(String bookName){
        if(haves.size() == 0){
            System.out.println("There are no books on your Haves list to remove!");
        }
        ArrayList<Book> tempHaves = new ArrayList<>();
        for(Book item : haves){
            if(!(item.getName().equals(bookName))){
                tempHaves.add(item);
            }
        }
        haves = tempHaves;
    }
}