/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.application.Application;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author ayesha
 */

class arrow extends Line{
    double initialX1=149;
    double initialY1=273;
    double initialX2=189;
    double initialY2=233;
    double xx;
    double yy;
    double time=0;
    double speed=120;
    int angle=60;
    double gravity=10;
    double pi=3.1416;
    arrow(double x1,double y1,double x2,double y2,AnchorPane root, double radius,Color color){
       
       super(x1,y1,x2,y2);
       initialX1=x1;
       initialY1=y1;
       initialX2=x2;
       initialY2=y2;
       
       root.getChildren().add(this);
    }
    public void updateArrow()
    {
        initialX2=initialX2*0.9;
        xx=(initialX1)+speed*(cos(angle*pi/180)*time);
        yy=(initialY1)-(speed*(sin(angle*pi/180)*time)-.5*gravity*time*time);
        setStartX(initialX1+speed*(cos(angle*pi/180)*time));
        setStartY(initialY1-(speed*(sin(angle*pi/180)*time)-.5*gravity*time*time));
        setEndX((initialX2)+speed*(cos(angle*pi/180)*time));
        setEndY((initialY2)-(speed*(sin(angle*pi/180)*time)-.5*gravity*time*time));
        
        time+=.1;    
    }
    public void updateArrow2()
    {
        initialY2=initialY2/0.995;
        setStartX(initialX1+speed*(cos(angle*pi/180)*time));
        setStartY(initialY1-(speed*(sin(angle*pi/180)*time)-.5*gravity*time*time));
        setEndX((initialX2)+speed*(cos(angle*pi/180)*time));
        setEndY((initialY2)-(speed*(sin(angle*pi/180)*time)-.5*gravity*time*time));
        
        time+=.1;    
    }
    public void stop()
    {
        
    }
    public void setarrowAngle(int ang)
    {
        angle = ang;
    }
    
    public void setarrowSpeed(int spd)
    {
        speed=spd;
    }
    double getxx()
    {
       return xx; 
    }
    double getyy()
    {
       return yy; 
    }
}



public class Main extends Application {
    Text txt= new Text(140,40,"X");
    Text txt1= new Text(1125,40,"X");
    double ang=0;
    double spd=60;
    double iniX;
    double iniY;
    int flag=0;

