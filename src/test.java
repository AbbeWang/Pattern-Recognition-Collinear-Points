import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class test {
	
    public static void main(String[] args) {

    	// read the N points from a file
//        In in = new In(args[0]);
//        int N = in.readInt();
    	
    	int N = 6;
    	int[] px = new int[N];
    	int[] py = new int[N];
    	
    	px[0] = 19000; px[1] = 18000; px[2] = 32000; px[3] = 21000; px[4] = 1234; px[5] = 14000;
    	py[0] = 10000; py[1] = 10000; py[2] = 10000; py[3] = 10000; py[4] = 5678; py[5] = 10000;
      	
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
//            int x = in.readInt();
//            int y = in.readInt();
        	
        	int x = px[i];
        	int y = py[i];
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.show(0);
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
    }

}
