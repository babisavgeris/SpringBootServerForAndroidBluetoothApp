package com.babis.BluetoothServer.service;

import com.babis.BluetoothServer.entity.Role;
import com.babis.BluetoothServer.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
