package pro1.swingComponents;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {
    public OptionsPanel(MainFrame parent) {
        // Šířka mezi 150 a 450 px [zadání]
        this.setPreferredSize(new Dimension(250, 0));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));

        // Slider pro tloušťku celé lomené čáry [zadání]
        this.add(new JLabel("Tloušťka čáry:"));
        JSlider thicknessSlider = new JSlider(1, 20, 5);
        thicknessSlider.addChangeListener(e -> parent.setThickness(thicknessSlider.getValue()));
        this.add(thicknessSlider);

        // Checkbox pro barevnost: červená (zapnuto), šedá (vypnuto) [zadání]
        JCheckBox colorCheck = new JCheckBox("Červená barva");
        colorCheck.addActionListener(e -> parent.setRed(colorCheck.isSelected()));
        this.add(colorCheck);

        // Tlačítko reset [zadání]
        JButton resetBtn = new JButton("Reset");
        resetBtn.addActionListener(e -> parent.reset());
        this.add(resetBtn);
    }
}