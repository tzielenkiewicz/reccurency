import java.awt.*;

public class Figury extends Frame {
    Figury() {
        setSize(400, 300);
        setVisible(true);
        setTitle("Application of recurrent functions");
    }
    public void paint (Graphics g) {
        int dim = 200;
        Insets b = getInsets();
        g.translate(b.left, b.top);
        squares(4, dim, 10, 10, g);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);

    }

    private void squares(int n, int dim, int x, int y, Graphics g) {
        if (n > 0) {
            g.drawLine(x, y, x + dim, y);
            g.drawLine(x + dim, y, x + dim, y + dim);
            g.drawLine(x + dim, y + dim, x, y + dim);
            g.drawLine(x, y + dim, x, y + dim/2);
            g.drawLine(x, y + dim/2, x + dim/2, y + dim);
            g.drawLine(x + dim/2, y + dim, x + dim, y + dim/2);
            g.drawLine(x + dim, y + dim/2, x + dim/2, y);
            g.drawLine(x + dim/2, y, x + dim/4, y + dim/4);
            squares(n-1, dim/2, x + dim/4, y + dim/4, g);
            g.drawLine(x + dim/4, y + dim/4, x, y + dim/2);
            g.drawLine(x, y + dim/2, x, y);
        }
    }
}
