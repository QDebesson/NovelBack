package psr.debesson.novel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psr.debesson.novel.client.models.NovelEntity;
import psr.debesson.novel.client.models.NovelSummaryEntity;
import psr.debesson.novel.client.repository.NovelRepository;
import psr.debesson.novel.client.repository.NovelSummaryRepository;
import psr.debesson.novel.domain.Novel;
import psr.debesson.novel.domain.NovelSummary;
import psr.debesson.novel.mapper.NovelMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class NovelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NovelService.class);

    @Autowired
    private NovelRepository novelRepository;

    @Autowired
    private NovelSummaryRepository novelSummaryRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private NovelMapper novelMapper;

    public List<Novel> getNovels() {
        List<NovelEntity> novelsEntity = novelRepository.findAll();
        List<Novel> novels = new ArrayList<>();
        novelsEntity.forEach(novelEntity -> {
            novels.add(novelMapper.asNovel(novelEntity));
        });
        return novels;
    }

    public Novel saveNovel(Novel novel) {
        NovelEntity novelEntity = novelMapper.asNovelEntity(novel);
        return novelMapper.asNovel(novelRepository.save(novelEntity));
    }

    public Novel updateNovel(Novel novel, Long id) {
        NovelEntity novelEntity = novelRepository.findOne(id);
        if (novelEntity != null) {
            novel.setId(id);
            novelRepository.save(novelMapper.asNovelEntity(novel));
            return novel;
        }
        return null;
    }

    public void deleteNovel(Long id) {
        NovelEntity novelEntity = novelRepository.findOne(id);
        if (novelEntity != null) {
            novelRepository.delete(novelEntity);
        }
    }

    public NovelSummary getNovelSummary(Long id) {
        NovelEntity novelEntity = novelRepository.findOne(id);
        if (novelEntity != null) {
            return novelMapper.asNovelSummary(novelEntity.getNovelSummaryEntity());
        }
        return null;
    }

    public NovelSummary saveNovelSummary(Long id, NovelSummary summary) {
        NovelEntity novelEntity = novelRepository.findOne(id);
        if (novelEntity != null) {
            if (novelEntity.getNovelSummaryEntity() == null) {
                // CREATE
                novelEntity.setTitle(summary.getTitle());
                novelEntity.setSubtitle(summary.getSubtitle());
                NovelSummaryEntity summaryEntity = novelMapper.asNovelSummaryEntity(summary);
                novelEntity.setNovelSummaryEntity(summaryEntity);
                summaryEntity.setNovelEntity(novelEntity);
                return novelMapper.asNovelSummary(novelSummaryRepository.save(summaryEntity));
            } else {
                // UPDATE
                novelEntity.getNovelSummaryEntity().setPremiseEntity(novelMapper.asPremiseEntity(summary.getPremise()));
                novelEntity.setTitle(summary.getTitle());
                novelEntity.setSubtitle(summary.getSubtitle());
                summary.setId(id);
                return summary;
            }
        }
        return null;
    }
}
