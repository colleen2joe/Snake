import java.awt.*;

public class Snake {
    Node head = null;
    Node tail = null;
    int size = 0;

    private Node n = new Node(20,40,Direction.L);

    public Snake() {
        head = n;
        tail = n;
        size = 1;
    }

    public void addToTail () {
        Node node = null;
        switch (tail.dir) {
            case L:
                node = new Node(tail.row, tail.col + 1, tail.dir);
                break;
            case R:
                node = new Node(tail.row, tail.col - 1, tail.dir);
                break;
            case U:
                node = new Node(tail.row + 1, tail.col, tail.dir);
                break;
            case D:
                node = new Node(tail.row - 1, tail.col + 1, tail.dir);
                break;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    public void addToHead () {
        Node node = null;
        switch (head.dir) {
            case L:
                node = new Node(head.row, head.col - 1, head.dir);
                break;
            case R:
                node = new Node(head.row, head.col + 1, tail.dir);
                break;
            case U:
                node = new Node(head.row - 1, head.col, head.dir);
                break;
            case D:
                node = new Node(head.row + 1, head.col + 1, head.dir);
                break;
        }
        node.next = head;
        head = node;
        size++;
    }

    public void draw(Graphics g){
        if (size <= 0)
            return;
        for (Node n = head; n != null; n = n.next){
            n.draw(g);
        }
    }

    private class Node {
        int w = Yard.BLOCK_SIZE;
        int h = Yard.BLOCK_SIZE;
        int row, col;
        Direction dir = Direction.L;
        Node next = null;

        Node(int row, int col, Direction dir) {
            this.row = row;
            this.col = col;
            this.dir = dir;
        }

        void draw(Graphics g) {
            Color c = g.getColor();
            g.setColor(Color.black);
            g.fillRect(row * Yard.BLOCK_SIZE, col * Yard.BLOCK_SIZE, w, h);
            g.setColor(c);
        }
    }
}
