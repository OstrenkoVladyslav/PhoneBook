// https://github.com/OstrenkoVladyslav/PhoneBook.git
package phonebook;

import java.util.*;
import java.awt.*;

public class PhoneBook extends Frame {
     // Объявляем и создаем менеджер расположения
     BorderLayout manager = new BorderLayout();
     // Объявляем и создаем кнопку
     Button button = new Button();
     public PhoneBook () {
          try {
               // Настраиваем окно и элементы управления
               init();
          }
          catch(Exception e) {
               e.printStackTrace();
          }
    }
     
    private void init() throws Exception {
        // Делаем надпись на кнопке
        button.setLabel("Ok");
        // Задаем размеры окна в пикселях
        this.setSize(new Dimension(400, 300));
        // Устанавливаем строку в заголовке окна
        this.setTitle("Frame Title");
        // Устанавливаем менеджер расположения в окне
        this.setLayout(manager);
        // Добавляем кнопку в окно, задавая при этом
        // ограничения, специфичные для данного менеджера
        this.add(button, BorderLayout.SOUTH);
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
                if (me.getValue() == search)
                    System.out.println(me.getKey());
            }

            // Создаем объект окна
            PhoneBook frame = new PhoneBook();
            // Делаем окно видимым
            frame.setVisible(true);
    }
}
