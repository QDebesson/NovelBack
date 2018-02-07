package psr.debesson.novel.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import psr.debesson.novel.client.models.NovelSummaryEntity;

@Repository
public interface NovelSummaryRepository extends JpaRepository<NovelSummaryEntity, Long> {
}
