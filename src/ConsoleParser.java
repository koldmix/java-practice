import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsoleParser {
    private  Scanner scanner = new Scanner(System.in);


    public void readPriorityFromConcole(String priorityMenu, Consumer<Priority> userPriority){
        int numberOfPriority = 0;
        while (numberOfPriority < 1 || numberOfPriority > 3){
            System.out.println(priorityMenu);
            try {
                numberOfPriority = Integer.parseInt(scanner.nextLine());
                userPriority.accept(Priority.fromInt(numberOfPriority));
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
            }
        }
    }

    public void readDateFromConcole(DateTimeFormatter dtf, Consumer<String> setDeadLine){
        boolean correctDate = false;
        while (!correctDate){
            System.out.println("Введите дедлайн в формате dd.MM.yy: ");
            String date = scanner.nextLine();
            try {
                LocalDate localDate = LocalDate.parse(date, dtf);
                String deadLine = localDate.format(dtf);
                setDeadLine.accept(deadLine);
                correctDate = true;
            }catch (DateTimeException e){
                System.out.println("Неверный формат даты");
            }
        }
    }

    public int readDeleteNumFromConsole(){
        System.out.println("Введите номер задачи: ");
        return Integer.parseInt(scanner.nextLine());
    }


    public void readFromConsole(String field, Consumer<String> setter){
        System.out.println("Введите " + field);
        setter.accept(scanner.nextLine());
    }
}
