import java.io.*;
import java.net.URL;
import java.util.ArrayList;

class Data implements Serializable{
    ArrayList<Spot> spots;
    ArrayList<Person> people;
    ArrayList<Person> deiCommunity;
    Double revenue;

    Data() {
        this.spots = importSpots();
        this.people = new ArrayList<>();
        System.out.println("ACONTECEU");
        this.deiCommunity = importDEICommunity();
        this.revenue = getMinRevenue();
    }

    private Double getMinRevenue() {
        double minRevenue = 0;
        for(Person p : people){
            for(Spot s: p.chosenSpots) {
                minRevenue += s.getCost(p);
            }
        }
        return minRevenue;
    }

    private ArrayList<Spot> importSpots() {
        URL url = getClass().getResource("spotsInfo.txt");
        String line;
        String[] sLine;
        ArrayList<Spot> spots = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(url.getPath());
            BufferedReader bufferReader = new BufferedReader(fileReader);
            try {
                while ((line = bufferReader.readLine()) != null) {
                    sLine = line.split(";");
                    Coordinates c = new Coordinates(Double.parseDouble(sLine[1]), Double.parseDouble(sLine[2]));
                    switch (sLine[0]) {
                        case "Garden":
                            Garden g = new Garden(c, Integer.parseInt(sLine[3]), Integer.parseInt(sLine[4]));
                            spots.add(g);
                            break;

                        case "SportsArea":
                            ArrayList<String> sports = new ArrayList<>();
                            for(int j = 4; j < sLine.length; j++) {
                                sports.add(sLine[j]);
                            }
                            SportsArea sa = new SportsArea(c, Integer.parseInt(sLine[3]), sports);
                            spots.add(sa);
                            break;

                        case "Exposition":
                            Exposition e = new Exposition(c, Integer.parseInt(sLine[3]), sLine[4], Double.parseDouble(sLine[5]));
                            spots.add(e);
                            break;

                        case "Bar":
                            ArrayList<Person> guestList = new ArrayList<>();
                            Bar b = new Bar(c, Integer.parseInt(sLine[3]), sLine[4], Integer.parseInt(sLine[5]), Double.parseDouble(sLine[6]), Integer.parseInt(sLine[7]), guestList);
                            spots.add(b);
                    }
                }
            }
            catch (IOException ex) {
                System.out.println("Unable to read " + url.getPath());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open " + url.getPath());
        }
        return spots;
    }
/*
    private ArrayList<Person> importPeople(){
        ArrayList<Person> people = new ArrayList<>();
        String line;
        String[] sLine;
        URL url = getClass().getResource("peopleInfo.txt");

        try {
            FileReader fileReader = new FileReader(url.getPath());
            BufferedReader bufferReader = new BufferedReader(fileReader);

            try {
                while ((line = bufferReader.readLine()) != null) {
                    sLine = line.split(";");
                    ArrayList<Spot> spots = new ArrayList<>();

                    switch(sLine[0]){
                        case "Teacher":
                            Teacher t = new Teacher(sLine[1], sLine[2], sLine[3], sLine[4], sLine[5], spots);
                            people.add(t);
                            break;

                        case "Employee":
                            Employee e = new Employee(sLine[1], sLine[2], sLine[3], sLine[4], sLine[5], spots);
                            people.add(e);
                            break;

                        case "Student":
                            Student s = new Student(sLine[1], sLine[2], sLine[3], sLine[4], sLine[5], spots);
                            people.add(s);
                    }
                }
            }
            catch(IOException ex){
                System.out.println("Unable to read " + url.getPath());
            }

        }
        catch(FileNotFoundException ex){
            System.out.println("Unable to open " + url.getPath());
        }
        return people;
    }
    */

    private ArrayList<Person> importDEICommunity(){
        ArrayList<Person> deiCommunity = new ArrayList<>();
        String line;
        String[] sLine;
        URL url = getClass().getResource("deicommunity.txt");

        try {
            FileReader fileReader = new FileReader(url.getPath());
            BufferedReader bufferReader = new BufferedReader(fileReader);
            try {
                while ((line = bufferReader.readLine()) != null) {
                    sLine = line.split(";");
                    ArrayList<Spot> spots = new ArrayList<>();

                    switch(sLine[0]){
                        case "Teacher":
                            Teacher t = new Teacher("", "", sLine[1], sLine[2], sLine[3], spots);
                            deiCommunity.add(t);
                            break;

                        case "Employee":
                            Employee e = new Employee("", "", sLine[1], sLine[2], sLine[3], spots);
                            deiCommunity.add(e);
                            break;

                        case "Student":
                            Student s = new Student("", "", sLine[1], sLine[2], sLine[3], spots);
                            deiCommunity.add(s);
                    }
                }
            }
            catch(IOException ex){
                System.out.println("Unable to read " + url.getPath());
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("Unable to open " + url.getPath());
        }
        return  deiCommunity;
    }

}

class ObjectFiles{

    void writeObject(Object o){
        try {
            ObjectOutputStream oS = new ObjectOutputStream(new FileOutputStream("eventInfo"));
            oS.writeObject(o);
            oS.close();
        }
        catch (FileNotFoundException ex){
            System.out.println("Unable to open " + "eventInfo");
        }
        catch (IOException ex){
            System.out.println("Unable to write to " + "eventInfo");
        }
    }

    Object readObject() {
        Object data = null;
        try {
            ObjectInputStream iS = new ObjectInputStream(new FileInputStream("./eventInfo"));
            data = iS.readObject();
            iS.close();
            return data;
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("class not found");
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("file not found");
        }
        catch(IOException ex)
        {
            System.out.println("unable to open " + "./eventInfo");
        }
        return data;
    }
}
