import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        DataManager dataManager = new DataManager();
        dataManager.registerDataProcessor(new DataProcessors());


        dataManager.loadData("E:\\los1\\uechebnoe\\итип\\projects\\Lab9\\src\\input.txt");

        dataManager.processData();

        dataManager.saveData("E:\\los1\\uechebnoe\\итип\\projects\\Lab9\\src\\output.txt");
    }
}
