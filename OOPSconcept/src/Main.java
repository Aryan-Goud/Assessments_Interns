import bookdetails.*;
class library{
//    using contructors
    library(){
        System.out.println("There are wide variety of books available (Default constructor)");
    }
    library(int no_of_books){

        System.out.println(no_of_books+" books are available (parameterized constructor)");
    }
//    overloading
    void no_pages(int no_of_pages){

        System.out.println(no_of_pages+" pages in the book");
    }
    void no_pages(int no_of_pages,String book_name){
        System.out.println("There are "+no_of_pages+" pages in the "+book_name);
    }
}
//INHERITANCE
class  books extends library{
    //overriding
    void no_pages(int no_of_pages){

        System.out.println(no_of_pages+" pages in the book");
    }

}
//INTERFACE
class specifications implements book_details{
    public void book_shape()
    {

        System.out.println("Books are in rectangle shape");
    }
    public void book_price(String book_name,int price)
    {

        System.out.println(book_name+" book price is "+price);
    }
}
//ABSTRACTION
class booktypes extends book_types{

    @Override
    public void book_types(String na) {

        System.out.println("The book is "+na);
    }

    @Override
    public void book_colour(String col) {
        System.out.println("The book colour is "+col);

    }
}
public class Main {
    public static void main(String[] arhs) {
//        library l1=new library(10);
//        System.out.println("METHOD OVERLOADING");
//        l1.no_pages(100);
//        l1.no_pages(200,"Ramayanam");
        books b=new books();
        System.out.println("METHOD OVERRIDING");
        b.no_pages(300);
        System.out.println("INTERFACES");
        specifications sp=new specifications();
        sp.book_shape();
        sp.book_price("Into The Dark",1000);
        System.out.println("ABSTRACTION");
        booktypes bt=new booktypes();
        bt.book_types("Humour");
        bt.book_colour("Black");
    }
}