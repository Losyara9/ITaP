import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        File file = new File("E:\\los1\\uechebnoe\\итип\\projects\\Lab7\\src\\words.txt");
        // создаем объект Scanner для чтения файла
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // создаем объект Map для хранения слов и их количества
        Map<String, Integer> wordsCount = new HashMap<>();
        // читаем файл по словам и добавляем их в Map
        while (scanner.hasNext()) {
            String word = scanner.next().replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase();
            if (!word.isEmpty()) {
                if (wordsCount.containsKey(word)) {
                    wordsCount.put(word, wordsCount.get(word) + 1);
                } else {
                    wordsCount.put(word, 1);
                }
            }
        }
        // закрываем Scanner
        scanner.close();
        // создаем список из элементов Map
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordsCount.entrySet());
        // сортируем список по убыванию количества повторений
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        // выводим топ-10 слов
        System.out.println("Top 10 words:");
        for (int i = 0; i < 10 && i < list.size(); i++) {
            System.out.println(list.get(i).getKey() + " - " + list.get(i).getValue());
        }

    }

}
