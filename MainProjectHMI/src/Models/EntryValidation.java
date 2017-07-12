package Models;

import Dao.UserDAO;

/**
 * Created by staLker on 04-07-2017.
 */
public class EntryValidation {

    public static boolean isFirstNameValid(String firstName){
        if(firstName.matches( "[a-zA-Z][a-zA-Z]*" )){
            return true;
        }
        else return false;
    }
    public static boolean isLastNameValid(String lastName){
        if(lastName.matches( "[a-zA-Z][a-zA-Z]*")){
            return true;
        }
        else return false;
    }
    public static boolean isEmailValid(String eMail){
        if(eMail.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")){
           return true;
        }
        else return false;
    }
    public static boolean isContactValid(long contact){
        if(String.valueOf(contact).matches("\\d{10}")){
            return true;
        }
        else return false;
    }
    public static boolean isUserNameValid(String userName){
        if(userName.matches("^[a-zA-Z0-9_-]{3,15}$") && !UserDAO.getUserDAOInstance().ifUserExists(userName)){
            return true;
        }
        else return false;
    }
    public static boolean isPasswordValid(String password,String anotherPassword){
        if(password.intern() == anotherPassword.intern()){
            return true;
        }
        else return false;
    }
}
