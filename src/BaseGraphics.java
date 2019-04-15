import java.awt.*;
import java.lang.reflect.Array;

public abstract class BaseGraphics {
    int posX, posY;
    int Block[][];
    int width, height;
    Color color;

    public void drawMe(Graphics g) {
        int spacing = 1;
        g.setColor(color);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Block[i][j] = Array.getLength(Block);
                g.fillRect(spacing+i*25+posX,spacing+j*25+posY,25-2*spacing,25-2*spacing);
            }
        }
    }

    public void clearMe(Graphics g) {
        int spacing = 1;
        g.setColor(color);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Block[i][j] = Array.getLength(Block);
                g.clearRect(spacing + i * 25 + posX, spacing + j * 25 + posY, 25 - 2 * spacing, 25 - 2 * spacing);
            }


        }
    }
}
