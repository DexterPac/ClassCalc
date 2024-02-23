import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class Algorithm extends JFrame implements Runnable{

    public static Image image;
    public static Graphics2D g;
    double framerate = 25.0; //window/animation's framerate
    Thread relaxer;

    int howfun;
    int coolprof;
    int need;
    int afterwakeuphours;
    double percentpass;
    int repeat;
    int smartfriends;
    double x_factor;
    String AskInput;
    /////////////my rudimentary way of creating checks
    boolean funcheeck;
    boolean coolcheck;
    boolean needcheck;
    boolean hourcheck;
    boolean percentcheck;
    boolean repeatcheck;
    boolean friendcheck;
    boolean is1or2input;

    int numbercollecter;
    double decimalplace1;
    double decimalplace2;
    int isdecimal;

    boolean timetodecide;
    

    static Algorithm frame;
    public static void main(String[] args) throws Exception {
        GraphicsDevice Device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        frame = new Algorithm();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
       
       
    }

    public Algorithm() {
//this is where mouse/keyboard adapters go
        addMouseListener(new MouseAdapter()     {
            public void mousePressed(MouseEvent e) {
                
                if (e.BUTTON3 == e.getButton()) {
                    //right click
                    reset();
                    }
                
                repaint();
            }
        });


        addKeyListener(new KeyAdapter() {

            //keyboard listener. This is needed since I am using a canvas as my display and it 
            //is very difficult to display a text field over a canvas
            public void keyPressed(KeyEvent e) {
               
                if (e.VK_1 == e.getKeyCode()) {
                    numbercollecter = 1;
                }
                else if (e.VK_2 == e.getKeyCode()) {
                    numbercollecter = 2;
                }
                else if (!is1or2input)
                {
                    if (e.VK_3 == e.getKeyCode()) {
                        numbercollecter = 3;
                    }
                    else if (e.VK_4 == e.getKeyCode()) {
                        numbercollecter = 4;
                    }
                    else if (e.VK_5 == e.getKeyCode()) {
                        numbercollecter = 5;
                    }
                    else if (e.VK_6 == e.getKeyCode()) {
                        numbercollecter = 6;
                    }
                    else if (e.VK_7 == e.getKeyCode()) {
                        numbercollecter = 7;
                    }
                    else if (e.VK_8 == e.getKeyCode()) {
                        numbercollecter = 8;
                    }
                    else if (e.VK_9 == e.getKeyCode()) {
                        numbercollecter = 9;
                    }
                    else if (e.VK_0 == e.getKeyCode()) {
                        if(numbercollecter == 1 && !percentcheck)
                        {
                            numbercollecter = 10;
                        }
                        else
                        {
                            numbercollecter = 0;
                        }
                    }
                }
                
                if (e.VK_ENTER == e.getKeyCode())
                {
                    WhatLetterAmIOn();
                }
                

                repaint();
            }
            
        });
        
        init();
        start();
    }
    

    public void init() {
        requestFocus();
    }

    public void destroy() {
    }

    //formula to check if I add the course or not
    public boolean doMath() {
        double classcalc;

        classcalc = ((howfun +(coolprof/need) + afterwakeuphours * (percentpass /repeat *smartfriends)) *x_factor);
        if(classcalc >= 1)
        {
            return(true);
        }
        else if(classcalc < 1)
        {
            return(false);
        }

        return(true);

    }

    //this is to determine what check is curerntly active
    public void WhatLetterAmIOn() {
        if(funcheeck)
        {
            howfun = numbercollecter;
            funcheeck = false;
        }
        else if(coolcheck)
        {
            coolprof = numbercollecter;
            coolcheck = false;
        }
        else if(needcheck)
        {
            need = numbercollecter;
            needcheck = false;
            is1or2input = false;
        }
        else if(hourcheck)
        {
            afterwakeuphours = numbercollecter;
            hourcheck = false;
        }
        else if(percentcheck)
        {
            if(isdecimal == 2)
            {
                decimaldecider(numbercollecter);
                isdecimal = 0;
                percentcheck = false;
                percentpass = (decimalplace1*.1) + (decimalplace2*.01);
            }
            else if(isdecimal == 1)
            {
                decimaldecider(numbercollecter);
                isdecimal = 2;
            }
        }
        else if(repeatcheck)
        {
            repeat = numbercollecter;
            repeatcheck = false;
            is1or2input = false;
        }
        else if(friendcheck)
        {
            smartfriends = numbercollecter;
            friendcheck = false;
            is1or2input = false;
        }
        numbercollecter = 0;
    }

    //this is strictly used for the percentage/decimal input
    public void decimaldecider(int _num) {
        if(isdecimal == 1)
        {
            decimalplace1 = (double)_num;
        }
        else if(isdecimal == 2)
        {
            decimalplace2 = (double)_num;
        }
    }

    
//below displays objects in the window
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
        g.setColor(Color.white);
        g.fillRect(0, 0, Window.xsize, Window.ysize);
        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};

        //fill border
        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon(x, y, 4);
        // draw border
        //g.setColor(Color.red);
        //g.drawPolyline(x, y, 5);

        if (Window.animateFirstTime)
        {
            gOld.drawImage(image, 0, 0, null);
            return;
        }

        //all the below actually does is display text, I'm keeping this simple as the bulk of this
        //code is just built to create the window and the function to display on the canvas
        //and it is already really long
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial Black", Font.PLAIN, 20));
        g.drawString(AskInput, 50, 200);

        g.setColor(Color.BLUE);
        g.drawString("Press 'Enter' to submit your answer", 50, 300);
        
        if(percentcheck)
        {
            g.drawString("Please enter your first decimal place, then press 'Enter'", 50, 400);
            g.drawString("Then enter your second decimal place, then press 'Enter'", 50, 420);
            g.drawString("Ex: 3 --> Enter --> 4 --> Enter == 34%", 50, 440);
        }

        g.setColor(Color.BLACK);
        if(timetodecide)
        {
            if(doMath())
            {
                g.drawString("You should add this course", 50, 400);
            }
            else if(!doMath())
            {
                g.drawString("You should not add this course", 50, 400);
            }
        }


        gOld.drawImage(image, 0, 0, null); //allows the above to be drawn on window
    }
