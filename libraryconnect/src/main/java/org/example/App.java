package org.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;
import java.io.*;

import static java.lang.System.exit;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        System.out.println("Hello World!");

        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String pass = "aryan";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(url,user,pass);
            System.out.println("connected");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int n;
        Scanner sc=new Scanner(System.in);

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.println("<---------------------------------------------->");
            System.out.println("Press 0 to EXIT");
            System.out.println("Press 1 for inserting book");
            System.out.println("Press 2 for search book");
            System.out.println("Press 3 for delete book");
            System.out.println("Press 4 for list all books");
            System.out.print("Enter a value: ");
            n=sc.nextInt();
            System.out.println("<---------------------------------------------->");
            switch (n){
                case 0:
                    exit(1);
                case 1:
                    System.out.print("Enter title name: ");
                    String title= br.readLine();
                    System.out.print("Enter author name: ");
                    String author=br.readLine();
                    System.out.print("Enter Date in YYYY-MM-DD format: ");
                    String years= br.readLine();
                    String query="INSERT INTO library(title,author,years) " + "VALUES(?,?,?)";
                    PreparedStatement pstmt = connection.prepareStatement(query);
                        // set parameters for statement
                        pstmt.setString(1, title);
                        pstmt.setString(2, author);
                        pstmt.setString(3, years);
                        pstmt.executeUpdate();
                    System.out.println("Book inserted successfully!");
                break;
                case 2:
                    int f=0;
                    System.out.print("Enter any book detail to search: ");
                    String sr= br.readLine();
                    String que="Select * from library";
                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(que);
                    while (result.next()){
                        String titilename=result.getString(1);
                        String authorname=result.getString(2);
                        String publ=result.getString(3);
                        if (titilename.equals(sr) || authorname.equals(sr) || publ.contains(sr)){
                            f=1;
                            System.out.println("Author of the book "+titilename+" is "+authorname+" published in year "+publ);
                        }

                    }
                    if (f==0){
                        System.out.println("!!No book details found");
                    }

                break;
                case 3:
                    String sql = "DELETE FROM library WHERE title=?";
                    System.out.print("Enter a book name you want to delete: ");
                    PreparedStatement statemen= connection.prepareStatement(sql);
                    String til= br.readLine();
                    statemen.setString(1, til);

                    int rowsDeleted = statemen.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("A book was deleted successfully!");
                    }
                    else{
                        System.out.println("!!No book found Try another");
                    }
                break;
                case 4:
                    String sqls = "SELECT * FROM library";

                    Statement statements = connection.createStatement();
                    ResultSet results = statements.executeQuery(sqls);

                    int count = 0;

                    while (results.next()){
                        String titlena = results.getString(1);
                        String aut = results.getString(2);
                        String yea = results.getString(3);
                        String output = "Book-%d: name->%s  author->%s  year->%s";
                        System.out.println(String.format(output, ++count, titlena, aut, yea));
                    }
                break;
                default:
                    System.out.println("Enter a valid number!!");
                break;
            }
        }while (n!=0);

    }
}
