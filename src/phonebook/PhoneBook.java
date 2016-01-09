// https://github.com/OstrenkoVladyslav/PhoneBook.git
/*
Приложение для создания справочника телефонов.
Справочник phonebook типа HashMap с полями number_field (ключ)
и surname_field (значение).
Реализуется вывод в стандартный поток элементов справочника, поиск абонента
по номеру телефона и по фамилии.
В окне программы предусмотрено добавление новой записи в справочник.
Валидация полей не реализована.
*/

package phonebook;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class PhoneBook extends Frame {

    java.awt.List data_list = new java.awt.List();
    HashMap phonebook = new HashMap();
    Panel panel1, panel2, panel3;
    TextField number_field = new TextField();
    TextField surname_field = new TextField();
    Button add_button  = new Button("Add");
    Button ok_button  = new Button("OK");
    AddListener add_record_listener = new AddListener();
    CloseListener close_listener = new CloseListener();
    

    public PhoneBook (String title) {
        super(title);
        this.phonebook = new HashMap();
        this.panel1 = new Panel();
        this.panel2 = new Panel();
        this.panel3 = new Panel();
        Label number_label = new Label("Number: ");
        Label surname_label = new Label("Surname: ");
        //this.add_button = new Button();
        BorderLayout manager = new BorderLayout();
        setLayout(manager);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setResizable(true);

        // Создаем надпись и текстовое поле "Number"
        panel1.add(number_label);
        number_field = (TextField) panel1.add(new TextField(15));

        // Создаем надпись и текстовое поле "Surname"
        panel1.add(surname_label);
        surname_field = (TextField) panel1.add(new TextField(15));

        // Добавляем кнопку "Add"
        add_button.addActionListener(add_record_listener);
        panel1.add(add_button);
        add (panel1, BorderLayout.NORTH);

        // Создаем новую панель и добавляем туда список
        Panel panel2 = new Panel();
        this.data_list = new java.awt.List(10);
        panel2.add(data_list);
        add(panel2, BorderLayout.CENTER);
        
        // Добавляем кнопку ОК
        ok_button.addActionListener(close_listener);
        panel3.add(ok_button);
        add (panel3, BorderLayout.SOUTH);
        
        addWindowListener(new MyWindowAdapter());
    }
    
    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            add_record(PhoneBook.this);
            refresh_list(PhoneBook.this);
        }
    }

    class CloseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }    
    
    
    public void refresh_list(PhoneBook frame){
        Set<Map.Entry<String, String>> set = frame.phonebook.entrySet();
        frame.data_list.clear();
        for (Map.Entry<String, String> me : set){
            frame.data_list.add(me.getKey()+"  "+me.getValue());
        }
        frame.data_list.setVisible(true);
    }
    
    public void add_record(PhoneBook frame){
        frame.phonebook.put(frame.number_field.getText(),frame.surname_field.getText());
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
        // Создаем объект класса PhoneBook
        PhoneBook frame = new PhoneBook("PhoneBook application (©Ostrenko)");
        frame.phonebook.put("0503231014","Ostrenko");
        frame.phonebook.put("0505775705","Petrov");
        frame.phonebook.put("0505575007","Sidorov");
        frame.phonebook.put("0505557799","Petrov");
        frame.phonebook.put("0505557798","Sidorov");

        // Get a set of the entries.
        Set<Map.Entry<String, String>> set = frame.phonebook.entrySet();

        // Display the set.
        System.out.println("List of all pairs:");
        for(Map.Entry<String, String> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println("--------------------------------------");
        System.out.println("Finding surname by phone number");
        System.out.println("Owner of 0503231014 number is "+frame.phonebook.get("0503231014"));
        System.out.println("--------------------------------------");

        // Finding phone numbers by surname
        String search = "Sidorov";
        System.out.println("Searching for "+search+"...");
        for (Map.Entry<String, String> me : set){
            if (me.getValue() == search)
                System.out.println(me.getKey());
        }
        System.out.println("--------------------------------------");
        System.out.println("Starting windowed program...");

        // Заполняем TextField значениями
        frame.refresh_list(frame);
        
        // Делаем окно видимым
        frame.setVisible(true);
    }
}