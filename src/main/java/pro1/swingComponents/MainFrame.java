package pro1.swingComponents;

import pro1.drawingModel.*;
import pro1.drawingModel.Rectangle;
import pro1.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    private DisplayPanel displayPanel;
    private int x;
    private int y;
    private String color = "#000000";

    public void setColor(String color) {
        this.color = color;
    }

    public MainFrame() {
        this.setTitle("PRO1 Drawing");
        this.setVisible(true);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.displayPanel = new DisplayPanel();
        this.add(displayPanel, BorderLayout.CENTER);

        JPanel leftPanel = new OptionsPanel(this);
        this.add(leftPanel, BorderLayout.WEST);

        /*
        JButton newColorBtn = new JButton("Nová barva");
        leftPanel.add(newColorBtn);
        newColorBtn.addActionListener( (e) -> {
            displayPanel.setDrawable(example());
        } );
         */

        this.displayPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MainFrame.this.x = e.getX();
                MainFrame.this.y = e.getY();
                //displayPanel.setDrawable(example(e.getX(), e.getY()));
                MainFrame.this.showExample();
            }
        } );
    }

    public void showExample() {
        MainFrame.this.displayPanel.setDrawable(this.example());
    }

    private Drawable example(int x, int y) {
        var color = ColorUtils.randomColor();

        /*
        var d1 = new Rectangle(0, 0, 150, 250, color);
        var d2 = new Text(0, 0, color);
        return new Group(new Drawable[]{d1, d2}, x, y, 10, 1, 1);
         */

        var d1 = new Ellipse(0, 0, 150, 250, color);
        var d2 = new Text(0, 0, color);
        var d3 = new Line(0, 50, 170, 170,3, color);
        return new Group(new Drawable[]{d1, d2, d3}, x, y, 40, 1, 1);
    }
}