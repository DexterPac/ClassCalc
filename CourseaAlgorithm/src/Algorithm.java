import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class Algorithm extends JFrame implements Runnable{

    public static Image image;
    public static Graphics2D g;
    double framerate = 25.0; //window/animation's framerate
    Thread relaxer;

    boolean DefaultButtons;
    boolean TakeClass;
    boolean CreatePerson;
    boolean AcessPerson;

    int howfun;
    int coolprof;
    int need;
    int afterwakeuphours;
    double percentpass;
    int repeat;
    int smartfriends;
    double x_factor;
    String AskInput;
    String AskInput2;
    String AskInput3;
    /////////////my rudimentary way of creating checks
    boolean funcheeck;
    boolean coolcheck;
    boolean needcheck;
    boolean hourcheck;
    boolean percentcheck;
    boolean repeatcheck;
    boolean friendcheck;
    boolean is1or2input;

    boolean askpersonname1;
    boolean askpersonname2;
    boolean asklocation;
    boolean asktitle;
   

    int numbercollecter;
    double decimalplace1;
    double decimalplace2;
    int isdecimal;

    String createfirstname;
    String createlastname;
    String createlocation;
    String createtitle;

    Person personpointer;

    boolean readytocreate;
    boolean timetodecide;

    boolean findperson;
    boolean acceptfindperson;
    boolean acceptfindperson2;

    String Whatisusertyping;
    boolean istalk;
    boolean issleep;
    boolean iseat;
    boolean getlocation;
    boolean setlocation;

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
                
                if (e.BUTTON1 == e.getButton()) {
                    //left click
                    int mouseX2 = e.getX();
                    int mouseY2 = e.getY();
                    
                        
                    //System.out.println(mouseX2 + "XX");
                    //System.out.println(mouseY2 + "YY");   

                    //the X in the top right corner
                    if(mouseX2 > 770 && mouseX2 < 830 && mouseY2 > 100 && mouseY2 < 150)
                    {
                        reset();
                    }

///////////////////////////////////
                    //the below are used to create rudimentary buttons (sometimes working on a canvas kinda sucks)
                    if(DefaultButtons)
                    {
                        if(mouseX2 > 120 && mouseX2 < 720 && mouseY2 > 100 && mouseY2 < 200) //take class button
                        {
                            DefaultButtons = false;
                            CreatePerson = false;
                            AcessPerson = false;
                            TakeClass = true;
                        }
                        else if(mouseX2 > 120 && mouseX2 < 720 && mouseY2 > 500 && mouseY2 < 600) //person information button
                        {
                            DefaultButtons = false;
                            TakeClass = false;
                            AcessPerson = false;
                            CreatePerson = true;

                        }
                        else if(mouseX2 > 120 && mouseX2 < 720 && mouseY2 > 300 && mouseY2 < 400) //create person button
                        {
                            DefaultButtons = false;
                            TakeClass = false;
                            CreatePerson = false;
                            AcessPerson = true;

                        }
                    }
                    else if(acceptfindperson) //these are corresponding buttons for a person's information
                    {
                        if(mouseX2 > 120 && mouseX2 < 720 && mouseY2 > 100 && mouseY2 < 150) //talk
                        {
                            issleep = false;
                            getlocation = false;
                            iseat = false;
                            setlocation = false;
                            istalk = true;
                            acceptfindperson2 = true;
                            AskInput3 = "please type what you want the person to say";
                            Whatisusertyping = "";   

                        }
                        else if(mouseX2 > 120 && mouseX2 < 720 && mouseY2 > 200 && mouseY2 < 250) //eat
                        {
                            issleep = false;
                            getlocation = false;
                            setlocation = false;
                            istalk = false;
                            acceptfindperson2 = true;
                            iseat = true;
                            AskInput3 = "please type what you want the person to eat";
                            Whatisusertyping = "";
                        }
                        else if(mouseX2 > 120 && mouseX2 < 720 && mouseY2 > 300 && mouseY2 < 350) //sleep
                        {
                            getlocation = false;
                            setlocation = false;
                            istalk = false;
                            acceptfindperson2 = true;
                            iseat = false;
                            issleep = true;
                            AskInput3 = personpointer.sleep();
                            Whatisusertyping = "";
                            issleep = false;
                        }
                        else if(mouseX2 > 120 && mouseX2 < 720 && mouseY2 > 400 && mouseY2 < 450) //get location
                        {
                            issleep = false;
                            istalk = false;
                            iseat = false;
                            setlocation = false;
                            getlocation = true;
                            acceptfindperson2 = true;
                            AskInput3 = personpointer.getlocation();
                            Whatisusertyping = "";
                        }
                        else if(mouseX2 > 120 && mouseX2 < 720 && mouseY2 > 500 && mouseY2 < 550) //change location
                        {
                            issleep = false;
                            iseat = false;
                            istalk = false;
                            getlocation = false;
                            setlocation = true;
                            acceptfindperson2 = true;
                            AskInput3 = "please type where the person will relocate";
                            Whatisusertyping = "";  
                        }
                    }
                    else if(AcessPerson)
                    {
                        if(mouseX2 > 120 && mouseX2 < 720 && mouseY2 > 100 && mouseY2 < 200) //get list of people
                        {
                            findperson = false;
                            AskInput3 = Person.getPeopleList();
                        }
                        else if(mouseX2 > 120 && mouseX2 < 720 && mouseY2 > 300 && mouseY2 < 400) //choose specific person
                        {
                            //Person.getPerson(0);
                            findperson = true;
                        }
                    }

                }
                
/////////////////////////////////////////////////////

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
               
                if(TakeClass) //if you clicked the take class button
                {
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
                }

//////////////////////////////////////////////
                if(CreatePerson || AcessPerson) //if you clicked either creater person or person information button
                {

                    if(findperson) //once you clicked to choose a specific individual you will press 0-9 to decide between your list of people
                    {
                        if (e.VK_0 == e.getKeyCode()) {
                            personpointer = Person.getPerson(0);
                            acceptfindperson = true;
                        }
                        else if (e.VK_1 == e.getKeyCode()) {
                            personpointer = Person.getPerson(1);
                            acceptfindperson = true;
                        }
                        else if (e.VK_2 == e.getKeyCode()) {
                            personpointer = Person.getPerson(2);
                            acceptfindperson = true;
                        }
                        else if (e.VK_3 == e.getKeyCode()) {
                            personpointer = Person.getPerson(3);
                            acceptfindperson = true;
                        }
                        else if (e.VK_4 == e.getKeyCode()) {
                            personpointer = Person.getPerson(4);
                            acceptfindperson = true;
                        }
                        else if (e.VK_5 == e.getKeyCode()) {
                            personpointer = Person.getPerson(5);
                            acceptfindperson = true;
                        }
                        else if (e.VK_6 == e.getKeyCode()) {
                            personpointer = Person.getPerson(6);
                            acceptfindperson = true;
                        }
                        else if (e.VK_7 == e.getKeyCode()) {
                            personpointer = Person.getPerson(7);
                            acceptfindperson = true;
                        }
                        else if (e.VK_8 == e.getKeyCode()) {
                            personpointer = Person.getPerson(8);
                            acceptfindperson = true;
                        }
                        else if (e.VK_9 == e.getKeyCode()) {
                            personpointer = Person.getPerson(9);
                            acceptfindperson = true;
                        }
                    }

///////////////

                    //the below is how we will record and save what letters the user types on their keyboard
                    if (e.VK_A == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "A";
                        else if(askpersonname2)
                            createlastname += "A";
                        else if(asklocation)
                            createlocation += "A";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "A";
                        }
                    }
                    else if (e.VK_B == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "B";
                        else if(askpersonname2)
                            createlastname += "B";
                        else if(asklocation)
                            createlocation += "B";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "B";
                        }
                    }
                    else if (e.VK_C == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "C";
                        else if(askpersonname2)
                            createlastname += "C";
                        else if(asklocation)
                            createlocation += "C";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "C";
                        }
                    }
                    else if (e.VK_D == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "D";
                        else if(askpersonname2)
                            createlastname += "D";
                        else if(asklocation)
                            createlocation += "D";
                        else if(asktitle)
                            createtitle += "D";  
                            
                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "D";
                        }
                    }
                    else if (e.VK_E == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "E";
                        else if(askpersonname2)
                            createlastname += "E";
                        else if(asklocation)
                            createlocation += "E";
                        else if(asktitle)
                            createtitle += "E";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "E";
                        }
                    }
                    else if (e.VK_F == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "F";
                        else if(askpersonname2)
                            createlastname += "F";
                        else if(asklocation)
                            createlocation += "F";
                        else if(asktitle)
                            createtitle += "F";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "F";
                        }
                    }
                    else if (e.VK_G == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "G";
                        else if(askpersonname2)
                            createlastname += "G";
                        else if(asklocation)
                            createlocation += "G";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "G";
                        }
                    }
                    else if (e.VK_H == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "H";
                        else if(askpersonname2)
                            createlastname += "H";
                        else if(asklocation)
                            createlocation += "H";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "H";
                        }
                    }
                    else if (e.VK_I == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "I";
                        else if(askpersonname2)
                            createlastname += "I";
                        else if(asklocation)
                            createlocation += "I";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "I";
                        }
                    }
                    else if (e.VK_J == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "J";
                        else if(askpersonname2)
                            createlastname += "J";
                        else if(asklocation)
                            createlocation += "J";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "J";
                        }
                    }
                    else if (e.VK_K == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "K";
                        else if(askpersonname2)
                            createlastname += "K";
                        else if(asklocation)
                            createlocation += "K";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "k";
                        }
                    }
                    else if (e.VK_L == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "L";
                        else if(askpersonname2)
                            createlastname += "L";
                        else if(asklocation)
                            createlocation += "L";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "L";
                        }
                    }
                    else if (e.VK_M == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "M";
                        else if(askpersonname2)
                            createlastname += "M";
                        else if(asklocation)
                            createlocation += "M";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "M";
                        }
                    }
                    else if (e.VK_N == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "N";
                        else if(askpersonname2)
                            createlastname += "N";
                        else if(asklocation)
                            createlocation += "N";
                        else if(asktitle)
                            createtitle += "N";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "N";
                        }
                    }
                    else if (e.VK_O == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "O";
                        else if(askpersonname2)
                            createlastname += "O";
                        else if(asklocation)
                            createlocation += "O";
                        else if(asktitle)
                            createtitle += "O";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "O";
                        }
                    }
                    else if (e.VK_P == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "P";
                        else if(askpersonname2)
                            createlastname += "P";
                        else if(asklocation)
                            createlocation += "P";
                        else if(asktitle)
                            createtitle += "P";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "P";
                        }
                    }
                    else if (e.VK_Q == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "Q";
                        else if(askpersonname2)
                            createlastname += "Q";
                        else if(asklocation)
                            createlocation += "Q";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "Q";
                        }
                    }
                    else if (e.VK_R == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "R";
                        else if(askpersonname2)
                            createlastname += "R";
                        else if(asklocation)
                            createlocation += "R";
                        else if(asktitle)
                            createtitle += "R";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "R";
                        }
                    }
                    else if (e.VK_S == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "S";
                        else if(askpersonname2)
                            createlastname += "S";
                        else if(asklocation)
                            createlocation += "S";
                        else if(asktitle)
                            createtitle += "S";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "S";
                        }
                    }
                    else if (e.VK_T == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "T";
                        else if(askpersonname2)
                            createlastname += "T";
                        else if(asklocation)
                            createlocation += "T";
                        else if(asktitle)
                            createtitle += "T";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "T";
                        }
                    }
                    else if (e.VK_U == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "U";
                        else if(askpersonname2)
                            createlastname += "U";
                        else if(asklocation)
                            createlocation += "U";
                        else if(asktitle)
                            createtitle += "U";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "U";
                        }
                    }
                    else if (e.VK_V == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "V";
                        else if(askpersonname2)
                            createlastname += "V";
                        else if(asklocation)
                            createlocation += "V";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "V";
                        }
                    }
                    else if (e.VK_W == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "W";
                        else if(askpersonname2)
                            createlastname += "W";
                        else if(asklocation)
                            createlocation += "W";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "W";
                        }
                    }
                    else if (e.VK_X == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "X";
                        else if(askpersonname2)
                            createlastname += "X";
                        else if(asklocation)
                            createlocation += "X";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "X";
                        }
                    }
                    else if (e.VK_Y == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "Y";
                        else if(askpersonname2)
                            createlastname += "Y";
                        else if(asklocation)
                            createlocation += "Y";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "Y";
                        }
                    }
                    else if (e.VK_Z == e.getKeyCode()) {
                        if(askpersonname1)
                            createfirstname += "Z";
                        else if(askpersonname2)
                            createlastname += "Z";
                        else if(asklocation)
                            createlocation += "Z";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += "Z";
                        }
                    }
                    else if(e.VK_SPACE == e.getKeyCode()) //allows you to use spaces
                    {
                        if(askpersonname1)
                            createfirstname += " ";
                        else if(askpersonname2)
                            createlastname += " ";
                        else if(asklocation)
                            createlocation += " ";
                        else if(asktitle)
                            createtitle += " ";

                        if(istalk || iseat || issleep || setlocation)
                        {
                            Whatisusertyping += " ";
                        }
                    }
                    else if(e.VK_BACK_SPACE == e.getKeyCode()) {   //allows you to backspace
                        //the below creates an array of the current word then removes the last character entered, then combines it back to a full word
                        String str[] = Whatisusertyping.split("");
                        ArrayList<String> strList = new ArrayList<String>(Arrays.asList(str));
                        strList.remove((strList.size()-1)); 

                        String listString = String.join("", strList); 
                        
                        if(askpersonname1)
                        {
                            createfirstname = listString;
                        }
                        else if(askpersonname2)
                        {
                            createlastname = listString;
                        }
                        else if(asklocation)
                        {
                            createlocation = listString;
                        }
                        else if(asktitle)
                        {
                            createtitle = listString;
                        }

                    }
        
