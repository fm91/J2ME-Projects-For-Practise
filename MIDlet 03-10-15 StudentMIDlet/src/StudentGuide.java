import javax.microedition.lcdui.*;
import javax.microedition.midlet.*; 
import java.io.*;
public class StudentGuide extends MIDlet implements CommandListener
{
 private Form form;
 private Display display;
 
 private Command frm, dsp, txtB,tcker, alrt, sstem, comd;
 private StringItem item;

 public StudentGuide()
 {
  
 }
 public void startApp()
 {
 
  display = Display.getDisplay(this);
  Form form = new Form("StudentBoard");
  form.append("Welcome to the StudentGuide MIDlet.\n"+
"This App Will Help You Review WTK Objects");
  item = new StringItem("Chose an object from the menu:\n", "");
 
  frm = new Command("Form()", Command.OK, 1);
  dsp = new Command("Display()", Command.OK, 1);
  txtB = new Command("TextBox()", Command.OK, 1);
  tcker = new Command("Ticker()", Command.OK, 1);
  alrt = new Command("Alert()", Command.OK, 1);
  sstem = new Command("System()", Command.OK, 1);
  comd = new Command("Command()", Command.OK, 1);
  form.addCommand(frm);
  form.addCommand(dsp);
  form.addCommand(txtB);
  form.addCommand(tcker);
  form.addCommand(alrt);
  form.addCommand(sstem);
  form.addCommand(comd);
  form.append(item);

  form.setCommandListener(this);
  
  display.setCurrent(form);
 }

 public void pauseApp() { }

 public void destroyApp(boolean uncondn)
 {
  notifyDestroyed();
 }
    private void showForm()
 {
  item.setText( "Form():\n"+"Description: Form plays the role of a platform/container for other items. example:\n"+
"Form form = new Form(\"Form Title\");\n"+
"StringItem stringItem = new StringItem(\"Label\", Value);\n"+
"form.append(stringItem);");

 }
 private void showDisplay()
 {
  item.setText("Display():\n"+
"manages devices screen.We can get a reference to the device's display using this example:\n"+
"Display ourDisplay = Display.getDisplay(this)\n"+
"Later in our code we can set the current display to the Form or TextBox we created using the following method:\n"+
"setCurrent(Displayable nextDisplayable)\n"+
"• nextDisplayable: the Displayable that will be shown to the user, such as Forms or TextBoxes\n"+
"• alert: the alert which will be shown before a Displayable, meaning that the Displayable will be shown after the user acknowledges the alert.");

 }
 private void showTextBox()
 {
  item.setText("TextBox():\n"+
"The simplest type of screen is the TextBox. TextBox allows the user to enter a string.\n"+
"example: public TextBox(String title, String text, int maxSize, int constraints)\n"+
"   title: title of the screen.\n"+
"   text: the text displayed.\n"+
"   maxSize: maximum number of characters\n"+
"   constraints: restrictions on inputs:\n"+
"      • ANY allows any type of input that is supported by the device.\n"+
 "     • NUMERIC restricts the input to integers.\n"+
 "     • DECIMAL allows numbers with fractional parts.\n"+
 "     • PHONENUMBER requires a telephone number.\n"+
 "     • EMAILADDR input must be an e-mail address.\n"+
 "     • URL input must be a web address." );

 }
 private void showTicker()
 {
  item.setText("Ticker():\n"+
"A ticker is simply a bit of text that scrolls across the top of a Displayable; it is named after oldfashioned stock tickers.\n"+
"The Ticker class is a simple wrapper for a string. To add a ticker to a screen, you would do something like this:\n"
+"// Displayable d = ...\n"+
"Ticker ticker = new Ticker(\"This is the ticker message!\");\n"+
"d.setTicker(ticker);");

 }
 private void showAlert()
 {
  item.setText("Alert():\n"+
"An alert is an informative message shown to the user. In the MIDP universe, there are two flavors of alert:\n"+
"• A timed alert is shown for a certain amount of time, typically just a few seconds.\n"+
"• A modal alert stays up until the user dismisses it.\n"+
"example:\n\n"+
"Alert aName = new Alert(\"ERROR\", \"We Have An Error!!\", null, AlertType.INFO)");

 }
 private void showSystem()
 {

  item.setText( "System() :\n"+
"System provide access to the Java Virtual Machine (JVM) and system-wide resources. This class is greatly reduced from its J2SE counterparts, so much so that it makes sense to reproduce its entire public API here:\n\n"+
"public final class System \n"+
"extends java.lang.Object { \n"+
"// Constants \n"+
"public static final PrintStream err; \n"+
"public static final PrintStream out; \n"+
"// Static methods \n"+
"public static void arraycopy(Object src, int src_position, \n"+
"Object dst, int dst_position, int length); \n"+
"public static long currentTimeMillis(); \n"+
"public static void exit(int status); \n"+
"public static void gc(); \n"+
"public static String getProperty(String key); \n"+
"public static int identityHashCode(Object x); \n"+
"}\n\n"+
"System.out.print() is also used to debug apps");
 }
 private void showCommand()
 {
  item.setText("Command():\n"+
"In MIDP, commands are represented by instances of the Command class. To create a Command, just supply a name, a type, and a priority. example:\n\n"+
"Command cName = new Command(\"Title\", Command.type*, priority)\n\n"+
"    name: name of the command on the screen.\n"+
"    priority: determines which commands stay on the screen when there are too many.\n"+
"    .type : signifies commonly used commands like:\n"+
"    OK, CANCEL, BACK, STOP, HELP, SCREEN");

 }
 public void commandAction(Command c, Displayable d)
 {
  String label = c.getLabel();
  if (label.equals("Form()"))
  {
   showForm();
   
  }
  
  else if (label.equals("Display()"))
  {
   showDisplay();
   
  }
  
  else if (label.equals("Ticker()"))
  {
   showTicker();
   
  }
  
  else if (label.equals("Command()"))
  {
   showCommand();
  }
  else if (label.equals("TextBox()"))
  {
   showTextBox();
   
  }
  else if (label.equals("Alert()"))
  {
   showAlert();
   
  }
  else if (label.equals("System()"))
  {
   showSystem();
   
  }
 }
}