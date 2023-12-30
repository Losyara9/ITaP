import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CustomFileNotFoundException extends FileNotFoundException {

    // Класс CustomFileNotFoundException наследует от класса FileNotFoundException и добавляет конструктор с сообщением

    public CustomFileNotFoundException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        try {
            // Пытаемся прочитать файл "nonexistentFile.txt"
            readFile("E:\\los1\\uechebnoe\\итип\\projects\\Lab_5\\src\\source.txt");
        } catch (CustomFileNotFoundException e) {
            // Если файл не найден, ловим исключение CustomFileNotFoundException и передаем его в метод logException
            logException(e);
        }
    }

    public static void readFile(String fileName) throws CustomFileNotFoundException {
        // Создаем объект File для файла с заданным именем
        File file = new File(fileName);
        // Проверяем, существует ли файл
        if (!file.exists()) {
            // Если файл не существует, выбрасываем исключение CustomFileNotFoundException с сообщением
            throw new CustomFileNotFoundException("File not found: " + fileName);
        }
        // Здесь должен быть код для чтения файла, но он отсутствует в данном примере
    }

    public static void logException(Exception e) {
        try (FileWriter writer = new FileWriter("exceptionLog.txt", true)) {
            // Пытаемся записать сообщение об исключении в файл exceptionLog.txt
            writer.write(e.getMessage() + "\n");
        } catch (IOException ex) {
            // Если возникает ошибка при записи в файл, выводим сообщение об ошибке
            System.out.println("Error writing to log file: " + ex.getMessage());
        }
    }
}
