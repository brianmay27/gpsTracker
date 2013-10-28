package edu.vt.bmac.gpstracker;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Brian
 *  @version Oct 24, 2013
 */

public class Friends implements Serializable
{
    private HashMap<String, Friend> friends;
    public Friends() {
        friends = new HashMap<String, Friend>();
    }
    public Friend addFriend(String name) {
        Friend ret;
        if ((ret = friends.get(name)) != null)
            return ret;
        ret = new Friend(name);
        friends.put(name, ret);
        return ret;
    }
    public void addFriend(String name, Friend friend) {
        friends.put(name, friend);
    }
    public void updateFriend(String name, Friend friend) {
        friends.put(name, friend);
    }
    public Collection<Friend> getFriends() {
        return friends.values();
    }
    public Friend getFriend(String name) {
        return friends.get(name);
    }

}
