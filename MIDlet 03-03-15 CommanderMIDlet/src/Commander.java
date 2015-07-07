import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
public class Commander extends MIDlet {
public void startApp() {

Displayable d = new TextBox("TextBox", "Commander", 20, TextField.ANY);
Command c = new Command("Exit", Command.EXIT, 0);
Command menu1 = new Command("Menu", Command.OK, 1);
Command menu2 = new Command("Menu1", Command.OK, 1);
d.addCommand(c);
d.addCommand(menu1);
d.addCommand(menu2);
d.setCommandListener(new CommandListener() {
public void commandAction(Command c, Displayable s) {
notifyDestroyed();
}
} );
Ticker ticker = new Ticker("This is the ticker message!");
d.setTicker(ticker);

Display.getDisplay(this).setCurrent(d);
}
public void pauseApp() { }
public void destroyApp(boolean unconditional) { }
}