import java.awt.*;
import javax.swing.*;

public class DrawingPanel extends JPanel {
  public void paintComponent(Graphics g)
  {
    // clear screen
    g.setColor(Color.white);
    g.clearRect(0,0,500,500);

    {
      //System.out.printf("Design Barker Semester%n");
      int x = 0;
      int y = 0;
      int s = 0;
      Rectangle sky,ground;
      Color red,orange,yellow,green,blue,indigo,violet;
      red = new Color(225,0,0); //set colors
      orange = new Color(0xFF,0xA5,0);
      yellow = new Color(0xFF,0xFF,0);
      blue = new Color(0,0,225);
      indigo = new Color(0x4B,0,0x82);
      violet = new Color(0xEE,0x82,0xEE);
      //background (rectangles)
      sky = new Rectangle(x,y,500,166,new Color(0x87,0xCE,0xFA));
      sky.draw(g);
      ground = new Rectangle(x,166,500,334,new Color(0xF0,0xF8,0xFF));
      ground.draw(g);
      //Random stars
      for(int k=0;k<15;k++)
      {
        star(g,5 +(int)(Math.random()*16),(int)(Math.random()*500),(int)(Math.random()*110),yellow);
      }
      tree(g,200,s+100,s+100);
      reindeer(g,350,300);
      santa(g,x,y);
      present(g,200,350,50,indigo,violet);
      present(g,178,380,35,orange,blue);
      present(g,230,380,40,red,orange);
    }
  }
  public static void santa(Graphics g,int x,int y)
  {
      Circle santa,ball;
      Rectangle belt;
      Triangle hat;
      Color darkred = new Color(0x8B,0,0);
      Color white = new Color(0xFF,0xFF,0xFF);
      Color black = new Color(0,0,0);
      santa = new Circle(x+192,y+173,36,darkred);
      santa.draw(g);
      santa = new Circle(x+146,y+216,80,darkred);
      santa.draw(g);
      belt = new Rectangle(x+193,y+216,70,8,white);
      belt.draw(g);
      belt = new Rectangle(x+146,y+295,160,10,black);
      belt.draw(g);
      hat = new Triangle(x+228,y+250,35,-45,black);
      hat.draw(g);
      hat.setB(-35);
      hat.draw(g);
      hat = new Triangle(x+228,y+249,34,-44,darkred);
      hat.draw(g);
      hat.setB(-34);
      hat.draw(g);
      ball = new Circle(x+218,y+250,10,white);
      ball.draw(g);
  }
  public static void present(Graphics g,int x,int y,int s,Color c1,Color c2)
  {
      Rectangle box,ribbon;
      box = new Rectangle(x,y,s,s,c1);
      ribbon = new Rectangle(x+s/3,y,s/6,s,c2);
      box.draw(g);
      ribbon.draw(g);
      ribbon = new Rectangle(x,y+s/3,s,s/6,c2);
      ribbon.draw(g);
  }
  public static void reindeer(Graphics g,int x,int y)
  {
      //int y=125;
      Rectangle body,antler;
      Triangle face,feet,tail;
      Circle nose,eyes;
      Color peru = new Color(0xCD,0x85,0x3F);
      Color red = new Color(255,0,0);
      Color darkperu = new Color(0xB3,0x74,0x35);
      //body (rectangles)
      body = new Rectangle(x+40,y+75,15,50,peru);
      body.draw(g); //front left leg
      body.setX(x+75);
      body.draw(g); //back left leg
      body.setColor(darkperu);
      body.setX(x+20);
      body.draw(g);//front right leg
      body.setX(x+55);
      body.draw(g);//back right leg
      body = new Rectangle(x+20,y+56,70,35,peru);
      body.draw(g); //body
      body = new Rectangle(x+20,y+41,20,50,darkperu);
      body.draw(g); //neck
      tail = new Triangle(x+90,y+46,-10,10,darkperu);
      tail.draw(g);
      //feet
      feet = new Triangle(x+40,y+115,15,10,new Color(0,0,0));
      feet.draw(g);
      feet.setX(x+55);
      feet.draw(g);
      feet.setX(x+75);
      feet.draw(g);
      feet.setX(x+20);
      feet.draw(g);
      //antlers (rectangle)
      antler = new Rectangle(x+29,y+5,8,15,new Color(0x4E,0x34,0));
      antler.draw(g);
      antler.setX(x+13);
      antler.draw(g);
      //face (2 triangles)
      face=new Triangle(x+25,y+70,25,-50,peru);  
      face.draw(g);
      face.setB(-25);
      face.draw(g);
      //nose (circle) //You can even see it GLOW!
      if((double)Math.random()*3>2)
        nose=new Circle(x+18,y+56,7,red);
      else
        nose=new Circle(x+18,y+56,7,new Color(0x8B,0,0));
      nose.draw(g);
      //eyes (circle)
      eyes=new Circle(x+25,y+30,8,new Color(0xFF,0xFF,0xFF));
      eyes.draw(g);
      eyes.setX(x+9);
      eyes.draw(g);
      eyes=new Circle(x+25,y+30,7,new Color(0,0,0)); //pupils
      eyes.draw(g);
      eyes.setX(x+9);
      eyes.draw(g);
  }
  public static void tree(Graphics g,int s,int x,int y)
  {
      int q=s/3;
      if(q==0)
        q=1;
      Triangle tree;
      Rectangle trunk;
      Color darkgreen = new Color(0,0x64,0);
      tree=new Triangle(x,y,q,s,darkgreen);  
      tree.draw(g);
      tree.setB(-q);
      tree.draw(g);
      trunk = new Rectangle(x-q/4,y+s,q/2,s/4,new Color(0x4E,0x34,0));
      trunk.draw(g);
      star(g,s/8,x,y-15,new Color(0xF0,0xE6,0x8C));
  }
  public static void star(Graphics g,int s,int x,int y,Color c)
  {
      int q=s/3;
      Triangle vert,horiz;
      if(q==0)
        q=1;
      vert=new Triangle(x,y,q,s,c);
      vert.draw(g);
      vert.setB(-q);
      vert.draw(g);
      vert.setY(y+2*s);
      vert.setH(-s);
      vert.draw(g);
      vert.setB(q);
      vert.draw(g);
      horiz= new Triangle(x,y+s-q,s,q,c);
      horiz.draw(g);
      horiz.setB(-s);
      horiz.draw(g);
      horiz.setY(horiz.getY()+2*q);
      horiz.setH(-q);
      horiz.draw(g);
      horiz.setB(s);
      horiz.draw(g);
  }
}
