import java.util.ArrayList;
import java.util.Scanner;
/**
   * This where the user actions and user information are stored 
 *
 * @author Tolga Cohce, 
 * @version March 11th 2023
 */
public class CommunityLibrary
{
    private ArrayList<Buddy> users;
    /**
     * Declaring our name and the ArrayList 
     *      where user information will be held.
     */
    public CommunityLibrary(String name)
    {
        users = new ArrayList<Buddy>(); //Where all user info is stored the "database".
        name = name; //Something to identify the community library with
    }
    /**
     * Gets the information of all users in the ArrayList.
     * @return  ArrayList users
     */
    public ArrayList getUsers()
    {
        return users;
    }
    public void getUserByName(String name){
        for (Buddy user: users){
            if (user.getName().equals(name)){
                System.out.println(user.getInformation());
                return;
            }
        }
    }
    public void getUserByEmail(String email){
        for (Buddy user: users){
            if (user.getEmail().equals(email)){
                System.out.println(user.getInformation());
                return;
            }
        }
    }
    public void getUserByPhoneNumber(String number){
        for (Buddy user: users){
            if (user.getPhoneNumber().equals(number)){
                System.out.println(user.getInformation());
                return;
            }
        }
    }
    /**
     * Adds a user to the "database" (users ArrayList)
     */
    public void addUser(Buddy user){
        users.add(user);       
    }
    /**
     * Deletes a user at a specific index in the "database" (users ArrayList).
     */
    public void delUserAt(int index)
    {
        users.remove(index);
    }
    /**
     * Deletes the lastAdded user to the "database" (users ArrayList)
     */
    public void delLastAdded(){
        users.remove(users.size() - 1);
    }
    /**
     * Deletes all users in the "database" (users ArrayList)
     */
    public void delAllUsers(){
        System.out.println("Are you sure you want to delete all users? (y/n)\n" + 
        "Press anything else to cancel: ");
        Scanner scanner = new Scanner(System.in);
        String areYouSure = scanner.nextLine();
        if(areYouSure.equals("y")){
            users.clear();
        }else{
            return;
        }
    }
    /**
     * Deletes a user in the "database" (users ArrayList) by it's name.
     *      if a user does not exist by that name, prints an error.
     */
    public void delUserByName(String name){
        for (Buddy user : users){
            if (user.getName().equals(name)){
                int index = users.indexOf(user);
                users.remove(index);
                System.out.println("User: " + name + " has been deleted.");
            }
        }
        System.out.println("Sorry! there is no user with that name.");
        return;
    }
    /**
     * Deletes a user in the "database" (users ArrayList) by it's email.
     *      if a user which has that email does not exist, prints an error.
     */
    public void delUserByEmail(String email){
        for (Buddy user : users){
            if (user.getEmail().equals(email)){
                int index = users.indexOf(user);
                users.remove(index);
                System.out.println("User with the email : " + email + " has been deleted.");
            }
        }
        System.out.println("Sorry! there is no user with that name.");
        return;
    }
    
    
}