///////////////

                    if (e.VK_ENTER == e.getKeyCode())
                    {
                        //the below if/else ifs allow the change in questions when asking for a person's information
                        if(askpersonname1)
                        {
                            askpersonname1 = false;
                            askpersonname2 = true;
                        }
                        else if(askpersonname2)
                        {
                            askpersonname2 = false;
                            if(CreatePerson)
                                asklocation = true;
                        }
                        else if(asklocation)
                        {
                            asklocation = false;
                            asktitle = true;
                        }
                        else if(asktitle)
                        {
                            asktitle = false;
                        }
                        else 
                        {

                            if(CreatePerson)
                            {
                                if(createtitle.equals("PROFESSOR")) //creating a professor
                                {
                                    Professor prof = new Professor(createfirstname, createlastname, createlocation, Person.Title.PROFESSOR);
                                    personpointer = prof;
                                    Person.setPeopleList(personpointer);
                                    readytocreate = true;
                                }
                                else if(createtitle.equals("STUDENT")) //creating a student
                                {
                                    Student stud = new Student(createfirstname, createlastname, createlocation, Person.Title.STUDENT);
                                    personpointer = stud;
                                    Person.setPeopleList(personpointer);
                                    readytocreate = true;
                                    
                                }
                            }

                            if(istalk) //returns talking phrase
                            {
                                AskInput3 = personpointer.talk(Whatisusertyping);
                                istalk = false;
                            }
                            else if(iseat) //returns eating phrase
                            {
                                AskInput3 = personpointer.eat(Whatisusertyping);
                                iseat = false;
                            }
                            else if(setlocation) //returns changing location phrase
                            {
                                personpointer.setlocation(Whatisusertyping);
                                setlocation = false;
                            }
 
                        }

                    }


                    
                }
                
