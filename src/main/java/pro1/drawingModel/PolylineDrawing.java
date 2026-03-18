package pro1.drawingModel;

import java.awt.*;
import java.util.List;

public class PolylineDrawing implements Drawable {
    private final List<Point> points;
    private final int thickness;
    private final boolean isRed;

    public PolylineDrawing(List<Point> points, int thickness, boolean isRed) {
        this.points = points;
        this.thickness = thickness;
        this.isRed = isRed;
    }

    @Override
    public void draw(Graphics2D g) {
        if (points.isEmpty()) return;

        g.setStroke(new BasicStroke(this.thickness));
        g.setColor(isRed ? Color.RED : Color.GRAY);

        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }

        if (points.size() >= 2) {
            int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

            for (Point p : points) {
                minX = Math.min(minX, p.x);
                minY = Math.min(minY, p.y);
                maxX = Math.max(maxX, p.x);
                maxY = Math.max(maxY, p.y);
            }

            g.setStroke(new BasicStroke(1));
            g.setColor(Color.RED);
            g.drawRect(minX, minY, maxX - minX, maxY - minY);
        }
    }
}