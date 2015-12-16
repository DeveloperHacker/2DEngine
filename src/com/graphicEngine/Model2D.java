package com.graphicEngine;

import com.abstractEngine.math.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model2D extends ModelElement {

    protected List<ModelElement> elements;
    protected Frame2D background;

    public Model2D(Vector pos, String name) {
        super(pos, name);
        this.elements = Collections.synchronizedList(new ArrayList<>());
        this.pos = pos;
        this.background = new Frame2D();
    }

    public void addElement(ModelElement element) {
        this.elements.add(element);
    }

    public void setBackground(Frame2D background) {
        this.background = background;
    }

    public void removeElement(ModelElement element) {
        this.elements.remove(element);
    }

    public ModelElement getModelElement(int index) {
        return elements.get(index);
    }

    public List<ModelElement> getElements() {
        return elements;
    }

    public void update() {
    }

    @Override
    public void drawOutline(Graphics graphics, Screen screen, Vector parentPos) {
        background.drawOutline(graphics, screen, parentPos.add(pos));
        for (ModelElement element : elements) {
            element.drawOutline(graphics, screen, parentPos.add(pos));
        }
//        graphics.setColor(Color.BLUE);
//        graphics.drawLine((int) (parentPos.x), (int) (parentPos.y), (int)(getPosition.x), (int)(getPosition.y));
    }
}
