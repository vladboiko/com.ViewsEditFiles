package viewsFiles.ForTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame  extends JFrame implements ActionListener {
    private final String MYFILE = "MYFILE";
    private final String OPEN = "OPEN";
    private final String EDIT = "EDIT";
    private final String ABOUT = "ABOUT";

    private final String SAVE = "SAVE";
    private final String CANCEL = "CANCEL";
    private final String EXIT = "EXIT";

    public MenuFrame() throws HeadlessException {
        JFrame jFrame = new JFrame("TEST");
        jFrame.setBounds(100,100,500,400);

        jFrame.setJMenuBar(myMenu());

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

    }



    public static void main(String[] args) {
        new MenuFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action){
            case OPEN:

                break;
            case SAVE:

                break;
            case EXIT:
                System.exit(0);
        }
    }

    public JMenuBar myMenu(){
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu(MYFILE);
        JMenu menuEdit = new JMenu(EDIT);

        JMenuItem menuOpen = new JMenuItem(OPEN);
        JMenuItem menuSave = new JMenuItem(SAVE);
        JMenuItem menuExit = new JMenuItem(EXIT);

        menuExit.setActionCommand(EXIT);
        menuExit.addActionListener(this);
        menuOpen.setActionCommand(OPEN);
        menuOpen.addActionListener(this);
        menuSave.setActionCommand(SAVE);
        menuSave.addActionListener(this);


        JMenuItem menuCopy = new JMenuItem("Copy");
        JMenuItem menuPaste = new JMenuItem("Paste");
        JMenuItem menuClose = new JMenuItem("Close");

        menuFile.setFont(new Font("sans-serif",Font.PLAIN,18));
        menuOpen.setFont(new Font("sans-serif",Font.PLAIN,16));
        menuSave.setFont(new Font("sans-serif",Font.PLAIN,16));
        menuExit.setFont(new Font("sans-serif",Font.PLAIN,16));

        menuEdit.setFont(new Font("sans-serif",Font.PLAIN,25));
        menuCopy.setFont(new Font("sans-serif",Font.PLAIN,20));
        menuPaste.setFont(new Font("sans-serif",Font.PLAIN,20));
        menuClose.setFont(new Font("sans-serif",Font.PLAIN,20));

        menuFile.add(menuOpen);
        menuFile.add(menuSave);
        menuFile.add(menuExit);

        menuEdit.add(menuCopy);
        menuEdit.add(menuPaste);
        menuEdit.add(menuClose);


        menuBar.add(menuFile);
        menuBar.add(menuEdit);

        return menuBar;
    }
}
