import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class Main extends JFrame{

    private DrawPanel cPanel;

    public Main(){
        super("Project 2");

        JPanel wPanel = new JPanel();



        JCheckBox cluster = new JCheckBox("Cluster");
        cluster.setOpaque(false);
        wPanel.add(cluster);
        JCheckBox neighbor = new JCheckBox("Line");
        neighbor.setOpaque(false);
        wPanel.add(neighbor);
        JButton run = new JButton("Run");
        run.setOpaque(false);

        cPanel = new DrawPanel();
        cPanel.setBackground(new Color(90, 90, 90));
        wPanel.setVisible(true);
        cPanel.setVisible(true);

        GridLayout grid = new GridLayout(8, 1);
        wPanel.setLayout(grid);
        wPanel.add(cluster);
        wPanel.add(neighbor);
        wPanel.add(run);

        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(wPanel, BorderLayout.WEST);
        add(cPanel, BorderLayout.CENTER);

        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cluster q = new Cluster();
                int avgX = 0, avgY = 0;
                for(Circle c: cPanel.getStack()){
                    avgX += c.getX();
                    avgY += c.getY();
                }
                avgX = avgX/cPanel.getStack().size();
                avgY = avgY/cPanel.getStack().size();
                q = q.makeCluster(cPanel.getStack(), Color.RED, Color.BLUE, new Circle(avgX+1,
                        avgY+1, Color.BLACK), new Circle(avgY-1, avgY-1, Color.BLACK));
                Stack<Circle> pog = new Stack<Circle>();
                pog = q.kMean(q);
                cPanel.setStack(pog);
                repaint();
            }
        });

    }

    public static void main(String[] args){
        Main m = new Main();
        m.setSize(600, 600);
        m.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        m.setVisible(true);
    }
}
