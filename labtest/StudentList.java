package labtest;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import static labtest.Constants.*;

public class StudentList {

	public static String LoadData() {
		System.out.println(StartDialog);
		String reader = null;
		try {
			BufferedReader stream = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(DataFile)));
			reader = stream.readLine();
		} catch (Exception e) {

		}
		return reader;
	}
public static void WriteData ( String[] args){
	System.out.println(StartDialog);
	try {
		BufferedWriter s = new BufferedWriter(
				new FileWriter(DataFile, true));
		String t = args[0].substring(1);
		Date d = new Date();
		String df = "dd/mm/yyyy-hh:mm:ss a";
		DateFormat dateFormat = new SimpleDateFormat(df);
		String fd= dateFormat.format(d);
		s.write(", "+t+"\nList last updated on "+fd);
		s.close();
	} catch (Exception e){

	}
	System.out.println("Data Loaded.");
}
	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("Usage : java StudentList a|r|c|?word|+word");
			return;
		}


//		Check arguments
		if (args[0].equals(ShowAll)) {
			String reader = LoadData();
			String i[] = reader.split(",");
			for (String j : i) {
				System.out.println(j);
			}
			System.out.println(finish);
		}

		else if(args[0].equals("r"))
		{
			String r = LoadData();
			System.out.println(r);
			String i[] = r.split(",");
			Random x = new Random();
				int y = x.nextInt();
					System.out.println(i[y]);
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("+")){
			WriteData(args);
		}
		else if(args[0].contains("?"))
		{
			String r = LoadData();
			String i[] = r.split(",");
			String t = args[0].substring(1);
			for(int idx = 0; idx<i.length; idx++) {
				if(i[idx].equals(t)) {
					System.out.println("We found it!");
					break;
				}
			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("c"))
		{
			String D = LoadData();
			char a[] = D.toCharArray();
			String i[] = D.split(",");
			int words = i.length;
			System.out.println(words +" word(s) found " + a.length);
			System.out.println(finish);
		}
	}
}
//mui to sashhhhhhhh