//runs program
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = 1/framerate;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
//resets variables
    public void reset() {
//the reason I put this here was to give the option to restart the options again without having
//to close then re-open the program
        howfun = 0;
        coolprof = 0;
        need = 0;
        afterwakeuphours = 0;
        percentpass = 0;
        repeat = 0;
        smartfriends = 0;
        x_factor = .07;
        AskInput = "";

        funcheeck = false;
        coolcheck = false;
        needcheck = false;
        hourcheck = false;
        percentcheck = false;
        repeatcheck = false;
        friendcheck = false;
        is1or2input = false;

        numbercollecter = 0;
        decimalplace1 = 0;
        decimalplace2 = 0;
        isdecimal = 1;

        timetodecide = false;

    }
//this is where code to animate objects would go. This is called every frame
    public void animate() {
        if (Window.animateFirstTime) {
            Window.animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
            
            reset();
        }
        
//the below code initializes when the dialogue prompt will appear
        if(howfun == 0)
        {
            funcheeck = true;
            AskInput = "On a scale of 1-10 how fun would the class be?";
        }
        else if(coolprof == 0)
        {
            coolcheck = true;
            AskInput = "On a scale of 1-10 how cool would your professor be?";
        }
        else if(need == 0)
        {
            needcheck = true;
            is1or2input = true;
            AskInput = "Do I need this class to Graduate (2 = No or 1 = Yes)?";
        }
        else if(afterwakeuphours == 0)
        {
            hourcheck = true;
            AskInput = "How many hours does this class start after I wake up?";
        }
        else if(percentpass == 0)
        {
            percentcheck = true;
            AskInput = "What is the percent chance I will pass this class (Example .70 would be 70%)?";
        }
        else if(repeat == 0)
        {
            repeatcheck = true;
            is1or2input = true;
            AskInput = "Is this a repeat, have I taken the class before (1 = No or 2 = Yes)";
        }
        else if(smartfriends == 0)
        {
            friendcheck = true;
            is1or2input = true;
            AskInput = "Are any of my smart friends taking this class (1 = No or 2 = Yes)?";
        }
        else 
        {
            timetodecide = true;
        }

    }
//starts program
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
//stops program
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }

    //this allows me to display things on the window's canvas
    static class Drawing {
        private static Graphics2D g;
        private static Algorithm mainClassInst;
    
        public static void setDrawingInfo(Graphics2D _g,Algorithm _mainClassInst) {
            g = _g;
            mainClassInst = _mainClassInst;
    }
    
}



///////////////////////below create the executable window
public static class Window {
    private static final int XBORDER = 10;
     
 //    private static final int YBORDER = 20;
     
     private static final int TOP_BORDER = 40;
     private static final int BOTTOM_BORDER = 20;
     static boolean animateFirstTime = true;
     private static final int YTITLE = 30;
     private static final int WINDOW_BORDER = 8;
     static final int WINDOW_WIDTH = 2*(WINDOW_BORDER + XBORDER) + 850;
     static final int WINDOW_HEIGHT = YTITLE + WINDOW_BORDER + 700;
     static int xsize = -1;
     static int ysize = -1;
     
 /////////////////////////////////////////////////////////////////////////
     public static int getX(int x) {
         return (x + XBORDER + WINDOW_BORDER);
     }
 
     public static int getY(int y) {
 //        return (y + YBORDER + YTITLE );
         return (y + TOP_BORDER + YTITLE );
         
     }
 
     public static int getYNormal(int y) {
 //          return (-y + YBORDER + YTITLE + getHeight2());
       return (-y + TOP_BORDER + YTITLE + getHeight2());
         
     }
     
     public static int getYBORDER() {
         return(BOTTOM_BORDER);
     }
     
     public static int getXBORDER() {
         return(XBORDER);
     }
     
     public static int getWidth2() {
         return (xsize - 2 * (XBORDER + WINDOW_BORDER));
     }
 
     public static int getHeight2() {
 //        return (ysize - 2 * YBORDER - WINDOW_BORDER - YTITLE);
         return (ysize - (BOTTOM_BORDER + TOP_BORDER) - WINDOW_BORDER - YTITLE);
     }    
 } 
}
