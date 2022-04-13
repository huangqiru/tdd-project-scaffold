package extreme.tddscaffold;


public class Goods {

    protected Integer sellIn;
    protected Integer quality;

    public Goods() {
    }

    public Goods(Integer sellIn, Integer quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    protected Integer calculateCurrentQuality(Integer overDays, Integer changeValueOneDay) {
        if (sellIn >= overDays) {
            quality += overDays * changeValueOneDay;
        }
        if (sellIn < overDays ) {
            quality += (sellIn * changeValueOneDay + (overDays - sellIn) * 2 * changeValueOneDay);
        }
        adjustQualityLessThan0OrGreaterThan50();
        return quality;
    }

    protected void adjustQualityLessThan0OrGreaterThan50() {
        quality = quality < 0 ? 0 : quality;
        quality = quality > 50 ? 50 : quality;
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
