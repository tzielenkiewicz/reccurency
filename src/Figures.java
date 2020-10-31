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
        int length = 200;
        try {
            helix (length, 10, 10, g);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        g.clearRect(0,0,getWidth(),getHeight());
        try {
            triangles(200, 10, 10, 10, g);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.exit(0);

    }


    private void triangles(int lg, int n, int x, int y, Graphics g) throws InterruptedException {

        if (n > 0) {
            Thread.sleep(500);
            g.drawLine(x, y, x + lg, y);

            for (int i = n; i > 1; i--) {
                Thread.sleep(500);
                int tempLg = x + i * lg / n - lg / (2 * n);
                g.drawLine(x + i*lg/n, y, tempLg, y + lg / (2 * n));
                Thread.sleep(500);
                g.drawLine(tempLg, y + lg / (2 * n), x + (i-1) * lg / n, y);
            }
            Thread.sleep(500);
            g.drawLine(x + lg/n, y, x + lg/(2*n), y + lg / (2*n));
            Thread.sleep(500);
            triangles(lg - (lg/n), n-1, x + lg/(2*n), y + lg/(2*n), g);
            Thread.sleep(500);
            g.drawLine(x + lg/(2*n), y + lg/(2*n), x, y);
            Thread.sleep(500);
        }
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
        int diff = 10;
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
