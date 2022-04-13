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

        if (gapDay < 0) {
            return quality = 0;
        }
        if (gapDay < 10 && gapDay >= 5) {
            quality += (sellIn - 10) * changeValueOneDay + (overDays - (sellIn - 10)) * 2;
        }
        if (gapDay < 5) {
            quality += (sellIn - 10) * changeValueOneDay + (5 * 2) + (overDays - (sellIn - 5)) * 3;
        }

        super.adjustQualityLessThan0OrGreaterThan50();
        return quality;
    }
}
