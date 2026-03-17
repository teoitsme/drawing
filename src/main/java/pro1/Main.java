package pro1;

import pro1.swingComponents.MainFrame; // Důležitý import pro propojení s oknem
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}