import java.awt.*;
import java.util.Stack;

public class Cluster {
    Stack<Circle> stack1;
    public Cluster(){
        stack1 = new Stack<Circle>();
    }
    public Cluster makeCluster(Stack<Circle> input, Color c1, Color c2){
        Circle K1 = new Circle(125, 250, Color.BLACK);
        Circle K2 = new Circle(375, 250, Color.BLACK);
        while(input.size() != 0){
            Circle q = input.pop();
            Double DeltaK1 = Math.sqrt(((Math.abs(q.getX()-K1.getX())^2)+(Math.abs(q.getY()-K1.getY())^2)));
            Double DeltaK2 = Math.sqrt(((Math.abs(q.getX()-K2.getX())^2)+(Math.abs(q.getY()-K2.getY())^2)));
            if(DeltaK1 < DeltaK2){
                q.setColor(c1);
                stack1.push(q);
            }
            else{
                q.setColor(c2);
                stack1.push(q);
            }
        }
        return this;
    }
}
