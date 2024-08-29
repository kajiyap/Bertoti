package service.impl;

import service.Observer;

public class MessageObserver implements Observer {
    private String name;

    public MessageObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}
