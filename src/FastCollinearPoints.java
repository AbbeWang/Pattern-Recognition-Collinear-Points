import java.util.*;

public class FastCollinearPoints {
	private final List<LineSegment> segment;
	private final List<Point> maxpoint;
	
	public FastCollinearPoints(Point[] points) {
		// finds all line segments containing 4 or more points
		
		// corner cases
		if (points == null) {
			throw new java.lang.NullPointerException();
		}
		
		Arrays.sort(points);
		for (int i = 0; i < points.length; i++) {
			if (points[i] == null)
				throw new java.lang.NullPointerException();
			
			if (i > 0)
				if (points[i].compareTo(points[i-1]) == 0)
					throw new java.lang.IllegalArgumentException();
		}
		
		// initialize segment
		this.segment = new ArrayList<LineSegment>();
		this.maxpoint = new ArrayList<Point>();

		//quicksort & find collinear points
		for (int p = 0; p < points.length-3; p++) {
			sort(points, points[p], p+1, points.length - 1);
			
			int i = p + 1;
			while (i < points.length - 2) {
				if (points[p].slopeOrder().compare(points[i], points[i+1]) == 0) {
					int j;
					for (j = i+2; j < points.length; j++) {
						if (points[p].slopeOrder().compare(points[i], points[j]) != 0)
							break;
					}
					
					if (j - i >= 3) {
						Point temp = points[i];
						for (int k = i+1; k < j; k++) {
							if (temp.compareTo(points[k]) < 0)
								temp = points[k];							
						}
						
						if (!maxpoint.contains(temp)) {
							segment.add(new LineSegment(points[p], temp));
							maxpoint.add(temp);
						}
					}
					
					i = j;
				}
				
				else i++;
			}
			
			Arrays.sort(points);
		}
		
		 

	}
	
	
	// partitioning
	private static int partition(Point[] a, Point origin, int lo, int hi) {
		int i = lo, j = hi + 1;
		while (true) {
			while (origin.slopeTo(a[++i]) < origin.slopeTo(a[lo]))
				if (i == hi) break;
			
			while (origin.slopeTo(a[lo]) < origin.slopeTo(a[--j]))
				if (j == lo) break;
			
			if (i >= j) break;
			exch(a, i, j);
		}
		
		exch(a, lo, j);
		return j;
	}
	
	private static void exch(Point[] a, int i, int j) {
		Point temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
	// sort implementation
	private static void sort(Point[] a, Point origin, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(a, origin, lo, hi);
		sort(a, origin, lo, j-1);
		sort(a, origin, j+1, hi);
	}
	
//	public static void sort(Point[] a, Point origin) {
//		sort(a, origin, 0, a.length - 1);
//	}
	
	
	
	public int numberOfSegments() {
		// the number of line segments
		
		return segment.size();
	}
	
	public LineSegment[] segments() {
		// the line segments
		LineSegment[] segments = new LineSegment[segment.size()];
		
		for (int i = 0; i < segment.size(); i++)
			segments[i] = segment.get(i);
		
		return segments;
	}
}
