import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Data a = new Data();
        try {
            a.importUsersData("/Users/tiagomartins/github/OOP-Project/src/usersInfo.txt");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
