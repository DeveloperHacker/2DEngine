package com.abstractEngine;

import com.abstractEngine.object.Object;

import java.util.ArrayList;
import java.util.List;

public class World {
    private List<Object> objects;

    public World() {
        objects = new ArrayList<>();
    }

    public void addObject(Object object) {
        objects.add(object);
    }

    public void removeObject(Object object) {
        objects.remove(object);
    }

    public void update() {

    }
}
