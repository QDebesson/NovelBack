package psr.debesson.novel.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "novel_summary")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class NovelSummaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_novel")
    private NovelEntity novelEntity;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "estimated_end_date")
    @Temporal(TemporalType.DATE)
    private Date targetedEndDate;

    @Embedded
    private PremiseEntity premiseEntity;


    public NovelSummaryEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NovelEntity getNovelEntity() {
        return novelEntity;
    }

    public void setNovelEntity(NovelEntity novelEntity) {
        this.novelEntity = novelEntity;
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

    public PremiseEntity getPremiseEntity() {
        return premiseEntity;
    }

    public void setPremiseEntity(PremiseEntity premiseEntity) {
        this.premiseEntity = premiseEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NovelSummaryEntity that = (NovelSummaryEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "NovelSummaryEntity{" +
                "id=" + id +
                ", novelEntity=" + novelEntity +
                ", startDate=" + startDate +
                ", targetedEndDate=" + targetedEndDate +
                ", premiseEntity=" + premiseEntity +
                '}';
    }
}
