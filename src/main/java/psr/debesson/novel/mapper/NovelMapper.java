package psr.debesson.novel.mapper;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import fr.xebia.extras.selma.Maps;
import psr.debesson.novel.client.models.NovelEntity;
import psr.debesson.novel.client.models.NovelSummaryEntity;
import psr.debesson.novel.client.models.PremiseEntity;
import psr.debesson.novel.domain.Novel;
import psr.debesson.novel.domain.NovelSummary;
import psr.debesson.novel.domain.Premise;


@Mapper(withIoC = IoC.SPRING)
public abstract class NovelMapper {

    @Maps(withIgnoreFields = "novelSummaryEntity")
    public abstract Novel asNovel(NovelEntity novelEntity);

    @Maps(withIgnoreFields = "novelSummaryEntity")
    public abstract NovelEntity asNovelEntity(Novel novel);

    @Maps(withCustomFields = {
            @Field({"NovelSummary.id", "novelEntity.id"}),
            @Field({"NovelSummary.premise", "NovelSummaryEntity.premiseEntity"}),
            @Field({"NovelSummary.title", "novelEntity.title"}),
            @Field({"NovelSummary.subtitle", "novelEntity.subtitle"})
    })
    public abstract NovelSummary asNovelSummary(NovelSummaryEntity novelSummaryEntity);


    @Maps(withCustomFields = {
            @Field({"NovelSummary.id", "novelEntity.id"}),
            @Field({"NovelSummary.premise", "NovelSummaryEntity.premiseEntity"}),
            @Field({"NovelSummary.title", "novelEntity.title"}),
            @Field({"NovelSummary.subtitle", "novelEntity.subtitle"}),
    }, withIgnoreFields = {"novelEntity", "id"})
    public abstract NovelSummaryEntity asNovelSummaryEntity(NovelSummary novelSummary);

    @Maps
    public abstract PremiseEntity asPremiseEntity(Premise premise);

    @Maps
    public abstract Premise asPremise(PremiseEntity premiseEntity);

}
