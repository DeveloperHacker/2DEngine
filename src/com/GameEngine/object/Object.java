package com.gameEngine.object;
import com.gameEngine.math.Figure;
import com.gameEngine.math.Point;
import com.gameEngine.math.Vector;
import java.util.ArrayList;

public class Object {
    protected Point pos;
    protected Vector h;
    protected Vector w;
    protected ArrayList<Figure> mask;
    protected double k;
    public Object(Object obj) {
        pos = obj.pos;
        h = obj.h;
        w = obj.w;
        mask = obj.mask;
        k = obj.k;
    }
    public Object(Point pos, Vector h, Vector w, ArrayList<Figure> mask, double k) {
        this.pos = pos;
        this.h = h;
        this.w = w;
        this.mask = mask;
        this.k = k;
    }
    public Object(Point pos, Vector h, Vector w, double k) {
        this.pos = pos;
        this.h = h;
        this.w = w;
        this.mask = new ArrayList<>();
        this.k = k;
    }
    public void setPos(Point pos) { this.pos = pos; }
    public void setH(Vector h) { this.h = h; }
    public void setW(Vector w) { this.w = w; }
    public void setK(double k) { this.k = k; }
    public void addMaskFigure(Figure figure) { mask.add(figure); }
    public Point getPos() { return pos; }
    public Vector getH() { return h; }
    public Vector getW() { return w; }
    public double getK() { return k; }
    public void removeMaskFigure(Figure figure) { mask.remove(figure); }
    @Override
    public boolean equals(java.lang.Object obj) {
        return ((com.gameEngine.object.MovableObject)obj).pos.equals(pos)
                && ((com.gameEngine.object.MovableObject)obj).k == k
                && ((com.gameEngine.object.MovableObject)obj).h.equals(h)
                && ((com.gameEngine.object.MovableObject)obj).w.equals(w)
                && ((com.gameEngine.object.MovableObject)obj).mask.equals(mask);
    }
    @Override
    public int hashCode() {
        final int a = 3;
        final int b = 5;
        final int c = 7;
        final int d = 11;
        final int e = 13;
        final int f = 17;
        return a + b * pos.hashCode() + c * (int)k + f * h.hashCode() + d * w.hashCode() + e * mask.hashCode();
    }
    @Override
    public java.lang.Object clone() {
        return new Object(this);
    }
    @Override
    public String toString() {
        return "[" + "'Position = " + pos +
                "', 'Height = " + h.abs() +
                "', 'Width = " + w.abs() +
                "', 'Mask = " + mask +
                "', 'K = " + k + "']";
    }
}
