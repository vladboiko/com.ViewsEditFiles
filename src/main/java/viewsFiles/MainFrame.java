package viewsFiles;

import javafx.stage.DirectoryChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainFrame extends JFrame implements ActionListener {
    private final String MYFILE = "MYFILE";
    private final String OPEN = "OPEN";
    private final String EDIT = "EDIT";
    private final String ABOUT = "ABOUT";

    private final String SAVE = "SAVE";
    private final String CANCEL = "CANCEL";
    private final String EXIT = "EXIT";

    private File file;
    private JMenuBar menuBar = new JMenuBar();

    private    JMenu menuFile = new JMenu(MYFILE);
    private JMenu menuEdit = new JMenu(EDIT);

    private JMenuItem menuOpen = new JMenuItem(OPEN);
    private JMenuItem menuSave = new JMenuItem(SAVE);
    private JMenuItem menuExit = new JMenuItem(EXIT);
    private   JFrame frame;
    private JTextArea textArea = new JTextArea(20,60);

    public MainFrame() throws HeadlessException {
          frame = new JFrame("FOR QUICKLY VIEW FILES");
        frame.setBounds(100,100,800,600);

        JPanel panelTxt = new JPanel();


        JPanel panelBtn = new JPanel();
        panelBtn.setSize(300,50);
        panelBtn.setFont(new Font("sans-serif",Font.PLAIN,16));

        //panelBtn.setLayout(new GridLayout(1,2));
        panelBtn.add(createButton(SAVE,SAVE));
        panelBtn.add(createButton(EXIT,EXIT));

        textArea.setFont(new Font("sans-serif",Font.PLAIN,16));
        panelTxt.add(new JScrollPane(textArea));

        frame.add(panelTxt,BorderLayout.NORTH);
        frame.add(panelBtn,BorderLayout.SOUTH);
        frame.setJMenuBar(myMenu());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    private JButton createButton(String title, String action) {
        JButton button = new JButton(title);
        button.setActionCommand(action);
        button.addActionListener(this);
        button.setName(title);
        button.setFont(new Font("sans-serif",Font.PLAIN,18));
        return button;
    }

    public JMenuBar myMenu(){

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

        menuEdit.setFont(new Font("sans-serif",Font.PLAIN,18));
        menuCopy.setFont(new Font("sans-serif",Font.PLAIN,16));
        menuPaste.setFont(new Font("sans-serif",Font.PLAIN,16));
        menuClose.setFont(new Font("sans-serif",Font.PLAIN,16));

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
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action){
            case OPEN:
                try {
                    openFile();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            case SAVE:
                textArea.setVisible(false);
                break;
            case EXIT:
                System.exit(0);
        }

    }
    final JFileChooser fc = new JFileChooser();
    final DirectoryChooser directoryChooser = new DirectoryChooser();
    private void openFile() throws IOException {
        int returnVal = fc.showOpenDialog(menuOpen);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            System.out.println((file.getAbsolutePath()));
            if(file.getName().endsWith("txt") || file.getName().endsWith("xlsx")||
             file.getName().endsWith("docx")||
         file.getName().endsWith("docx")||
         file.getName().endsWith("xls"))
            textArea.append(readFile(file.getAbsolutePath()));
           else if(file.getName().endsWith("png") ||
                    file.getName().endsWith("jpg") ||
                    file.getName().endsWith("jpeg")||
                    file.getName().endsWith("tiff") ||
                    file.getName().endsWith("bmp")){
                textArea.setVisible(false);
                openImage(file.getAbsolutePath());
                //  System.out.println("Graphics");
            }
            else {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(new File(file.getAbsolutePath()));
                System.out.println("Done.");

            }
         //   log.append("Opening: " + file.getName() + "." + newline);
        } else {
           // log.append("Open command cancelled by user." + newline);
        }
    }

    private void openImage(String absolutePath) {
        frame.setVisible(false);
        ImageFrame imageFrame = new ImageFrame(new File(absolutePath));
        imageFrame.setVisible(true);
    }

    public String readFile(String nameFile) throws IOException {
        FileReader reader = new FileReader(nameFile);
        String text = "";
        int ch = -1;
        while ((ch = reader.read()) != -1) {
            text += (char) ch;
        }
        reader.close();
        return text;
    }


}
