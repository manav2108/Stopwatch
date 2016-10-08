package stopwatch;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
public class Stopwatch implements ActionListener
{
    JLabel disp=new JLabel();
    JButton start=new JButton();
    JButton stop=new JButton();
    JButton lap=new JButton();
    double t1,t2;
    int i;
    boolean flag=false;
        Stopwatch()
        {
        JFrame f=new JFrame();
        f.setLayout(null);
        f.setSize(550, 300);
        f.setLocation(0,0);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Stopwatch");
        //---------------------
        start.setSize(100, 50);
        start.setLocation(50,150);
        start.setText("Start");
        //-----------------------
        stop.setSize(100, 50);
        stop.setLocation(200,150);
        stop.setText("Stop");
        //-----------------------
        lap.setSize(100, 50);
        lap.setLocation(350,150);
        lap.setText("Lap");
        //------------------------
        disp.setText("00.000");
        disp.setSize(500,100);
        disp.setLocation(50,50);
        disp.setForeground(Color.red);
        disp.setFont(new Font("Arial",Font.PLAIN,25));
        //------------------------
        start.addActionListener(this);
        stop.addActionListener(this);
        lap.addActionListener(this);
        //------------------------
        f.add(disp);
        f.add(start);
        f.add(stop);
        f.add(lap);
        f.setVisible(true);
    }
        public void actionPerformed(ActionEvent ae)
        {
            Calendar cal = Calendar.getInstance();
            if(ae.getActionCommand().equals("Start"))
            {
                if(!flag)
                {
                start.setForeground(Color.white);
                flag=true;
                t1=cal.getTimeInMillis();
                disp.setText("StopWatch is Running");
                lap.setForeground(Color.black);
                }
                else;
            }
            else if(ae.getActionCommand().equals("Stop"))
            {
                if(flag)
                {
                    t2=cal.getTimeInMillis();
                    disp.setText("Elapsed time is:"+((t2-t1)/1000)+"Seconds");
                    flag=false;
                    i=1;//resets lap count
                    start.setForeground(Color.black);
                    lap.setForeground(Color.white);
                }
                else;
            }
            else
            {
                if(flag)
                {
                    t2=cal.getTimeInMillis();
                    disp.setText("LAP:"+i+" Elapsed time is: "+((t2-t1)/1000)+" Seconds");
                    t1=t2;
                    i++;
                    flag=true;
                }
                else;
            }
        }
}
