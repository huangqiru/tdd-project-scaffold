package extreme.tddscaffold;


public class Goods {

    protected Integer sellIn;
    protected Integer quality;
    public final static Integer MIN_QUALITY = 0;
    public final static Integer MAX_QUALITY = 50;
    public final static Integer DOUBLE_QUALITY_WHEN_EXPIRE = 2;

    public Goods() {
    }

    public Goods(Integer sellIn, Integer quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    protected Integer calculateCurrentQuality(Integer overDays, Integer changeValueOneDay) {
        boolean isExpire = sellIn < overDays;

        if (!isExpire) {
            quality += overDays * changeValueOneDay;
        }

        if (isExpire) {
            int qualityOfInSellInPart = sellIn * changeValueOneDay;
            int qualityOfOverSellInPart = (overDays - sellIn) * DOUBLE_QUALITY_WHEN_EXPIRE * changeValueOneDay;
            quality += qualityOfInSellInPart + qualityOfOverSellInPart;
        }

        adjustQualityLessThan0OrGreaterThan50();
        return quality;
    }

    protected void adjustQualityLessThan0OrGreaterThan50() {
        quality = quality < MIN_QUALITY ? MIN_QUALITY : quality;
        quality = quality > MAX_QUALITY ? MAX_QUALITY : quality;
    }

    public Integer getSellIn() {
        return sellIn;
    }

    public void setSellIn(Integer sellIn) {
        this.sellIn = sellIn;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }
}
