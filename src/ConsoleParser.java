import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.function.Consumer;

public final class ConsoleParser {
    private static Scanner scanner = new Scanner(System.in);

    private ConsoleParser() {
    }

    public static void readPriorityFromConcole(String priorityMenu, Consumer<Priority> userPriority) {
        int numberOfPriority = 0;
        while (numberOfPriority < 1 || numberOfPriority > 3) {
            System.out.println(priorityMenu);
            try {
                numberOfPriority = Integer.parseInt(scanner.nextLine());
                userPriority.accept(Priority.fromInt(numberOfPriority));
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
            }
        }
    }

    public static void readDateFromConcole(DateTimeFormatter dtf, Consumer<String> setDeadLine) {
        boolean correctDate = false;
        while (!correctDate) {
            System.out.println("Введите дедлайн в формате dd.MM.yy: ");
            String date = scanner.nextLine();
            try {
                LocalDate localDate = LocalDate.parse(date, dtf);
                String deadLine = localDate.format(dtf);
                setDeadLine.accept(deadLine);
                correctDate = true;
            } catch (DateTimeException e) {
                System.out.println("Неверный формат даты");
            }
        }
    }

    public static int readDeleteNumFromConsole() {
        while (true) {
            System.out.println("Введите номер задачи: ");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Введите число");
            }
        }
    }


    public static void readFromConsole(String field, Consumer<String> setter) {
        System.out.println("Введите " + field);
        setter.accept(scanner.nextLine());
    }
}
