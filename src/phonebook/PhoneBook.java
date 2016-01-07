// https://github.com/OstrenkoVladyslav/PhoneBook.git
package phonebook;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class PhoneBook extends Frame {
    BorderLayout manager = new BorderLayout();
    Button button_ok = new Button("Ok");
    Button button_add = new Button("Add record");
    
    public PhoneBook (String title) {
        super(title);
        try {
            init();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
     
    private void init() throws Exception {
        setLayout(manager);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        addWindowListener(new MyWindowAdapter());
    }
    
    static private void refresh_list(Map phonebook, java.awt.List data_list){
        Set<Map.Entry<String, String>> set = phonebook.entrySet();
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
        Panel panel = new Panel();

        // Создаем надпись и поле "Number"
        Label number_label = new Label ("Number:");
        panel.add(number_label);
        TextField number_field = new TextField();
        number_field = (TextField) panel.add(new TextField(15));

        // Создаем надпись и поле "Surname"
        Label surname_label = new Label ("Surname:");
        panel.add(surname_label);
        TextField surname_field = new TextField();
        surname_field = (TextField) panel.add(new TextField(15));

        // Создаем кнопку "Add"
        Component add_button = panel.add(new Button("Add"));
        frame.add (panel, BorderLayout.NORTH);

        // Создаем новую панель и добавляем туда список
        panel = new Panel();
        java.awt.List data_list;
        data_list = new java.awt.List(10);
        panel.add(data_list);
        frame.add(panel, BorderLayout.CENTER);
        
        panel = new Panel();
        Component test_button2 = panel.add(new Button("Test2"));
        Component test_button3 = panel.add(new Button("Test3"));
        frame.add (panel, BorderLayout.SOUTH);

        frame.setVisible(true);
        
        refresh_list(phonebook, data_list);
        
        
    }
}
