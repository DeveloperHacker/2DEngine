package models;

import com.abstractEngine.ModelElement;
import com.abstractEngine.math.Vector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comets extends Gas {

    private List<Comet> comets;

    public Comets(Vector pos, int width, int height, Vector G, String name) {
        super(pos, width, height, G, name);
        this.comets = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public void addElement(ModelElement comet) {
        comets.add((Comet) comet);
        elements.add(comet);
    }

    @Override
    public void update() {
        super.update();
        for (Comet comet : comets) {
            comet.update();
        }
    }
}
