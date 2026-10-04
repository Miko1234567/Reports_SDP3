package reports;

public abstract class Report {
    protected Formatter formatter;
    protected String id;
    protected String domainData;

    public Report(Formatter formatter, String id, String domainData) {
        this.formatter = formatter;
        this.id = id;
        this.domainData = domainData;
    }

    public void setImplementation(Formatter formatter) {
        this.formatter = formatter;
    }

    public Formatter getImplementation() {
        return this.formatter;
    }

    public String getId() {
        return id;
    }

    public String getDomainData() {
        return domainData;
    }

    public abstract String execute();
}