package com.graphicEngine;

import com.abstractEngine.ModelElement;
import com.abstractEngine.math.Vector;
import com.graphicEngine.Atom2D;
import com.graphicEngine.Frame2D;
import com.graphicEngine.Screen;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model extends ModelElement {

    protected List<ModelElement> elements;
    protected Frame2D background;

    public Model(Vector pos, String name) {
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
    public void show(Graphics graphics, Screen screen, Vector parentPos) {
        for (ModelElement element : elements) {
            element.show(graphics, screen, parentPos.add(pos));
        }
        background.show(graphics, screen, parentPos.add(pos));
//        graphics.setColor(Color.BLUE);
//        graphics.drawLine((int) (parentPos.x), (int) (parentPos.y), (int)(getPosition.x), (int)(getPosition.y));
    }
}
