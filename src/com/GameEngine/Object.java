package com.GameEngine;
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
    public String toString() {
        return "Object: [" +
                "'Position = " + pos.toString() +
                "', 'Height = " + h.abs() +
                "', 'Width = " + w.abs() +
                "', 'Mask = " + mask.toString() +
                "', 'K = " + k + "']";
    }
}
