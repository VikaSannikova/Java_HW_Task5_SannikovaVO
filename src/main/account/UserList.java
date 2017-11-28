package main.account;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class UserList {
    private Map<String, String> users = new TreeMap<String, String>();

    public UserList() {
        users.put("Oleg", "123456");
        users.put("Admin", "qwerty");
        users.put("root", "root");
    }

    public boolean tryLogin(String name, String password) {
        for(Map.Entry<String, String> entry: users.entrySet()) {
            if(Objects.equals(entry.getKey(), name) && Objects.equals(entry.getValue(), password)) {
                return true;
            }
        }
        return false;
    }
}
