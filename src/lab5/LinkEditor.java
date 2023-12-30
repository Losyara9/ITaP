import java.util.regex.*;

public class LinkEditor {
    public static void main(String[] args) {
        String text = "www.example.com www.bebra.com http://example.org";

        Pattern pattern = Pattern.compile("(www\\.[^\\s]+)");
        Matcher matcher = pattern.matcher(text);

        boolean foundMatch = false;

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            foundMatch = true;
            String url = matcher.group();
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "http://" + url;
            }
            matcher.appendReplacement(sb, url);

        }
        matcher.appendTail(sb);

        if (foundMatch) {
            String modifiedText = sb.toString();
            System.out.println(modifiedText);
        } else {
            System.out.println("В тексте нет ссылок для редактирования.");
        }
    }
}
