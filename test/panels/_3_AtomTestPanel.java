package panels;

import com.abstractEngine.math.Ellipse;
import com.abstractEngine.math.Figure;
import com.abstractEngine.math.Vector;
import com.graphicEngine.Screen;
import models.Comet;
import models.Comets;

public class _3_AtomTestPanel extends AtomTestPanel {

    public _3_AtomTestPanel(int width, int height, String name) {
        super(new Comets(new Vector(), width, height, new Vector(0, 0.2), name), new Screen(new Vector(), width, height));
    }

    @Override
    protected void initTest() {
        double radius = 25;
        Ellipse circle = new Ellipse(new Vector(radius, radius), radius * 2, radius * 2);
        Figure head = circle.toFigure(20);
        Vector speed;
        Comet comet;
        Vector pos;
        double dumping = 0.99;
        int quantityComets = 5;
        int lengthTail = 100;
        for (int i = 1; i < quantityComets + 1; ++i) {
            speed = new Vector(Math.random() * 20 - 10, Math.random() * 20 - 10);
            pos = new Vector(width() * i / (quantityComets + 1) - head.width() / 2, height() / 2);
            comet = new Comet(head, dumping, pos, 10, speed, "Comet" + i);
            for (int j = 0; j < lengthTail; ++j) {
                comet.addTailElement();
            }
            comet.setOutlineHeadColor(randColor());
            comet.setOutlineTailColor(comet.getOutlineHeadColor());
            addElement(comet);
        }
    }
}
