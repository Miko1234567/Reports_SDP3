import reports.*;

public class main {
    public static void main(String[] args) {
        int passed = 0;
        int total = 7;

        Report r1 = new AttendanceReport(new TextFormatter(), "R001");
        String res1 = r1.execute();
        boolean passT1 = res1.contains("Attendance Report") && res1.contains("75%") && res1.contains("---");
        printTestResult("T1", passT1, "AttendanceReport + TextFormatter", res1);
        if (passT1) passed++;

        Report r2 = new AttendanceReport(new HtmlFormatter(), "R001");
        String res2 = r2.execute();
        boolean passT2 = res2.contains("<html>") && res2.contains("75%");
        printTestResult("T2", passT2, "AttendanceReport + HtmlFormatter", res2);
        if (passT2) passed++;

        Report r3 = new GradeReport(new TextFormatter(), "R002");
        String res3 = r3.execute();
        boolean passT3 = res3.contains("Grade Report") && res3.contains("Average: 80");
        printTestResult("T3", passT3, "GradeReport + TextFormatter", res3);
        if (passT3) passed++;

        Report r4 = new GradeReport(new HtmlFormatter(), "R002");
        String res4 = r4.execute();
        boolean passT4 = res4.contains("<html>") && res4.contains("Average: 80");
        printTestResult("T4", passT4, "GradeReport + HtmlFormatter", res4);
        if (passT4) passed++;

        Report r5 = new AttendanceReport(new TextFormatter(), "R005");
        Report originalRef = r5;
        String beforeSwitch = r5.execute();

        r5.setImplementation(new HtmlFormatter());
        String afterSwitch = r5.execute();

        boolean sameObj = (r5 == originalRef);
        boolean stateUnchanged = r5.getId().equals("R005") && r5.getDomainData().contains("75%");
        boolean passT5 = sameObj && stateUnchanged && beforeSwitch.contains("---") && afterSwitch.contains("<html>");

        System.out.println("T5 " + (passT5 ? "PASS" : "FAIL") + " sameObject=" + sameObj + " | stateUnchanged=" + stateUnchanged);
        System.out.println("  before=" + beforeSwitch);
        System.out.println("  after=" + afterSwitch);
        if (passT5) passed++;
        
        Report r6 = new AttendanceReport(new MarkdownFormatter(), "R001");
        String res6 = r6.execute();
        boolean passT6 = res6.contains("# Attendance Report") && res6.contains("75%");
        printTestResult("T6", passT6, "AttendanceReport + MarkdownFormatter (I3)", res6);
        if (passT6) passed++;

        Report r7 = new GradeReport(new MarkdownFormatter(), "R002");
        String res7 = r7.execute();
        boolean passT7 = res7.contains("# Grade Report") && res7.contains("Average: 80");
        printTestResult("T7", passT7, "GradeReport + MarkdownFormatter (I3)", res7);
        if (passT7) passed++;

        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
    }

    private static void printTestResult(String id, boolean passed, String combo, String actual) {
        System.out.println(id + " " + (passed ? "PASS" : "FAIL") + " | " + combo + " | result=" + actual.replace("\n", " \\n "));
    }
}