//////////////////////////////////////////////
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

        g.setColor(Color.BLACK);
        g.drawLine(770, 100, 830, 150);
        g.drawLine(770, 150, 830, 100);

//////////////all the below represents the different stages that have buttons in them
        if(DefaultButtons) //first set of buttons
        {
            g.setColor(Color.RED);
            g.fillRect(Window.getWidth2()/7, 100, 600, 100);

            g.fillRect(Window.getWidth2()/7, 500, 600, 100);

            g.fillRect(Window.getWidth2()/7, 300, 600, 100);

            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial Black", Font.PLAIN, 20));
            g.drawString("Should I Take This Class?", Window.getWidth2()/3, 150);

            g.drawString("Create Person", Window.getWidth2() * 2/5, 550);

            g.drawString("Access A Person", Window.getWidth2() * 2/5, 350);
        }
        else if(TakeClass) //displays for the take class stage
        {

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

        }
        else if(CreatePerson) //displays for the create person stage
        {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial Black", Font.PLAIN, 20));
            g.drawString(AskInput2, 30, 200);

            g.setColor(Color.BLUE);
            g.drawString("Press 'Enter' to submit your answer", 50, 300);
        }
        else if(AcessPerson) //displays for picking people stage
        {
            if(acceptfindperson)//displays for person information stage
            {
                g.setColor(Color.RED);
                g.fillRect(Window.getWidth2()/7, 100, 600, 50);

                g.fillRect(Window.getWidth2()/7, 200, 600, 50);

                g.fillRect(Window.getWidth2()/7, 300, 600, 50);

                g.fillRect(Window.getWidth2()/7, 400, 600, 50);

                g.fillRect(Window.getWidth2()/7, 500, 600, 50);

///////////             

                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial Black", Font.PLAIN, 20));
                g.drawString("Make Person Talk", Window.getWidth2() * 2/5, 125);

                g.drawString("Make Person Eat", Window.getWidth2() * 2/5, 225);

                g.drawString("Make Person Sleep", Window.getWidth2() * 2/5, 325);

                g.drawString("Get Person's Location", Window.getWidth2() * 2/5, 425);

                g.drawString("Change Person's Location", Window.getWidth2() * 2/5, 525);
            }
            else
            {
                g.setColor(Color.RED);
                g.fillRect(Window.getWidth2()/7, 100, 600, 100);

                g.fillRect(Window.getWidth2()/7, 300, 600, 100);

                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial Black", Font.PLAIN, 20));
                g.drawString("Get List of People", Window.getWidth2()/3, 150);

                g.drawString("Find Person", Window.getWidth2() * 2/5, 350);
            }

            g.drawString(AskInput3, 20, 650);
        }

        g.setColor(Color.BLUE);
        g.drawString(Whatisusertyping,20,700);


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

        DefaultButtons = true;
        TakeClass = false;
        CreatePerson = false;
        AcessPerson = false;
        findperson = false;
        acceptfindperson = false;
        acceptfindperson2 = false;

        AskInput3 = "";
        Whatisusertyping = "";

        istalk = false;
        issleep = false;
        iseat = false;
        getlocation = false;
        setlocation = false;

        resettakeclassstats();
        resetcreateperson();

    }

    public void resettakeclassstats() {
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

    public void resetcreateperson() {
        AskInput2 = "";
        askpersonname1 = true;
        askpersonname2 = false;
        asklocation = false;
        asktitle = false;

        createfirstname = "";
        createlastname = "";
        createlocation = "";
        createtitle = "";

        personpointer = null;

        readytocreate = false;
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
    if(TakeClass)
    {
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

    if(CreatePerson)
    {
        if(askpersonname1)
        {
            AskInput2 = "Please enter the person's first name";
            Whatisusertyping = createfirstname;
        }
        else if(askpersonname2)
        {
            AskInput2 = "Please enter the person's last name";
            Whatisusertyping = createlastname;
        }
        else if(asklocation)
        {
            AskInput2 = "Please enter the person's location";
            Whatisusertyping = createlocation;
        }
        else if(asktitle)
        {
            AskInput2 = "Please enter whether the person is a professor or student";
            Whatisusertyping = createtitle;
        }
        else if(readytocreate)
        {
            AskInput2 = "You created Person - " + personpointer.toString2();
            //System.out.println(personpointer.getfirst());
            readytocreate = false;
        }
    }

    if(AcessPerson)
    {
        //doesn't work because I set these value back to false
        if(acceptfindperson && !acceptfindperson2)
        {
            AskInput3 = "You have picked " + personpointer.toString2();
            findperson = false;
        }
        else if(findperson)
        {
            AskInput3 = "Please press number 0-9 that corresponds with the order of people listed";
        }
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
