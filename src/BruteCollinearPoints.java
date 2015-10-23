import java.util.*;

public class BruteCollinearPoints {
	private final List<LineSegment> segment;
	
	public BruteCollinearPoints(Point[] points) {
		// finds all line segments containing 4 points
		
		// corner cases
		if (points == null) {
			throw new java.lang.NullPointerException();
		}
		
		Arrays.sort(points);
		for (int i = 0; i < points.length; i++) {
			if (points[i] == null)
				throw new java.lang.NullPointerException();
			
			if (i > 0)
				if (points[i] == points[i-1])
					throw new java.lang.IllegalArgumentException();
		}
		
		// initialize segment
		this.segment = new ArrayList<LineSegment>();
		
		// finding all 4-point combinations that collinear
		for (int i = 0; i < points.length - 3; i++) {
			for (int j = i + 1; j < points.length - 2; j++) {
				for (int k = j + 1; k < points.length - 1; k++) {
					for (int l = k + 1; l < points.length; l++) {
						if (points[i].slopeOrder().compare(points[j], points[k]) == 0 && 
								points[i].slopeOrder().compare(points[j], points[l]) == 0) {
							segment.add(new LineSegment(points[i], points[l]));
						}
					}
				}
			}
		}
	}
	
	
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
