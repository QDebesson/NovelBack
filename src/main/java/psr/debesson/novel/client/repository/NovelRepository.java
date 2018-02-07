package psr.debesson.novel.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import psr.debesson.novel.client.models.NovelEntity;

@Repository
public interface NovelRepository extends JpaRepository<NovelEntity, Long> {
}
