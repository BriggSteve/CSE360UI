import java.io.*;
import java.math.*;
import java.util.*;

public class Main2Test {

    public static void main(String [ ] args)
    {
        String name = "";
        String username = "";
        String password = "";
        String job = "";

        int lock = 0;
        boolean Cont = true;

        try{
            FileInputStream filein = new FileInputStream(new File("entrydata.ser"));
            ObjectInputStream readStream = new ObjectInputStream(filein);
            Entry inputTemp = (Entry) readStream.readObject();
            for(int i = 0; i < inputTemp.size(); i++){
                System.out.println(inputTemp.name);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        System.out.println("Welcome to the Data Entry Form!");
        ArrayList<Entry> entries = new ArrayList<Entry>();
        Scanner entryScan = new Scanner(System.in);
        try {
            //File outfile = new File("entrydata.txt");
            FileOutputStream fileout = new FileOutputStream(new File ("entrydata.ser"));
            ObjectOutputStream writeStream = new ObjectOutputStream(fileout);
            for (int i = 0; i < entries.size(); i++){
                Entry tempob = entries.get(i);
                writeStream.writeObject(tempob);
            }
            writeStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }








        while(Cont) {

            System.out.println("Please Enter the Name of your Entry:");
            name = entryScan.nextLine();

            System.out.println("Please enter username");
            username = entryScan.nextLine();

            System.out.println("Please enter a password");
            password = entryScan.nextLine();

            System.out.println("Please enter a job (doctor/nurse/patient)");
            job = entryScan.nextLine();

            Entry temp = new Entry(name, username, password, job);
            entries.add(temp);
            System.out.println("Do you wish to add another entry? 1 for yes 0 for no");
            lock = entryScan.nextInt();
            if (lock == 0){
                Cont = false;
            }

        }

        try {
            FileOutputStream fileout = new FileOutputStream("entrydata.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(fileout);

            FileInputStream filein = new FileInputStream("entrydata.ser");
            ObjectInputStream readfile = new ObjectInputStream(filein);

            for (int i = 0; i < entries.size(); i++){
                Entry tempob = entries.get(i);
                writeStream.writeObject(tempob);
                writeStream.flush();
            }
            writeStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }




        System.out.println("These are your Entries:");
        for (int i = 0; i < entries.size(); i++){
            System.out.println(entries.get(i).name );
            System.out.println(entries.get(i).username );
            System.out.println(entries.get(i).password );
            System.out.println(entries.get(i).job );
        }
    }

}
class Entry implements Serializable {
    public String name;
    public String username;
    public String password;
    public String job;
    public Entry(String a, String b, String c, String d){
        name = a;
        username = b;
        password = c;
        job = d;
    }


}

