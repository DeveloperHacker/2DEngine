package worlds;

import com.abstractEngine.World;
import com.abstractEngine.math.Point;
import com.abstractEngine.math.Vector;
import com.abstractEngine.object.Object;
import com.graphicEngine.World2D;

public class TestWorld extends World {

    private int width;
    private int height;

    public TestWorld(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    public void update() {
        final Vector G = new Vector(0, 0.2);
        final double maxSpeed = 20;
        final double damping = 0.9;
        for (Object object : objects) {
            if (object.movable()) {
                object.setSpeed(Vector.add(object.speed(), G));
                if (object.pos().y <= 0) {
//                    if (object.speed().y() < 0)
//                        object.setSpeed(new Vector(object.speed().x(), -object.speed().y())/*.mul(damping)*/);
                }
                if (object.pos().y >= height - object.mask().height()) {
                    if (object.speed().y() > 0)
                        object.setSpeed(new Vector(object.speed().x(), -object.speed().y())/*.mul(damping)*/);
                }
                if (object.pos().x <= 0) {
                    if (object.speed().x() < 0)
                        object.setSpeed(new Vector(-object.speed().x(), object.speed().y())/*.mul(damping)*/);
                }
                if (object.pos().x >= width - object.mask().width()) {
                    if (object.speed().x() > 0)
                        object.setSpeed(new Vector(-object.speed().x(), object.speed().y())/*.mul(damping)*/);
                }
                if (object.speed().abs() > maxSpeed)
                    object.setSpeed(object.speed().mul(maxSpeed / object.speed().abs()));
            }
        }
        for (int i = 0; i < objects.size() - 1; i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                clash(objects.get(i), objects.get(j));
            }
        }
        for (Object object : objects) {
            if (object.movable()) {
                object.setPos(Point.add(object.pos(), object.speed().pos));
            }
        }
    }
}


class TestWorldWeightlessness extends World {

    private int width;
    private int height;

    public TestWorldWeightlessness(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    public void update() {
        final double maxSpeed = 100;
        final double xDamping = 0.9;
        final double yDamping = 0.98;
        for (Object object : objects) {
            if (object.movable()) {
                if (object.pos().y <= 0) {
                    if (object.speed().y() < 0)
                        object.setSpeed(new Vector(object.speed().x() * xDamping, -object.speed().y() * yDamping));
                }
                if (object.pos().y >= height - object.mask().height()) {
                    if (object.speed().y() > 0)
                        object.setSpeed(new Vector(object.speed().x() * xDamping, -object.speed().y() * yDamping));
                }
                if (object.pos().x <= 0) {
                    if (object.speed().x() < 0)
                        object.setSpeed(new Vector(-object.speed().x() * xDamping, object.speed().y() * yDamping));
                }
                if (object.pos().x >= height - object.mask().width()) {
                    if (object.speed().x() > 0)
                        object.setSpeed(new Vector(-object.speed().x() * xDamping, object.speed().y() * yDamping));
                }
                if (object.speed().abs() > maxSpeed)
                    object.setSpeed(object.speed().mul(maxSpeed / object.speed().abs()));
            }
        }
        for (int i = 0; i < objects.size() - 1; i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                clash(objects.get(i), objects.get(j));
            }
        }
        for (Object object : objects) {
            if (object.movable()) {
                object.setPos(Point.add(object.pos(), object.speed().pos));
            }
        }
    }
}

