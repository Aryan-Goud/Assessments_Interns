import java.util.*;
import java.util.HashMap;
import java.util.Collection;
public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        int c;
        int v_id,n_id;
        String v_name,n_name;
        boolean f=false;
        HashMap<Integer,String> voters_register= new HashMap<Integer,String>();
        HashMap<Integer,String> nominee_register= new HashMap<Integer,String>();
        HashMap<Integer,ArrayList<String>> voting=new HashMap<Integer,ArrayList<String>>();
        Collection<Integer> votersVoted= new ArrayList<>();


        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("<---------------------------------------------------->");
            System.out.println("Press 1 if you are a voter");
            System.out.println("Press 2 if you want to register as a nominee");
            System.out.println("Press 3 to VOTE");
            System.out.println("Press 4 To know RESULTS");
            System.out.println("Press 5 To know WINNER");
            System.out.println("Press 6 To view who did not VOTE");
            System.out.println("<---------------------------------------------------->");
            System.out.print("Enter your choice: ");
            c=sc.nextInt();
            switch (c)
            {
                case 1:
                    System.out.println("Please enter voter details");
                    System.out.print("Enter your id ");
                    v_id=sc.nextInt();
                    System.out.print("Enter your name ");
                    v_name=sc.next();
                    voters_register.put(v_id, v_name);
                break;
                case 2:
                    System.out.println("Please enter Nominee details");
                    System.out.print("Enter your id ");
                    n_id=sc.nextInt();
                    System.out.print("Enter your name ");
                    n_name=sc.next();
                    nominee_register.put(n_id, n_name);
                break;
                case 3:
                    System.out.println("Please Vote accordingly");
                    System.out.print("Enter your id ");
                    n_id=sc.nextInt();
                    System.out.print("Enter your name ");
                    n_name = sc.next();
                    int uid = n_id;

                    if (!voters_register.containsKey(n_id)) {
                        System.out.println("Voter_id is not yet registered ");
                    }
                    else
                    {
                        if (votersVoted.contains(uid))
                        {
                            System.out.println("You have already voted!!");
                        }
                        else{

                            System.out.println(nominee_register);
                            System.out.print("Enter ID of nominee you want to vote: ");
                            int nomID = sc.nextInt();
                            votersVoted.add(uid);
                            if (voting.containsKey(nomID)) {
                                voting.get(nomID).add(n_name);
                            } else {
                                voting.put(nomID, new ArrayList<>());
                                voting.get(nomID).add(n_name);
                            }
                        }
                    }
                break;
                case 4:
                    System.out.println(voting);
                break;
                case 5:
                    int maxi=0;
                    String nam ="";
                    for (int i = 1; i <= voting.size(); i++) {
                        if (maxi<voting.get(i).size()){
                            maxi=voting.get(i).size();
                            nam=nominee_register.get(i);
                        }
                    }
                    System.out.println("Winner is "+nam);

                break;
                case 6:
                    for (int i = 1; i <= voters_register.size(); i++) {
                        if(!votersVoted.contains(i)){
                            System.out.print(voters_register.get(i)+"  ");
                        }
                    }
                    System.out.println();
                break;
                default:
                    System.out.println("Enter valid number");
            }
        }while (c!=0);

    }
}