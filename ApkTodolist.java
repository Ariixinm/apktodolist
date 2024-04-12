
import java.util.Scanner;

public class ApkTodolist {
    public static  String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args){
  ViewShowTodolist();
    }
    /*menampilakan todo list*/

    public static void showtodolist() {
        System.out.println("TODOLIST");
        for (int i = 0; i < model.length; i++) {
        var todo = model[i];
        var no = i +1;

        if (todo != null){
            System.out.println(no+".  "+todo);
        }
        }
    }
    public static void testtodolist(){
        model[0]="masukan ke sukaan mu";
        model[1]="sayang kamu g ada dua nya ";
        showtodolist();
    }
    /*menambah todo list*/
    public  static  void   Addtodolist(String todo){

        //cek penuh apa tidak
        var isfuul= true;
        for (var i = 0; i < model.length ; i++) {
            if (model [i] == null) {
                isfuul = false;
                break;
                
            }

        }
        //jika penuh kita rize kalikan 2
        if (isfuul){
            var temp = model;
            model = new String [model.length * 2];

            for (int i = 0; i < temp.length ; i++) {
                model[i] = temp[i];

            }
        }
        for (var i = 0; i < model.length ; i++) {
            if (model[i] == null) {
                model[i]= todo;
                break;

            }

        }

    }
    public  static void Addtodolist(){
        for (int i = 0; i < 25 ; i++) {
            Addtodolist("SELERAKU CUMA KAMU XIXI . " +i);
        }
        showtodolist();
    }
    /*menghapus todo list*/
    public static boolean removetodolist(Integer Number) {
        if ((Number - 1) >= model.length){
            return false;
        } else if (model[Number - 1 ] ==null) {
            return false;
        }else {
            for (int i = (Number- 1); i < model.length ; i++) {
                if (i == (model.length  -1)) {
                    model[i]= null;
                    
                }else{
                    model[i]=model[i+ 1];
                }
            }
            return true;
        }
    }
    public static void testremovetodolist(){
        Addtodolist("satu");
        Addtodolist("dua");
        Addtodolist("tiga");
        Addtodolist("empat");
        Addtodolist("lima");

        var result = removetodolist(20);
            System.out.println(result);

            result= removetodolist(7);
        System.out.println(result);

        result=removetodolist(2);
        System.out.println(result);

        showtodolist();
    }

public static  String input (String info){
    System.out.println(info +":");
    String data = scanner.nextLine();
    return data;
}
public static  void testinput(){
    var name = input("masukan nama");
    System.out.println("hi " + name);

    var channel = input("channel");
    System.out.println(channel);
}
    /* menampilakan view todolist*/
    public static void ViewShowTodolist() {
        while (true) {
            showtodolist();

            System.out.println("menu : ");
            System.out.println("1. tambahankan");
            System.out.println("2. hapus");
            System.out.println("x. keluar");

            var input = input("pilih");

            if (input.equals("1")) {
                ViewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodolist();
            } else if (input.equals("X")) {
                break;
            }else{
                System.out.println("pilihan tidak ada");
            }
        }
    }
    public static void TestViewShowTodoList(){


        Addtodolist("SATU");
        Addtodolist("DUA");
        Addtodolist("TIGA");
        Addtodolist("EMPAT");
        Addtodolist("LIMA");
        ViewShowTodolist();
    }
    /* menampilkan menambah todolist*/
    public static void ViewAddTodoList() {
        System.out.println("MENAMBAHKAN  TODOLIST");

        var todo = input("todo (x jika batal)");

        if (todo.equals("x")) {
        } else {
            Addtodolist(todo);
        }
    }
    public static void TestViewADDTodolist(){
        Addtodolist("satu");
        Addtodolist("dua");
        Addtodolist("tiga");

        ViewAddTodoList();
        showtodolist();

    }
    /*menampilkan hapus todolist*/
    public static void viewRemoveTodolist(){
        System.out.println("MENGHAPUS TODOLIST");
        var number =  input("nomor di hapus (x jika di batalkan)");
        if(number.equals("x")){

        }else{
            boolean success= removetodolist(Integer.valueOf(number));
            if (!success){
                System.out.println("GAGAL MENGINPUT TODOLIST : " +number);
            }
        }
    }
    public static void TestRemoveTodoList(){
        Addtodolist("satu");
        Addtodolist("dua");
        Addtodolist("tiga");

        showtodolist();
        viewRemoveTodolist();
        showtodolist();
    }
}
