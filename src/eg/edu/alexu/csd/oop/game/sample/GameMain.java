package eg.edu.alexu.csd.oop.game.sample;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameMain extends JFrame {
    private BufferedImage image;
    JButton start;
    int windwowidth = 1200;
    int windwheight = 700;

    public static void main(String [] args){
        new GameMain();
    }

    public GameMain(){

        this.setSize(windwowidth,windwheight);
        this.setLocationRelativeTo(null);
        this.setTitle("welcome to our game...!");
        JPanel contentpane = new JPanel();
        contentpane.setLayout(new BorderLayout());
        start = new JButton("start game");
        //start.setBackground(Color.black);
        ImagePanel Image = new ImagePanel();
        start.setFont(new Font("Arial", Font.PLAIN, 40));
        contentpane.add(start,BorderLayout.SOUTH);
        contentpane.add(Image,BorderLayout.CENTER);
         this.add(contentpane);
         this.setVisible(true);
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         start.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent actionEvent) {
                  Main main = new Main();
                 try {
                     main.printgame();
                 } catch (CloneNotSupportedException e) {
                     e.printStackTrace();
                 }
             }
         });
        }
    }
class ImagePanel extends JPanel{

    private BufferedImage image;

    public ImagePanel() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/yes.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
    }

}

