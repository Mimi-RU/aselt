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
		if (args[0].equals("a")) {
			String reader = LoadData();
			String i[] = reader.split(",");
			for (String j : i) {
				System.out.println(j);
			}
			System.out.println("Data Loaded.");
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
			boolean done = false;
			String t = args[0].substring(1);
			for(int idx = 0; idx<i.length && !done; idx++) {
				if(i[idx].equals(t)) {
					System.out.println("We found it!");
						done=true;
				}
			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("c"))
		{
			System.out.println("Loading data ...");
			try {
			BufferedReader s = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt")));
			String D = s.readLine();
			char a[] = D.toCharArray();
			boolean in_word = false;
			int count=0;
			for(char c:a) {
				if(c ==' ')
				{
					if (!in_word) {	count++; in_word =true;	}
					else { in_word=false;}
				}
			}
			System.out.println(count +" word(s) found " + a.length);
			} catch (Exception e){}
			System.out.println("Data Loaded.");
		}
	}
}