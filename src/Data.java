import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class Data {
    private HashMap<String, HashMap<String, String>> users = new HashMap<>();
    private ArrayList<String> DEIMembers = new ArrayList<>();

    public Data() {
        try {
            this.importUsersData("/Users/tiagomartins/github/OOP-Project/src/peopleInfo.txt");
            this.importDEIUMembers("/Users/tiagomartins/github/OOP-Project/src/DEIMembers.txt");
            System.out.println(users);
            System.out.println(DEIMembers);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void importUsersData(String path) throws IOException{
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);
        String line;
        String[] sLine;

        while((line = textReader.readLine()) != null){
            sLine = line.split(";");
            splitLineUsers(sLine);
        }

        textReader.close();
    }

    public void splitLineUsers(String[] splittedLine) {
        HashMap<String, String> info = new HashMap<>();

        for (int i = 1; i < splittedLine.length; i++) {
            switch (i) {
                case 1:
                    info.put("password", splittedLine[i]);
                    break;

                case 2:
                    info.put("name", splittedLine[i]);
                    break;

                case 3:
                    info.put("profile", splittedLine[i]);
                    break;

                case 4:
                    info.put("post", splittedLine[i]);
                    break;

                case 5:
                    info.put("sub_post", splittedLine[i]);
                    break;
            }
        }

        users.put(splittedLine[0], info);
    }

    public void importDEIUMembers(String path) throws IOException{
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);
        String line;
        String[] sLine;
        while((line = textReader.readLine()) != null){
            sLine = line.split(";");
            splitLineDEI(sLine);
        }
    }

    public void splitLineDEI(String[] splittedLine) {
       for(int i = 0; i < splittedLine.length; i++){
           switch (i) {
               case 0:
                   DEIMembers.add(splittedLine[0]);
           }
       }
    }

    public boolean isUsernameValid(String username) {
        return users.containsKey(username);
    }

    public boolean belongsToDei(String name){
        return DEIMembers.contains(name);
    }

    public boolean isLoginValid(String username, String password){
        HashMap<String, String> user = users.get(username);
        if(user != null && user.get(password) == password){
            return true;
        }
        return false;
    }
}
