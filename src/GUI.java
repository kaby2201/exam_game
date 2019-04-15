import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.Random;

public class GUI extends  JFrame implements KeyListener, ActionListener{

    //static int block[][] = new int[2][2];
    SmashBlock smashblock;
    HeroBlock heroblock;
    Direction currentDirection = Direction.RIGHT;
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Game");
    JMenuItem Game = new JMenuItem("New Game");
    boolean run = true;
    Timer timer;



    public GUI() {
        this.setTitle("Tetris");
        this.setSize(800,800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addKeyListener(this);
        //this.setJMenuBar(menuBar);
        this.setResizable(false);
        this.setBackground(Color.white);
        this.setVisible(true);

        //menuBar.add(menu);
        //menu.add(Game);
        timer = new Timer(1500,this);
        timer.start();
        smashblock = new SmashBlock();
        heroblock = new HeroBlock();


        //x.setLayout(new GridLayout(20, 10));

        //this.add(b1);

        //b1.addActionListener(this);
        menu.addActionListener(this);


    }

    public void paint(Graphics g) {
        int spacing = 0;
        g.setColor(Color.white);
        g.fillRect(0,0,1280,800);
        g.setColor(Color.BLACK);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                g.drawRect(spacing+i*25+275,spacing+j*25+25+20,25-2*spacing,25-2*spacing);

            }

        }

    }

      public Graphics Random() {
        int random  = (int)(Math.random() * 2);
            switch (random) {
                case 0:
                    smashblock.drawMe(this.getGraphics());
                    break;
                case 1:
                    heroblock.drawMe(this.getGraphics());
                    break;

                default: System.out.println("Error");
            }
            return this.getGraphics();
        }

        /*public void DrawBlock(int i) {
        if (i == 0) {

        }
        else if (i == 1) {

        }
        }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        //Se is the timer have started, and the user don't get out of the max width 450
        if (e.getSource().equals(timer) && smashblock.posY <= 450) {
            smashblock.clearMe(this.getGraphics());

            int newPosY = smashblock.posY + 50;
            smashblock.posY = newPosY;
            currentDirection = Direction.DOWN;
        }
        smashblock.drawMe(this.getGraphics());

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


        /*if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("SPACE ble trykket på");
            smashblock.drawMe(this.getGraphics());
        }*/

        if (e.getKeyCode() == KeyEvent.VK_RIGHT && smashblock.posX != 475 &&smashblock.posY <= 450) {
            System.out.println("Høyre!");
            smashblock.clearMe(this.getGraphics());
            //this.getGraphics().clearRect(getX(),getY(),getWidth(),getHeight());
            //paint(x.getGraphics());

            int newPosX = smashblock.posX + 50;
            smashblock.posX = newPosX;
            currentDirection = Direction.RIGHT;

            //if (smashblock.posX > 525) smashblock.posX = 275;
            //if (smashblock.posX < 275) smashblock.posX = 525;


        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT && smashblock.posX != 275 && smashblock.posY <= 450) {
            System.out.println("Venstre!");
            smashblock.clearMe(this.getGraphics());
            //this.getGraphics().clearRect(getX(),getY(),getWidth(),getHeight());
            //paint(x.getGraphics());

            int newPosX = smashblock.posX - 50;
            smashblock.posX = newPosX;
            currentDirection = Direction.LEFT;


        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN && smashblock.posY <= 450) {
            System.out.println("Venstre!");
            smashblock.clearMe(this.getGraphics());
            //this.getGraphics().clearRect(getX(),getY(),getWidth(),getHeight());
            //paint(x.getGraphics());

            int newPosY = smashblock.posY + 50;

            smashblock.posY = newPosY;
            currentDirection = Direction.DOWN;

        }

        smashblock.drawMe(this.getGraphics());




    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
