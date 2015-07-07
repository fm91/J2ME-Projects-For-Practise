import java.util.*;
import javax.microedition.lcdui.*;

public class SplashScreen extends Canvas 
{
    private Display     display;
    private Displayable next;
    private Timer       timer = new Timer();

    public SplashScreen(Display display, Displayable next)
    {
        this.display = display;
        this.next = next;
        display.setCurrent( this );
    }

    protected void keyPressed( int keyCode ){
        dismiss();
    }

    protected void paint( Graphics g ){
        // do your drawing here
    }

    protected void pointerPressed( int x, int y ){
        dismiss();
    }

    protected void showNotify()
    // called automatically when the Canvas is put on screen
    {  timer.schedule( new CountDown(), 5000 );  
               // CountDown started after 5 secs
    }

    private void dismiss(){
        timer.cancel();
        display.setCurrent( next );
    }

    // ----------------------------------------
    private class CountDown extends TimerTask 
    {
        public void run(){
            dismiss();
        }
    }
}