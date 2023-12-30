import java.util.HashMap;
import java.util.HashSet;

public class SalesTracker {
    private HashSet<SalesRecord> salesRecords;

    public SalesTracker() {
        salesRecords = new HashSet<>();
    }

    public void addSale(String productName, double price) {
        SalesRecord newRecord = new SalesRecord(productName, price);
        salesRecords.add(newRecord);
    }

    public void displaySales() {
        for (SalesRecord record : salesRecords) {
            System.out.println("Product: " + record.getProductName() + ", Price: " + record.getPrice());
        }
    }

    public double calculateTotalSales() {
        double totalSales = 0;
        for (SalesRecord record : salesRecords) {
            totalSales += record.getPrice();
        }
        return totalSales;
    }

    public String getMostPopularProduct() {
        HashMap<String, Integer> productCount = new HashMap<>();
        String mostPopularProduct = null;
        int maxCount = 0;

        for (SalesRecord record : salesRecords) {
            String productName = record.getProductName();
            int count = productCount.getOrDefault(productName, 0) + 1;
            productCount.put(productName, count);
            if (count > maxCount) {
                mostPopularProduct = productName;
                maxCount = count;
            }
        }

        return mostPopularProduct;
    }

}
