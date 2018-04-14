package com.example.darshan.foodude.Common;

import com.example.darshan.foodude.Model.User;

/**
 * Created by darshan on 28/3/18.
 */

public class Common {
    public static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Common.currentUser = currentUser;
    }

    public User getName(){
        return currentUser;
    }
}
