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
 */
public class GoodsTest {

    private Goods goods;

    @BeforeEach
    public void init() {
        goods = new Goods(10, 20);
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
}
