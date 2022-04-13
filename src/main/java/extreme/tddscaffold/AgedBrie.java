package extreme.tddscaffold;

public class AgedBrie extends Goods {

    public AgedBrie() {
    }

    public AgedBrie(Integer sellIn, Integer quality) {
        super(sellIn, quality);
    }

    @Override
    protected Integer calculateCurrentQuality(Integer overDays, Integer changeValueOneDay) {
        super.quality += overDays * changeValueOneDay;
        super.adjustQualityLessThan0OrGreaterThan50();
        return quality;
    }
}
