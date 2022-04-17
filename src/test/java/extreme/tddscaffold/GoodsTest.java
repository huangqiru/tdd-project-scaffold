package extreme.tddscaffold;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tasking
 * 普通商品,价值20, 保质期10天, 每天贬值1
 * 1.Given 过去1天 未超过保质期, when 计算当前价值, then输出19
 * 2.Given 过去10天 未超过保质期, when 计算当前价值, then输出10
 * 3.Given 过去11天 超过保质期, when 计算当前价值, then输出8
 * 4.Given 过去15天 超过保质期, when 计算当前价值, then输出0
 * 5.Given 过去16天 超过保质期, when 计算当前价值, then输出0
 * <p>
 * AgedBrie, 价值20, 每天增值1, 无保质期概念
 * 1.Given 过去1天  when 计算当前价值, then输出21
 * 2.Given 过去30天  when 计算当前价值, then输出50
 * 3.Given 过去31天  when 计算当前价值, then输出50
 * <p>
 * Sulfuras, 价值20, 价值不会变动, 无保质期概念
 * 1.Given 过去1天  when 计算当前价值, then输出20
 * 2.Given 过去20天  when 计算当前价值, then输出20
 * 3.Given 过去40天  when 计算当前价值, then输出20
 * <p>
 * Backstage pass, 价值20,距离演出日20天 每过一天增值1, 距离演出前10天增值2, 距离演出前5天增值3, 过了演出日,价值=0
 * 1.Given 过去1天  when 计算当前价值, then输出21
 * 2.Given 过去10天  when 计算当前价值, then输出30
 * 3.Given 过去11天  when 计算当前价值, then输出32
 * 4.Given 过去15天  when 计算当前价值, then输出40
 * 5.Given 过去16天  when 计算当前价值, then输出43
 * 6.Given 过去20天  when 计算当前价值, then输出50
 * 7.Given 过去21天  when 计算当前价值, then输出0
 * 8.Given 过去50天  when 计算当前价值, then输出0
 */
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
