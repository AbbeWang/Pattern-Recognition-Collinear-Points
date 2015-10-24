import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class test1 {
	
    public static void main(String[] args) {
   	
    	int N = 8;
    	int[] px = new int[N];
    	int[] py = new int[N];
    	
    	px[0] = 10000; px[1] = 0; px[2] = 3000; px[3] = 7000; px[4] = 20000; px[5] = 3000; px[6] = 14000; px[7] = 6000;
    	py[0] = 0; py[1] = 10000; py[2] = 7000; py[3] = 3000; py[4] = 21000; py[5] = 4000; py[6] = 15000; py[7] = 7000;
      	
//    	px[0] = 19000; px[1] = 18000; px[2] = 32000; px[3] = 21000; px[4] = 1234; px[5] = 14000;
//    	py[0] = 10000; py[1] = 10000; py[2] = 10000; py[3] = 10000; py[4] = 5678; py[5] = 10000;

        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
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
    	
//    	List<Point> maxpoint = new ArrayList<Point>();
//    	maxpoint.add(new Point(1,5));
//    	
//    	System.out.println(maxpoint.get(0));
        
//        System.out.println(points[4].slopeTo(points[2]));
//        System.out.println(points[4].slopeTo(points[5]));
//        System.out.println(points[5].slopeTo(points[2]));
    }

}
