import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    private DrawPanel cPanel;
    private boolean clusterBool = false;
    private boolean neighborBool = false;

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
        cluster.addActionListener(this);
        neighbor.addActionListener(this);
        run.addActionListener(this);

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


    }

    public static void main(String[] args){
        Main m = new Main();
        m.setSize(600, 600);
        m.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        m.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Cluster")) {
            if (!clusterBool) {
                clusterBool = true;
                System.out.println("Cluster checked");
            }
            else {
                clusterBool = false;
                System.out.println("Cluster unchecked");
            }
        }
        if(e.getActionCommand().equals("Line")) {
            if (!neighborBool) {
                neighborBool = true;
                System.out.println("Neighbor checked");
            }
            else {
                neighborBool = false;
                System.out.println("Neighbor unchecked");
            }
        }
        if(e.getActionCommand().equals("Run"))
        {
            if(clusterBool)
            {
                Cluster clust = new Cluster();
                clust.makeCluster(cPanel.getStack(), Color.BLUE, Color.ORANGE);
                cPanel.setStack(clust.getStack1());
            }
            if(neighborBool)
            {
                Line line = new Line();
                cPanel.setStack(line.nearestNeighbors(cPanel.getStack()));

            }
            repaint();
        }
    }
}
