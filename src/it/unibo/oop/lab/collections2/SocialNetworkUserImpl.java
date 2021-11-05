package it.unibo.oop.lab.collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U> Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt a
     * generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */
    final private Map<String, ArrayList<U>> friends;
    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     * 
     * 2) Define a further constructor where age is defaulted to -1
     */

    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name    the user firstname
     * @param surname the user lastname
     * @param userAge user's age
     * @param user    alias of the user, i.e. the way a user is identified on an
     *                application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
	super(name, surname, user, userAge);
	friends = new HashMap<>();
    }

    /*
     * [METHODS]
     * 
     * Implements the methods below
     */

    @Override
    public boolean addFollowedUser(final String circle, final U user) {
	boolean returnValue = true;
	if (friends.containsKey(circle)) {
	    ArrayList<U> friendList = friends.get(circle);
	    if (!friendList.contains(user)) {
		friendList.add(user);
	    } else {
		returnValue = false;
	    }
	} else {
	    ArrayList<U> friendList = new ArrayList<>();
	    friendList.add(user);
	    friends.put(circle, friendList);
	}
	return returnValue;
    }

    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
	if (!friends.containsKey(groupName)) {
	    return new ArrayList<>();
	}
	return (Collection<U>) new ArrayList<>(friends.get(groupName));
    }

    @Override
    public List<U> getFollowedUsers() {
	ArrayList<U> allFriends = new ArrayList<>();
	for (Entry<String, ArrayList<U>> group : friends.entrySet()) {
	    allFriends.addAll(group.getValue());
	}
	return allFriends;
    }

}
