package extreme.tddscaffold;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GoodsTest {

    private Goods goods;
    private AgedBrie agedBrie;

    @BeforeEach
    public void init() {
        goods = new Goods(10, 20);
        agedBrie = new AgedBrie(0, 20);
    }

    @Test
    void should_return_19_when_calculate_given_Goods_overDay_is_1() {
        Integer quality = goods.calculateCurrentQuality(1, -1);
        Assertions.assertEquals(19, quality);
    }

    @Test
    void should_return_10_when_calculate_given_Goods_overDay_is_10() {
        Integer quality = goods.calculateCurrentQuality(10, -1);
        Assertions.assertEquals(10, quality);
    }

    @Test
    void should_return_8_when_calculate_given_Goods_overDay_is_11() {
        Integer quality = goods.calculateCurrentQuality(11, -1);
        Assertions.assertEquals(8, quality);
    }

    @Test
    void should_return_0_when_calculate_given_Goods_overDay_is_15() {
        Integer quality = goods.calculateCurrentQuality(15, -1);
        Assertions.assertEquals(0, quality);
    }

    @Test
    void should_return_0_when_calculate_given_Goods_overDay_is_16() {
        Integer quality = goods.calculateCurrentQuality(16, -1);
        Assertions.assertEquals(0, quality);
    }

    @Test
    void should_return_21_when_calculate_given_AgedBrie_overDay_is_1() {
        Integer quality = agedBrie.calculateCurrentQuality(1, 1);
        Assertions.assertEquals(21, quality);
    }

    @Test
    void should_return_50_when_calculate_given_AgedBrie_overDay_is_30() {
        Integer quality = agedBrie.calculateCurrentQuality(31, 1);
        Assertions.assertEquals(50, quality);
    }

    @Test
    void should_return_50_when_calculate_given_AgedBrie_overDay_is_31() {
        Integer quality = agedBrie.calculateCurrentQuality(31, 1);
        Assertions.assertEquals(50, quality);
    }
}
