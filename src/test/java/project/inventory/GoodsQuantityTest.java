package project.inventory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodsQuantityTest {

    @Test
    void canBeSold() {
        GoodsQuantity goodsQuantity = new GoodsQuantity();

        assertTrue(goodsQuantity.canBeSold(5, 10));     // Test case where desired quantity is less than available quantity
        assertFalse(goodsQuantity.canBeSold(15, 10));   // Test case where desired quantity is more than available quantity
        assertFalse(goodsQuantity.canBeSold(0, 10));    // Test case where desired quantity is 0
        assertFalse(goodsQuantity.canBeSold(-5, 10));   // Test case where desired quantity is negative
        assertFalse(goodsQuantity.canBeSold(5, 0));     // Test case where available quantity is 0
        assertFalse(goodsQuantity.canBeSold(5, -3));    // Test case where available quantity is negative

    }

}