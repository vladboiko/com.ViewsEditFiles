package viewsFiles;

import javax.swing.*;
import java.io.File;

public class ImageFrame extends JFrame {
    public ImageFrame(File pathFile)
    {
        setTitle("ImageTest");
        setSize(600, 500);

        // Добавление компонента к фрейму.

        ImageComponent component = new ImageComponent(pathFile);
        add(component);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
