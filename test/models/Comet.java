package models;

import com.abstractEngine.math.Figure;
import com.abstractEngine.math.Vector;
import com.abstractEngine.object.Atom;
import com.graphicEngine.Atom2D;
import com.graphicEngine.Figure2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Comet extends SingleElement {

    private List<Figure2D> tail;
    private Figure2D head;
    private double dumping;
    private Vector prevPos;

    public static final Color defaultCOLOR = Color.WHITE;
    private Color tailColor;
    private Color headColor;

    public Comet(Figure head, double dumping, Vector pos, double mass, Vector speed, String name) {
        super(pos, initAtom2D(head, defaultCOLOR, new Vector(), mass, speed, name), name);
        this.prevPos = pos;
        this.tail = new ArrayList<>();
        this.dumping = dumping;
        this.tailColor = defaultCOLOR;
        this.headColor = defaultCOLOR;
        this.head = (Figure2D) (getAtom().background());
    }

    private static Atom2D initAtom2D(Figure head, Color headColor, Vector pos, double mass, Vector speed, String name) {
        Atom atom = new Atom(pos, head, mass, speed, true, "\"Head of " + name + "\"");
        return new Atom2D(atom, new Figure2D(head, headColor));
    }

    public Comet(Figure head, double dumping, Vector pos, double mass, String name) {
        this(head, dumping, pos, mass, new Vector(), name);
    }

    public void setColorHead(Color color) {
        headColor = color;
        head.set(headColor);
    }

    public void setColorTail(Color color) {
        tailColor = color;
        for (Figure2D figure : tail) {
            figure.set(tailColor);
        }
    }

    public Figure2D getHead() {
        return head;
    }

    public Figure2D getSegmentTail(int index) {
        return tail.get(index);
    }

    public void addTailElement() {
        Figure newSegment;
        if (tail.size() != 0) {
            newSegment = tail.get(tail.size() - 1).figure.clone();
        } else {
            newSegment = head.figure.clone();
        }
        newSegment.scale(newSegment.center(), dumping);
        tail.add(new Figure2D(newSegment, tailColor));
        background.add(tail.get(tail.size() - 1));
    }

    @Override
    public void moveTo(Vector pos) {
        this.prevPos = this.pos;
        this.pos = pos;
    }

    @Override
    public void update() {
        super.update();
        Figure currentFigure;
        Figure prevFigure;
        for (int i = tail.size() - 1; i > 0; --i) {
            currentFigure = tail.get(i).figure;
            prevFigure = tail.get(i - 1).figure;
            currentFigure.moveTo(currentFigure.pos().
                    add((prevPos.add(prevFigure.center())).rem(pos.add(currentFigure.center()))));
        }
        currentFigure = tail.get(0).figure;
        prevFigure = head.figure;
        currentFigure.moveTo(currentFigure.pos().
                add((prevPos.add(prevFigure.center())).rem(pos.add(currentFigure.center()))));
    }
}
