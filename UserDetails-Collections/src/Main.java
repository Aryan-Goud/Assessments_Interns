import java.util.*;
import User.User;

public class Main {

    public static void main(String[] args) {
        int c,u_id;
        String u_name;
        Collection<User> al=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        do
        {
            System.out.println("1.Create");
            System.out.println("2.Search");
            System.out.println("3.Display");
            System.out.println("4.Delete");
            System.out.println("0.EXIT");
            System.out.println("Enter your choice");
            c=sc.nextInt();
            switch (c) {
                case 1:
                    System.out.println("Enter user name:");
                    u_name = sc.next();
                    System.out.println("Enter user id");
                    u_id = sc.nextInt();
                    al.add(new User(u_id, u_name));
                break;
                case 2:
                    boolean f = false;
                    System.out.println("Enter user_id to know name of user");
                    Iterator<User> i = al.iterator();
                    int uid = sc.nextInt();
                    while (i.hasNext()) {
                        User u = i.next();
                        if (u.getUserId() == uid) {
                            System.out.println(u.getUserName());
                            f = true;
                            break;
                        }
                    }
                    if (f == false) {
                        System.out.println("Username not found with that user_id");
                    }
                break;
                case 3:
                    System.out.println(al);
                break;
                case 4:
                    f = false;
                    String unm="";
                    System.out.println("Enter user_id you want to delete");
                    i = al.iterator();
                    u_id = sc.nextInt();
                    while (i.hasNext()) {
                        User u = i.next();
                        if (u.getUserId() == u_id) {
                            unm=u.getUserName();
                            al.remove(u);
                            f = true;
                            break;
                        }
                    }
                    if (f==false) {
                        System.out.println("Userid not found in the list to delete");
                    }
                    else{
                        System.out.println("Userid "+u_id+" with name "+unm+" is deleted");
                    }
                break;
                default:
                    System.out.println("Enter a valid number");
                break;
            }
        }while (c!=0);
    }

}