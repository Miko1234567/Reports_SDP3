# Report Formatter

This project demonstrates the **Strategy Pattern** in Java.

## Features

* `Report` — abstract base class for reports.
* `AttendanceReport` — attendance report.
* `GradeReport` — grade report.
* `Formatter` — interface for formatting reports.
* `TextFormatter` — formats reports as plain text.
* `HtmlFormatter` — formats reports as HTML.
* `MarkdownFormatter` — formats reports as Markdown.

## Strategy Pattern

The `Formatter` interface allows changing the report format without changing the report itself.

Example:

```java
Report report = new GradeReport(new TextFormatter(), "R002");
report.setImplementation(new HtmlFormatter());
```

## Testing

The `main` class contains 7 tests.

Expected result:

```text
SUMMARY: 7/7 PASS
```
