import java.util.*;

public class test {
	
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    	Point[] p = new Point[5];
    	
    	p[0] = new Point(4,2);
    	p[1] = new Point(2,1);
    	p[2] = new Point(3,5);
    	p[3] = new Point(5,3);
    	p[4] = new Point(1,2);
    	
    	Arrays.sort(p);
    	
    	for(int i=0; i<5; i++){
    		System.out.println(p[i]);
    	}

    }

}
