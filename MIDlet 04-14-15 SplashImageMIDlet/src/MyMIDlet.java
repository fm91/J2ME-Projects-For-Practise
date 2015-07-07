import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class MyMIDlet extends MIDlet
                      implements CommandListener 
{
    private ImageItem imageItem;
    private Image image;
    private Form form;
    private Display display;
    private Command exitCommand = new Command( 
                         "Exit", Command.EXIT, 1 );
    private Command nextCommand = new Command( 
                         "Next", Command.OK, 1 );

    public MyMIDlet(){
try{
  image = Image.createImage("/leaf2.png");
  } catch (Exception e){ }
  imageItem = new ImageItem("", 
  image, ImageItem.LAYOUT_CENTER | ImageItem.LAYOUT_NEWLINE_BEFORE, null);
}

    protected void destroyApp(boolean unconditional )
               throws MIDletStateChangeException {
        exitMIDlet();
    }

    protected void pauseApp(){}

    protected void startApp() 
                throws MIDletStateChangeException {
        if( display == null ){
            // first time called...
            initMIDlet();
        }
    }

    
  

    private void initMIDlet(){
        display = Display.getDisplay( this );
        new SplashScreen(display, new TrivialForm() );
    }

    public void exitMIDlet(){
        notifyDestroyed();
    }

    public void commandAction(Command c, Displayable d ){
        exitMIDlet();
    }


    // A trivial UI screen

    class TrivialForm extends Form {
        TrivialForm(){
            super( "MyMIDlet" );
            addCommand( exitCommand );
            addCommand(nextCommand);
            setCommandListener( MyMIDlet.this );
           form = new Form("Loading...");
          form.append(imageItem);
           
           display.setCurrent(form);
        }
    }

   
}
