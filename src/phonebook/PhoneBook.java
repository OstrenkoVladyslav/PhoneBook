// https://github.com/OstrenkoVladyslav/PhoneBook.git
package phonebook;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class PhoneBook extends Frame {

    static java.awt.List data_list;
    static HashMap phonebook = new HashMap();
//    PhoneBook frame;
//    Panel panel1, panel2, panel3;
//    static TextField number_field, surname_field;
//    Label number_label, surname_label;
    
    public PhoneBook (String title ) {
        super(title);
        this.phonebook = new HashMap();
//        this.frame = new PhoneBook(title);
//        this.panel1 = new Panel();
//        this.panel2 = new Panel();
//        this.panel3 = new Panel();
//        this.number_label = new Label("Number: ");
//        this.surname_label = new Label("Surname: ");
        
        try {
//            BorderLayout manager = new BorderLayout();
//            setLayout(manager);
//            setSize(500, 300);
//            setLocationRelativeTo(null);
//            setResizable(false);
//
//            // Создаем панель с полем "Number"
//            panel1.add(number_label);
//            TextField number_field = (TextField) panel1.add(new TextField(15));
//
//            // Создаем надпись и поле "Surname"
//            panel2.add(surname_label);
//            TextField surname_field = (TextField) panel2.add(new TextField(15));
//
//            // Создаем кнопку "Add"
//            Button add_button = (Button) panel3.add(new Button("Add"));
//            add (panel3, BorderLayout.NORTH);
//
//            // Создаем новую панель и добавляем туда список
//            Panel panel4 = new Panel();
//            this.data_list = new java.awt.List(10);
//            panel4.add(data_list);
//            add(panel4, BorderLayout.CENTER);
//
//            Button button_ok = new Button("Ok");
//            Button button_add = new Button("Add record");
//
//            //Создадим слушателей
//            
//
//            addWindowListener(new MyWindowAdapter());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
     
//    static void refresh_list(){
//        Set<Map.Entry<String, String>> set = phonebook.entrySet();
//        //data_list.clear();
//        for (Map.Entry<String, String> me : set){
//            data_list.add(me.getKey()+"  "+me.getValue());
//        }
//    }
    
//    void add_record(){
//        phonebook.put(number_field.getText(),surname_field.getText());
//    }
    
    class MyWindowAdapter extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent we){
            System.exit(0);
        }
    }
//    
//    class AddRecordListener implements ActionListener{
//        public void actionPerformed(ActionEvent e) {
//            //phonebook.put(number_field.getText(),);
////            add_record();
////            refresh_list();
//        }
//        
//    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //HashMap phonebook = new HashMap();
        phonebook.put("0503231014","Ostrenko");
        phonebook.put("0505775705","Petrov");
        phonebook.put("0505575007","Sidorov");
        phonebook.put("0505557799","Petrov");
        phonebook.put("0505557798","Sidorov");

        // Get a set of the entries.
        Set<Map.Entry<String, String>> set = phonebook.entrySet();

        // Display the set.
//        System.out.println("List of all pairs:");
//        for(Map.Entry<String, String> me : set) {
//            System.out.print(me.getKey() + ": ");
//            System.out.println(me.getValue());
//        }
//        System.out.println("--------------------------------------");
        // Finding surname by phone number
//        System.out.println("Owner of 0503231014 number is "+phonebook.get("0503231014"));
//        System.out.println("--------------------------------------");

        // Finding phone numbers by surname
//        String search = "Sidorov";
//        System.out.println("Searching for "+search+"...");
//        for (Map.Entry<String, String> me : set){
//            if (me.getValue()==(search))
//                System.out.println(me.getKey());
//        }
//        System.out.println("--------------------------------------");
//        System.out.println("Starting windowed program...");

        // Создаем объект окна
//        PhoneBook frame = null;
        
        //refresh_list();
        
        //Set<Map.Entry<String, String>> set = phonebook.entrySet();
        //data_list.clear();
        for (Map.Entry<String, String> me : set){
            data_list.add(me.getKey()+"  "+me.getValue());
        }
        
        //frame.setVisible(true);
        
    }
}