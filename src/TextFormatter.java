package reports;

public class TextFormatter implements Formatter {
    @Override
    public String format(String title, String content) {
        return "--- " + title + " ---\n" + content;
    }
}