package viewsFiles.ImagesComp;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImageFrame extends JFrame {
    public ImageFrame(File pathFile)
    {
        setTitle("ImageTest");
        setSize(600, 500);

        // Добавление компонента к фрейму.

        ImageComponent component = new ImageComponent(pathFile);
        JPanel panel = new JPanel();
        add(panel.add(new JScrollPane(component)));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
