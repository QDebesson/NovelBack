package psr.debesson.novel.domain;

import java.util.Date;
import java.util.Objects;

public class NovelSummary {
    private Long id;

    private String title;

    private String subtitle;

    private Date startDate;

    private Date targetedEndDate;

    private Premise premise;

    public NovelSummary() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getTargetedEndDate() {
        return targetedEndDate;
    }

    public void setTargetedEndDate(Date targetedEndDate) {
        this.targetedEndDate = targetedEndDate;
    }

    public Premise getPremise() {
        return premise;
    }

    public void setPremise(Premise premise) {
        this.premise = premise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NovelSummary that = (NovelSummary) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "NovelSummary{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", startDate=" + startDate +
                ", targetedEndDate=" + targetedEndDate +
                ", premise=" + premise +
                '}';
    }
}
