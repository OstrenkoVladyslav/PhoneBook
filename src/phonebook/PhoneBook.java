// https://github.com/OstrenkoVladyslav/PhoneBook.git
package phonebook;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class PhoneBook extends Frame {

    public java.awt.List data_list;
    
    public PhoneBook (String title) {
        super(title);
        try {
            BorderLayout manager = new BorderLayout();
            Label number_label = new Label("Number: ");
            Label surname_label = new Label ("Surname:");
            setLayout(manager);
            setSize(500, 300);
            setLocationRelativeTo(null);
            setResizable(false);

            // Создаем панель с полем "Number"
            Panel panel = new Panel();
            panel.add(number_label);
            TextField number_field = (TextField) panel.add(new TextField(15));

            // Создаем надпись и поле "Surname"
            panel.add(surname_label);
            TextField surname_field = new TextField();
            surname_field = (TextField) panel.add(new TextField(15));

            // Создаем кнопку "Add"
            Component add_button = panel.add(new Button("Add"));
            add (panel, BorderLayout.NORTH);

            // Создаем новую панель и добавляем туда список
            panel = new Panel();
            this.data_list = new java.awt.List(10);
            panel.add(data_list);
            add(panel, BorderLayout.CENTER);


            Button button_ok = new Button("Ok");
            Button button_add = new Button("Add record");
            addWindowListener(new MyWindowAdapter());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
     
    private static void refresh_list(Map phonebook, java.awt.List data_list){
        Set<Map.Entry<String, String>> set = phonebook.entrySet();
        data_list.clear();
        for (Map.Entry<String, String> me : set){
            data_list.add(me.getKey()+"  "+me.getValue());
        }

    }
    
    class MyWindowAdapter extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent we){
            System.exit(0);
        }
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Map phonebook = new HashMap();
        phonebook.put("0503231014","Ostrenko");
        phonebook.put("0505775705","Petrov");
        phonebook.put("0505575007","Sidorov");
        phonebook.put("0505557799","Petrov");
        phonebook.put("0505557798","Sidorov");

        // Get a set of the entries.
        Set<Map.Entry<String, String>> set = phonebook.entrySet();

        // Display the set.
        System.out.println("List of all pairs:");
        for(Map.Entry<String, String> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println("--------------------------------------");
        // Finding surname by phone number
        System.out.println("Owner of 0503231014 number is "+phonebook.get("0503231014"));
        System.out.println("--------------------------------------");

        // Finding phone numbers by surname
        String search = "Sidorov";
        System.out.println("Searching for "+search+"...");
        for (Map.Entry<String, String> me : set){
            if (me.getValue().equals(search))
                System.out.println(me.getKey());
        }

        // Создаем объект окна
        PhoneBook frame = new PhoneBook("Phone book");
        refresh_list(phonebook, frame.data_list);
        frame.setVisible(true);
        
        
    }
}