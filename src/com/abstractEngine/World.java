package com.abstractEngine;

import com.abstractEngine.math.Figure;
import com.abstractEngine.math.Point;
import com.abstractEngine.math.Vector;
import com.abstractEngine.object.Object;
import com.graphicEngine.World2D;

import java.util.ArrayList;
import java.util.List;

public class World {
    private List<Object> objects;

    public World() {
        objects = new ArrayList<>();
    }

    public void add(Object object) {
        objects.add(object);
    }

    public void remove(Object object) {
        objects.remove(object);
    }

    public void update() {
        final Vector G = new Vector(0, 0.2);
        final double maxSpeed = 100;
        final double damping = 0.9;
        for (Object object : objects) {
            if (object.movable()) {
                if (object.pos().y >= World2D.HEIGHT - object.mask().height()) {
                    object.setSpeed(new Vector(object.speed().x(), -object.speed().y())/*.mul(damping)*/);
                } else if (object.pos().x <= 0 || object.pos().x >= World2D.WIDTH - object.mask().width()) {
                    object.setSpeed(new Vector(-object.speed().x(), object.speed().y())/*.mul(damping)*/);
                } else {
//                    object.setSpeed(Vector.add(object.speed(), G));
                }
            }
        }
        for (int i = 0; i < objects.size() - 1; i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                clash(objects.get(i), objects.get(j));
            }
        }
        for (Object object : objects) {
            if (object.movable()) {
                if (object.speed().abs() > maxSpeed) {
                    object.setSpeed(object.speed().mul(1 / maxSpeed));
                }
                object.setPos(Point.add(object.pos(), object.speed().pos));
            }
        }
    }

    private static boolean clash(Object _1, Object _2) {
        boolean intersection = Figure.intersection(new Figure(_1.pos(), _1.mask()), new Figure(_2.pos(), _2.mask()));
        if (intersection && _1.movable() && _2.movable()) {
            System.out.println(_1 + "\n" + _2 + "\n\n");
            Vector n = new Vector(Point.rem(Point.add(_1.mask().center, _1.pos()), Point.add(_2.mask().center, _2.pos())));
            Vector i = new Vector(1, 0);
            Vector j = new Vector(0, 1);
            double cos = Vector.cos(n, i);
            double sin = Vector.cos(n.minus(), j.minus());
            Vector V01 = new Vector(_1.speed().x() * cos + _1.speed().y() * sin, -_1.speed().x() * sin + _1.speed().y() * cos);
            Vector V02 = new Vector(_2.speed().x() * cos + _2.speed().y() * sin, -_2.speed().x() * sin + _2.speed().y() * cos);
            double V1x = ((_1.mass() - _2.mass()) * V01.x() + 2 * _2.mass() * V02.x()) / (_1.mass() + _2.mass());
            double V2x = (2 * _1.mass() * V01.x() + (_2.mass() - _1.mass()) * V02.x()) / (_1.mass() + _2.mass());
            _1.setSpeed(new Vector(V1x * cos - V01.y() * sin, V1x * sin + V01.y() * cos));
            _2.setSpeed(new Vector(V2x * cos - V02.y() * sin, V2x * sin + V02.y() * cos));
        } else if (intersection && _1.movable()) {

        } else if (intersection && _2.movable()) {

        }
        return intersection;
    }
}
