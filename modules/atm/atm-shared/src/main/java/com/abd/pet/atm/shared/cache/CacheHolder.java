package com.abd.pet.atm.shared.cache;

import com.abd.pet.atm.shared.exception.CacheException;
import com.abd.pet.atm.shared.model.AccountModel;
import com.abd.pet.atm.shared.model.UserModel;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class CacheHolder {

    private TreeSet<Long> ids = new TreeSet<>();

    private Map<Long, AccountModel>   accounts            = new HashMap<>();
    private Map<String, AccountModel> accountsByAccountId = new HashMap<>();

    private Map<Long, UserModel>   users       = new HashMap<>();
    private Map<String, UserModel> usersByName = new HashMap<>();
    private Map<String, String> usersByPassword = new HashMap<>();

    private String getUserKey(UserModel user) {
        return user.getName() + "\u0000" + user.getSurname();
    }
//String suuid = UUID.randomUUID().toString();
    public UserModel addUser( UserModel user) throws CacheException {
        String key = getUserKey(user);
        if (usersByName.containsKey(key)) {
            throw new CacheException("User exists.");
        }
        usersByName.put(key, user);
        addUserId(user);
        users.put(user.getId(), user);
        return user;
    }

    private void addUserId(UserModel user) {
        long id = 0;
        if (!ids.isEmpty()) {
            id = ids.last();
        }
        id++;
        user.setId(id);
    }

}
