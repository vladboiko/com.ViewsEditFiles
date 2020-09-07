package viewsFiles;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageComponent extends JComponent{
    private Image image;
    public ImageComponent(File pathFile)
    {
        try
        {
            image = ImageIO.read(pathFile);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g)
    {
        if(image == null) return;
        g.drawImage(image, 0, 0, null);
    }
}
