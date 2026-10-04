package reports;

public class HtmlFormatter implements Formatter {
    @Override
    public String format(String title, String content) {
        return "<html><body><h1>" + title + "</h1><p>" + content + "</p></body></html>";
    }
}