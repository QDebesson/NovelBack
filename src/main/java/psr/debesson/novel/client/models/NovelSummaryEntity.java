package psr.debesson.novel.client.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

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
                ", premiseEntity=" + premiseEntity +
                '}';
    }
}
