package extreme.tddscaffold;

public class BackstagePass extends Goods {
    public BackstagePass() {
    }

    public BackstagePass(Integer sellIn, Integer quality) {
        super(sellIn, quality);
    }

    @Override
    protected Integer calculateCurrentQuality(Integer overDays, Integer changeValueOneDay) {
        int gapDay = super.sellIn - overDays;
        Integer qualityOfCommonPart=(sellIn - 10) * changeValueOneDay;
        Integer qualityOfIn10DaysPart=(overDays - (sellIn - 10)) * 2;
        Integer qualityOfIn5DaysPart=(overDays - (sellIn - 5)) * 3;

        if (gapDay < 0) {
            return quality = 0;
        }
        if (gapDay >= 10) {
            quality += overDays * changeValueOneDay;
        }

        if (gapDay < 10 && gapDay >= 5) {
            quality += qualityOfCommonPart+ qualityOfIn10DaysPart;
        }

        if (gapDay < 5) {
            qualityOfIn10DaysPart=2*5;
            quality += qualityOfCommonPart + qualityOfIn10DaysPart + qualityOfIn5DaysPart;
        }

        super.adjustQualityLessThan0OrGreaterThan50();
        return quality;
    }
}
