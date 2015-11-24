package com.abstractEngine;

import com.abstractEngine.math.Figure;
import com.abstractEngine.math.Point;
import com.abstractEngine.math.Vector;
import com.abstractEngine.object.Object;
import com.graphicEngine.World2D;

import java.util.ArrayList;
import java.util.List;

public class World {
    protected List<Object> objects;

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
    }

    protected static boolean clash(Object _1, Object _2) {
        boolean intersection = Figure.intersection(new Figure(_1.pos(), _1.mask()), new Figure(_2.pos(), _2.mask()));
        if (intersection) {
            final double xDamping = 0.97;
            final double yDamping = 0.98;
            Vector n = new Vector(Point.rem(Point.add(_1.mask().center, _1.pos()), Point.add(_2.mask().center, _2.pos())));
            Vector i = new Vector(1, 0);
            Vector j = new Vector(0, 1);
            double cos = Vector.cos(n, i);
            double sin = Vector.cos(n.minus(), j.minus());
            Vector V01 = new Vector(_1.speed().x() * cos + _1.speed().y() * sin, -_1.speed().x() * sin + _1.speed().y() * cos);
            Vector V02 = new Vector(_2.speed().x() * cos + _2.speed().y() * sin, -_2.speed().x() * sin + _2.speed().y() * cos);
            double V1y = V01.y();
            double V2y = V02.y();
            if (_1.movable() && _2.movable()) {
                double V1x = ((_1.mass() - _2.mass()) * V01.x() + 2 * _2.mass() * V02.x()) / (_1.mass() + _2.mass());
                double V2x = (2 * _1.mass() * V01.x() + (_2.mass() - _1.mass()) * V02.x()) / (_1.mass() + _2.mass());
                _1.setSpeed(new Vector(V1x * cos - V1y * sin, V1x * sin + V1y * cos));
                _2.setSpeed(new Vector(V2x * cos - V2y * sin, V2x * sin + V2y * cos));
            } else if (_1.movable()) {
                double V1x = -V01.x();
                _1.setSpeed(new Vector(V1x * cos - V1y * sin, V1x * sin + V1y * cos));
            } else if (_2.movable()) {
                double V2x = -V02.x();
                _2.setSpeed(new Vector(V2x * cos - V2y * sin, V2x * sin + V2y * cos));
            }
        }
        return intersection;
    }
}
