import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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


    }

    public static void main(String[] args){
        Main m = new Main();
        m.setSize(600, 600);
        m.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        m.setVisible(true);
    }
}
