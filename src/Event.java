import java.io.*;
import java.util.Comparator;

class Event{
    Data d;

    Event() {
        File f = new File("./eventInfo");
        if(f.exists() && !f.isDirectory()) {
            ObjectFiles objF = new ObjectFiles();
            this.d = (Data) objF.readObject();
        } else {
            this.d = new Data();
        }
    }


    /**
     * Registers a new user by verifing that user's name belongs to dei community
     * @param username register username
     * @param password reister password
     * @param name     person name
     * @return -1 if user doesn't belongs to dei or people object if the account was creatd successefully
     */
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

    /**
     * Verifing is username and password match
     * @param username login username
     * @param password login password
     * @return
     */
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
