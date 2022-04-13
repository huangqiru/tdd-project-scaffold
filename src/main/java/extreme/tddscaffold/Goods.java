package extreme.tddscaffold;

public class Goods {

    private Integer sellIn;
    private Integer quality;

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
        if (sellIn < overDays) {
            quality += (sellIn * changeValueOneDay + (overDays - sellIn) * 2 * changeValueOneDay);
        }
        if (quality < 0 ) {
            quality = 0;
        }
        if (quality > 50) {
            quality = 50;
        }
        return quality;
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
