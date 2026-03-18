package pro1.swingComponents;

import pro1.drawingModel.PolylineDrawing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private DisplayPanel displayPanel;
    private List<Point> points = new ArrayList<>();
    private int thickness = 5;
    private boolean isRed = false;

    public MainFrame() {
        this.setTitle("PRO1 - Úkol Lomená čára");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.displayPanel = new DisplayPanel();
        this.add(this.displayPanel, BorderLayout.CENTER);

        OptionsPanel options = new OptionsPanel(this);
        this.add(options, BorderLayout.WEST);

        this.displayPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                points.add(e.getPoint());
                updateDrawing();
            }
        });

        this.setVisible(true);
    }

    public void updateDrawing() {
        this.displayPanel.setDrawable(new PolylineDrawing(points, thickness, isRed));
    }

    public void setThickness(int t) { this.thickness = t; updateDrawing(); }
    public void setRed(boolean r) { this.isRed = r; updateDrawing(); }
    public void reset() { points.clear(); updateDrawing(); }
}