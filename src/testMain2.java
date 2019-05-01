import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JFileChooser;   

//String name, double cost, String acquired, String expired, String date
class testMain2 {
	  public static void main(String[] args) throws FileNotFoundException {
		  PrintStream backToMain = System.out;
		  HigherLevel rn = new HigherLevel();
System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
		+"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
		+"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
		+"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
rn.choice1();
rn.addItem("Appliances", "Washer");
rn.setDayWarranty("Washer", 16);
rn.setPrice("Washer", 20.00);
//--------------------
//SAVED
String dateInt = LocalDate.now().toString(); //grab current date
String workingDate = (dateInt.substring(0, 4)+dateInt.substring(5, 7)+dateInt.substring(8, 10)); //turn date turn it into usable String.
String now = LocalDateTime.now().toString();
String workingTime = (now.substring(11, 13) + now.substring(14, 16)+now.substring(17, 19)+now.substring(21,21));
PrintStream out = new PrintStream(new FileOutputStream("C:/Users/tylor/Desktop/220Project/SavedOn" + workingDate + " TIME " + workingTime + ".txt"));
System.setOut(out);
rn.printAll();
System.setOut(backToMain);
//--------------------
JFileChooser jfc = new JFileChooser(); //establish file picker
jfc.setVisible(true); //make file chooser appear
jfc.showDialog(null,"Please Select the File");
File grabbedfile = jfc.getSelectedFile(); //set "filename" equal to the file that was chosen by the user
String thisIsGonnaHurt = "";
try {
	FileReader fileReader = new FileReader(grabbedfile);
	BufferedReader bufferedReader = new BufferedReader(fileReader);
	String line;
	while ((line = bufferedReader.readLine()) != null) {
	thisIsGonnaHurt += line;
	}
	fileReader.close();
	
} catch (IOException e) {
	e.printStackTrace();
}

System.out.println(thisIsGonnaHurt);

	  }
}
/*
FileReader fileReader = new FileReader(grabbedfile);
int i; 
try {
	while ((i=fileReader.read()) != -1)//go through until end, save current char as I.
	  System.out.print((char) i);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
*/