import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        Scanner inp = new Scanner(System.in);

        try {
            File file = new File("editor.txt");
            Scanner read = new Scanner(file);

            while (read.hasNextLine()) {
                String data = read.nextLine();
                String splitter[] = data.split(":", 2);
                ll.add(splitter[0]);

                if (ll.searchData(splitter[0]) != null) {
                    ll.searchData(splitter[0]).getData().addJudul(splitter[1]);
                }
            }
            read.close();
        } catch (Exception e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        ll.sort();
        // tampilan program
        while (true) {
            System.out.print(
                    "\n******LinkedList Program******\n\n1. Show all the editor data\n2. Search the editor based on the name\n3. Show the article editor\n4. Exit\nInsert your choice : ");
            int pilihan = Integer.parseInt(inp.nextLine());
            if (pilihan == 1) {
                ll.display();
                System.out.println("");
            } else if (pilihan == 2) {
                System.out.print("Enter the editor name(!case sensitive) : ");
                String editor = inp.nextLine();
                ll.searchContainsEditor(editor);
            } else if (pilihan == 3) {
                System.out.print("Enter the editor name(case sensitive) : ");
                String editor = inp.nextLine();
                ll.menubaru(editor);
            } else if (pilihan == 4) {
                System.exit(1);
            } else {
                System.out.println("Choice not found, TRY AGAIN!!!\n");
            }
        }
    }
}