package extreme.tddscaffold;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GoodsTest {

    private Goods goods;
    private AgedBrie agedBrie;
    private Sulfuras sulfuras;
    private BackstagePass backstagePass;

    @BeforeEach
    public void init() {
        goods = new Goods(10, 20);
        agedBrie = new AgedBrie(0, 20);
        sulfuras = new Sulfuras(0, 20);
        backstagePass = new BackstagePass(20, 20);
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

    @Test
    void should_return_20_when_calculate_given_Sulfuras_overDay_is_1() {
        Integer quality = sulfuras.calculateCurrentQuality(1, 0);
        Assertions.assertEquals(20, quality);
    }

    @Test
    void should_return_20_when_calculate_given_Sulfuras_overDay_is_20() {
        Integer quality = sulfuras.calculateCurrentQuality(20, 0);
        Assertions.assertEquals(20, quality);
    }

    @Test
    void should_return_20_when_calculate_given_Sulfuras_overDay_is_40() {
        Integer quality = sulfuras.calculateCurrentQuality(40, 0);
        Assertions.assertEquals(20, quality);
    }

    @Test
    void should_return_21_when_calculate_given_BackstagePass_overDay_is_1() {
        Integer quality = backstagePass.calculateCurrentQuality(1, 1);
        Assertions.assertEquals(21, quality);
    }

    @Test
    void should_return_30_when_calculate_given_BackstagePass_overDay_is_10() {
        Integer quality = backstagePass.calculateCurrentQuality(10, 1);
        Assertions.assertEquals(30, quality);
    }

    @Test
    void should_return_32_when_calculate_given_BackstagePass_overDay_is_11() {
        Integer quality = backstagePass.calculateCurrentQuality(11, 1);
        Assertions.assertEquals(32, quality);
    }

    @Test
    void should_return_40_when_calculate_given_BackstagePass_overDay_is_15() {
        Integer quality = backstagePass.calculateCurrentQuality(15, 1);
        Assertions.assertEquals(40, quality);
    }

    @Test
    void should_return_43_when_calculate_given_BackstagePass_overDay_is_16() {
        Integer quality = backstagePass.calculateCurrentQuality(16, 1);
        Assertions.assertEquals(43, quality);
    }

    @Test
    void should_return_50_when_calculate_given_BackstagePass_overDay_is_20() {
        Integer quality = backstagePass.calculateCurrentQuality(20, 1);
        Assertions.assertEquals(50, quality);
    }

    @Test
    void should_return_0_when_calculate_given_BackstagePass_overDay_is_21() {
        Integer quality = backstagePass.calculateCurrentQuality(21, 1);
        Assertions.assertEquals(0, quality);
    }

    @Test
    void should_return_0_when_calculate_given_BackstagePass_overDay_is_50() {
        Integer quality = backstagePass.calculateCurrentQuality(50, 1);
        Assertions.assertEquals(0, quality);
    }

}
