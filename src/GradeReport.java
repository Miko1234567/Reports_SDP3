package reports;

public class GradeReport extends Report {

    public GradeReport(Formatter formatter, String id) {
        super(formatter, id, "Grades: 70, 80, 90 | Average: 80");
    }

    @Override
    public String execute() {
        return formatter.format("Grade Report", domainData);
    }
}