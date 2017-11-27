import java.io.*;
import java.util.Comparator;

class Event{
    Data d;
    GUI_Management manage;

    Event() {
        File f = new File("./eventInfo");
        if(f.exists() && !f.isDirectory()) {
            ObjectFiles objF = new ObjectFiles();
            this.d = (Data) objF.readObject();
        } else {
            this.d = new Data();
        }
        System.out.println("ACONTECEU 2");
        this.manage = new GUI_Management();
    }


    int checkUsernameAndName(String username, String password, String name){
        for(Person p : d.people) {
            if (username.equals(p.getUsername())){
                return -1;
            }
        }
        for(Person p : d.deiCommunity){
            if(name.equals(p.getName())){
                p.setUsername(username);
                p.setPassword(password);
                this.d.people.add(p);

                return this.d.people.indexOf(p);
            }
        }
        return -1;
    }

    int checkLoginInfo(String username, String password) {
        int i = 0;
        for(Person p : d.people) {
            if(username.equals(p.getUsername()) && password.equals(p.getPassword())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    void sortSpots() {
        d.spots.sort(Comparator.comparingInt(Spot::getSubs).reversed());
    }
}
