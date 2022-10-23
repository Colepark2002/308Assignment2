import java.awt.*;
import java.util.Stack;

public class Cluster {
    Stack<Circle> stack1;
    Stack<Circle> stack2;
    public Cluster(){
        stack1 = new Stack<Circle>();
        stack2 = new Stack<Circle>();
    }
    public Circle[] moveKNodes(Cluster g){
            int stack1Size = stack1.size();
            int stack2Size = stack2.size();
            Circle[] x = new Circle[2];
            int tmp1MX = 0, tmp2MX = 0, tmp1MY = 0, tmp2MY = 0;
            Stack<Circle> tmp1 = new Stack<Circle>();
            Stack<Circle> tmp2 = new Stack<Circle>();
            tmp1 = g.stack1;
            tmp2 = g.stack2;
            while(tmp1.size() != 0){
                Circle n1 = tmp1.pop();
                tmp1MX += n1.getX();
                tmp1MY += n1.getY();
            }
            while(tmp2.size() != 0){
                Circle n2 = tmp2.pop();
                tmp2MX += n2.getX();
                tmp2MY += n2.getY();
            }
            tmp1MX = tmp1MX/stack1Size;
            tmp1MY = tmp1MY/stack1Size;
            tmp2MX = tmp2MX/stack2Size;
            tmp2MY = tmp2MY/stack2Size;
            x[0] = new Circle(tmp1MX, tmp1MY, Color.BLACK);
            x[1] = new Circle(tmp2MX, tmp2MY, Color.BLACK);
            return x;
    }
    public Cluster makeCluster(Stack<Circle> input, Color c1, Color c2, Circle K1, Circle K2) {
        Cluster p = new Cluster();
        while (input.size() != 0) {
            Circle q = input.pop();
            Double DeltaK1 = Math.sqrt(((Math.abs(q.getX() - K1.getX()) ^ 2) + (Math.abs(q.getY() - K1.getY()) ^ 2)));
            Double DeltaK2 = Math.sqrt(((Math.abs(q.getX() - K2.getX()) ^ 2) + (Math.abs(q.getY() - K2.getY()) ^ 2)));
            if (DeltaK1 < DeltaK2) {
                q.setColor(c1);
                p.stack1.push(q);
            } else {
                q.setColor(c2);
                p.stack2.push(q);
            }
        }
        return p;
    }
    public Stack<Circle> kMean(Cluster q){
        Stack<Circle> stacktmp = new Stack<Circle>();
        Circle[] f = new Circle[2];
        for(int i = 0; i < 100000;i++){
            stacktmp.clear();
            stacktmp.addAll(q.stack1);
            stacktmp.addAll(q.stack2);
            f = q.moveKNodes(q);
            q = q.makeCluster(stacktmp, Color.RED, Color.BLUE, f[0], f[1]);
        }
        stacktmp.clear();
        stacktmp.add(f[0]);
        stacktmp.add(f[1]);
        stacktmp.addAll(q.stack1);
        stacktmp.addAll(q.stack2);
        return stacktmp;
    }
}
