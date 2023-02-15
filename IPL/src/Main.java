import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.time.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> al=new ArrayList<>();
        ArrayList<String> sch=new ArrayList<>();
        ArrayList<String> sec=new ArrayList<>();
        ArrayList<String> weeksec=new ArrayList<>();
        HashMap<String,String> hm=new HashMap<>();
        System.out.print("Enter number of teams participating: ");
        int h=sc.nextInt();
        System.out.println("Enter your team name and its ground for the play :");
        for (int i = 0; i < h; i++) {
            System.out.print("Enter team name: ");
            String teamName,ground;
            teamName=sc.next();
            System.out.print("Enter ground name for "+teamName+": ");
            ground=sc.next();
            al.add(teamName);
            hm.put(teamName,ground);
        }
        for (int i = 0; i < al.size()-1; i++)
        {
            for (int j = i+1; j < al.size(); j++)
            {
                   sch.add(al.get(i)+" VS "+al.get(j));
            }
        }
        int c=0 , f=0;
        boolean b=true;
        for (int i = 0; i < sch.size(); i++) {

            for (int j = 0; j < sch.size(); j++) {

                if (sec.isEmpty()) {
                    c++;
                    sec.add(sch.get(j));
                }
                else {

                    String[] s1 = sec.get(sec.size()-1).split(" ");

                    String[] s2 = sch.get(j).split(" ");
                    if (c%5==0) {
//                        System.out.println(c);
                        if (weeksec.isEmpty() && !sch.get(j).contains(s1[0]) && !sch.get(j).contains(s1[2]) && !sec.contains(sch.get(j))) {
                            weeksec.add(sch.get(j));
                            f++;
//                            System.out.println("this is week sat1 "+weeksec);
                        }
                        if (f>0  && !sec.contains(sch.get(j)) && !weeksec.get(0).contains(s2[0]) && !weeksec.get(0).contains(s2[2]) && !weeksec.contains(sch.get(j))) {
                            weeksec.add(sch.get(j));
                            f++;
//                            System.out.println("this is week sat "+weeksec);
//                            sec.addAll(weeksec);
                            c++;
                        }
                    }
//                    else if (c%6==0)
//                    {
//                        System.out.println(c);
//                        if (!weeksec.get(0).contains(s2[0]) && !weeksec.get(0).contains(s2[2]) && !weeksec.contains(sch.get(j))) {
//                        weeksec.add(sch.get(j));
//
//                        System.out.println("this is week sat "+weeksec);
//                        sec.addAll(weeksec);
//                        c++;
//                        }
//
//                    }
                    else if (c%6==0) {
//                        System.out.println(c);
                        String[] s3 = sch.get(j).split(" ");
//                        String[] s3 = weeksec.get(1).split(" ");
                        if (weeksec.size()<3   && f>1 && !weeksec.get(1).contains(s2[0]) && !weeksec.get(1).contains(s2[2])) {
                            weeksec.add(sch.get(j));
//                            c++;
                            f++;
//                            System.out.println("this is week sun1 "+weeksec);
//                            String[] s4 = weeksec.get(2).split(" ");

                        }
                        if (f>2  && sec.contains(sch.get(j)) && !weeksec.get(2).contains(s2[0]) && !weeksec.get(2).contains(s2[2]) && !weeksec.contains(sch.get(j)))
                        {
                            weeksec.add(sch.get(j));
//                            System.out.println("this is week sun "+weeksec);

                            sec.addAll(weeksec);
//                            System.out.println("insi full "+sec);
                            weeksec.clear();
                            f=0;
                            c=1;
                            b=false;

                        }
//                        c++;
//                        System.out.println("this is week out of "+weeksec);
                    }
//                    else if (c%8==0)
//                    {
//                        System.out.println(c);
//                        if (!weeksec.get(2).contains(s2[0]) && !weeksec.get(2).contains(s2[2]) && !weeksec.contains(sch.get(j)))
//                        {
//                            weeksec.add(sch.get(j));
//                            System.out.println("this is week sun "+weeksec);
//                            c++;
//                            sec.addAll(weeksec);
//                            System.out.println("insi full "+sec);
//                            weeksec.clear();
//                        }
//                    }
                    else {
                        if (!sch.get(j).contains(s1[0]) && !sch.get(j).contains(s1[2]) && !sec.contains(sch.get(j))) {
                            sec.add(sch.get(j));
                            if (b==true) {
                                c++;
                            }
                            else{
                                b=true;
                            }
//                            System.out.println(c);
//                            System.out.println(sec);
                        }
                    }

                }

            }
        }
//        System.out.println(sch);
//        System.out.println(sec);
//        System.out.println(al);
//        System.out.println(hm);
//        System.out.println("Hello world!");
        String s = "2023-05-01";
        String e = "2023-09-01";
        LocalDate start = LocalDate.parse(s);
        LocalDate end = LocalDate.parse(e);
        ArrayList<LocalDate> totalDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            totalDates.add(start);
            start = start.plusDays(1);
        }
        System.out.println("<---------------------IPL SCHEDULE---------------------->");
        String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Saturday","Sunday","Sunday"};
//        System.out.println(totalDates);
        System.out.println();
        System.out.println("S_No    Match      Date      Day      Venue");
        int n=0,v=0,m=1;
        for (int i = 0; i < sec.size(); i++) {
            String[] s4= sec.get(i).split(" ");
            if (v==6 || v==8){
                System.out.println(m++ +"      "+sec.get(i)+"  "+totalDates.get(i-1)+"  "+days[v++]+"      "+hm.get(s4[0]));
            }
            else {
                System.out.println(m++ +"      "+sec.get(i) + "  " + totalDates.get(i) + "  " + days[v++] + "     " + hm.get(s4[0]));

            }
            if (v == 9) {
                v = 0;
            }
            n=i;
        }
        v=4;

        for (int i = 0; i < sec.size()-(2*(sec.size()-sch.size())); i++) {
            String[] s4= sec.get(i).split(" ");
            if (v==6 || v==8){
                System.out.println(m++ +"      "+sec.get(i)+"  "+totalDates.get(--n)+"  "+days[v++]+"     "+hm.get(s4[2]));
                n++;
            }
            else {
                System.out.println(m++ +"      "+sec.get(i) + "  " + totalDates.get(n++) + "  " + days[v++] + "     " + hm.get(s4[2]));

            }
            if (v == 9) {
                v = 0;
            }
        }
        System.out.println();
        System.out.println("<----------------LETS PLAY----------------->");
        }
    }

