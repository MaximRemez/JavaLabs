package org.example.controller;

import org.example.model.*;

class GroupCreator {
    public static Group createGroup(String name, Human head) {
        return new Group(name, head);
    }
}
