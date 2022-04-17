package extreme.tddscaffold;

public class BackstagePass extends Goods {

    public final static Integer TEN_DAYS = 10;
    public final static Integer FIVE_DAYS = 5;
    public final static Integer DOUBLE_QUALITY_WHEN_IN_TEN_DAYS = 2;
    public final static Integer TREBLE_QUALITY_WHEN_IN_FIVE_DAYS = 3;

    public BackstagePass() {
    }

    public BackstagePass(Integer sellIn, Integer quality) {
        super(sellIn, quality);
    }

    @Override
    protected Integer calculateCurrentQuality(Integer overDays, Integer changeValueOneDay) {
        int gapDay = super.sellIn - overDays;
        Integer qualityOfCommonPart = (sellIn - TEN_DAYS) * changeValueOneDay;
        Integer qualityOfIn10DaysPart = (overDays - (sellIn - TEN_DAYS)) * DOUBLE_QUALITY_WHEN_IN_TEN_DAYS;
        Integer qualityOfIn5DaysPart = (overDays - (sellIn - FIVE_DAYS)) * TREBLE_QUALITY_WHEN_IN_FIVE_DAYS;

        if (gapDay < 0) {
            return quality = MIN_QUALITY;
        }
        if (gapDay >= TEN_DAYS) {
            quality += overDays * changeValueOneDay;
        }

        if (gapDay < TEN_DAYS && gapDay >= FIVE_DAYS) {
            quality += qualityOfCommonPart + qualityOfIn10DaysPart;
        }

        if (gapDay < FIVE_DAYS) {
            qualityOfIn10DaysPart = DOUBLE_QUALITY_WHEN_IN_TEN_DAYS * FIVE_DAYS;
            quality += qualityOfCommonPart + qualityOfIn10DaysPart + qualityOfIn5DaysPart;
        }

        super.adjustQualityLessThan0OrGreaterThan50();
        return quality;
    }
}
