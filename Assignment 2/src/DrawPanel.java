import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

public class DrawPanel extends JPanel implements MouseListener{
    int x;
    int y;
    Stack<Circle> stack;



    public DrawPanel(){
        addMouseListener(this);
        stack = new Stack<>();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if (!stack.isEmpty()){
            for (Circle circle : stack){
                g.setColor(circle.getColor());
                g.fillOval(circle.getX(), circle.getY(), 10 ,10);
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        stack.push(new Circle(x, y, Color.BLACK));
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public Stack<Circle> getStack() {
        return stack;
    }

    public void setStack(Stack<Circle> stack) {
        this.stack = stack;
    }
}
