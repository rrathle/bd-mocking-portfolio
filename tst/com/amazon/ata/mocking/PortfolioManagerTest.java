package com.amazon.ata.mocking;

import com.amazon.stock.InsufficientStockException;
import com.amazon.stock.Stock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class PortfolioManagerTest {
    private Stock amznStock = new Stock("amzn", "Amazon");
    private BigDecimal currentAmazonStockPrice = BigDecimal.valueOf(1_000L);
    private int quantityInPortfolio = 3;
    private Map<Stock, Integer> portfolioStocks;

    private Stock nonExistentStock = new Stock("id", "name");

    @Mock
    private Portfolio portfolio;
    @Mock
    private StockExchangeClient client;

    @InjectMocks
    private PortfolioManager portfolioManager;

    @BeforeEach
    void setUp() {
        initMocks(this);
        portfolioStocks = new HashMap<>();
        portfolioStocks.put(amznStock, quantityInPortfolio);
    }

    @Test
    void getMarketValue_portfolioWithStocks_returnsValueOfStocks() {
        // GIVEN
        BigDecimal expectedValue = currentAmazonStockPrice.multiply(BigDecimal.valueOf(quantityInPortfolio));
        when(portfolio.getStocks()).thenReturn(portfolioStocks);
        when(client.getPrice(amznStock)).thenReturn(currentAmazonStockPrice);

        // WHEN
        BigDecimal value = portfolioManager.getMarketValue();

        // THEN
        assertEquals(expectedValue, value);
    }

    @Test
    void buy_existingStock_returnsCostOfBuyingStock() {
        // GIVEN
        int quantityToBuy = 5;
        BigDecimal expectedCost = currentAmazonStockPrice.multiply(BigDecimal.valueOf(quantityToBuy));
        when(client.submitBuy(amznStock, quantityToBuy)).thenReturn(expectedCost);

        // WHEN
        BigDecimal cost = portfolioManager.buy(amznStock, quantityToBuy);

        // THEN
        assertEquals(expectedCost, cost);
        verify(portfolio).addStocks(amznStock, quantityToBuy);
    }

    @Test
    void buy_nonExistingStock_returnsNull() {
        // GIVEN
        int quantityToBuy = 5;
        when(client.submitBuy(nonExistentStock, quantityToBuy)).thenReturn(null);

        // WHEN
        BigDecimal cost = portfolioManager.buy(nonExistentStock, quantityToBuy);

        // THEN
        assertNull(cost);
        verifyZeroInteractions(portfolio);
    }

    @Test
    void sell_enoughStocksToSell_returnValueSoldFor() throws InsufficientStockException {
        // GIVEN
        int quantityToSell = quantityInPortfolio - 1;
        BigDecimal expectedValue = currentAmazonStockPrice.multiply(BigDecimal.valueOf(quantityToSell));
        when(client.submitSell(amznStock, quantityToSell)).thenReturn(expectedValue);

        // WHEN
        BigDecimal value = portfolioManager.sell(amznStock, quantityToSell);

        // THEN
        assertEquals(expectedValue, value);
        verify(portfolio).removeStocks(amznStock, quantityToSell);
    }

    @Test
    void sell_notEnoughStocksToSell_returnZeroValue() throws InsufficientStockException {
        // GIVEN
        int quantityToSell = quantityInPortfolio + 1;
        doThrow(InsufficientStockException.class).when(portfolio).removeStocks(amznStock, quantityToSell);

        // WHEN
        BigDecimal value = portfolioManager.sell(amznStock, quantityToSell);

        // THEN
        assertEquals(BigDecimal.ZERO, value);
        verifyZeroInteractions(client);
    }
}
