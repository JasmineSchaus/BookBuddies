import java.lang.String;
import java.util.ArrayList;
/**
 * This class checks whether a given input is a valid email address or not
 * 
 * @author Tolga Gokturk Cohce
 * @version February 11th 2023
 */
public class EmailAddress
{
    private String text;
    
    /**
     * Constructor for objects of class EmailAddress
     * @param   input string is the 'email address in question'
     */
    public EmailAddress(String input)
    {
        text = input;
    }
    /**
     * Sets the "email address" in question to a new value
     * a simple mutator method for the text field
     * 
     * @param  The new String value of the "email address" in question
     */
    public void setText(String newText)
    {
            text = newText;
    }
    /**
     * Simple Accessor Method for the given text or the "email address" in question
     * 
     * @return    the string field text, the given input/email address
     */
    public String getText()
    {
        return text;
    }
    /**
     * This method determines if the given text/email address/input is a valid
     * email address with the help of helper methods
     *
     * @return    a boolean value that states whether the given text is a
     *            valid email address
     */
    public boolean isValid() 
    {
        // setting the index of the first appearance of '@' so we can 
        // separate the name and domain portion of the email
        int indexOfAt = text.indexOf("@");
        
        // Check to see if the number of "@" symbols in the email address 
        // equals one. And checking if '@' appears at the beggining of the email
        if (countAtSymbol() != 1 || indexOfAt == 0 ||
        indexOfAt == text.length() - 1) 
        {
            return false;
        }
        // Splicing our text into domain and name to make the operations simpler
        String firstNamePortion = text.substring(0, indexOfAt); 
        String secondNamePortion = text.substring(indexOfAt + 1);
        if (countDot(secondNamePortion) == 0){
            return false;
        }
        // Checking if the domain and name portions of the email are valid 
        if (!isValidNamePortion(firstNamePortion) ||
        !isValidNamePortion(secondNamePortion)) {
            return false;
        }
        return true;
    }
    /**
     * This method counts the amount of '@' character that appears in the given
     * string, this helps us because an email address can only have a single '@'
     * character
     * 
     * @return    the amount of times '@' character appears in the given text 
     */
    private int countAtSymbol() 
    {
        int count = 0;
        // iterating through each character of the given text
        // specifically for character '@'
        for (int i = 0; i < text.length(); i++) {
          if (text.charAt(i) == '@') {
            count++;
          }
        }
        return count;
      }
    /**
     * This is a helper method for isValid()
     * This method checks for these characters: ('.' , '-' , '!' , '_') at the start and at the end of the email
     * 
     * @param     Local or Domain part of the email is given as a parameter (@ excluded)
     * @return    a boolean value that is true or false based on the existence and location of the aforementioned characters
     */
      private boolean specialCharCheck(String name){
        if (name.charAt(0) == '.' || name.charAt(0) == '-' || name.charAt(name.length() - 1) == '.' || 
        name.charAt(name.length() - 1) == '-' || name.charAt(0) == '!'|| name.charAt(name.length() - 1) == '!' ||
        name.charAt(name.length() - 1) == '_' || name.charAt(0) == '_') {
            return true; //  yes there is a special character in the email that should not be there
        } else {
            return false;// no there is not
        }
    }
    /**
     * This is a helper method for isValid()
     * This method focuses specifically on the name portion of the email address
     * The name portion -> the portion of an email before the '@'
     * 
     * @param     the input given // Email address in question
     * @return    a boolean value that is true or false based on the validity of
     *            the name part
     */
    private boolean isValidNamePortion(String name) 
    {
        // since an email address needs to have a name part in front of the domain
        // we have to check if that part exists
        if (name.length() == 0 || name.length() > 64 || specialCharCheck(name) == true) {
          return false;
        }
        for (int i = 0; i < name.length(); i++) {
          // iterating through each character in the given string
          char c = name.charAt(i);
          if(name.charAt(i) == '.' && name.charAt(i+1) == '.'){
              return false;
          }
          // After searching the API for a bit I thought isLetterOrDigit method
          // would be the best to use since it returns a boolean value 
          if (!Character.isLetterOrDigit(c) && c != '.') 
          // Checking if the special character is a letter, digit or a dot - to eliminate special characters such as $
          {
            return false;
          }
        }
        return true;
        }
    /**
     * This is a helper method for isValid()
     * This method focuses specifically on the domain portion of the email address
     * 
     * 
     * @param     domain part of the email // The domain portion -> the portion of an email after the '@'
     * @return    a boolean value that is true or false based on the validity of
     *            the domain part
     */
    private boolean isValidDomainPortion(String domain)
    {
        if (domain.length() == 0 || domain.length() == 64 || specialCharCheck(domain) == true ){
            return false;
        }
        for (int i = 0; i < domain.length(); i++) {
          // iterating through each character in the given string
          char c = domain.charAt(i);
          if(domain.charAt(i) == '.' && domain.charAt(i+1) == '.'){
              return false;
          }
          if (!Character.isLetterOrDigit(c) && c != '.') 
          // Checking if the special character is a letter, digit or a dot - to eliminate special characters such as $
          {
            return false;
          }
        }
        return true;
    }
    /**
     * This is a helper method for isValid()
     * This method focuses specifically on the domain portion of the email address
     * to count the amount of dots in the domain part since dot('.') splits the extensions (.com .gov .net)
     * 
     * 
     * @param     domain part of the email // The domain portion -> the portion of an email after the '@'
     * @return    an integer that represents the amount of times dot('.') appears in the domain portion.
     */
    private int countDot(String part) 
    {
        int count = 0;
        // iterating through each character of the given text
        // specifically for character '@'
        for (int i = 0; i < part.length(); i++) {
          if (text.charAt(i) == '.') {
            count += 1;
          }
        }
        return count;
    }
}

