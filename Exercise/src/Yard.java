import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Yard extends Frame {

    public static final int ROWS = 50;
    public static final int COLS = 50;
    public static final int BLOCK_SIZE = 10;

    Snake s = new Snake();

    Image offSrceenImage = null;

    public void launch() {
        this.setLocation(300,300);
        this.setSize(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);

        new Thread(new PaintThread()).start();
    }

    public static void main(String args[]) {
        new Yard().launch();
    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.gray);
        g.fillRect(0,0,COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
        g.setColor(Color.darkGray);
        //画出横线
        for (int i = 0; i < ROWS; i++){
            g.drawLine(0, BLOCK_SIZE * i, COLS * BLOCK_SIZE, BLOCK_SIZE * i);
        }
        //画出竖线
        for (int i = 0; i < COLS; i++){
            g.drawLine(BLOCK_SIZE * i, 0, i * BLOCK_SIZE, ROWS * BLOCK_SIZE);
        }
        g.setColor(c);
        s.draw(g);
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
    }

    private class PaintThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
