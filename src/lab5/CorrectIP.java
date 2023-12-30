import java.util.regex.*;

public class CorrectIP {
    public static void main(String[] args) {
        String ip_address = "192.168.123.250";

        if (checkIPAddress(ip_address)) {
            System.out.println("Введен корректный IP-адрес");
        } else {
            System.out.println("Некорректный IP-адрес");
        }
    }

    public static boolean checkIPAddress(String ip_address) {
        Pattern pattern = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
        Matcher matcher = pattern.matcher(ip_address);

        if (matcher.find()) {
            for (int i = 1; i <= 4; i++) {
                int num = Integer.parseInt(matcher.group(i));
                if (num < 0 || num > 255) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
