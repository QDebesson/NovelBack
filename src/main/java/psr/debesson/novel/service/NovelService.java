package psr.debesson.novel.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psr.debesson.novel.client.models.NovelEntity;
import psr.debesson.novel.client.models.NovelSummaryEntity;
import psr.debesson.novel.client.repository.NovelRepository;
import psr.debesson.novel.client.repository.NovelSummaryRepository;
import psr.debesson.novel.domain.Novel;
import psr.debesson.novel.domain.NovelSummary;
import psr.debesson.novel.mapper.NovelMapper;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class NovelService {

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
        novelsEntity.forEach(novelEntity -> novels.add(novelMapper.asNovel(novelEntity)));
        return novels;
    }

    public Novel saveNovel(Novel novel) {
        NovelEntity novelEntity = novelMapper.asNovelEntity(novel);
        NovelSummaryEntity summaryEntity = new NovelSummaryEntity();
        Novel savedNovel = novelMapper.asNovel(novelRepository.save(novelEntity));
        summaryEntity.setNovelEntity(novelEntity);
        summaryEntity.setStartDate(new Date());
        novelSummaryRepository.save(summaryEntity);
        return savedNovel;
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
            novelEntity.getNovelSummaryEntity().setPremiseEntity(novelMapper.asPremiseEntity(summary.getPremise()));
            novelEntity.getNovelSummaryEntity().setStartDate(summary.getStartDate());
            novelEntity.getNovelSummaryEntity().setTargetedEndDate(summary.getTargetedEndDate());
            novelEntity.setTitle(summary.getTitle());
            novelEntity.setSubtitle(summary.getSubtitle());
            summary.setId(id);
            return summary;
        }
        return null;
    }
}
