package reports;

public class AttendanceReport extends Report {

    public AttendanceReport(Formatter formatter, String id) {
        super(formatter, id, "Attendance: 3 of 4 attended sessions (75%)");
    }

    @Override
    public String execute() {
        return formatter.format("Attendance Report", domainData);
    }
}