    void SETANGLE(double xx,double yy)
    {
        double x=xx-iniX;
        double y=iniY-yy;
        System.out.println(x);
        System.out.println(y);
        ang= 180*atan2(y,x)/3.1416;
        txt.setText(String.format("%.0f",ang));
    }
    void SETSPEED(double xx,double yy)
    {
        double x=xx-iniX;
        double y=iniY-yy;
        spd=((sqrt(x*x+y*y)));
        txt1.setText(String.format("%.0f",spd));
    }
    @Override
    public void start(Stage primaryStage) {
        Text txt2= new Text(10,40,"ANGLE :");
        Text txt3= new Text(1000,40,"SPEED :");
        txt.setText(String.format("%.0f",ang));
        txt1.setText(String.format("%.0f",spd));
        txt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        txt1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        txt2.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        txt3.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        
        
        double bx=214,by=341;
        
        
        
        AnchorPane root = new AnchorPane();
        BackgroundImage backgroundImage ;        
        Image I=new Image("white.png");      
        backgroundImage=new  BackgroundImage(I,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        root.setBackground(background);
         
        
        Image iv1 = new Image("bowmanalone 1.png");
        ImageView iv2 = new ImageView(iv1);
        iv2.setX(70);
        iv2.setY(225);
        root.getChildren().add(iv2);
        Image iv4 = new Image("bowman2.png");
        ImageView iv3 = new ImageView(iv4);
        iv3.setX(1110);
        iv3.setY(263);
        root.getChildren().add(iv3);
        Image iv5 = new Image("arrow1.png");
        ImageView iv6 = new ImageView(iv5);
        iv6.setX(117);
        iv6.setY(245);
        root.getChildren().add(iv6);
        
        Image iv7 = new Image("arrow2.png");
        ImageView iv8 = new ImageView(iv7);
        
        iv8.setX(1090);
        iv8.setY(255);
        root.getChildren().add(iv8);
        iv8.setRotate(45);
        
        
        root.getChildren().add(txt);
        root.getChildren().add(txt2);
        root.getChildren().add(txt3);
        root.getChildren().add(txt1);
        
        Circle c= new Circle(1173,284,9,Color.BLACK);
        Circle c1= new Circle(112,282,9,Color.BLACK);
        Line l= new Line(1173,290,1173,304);
        Rectangle r= new Rectangle(107,305,10,20);
        r.setFill(Color.BLACK);
        Rectangle r1= new Rectangle(111,291,5,15);
        r1.setFill(Color.BLACK);        
        l.setStrokeWidth(8);
        root.getChildren().addAll(c,l,c1,r1,r);
        
        GridPane grid=new GridPane();
        grid.setAlignment(Pos.BOTTOM_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));       
        Button btn=new Button("PLAY");
        Button btn1=new Button("Sound");
        Button btn2=new Button("Music");
        Button btn3=new Button("EXIT");
        Button btn4=new Button("About");       
        HBox hbox=new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        hbox.getChildren().addAll(btn3,btn);
        grid.add(hbox,1,1);
  
        
        
        
        VBox vbox=new VBox(10);
        vbox.setAlignment(Pos.CENTER);        
        Button btnBack=new Button("BACK");
        Button btnSingle=new Button("PLAY NOW");
        Button btnMulti=new Button("MultiPlayer");
        Button btnLan=new Button("Lan");        
        vbox.getChildren().addAll(btnSingle,btnBack);
        

        
        
        
        
        Scene scene1=new Scene(grid,1180,495);
        Scene scene2=new Scene(vbox,1180,495);
        Scene scene3=new Scene(root,1285,510);
        
        btn.setOnAction(e->primaryStage.setScene(scene2));
        btnBack.setOnAction(e->primaryStage.setScene(scene1));
        btn3.setOnAction(e->exit());
        btnSingle.setOnAction(e->primaryStage.setScene(scene3));
        
        
        scene3.setOnMousePressed(event->{
            iniX=event.getX();
            iniY=event.getY();
            
        });
        
        scene3.setOnMouseDragged(event->{
        SETANGLE(event.getX(),event.getY());
        SETSPEED(event.getX(),event.getY());
        iv6.setRotate((int)ang %20);
        });
        
        
        
        scene3.setOnMouseReleased(event->{
        if(flag==0)
        {
            System.out.println(event.getX()+" "+event.getY());
            SETANGLE(event.getX(),event.getY());
            SETSPEED(event.getX(),event.getY());
            Line line1 = new Line(iniX, iniY,event.getX(),event.getY());
            line1.getStrokeDashArray().addAll(5d, 5d);
            root.getChildren().add(line1);
            double t1=bx; double t2=by;
        //int xxx= (int) ang;
            int xxx= (int) ang;
            int xxxx= (int) spd;
            arrow arr=new arrow(149,273,189,233,root,8,Color.DEEPPINK);
            new AnimationTimer() {
            @Override
            public void handle(long now) {
            
            //root.getChildren().remove(line1);
            if(arr.getxx()>=1174 && arr.getyy()>=269 && arr.getyy()<=364)           
            {
                Circle cc = new Circle(arr.getxx(),arr.getyy(),10,Color.RED);
                cc.setFill(Color.RED);
                root.getChildren().add(cc);
            }
            else
            {
            arr.updateArrow();
            arr.setarrowAngle(xxx);
            arr.setarrowSpeed(xxxx);
            flag=1;                
            }
            }
            }.start();
        }
        if(flag==1)
        {
            //flag=0;
            double t1=1136; double t2=298;
        //int xxx= (int) ang;
            int xxx= (int) ang;
            int xxxx= (int) spd;
            arrow arr=new arrow(1136,298,1096,258,root,8,Color.DEEPPINK);
            new AnimationTimer() {
            @Override
            public void handle(long now) {
            arr.updateArrow2();
            arr.setarrowAngle(xxx);
            arr.setarrowSpeed(xxxx);
            flag=0;
        //root.getChildren().remove(line1);
            }
            }.start();
        }
        });
        

        
        primaryStage.setTitle("AYESHA'S TANK");
        primaryStage.setScene(scene1);
        scene1.getStylesheets().add(Main.class.getResource("new.css").toExternalForm());
        scene2.getStylesheets().add(Main.class.getResource("new.css").toExternalForm());
        //scene3.getStylesheets().add(Main.class.getResource("new.css").toExternalForm());
        primaryStage.show();
    }
            
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
