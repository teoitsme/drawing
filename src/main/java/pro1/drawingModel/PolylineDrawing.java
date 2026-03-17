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

        // 1. Nastavení barvy a tloušťky pro lomenou čáru
        g.setStroke(new BasicStroke(this.thickness));
        g.setColor(isRed ? Color.RED : Color.GRAY);

        // 2. Vykreslení lomené čáry (propojuje všechny body)
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }

        // 3. Vykreslení nejmenšího nenakloněného obdélníku (Bounding Box)
        // Musí existovat alespoň dva vrcholy [zadání]
        if (points.size() >= 2) {
            int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

            for (Point p : points) {
                minX = Math.min(minX, p.x);
                minY = Math.min(minY, p.y);
                maxX = Math.max(maxX, p.x);
                maxY = Math.max(maxY, p.y);
            }

            g.setStroke(new BasicStroke(1)); // Obdélník je tenký
            g.setColor(Color.RED); // Vždy červenou barvou [zadání]
            g.drawRect(minX, minY, maxX - minX, maxY - minY);
        }
    }
}