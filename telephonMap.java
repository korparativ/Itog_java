import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class telephonMap {
    public static void main(String[] args) {
        HashMap <String, String> teleMap = new HashMap<String, String>();
        teleMap.put("Vasia", "4934");
        teleMap.put("Kolia", "4834, 8756, 0978, 3456");
        teleMap.put("Petia", "4564, 9876, 4534");
        teleMap.put("Ira", "4234, 3412");
        Boolean flag = true;
        Scanner scan = new Scanner(System.in);
        while (flag) {
            System.out.println("1 - Поиск телефона\n2 - Просмотр телефонного справочника\n3 - Добавить новый контакт\n4 - Изменить существующий контакт\n5 - Удалить контакт\n6 - Выйти из программы"); 
            String operation = scan.nextLine(); 
            if (operation.equals("1")){
                System.out.println("Введите название контакта");
                String name = scan.nextLine();
                if (teleMap.containsKey(name)){
                    System.out.println(teleMap.get(name));
                }
                else System.out.println("Контакт не найден");

            }
            else if (operation.equals("2")){
                for (Map.Entry entry: teleMap.entrySet()) {
                       System.out.println(entry);
                    }                    
                String [] arr = new String[teleMap.size()];
                int j = 0;
                for(String set: teleMap.keySet()){
                    arr[j++] = set;
                }
                for (int i = 0; i<arr.length; i++){
                    String st;
                    for (int l = 0; l<arr.length-1-i; l++){
                        if ((teleMap.get(arr[l])).split(",").length<(teleMap.get(arr[l+1])).split(",").length){
                            System.out.println(arr[l] + (teleMap.get(arr[l])).split(",").length); 
                            System.out.println((arr[l+1]+teleMap.get(arr[l+1])).split(",").length);                   
                            st = arr[l];
                            arr[l]=arr[l+1];
                            arr[l+1] = st;
                            System.out.println(arr[l]); 
                            System.out.println(arr[l+1]);                           
                        }
                    }                    
                }
                for (int i = 0; i<arr.length; i++){
                    System.out.println(arr[i] + " " + teleMap.get(arr[i]));
                }                
            }
            else if (operation.equals("3")){
                System.out.println("Введите название контакта");
                String name = scan.nextLine();
                if (teleMap.containsKey(name)){
                    System.out.println("Данный контакт уже существует");
                    System.out.println("1 - Добавить номер\n2 - Перезаписать контакт");
                    String oper = scan.nextLine();
                    if (oper.equals("1")) {
                        System.out.println("Введите номер телефона");
                        String phone = scan.nextLine();
                        String num = teleMap.get(name);
                        phone = num + ", " + phone;
                        teleMap.put(name, phone);
                    }
                    else if (oper.equals("2")) {
                        System.out.println("Введите номер телефона");
                        String phone = scan.nextLine();
                        teleMap.put(name, phone);
                    }
                    else System.out.println("Ошибка ввода, попробуйте еще раз");
                }
                else {
                    System.out.println("Введите номер телефона");
                    String phone = scan.nextLine();
                    teleMap.put(name, phone);
                } 
            }
            else if (operation.equals("4")){
                System.out.println("Введите название контакта");
                String name = scan.nextLine();
                if (!teleMap.containsKey(name)){
                    System.out.println("Контакт с таким именем отсутствует");
                }
                else {
                    teleMap.remove(name);
                    System.out.println("Введите новое имя");
                    name = scan.nextLine();
                    System.out.println("Введите номер телефона");
                    String phone = scan.nextLine();
                    teleMap.put(name, phone);
                }
            }
            else if (operation.equals("5")){
                System.out.println("Введите название контакта");
                String name = scan.nextLine();
                teleMap.remove(name);
            }
            else if (operation.equals("6")){
                flag = false;
            }
            else System.out.println("Ошибка ввода, попробуйте еще раз");
        }
    }
    
}
