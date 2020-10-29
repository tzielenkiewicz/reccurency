import java.awt.*;
import java.rmi.dgc.DGC;

public class Figures extends Frame {
    Figures() {
        setSize(400, 400);
        setVisible(true);
        setTitle("Application of recurrent functions");
    }
    public void paint (Graphics g) {
        Insets b = getInsets();
        g.translate(b.left, b.top);

        int dim = 260;

        try {
            squares(5, dim, 10, 10, g);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        g.clearRect(0,0,getWidth(),getHeight());
        int length = 260;
        try {
            helix (length, 10, 10, g);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        g.clearRect(0,0,getWidth(),getHeight());

        System.exit(0);

    }



    private void squares(int n, int dim, int x, int y, Graphics g) throws InterruptedException {
        if (n > 0) {
            g.drawLine(x, y, x + dim, y);
            Thread.sleep(500);
            g.drawLine(x + dim, y, x + dim, y + dim);
            Thread.sleep(500);
            g.drawLine(x + dim, y + dim, x, y + dim);
            Thread.sleep(500);
            g.drawLine(x, y + dim, x, y + dim/2);
            Thread.sleep(500);
            g.drawLine(x, y + dim/2, x + dim/2, y + dim);
            Thread.sleep(500);
            g.drawLine(x + dim/2, y + dim, x + dim, y + dim/2);
            Thread.sleep(500);
            g.drawLine(x + dim, y + dim/2, x + dim/2, y);
            Thread.sleep(500);
            g.drawLine(x + dim/2, y, x + dim/4, y + dim/4);
            Thread.sleep(500);
            squares(n-1, dim/2, x + dim/4, y + dim/4, g);
            Thread.sleep(500);
            g.drawLine(x + dim/4, y + dim/4, x, y + dim/2);
            Thread.sleep(500);
            g.drawLine(x, y + dim/2, x, y);

        }
    }
    private void helix (int length, int x, int y, Graphics g) throws InterruptedException {
        int diff = 5;
        if (length > 0) {
            g.drawLine(x, y, x + length, y);
            Thread.sleep(500);
            g.drawLine(x + length, y, x + length, y + length);
            Thread.sleep(500);
            g.drawLine(x + length, y + length, x + diff, y + length);
            Thread.sleep(500);
            g.drawLine(x + diff, y + length, x + diff, y + diff);
            Thread.sleep(500);
            helix(length - 2 * diff, x + diff, y + diff, g);
            Thread.sleep(500);
        }
    }
}
