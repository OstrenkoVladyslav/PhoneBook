// https://github.com/OstrenkoVladyslav/PhoneBook.git
package phonebook;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class PhoneBook extends Frame {

    protected java.awt.List data_list = new java.awt.List();
    protected HashMap phonebook = new HashMap();
    Panel panel1, panel2, panel3;
    protected TextField number_field = new TextField();
    protected TextField surname_field = new TextField();
    //protected Label number_label, surname_label;
    
    public PhoneBook (String title) {
        super(title);
        this.phonebook = new HashMap();
        this.panel1 = new Panel();
        this.panel2 = new Panel();
        Label number_label = new Label("Number: ");
        Label surname_label = new Label("Surname: ");
        //this.TextField number_field = new TextField();
        //this.TextField surname_field = new TextField();
        
        try {
            BorderLayout manager = new BorderLayout();
            setLayout(manager);
            setSize(500, 300);
            setLocationRelativeTo(null);
            setResizable(true);

            // Создаем панель с полем "Number"
            panel1.add(number_label);
            number_field = (TextField) panel1.add(new TextField("0506543210",15));
            //number_field.setText("0505556677");

            // Создаем надпись и поле "Surname"
            panel1.add(surname_label);
            surname_field = (TextField) panel1.add(new TextField("Zatulovsky",15));
            //surname_field.setText("Zatulovsky");

            // Создаем кнопку "Add"
            Button add_button = (Button) panel1.add(new Button("Add"));
            add (panel1, BorderLayout.NORTH);

            // Создаем новую панель и добавляем туда список
            Panel panel2 = new Panel();
            this.data_list = new java.awt.List(10);
            panel2.add(data_list);
            add(panel2, BorderLayout.CENTER);

            Button button_ok = new Button("Ok");
            Button button_add = new Button("Add record");

            //Создадим слушателей
            

            addWindowListener(new MyWindowAdapter());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
     
    public static void refresh_list(PhoneBook frame){
        Set<Map.Entry<String, String>> set = frame.phonebook.entrySet();
        frame.data_list.clear();
        for (Map.Entry<String, String> me : set){
            frame.data_list.add(me.getKey()+"  "+me.getValue());
        }
        frame.data_list.setVisible(true);
    }
    
    public void add_record(){
        String number = this.number_field.getText();
        String surname = surname_field.getText();
        this.phonebook.put(number,surname);
        //phonebook.put("0505554433","Putin");
    }
    
    class MyWindowAdapter extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent we){
            System.exit(0);
        }
    }
    
    class AddRecordListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //phonebook.put(number_field.getText(),);
            PhoneBook.add_record();
            refresh_list();
        }
        
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
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
        // Finding surname by phone number
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

        // Создаем объект окна

        frame.phonebook.put(frame.number_field.getText(),frame.surname_field.getText());
        frame.phonebook.put("123456789","qwerty");
        refresh_list(frame);

        //add_record();
        frame.setVisible(true);

    }
}