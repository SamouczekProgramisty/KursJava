package pl.samouczekprogramisty.kursjava.json;

import java.time.LocalDate;

public class Newspaper {
    private String title;
    private int circulation;
    private LocalDate issueDate;

    @SuppressWarnings("unused")
    public Newspaper() {
    }

    public Newspaper(String title, int circulation, LocalDate issueDate) {
        this.title = title;
        this.circulation = circulation;
        this.issueDate = issueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCirculation() {
        return circulation;
    }

    public void setCirculation(int circulation) {
        this.circulation = circulation;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }
}
