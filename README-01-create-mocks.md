## Create mocks in `PortfolioManagerTest`

### Getting familiar with `PortfolioManager`

Let's start by reading through the `PortfolioManager` class in this package to
get familiar with the code we are writing tests for.

There are three methods in this class `getMarketValue`, `buy`, and `sell`. To
accomplish these actions the `PortfolioManager` has a collection of `Stock`
holdings called a `Portfolio`. The `PortfolioManager` also has a connection to
the stock market that can look up prices of stocks and submit buys and submit
sales of stocks called a `StockExchangeClient`. It's going to be important for
us to understand how these methods work and how they use the `Portfolio` and
`StockExchangeClient` in order to add mocking to the tests, so go ahead and read
through the code now.

&nbsp;

### Getting familiar with `PortfolioManagerTest`

Now let's take a look at the tests for the `PortfolioManager`.
`PortfolioManagerTest` has five test methods:
* One for `getMarketValue`
* Two for `buy`
  * One when shares are successfully bought
  * One when you try to buy a stock that doesn't exist
* Two for `sell`
  * One when shares are successfully sold
  * One when called to sell more shares than exist in the `Portfolio`

Read through the `PortfolioManagerTest` class now.

&nbsp;

Run the `PortfolioManagerTest` tests and confirm that the
five tests currently all pass. While they all pass right now, we have no
guarantee they will continue to. We want to add mocking so in the future we can
continue to guarantee that they will all pass. Unfortunately the road to our
eventual successful tests involves many failed tests.

### Convert `Portfolio` and `StockExchangeClient` to mocks in the tests

Using the code in your reading as an example, create mocks of `Portfolio` and
`StockExchangeClient` in the `PortfolioManagerTest` class. The
`PortfolioManager` instantiated in the test class should use the new mocks
you've created.

&nbsp

Run the `PortfolioManagerTest` tests and confirm that four 
of the tests now fail and one passes (they may not appear in this order in your
RDE output):
```
* FAILED
  * getMarketValue_portfolioWithStocks_returnsValueOfStocks()
  * buy_existingStock_returnsCostOfBuyingStock()
  * sell_enoughStocksToSell_returnValueSoldFor()
  * sell_notEnoughStocksToSell_returnZeroValue()
* PASSED
  * buy_nonExistingStock_returnsNull()
```

HINT:
[All five of my tests have still FAILED and I can't figure out why!](./hints/hint-01.md)
 
HINT:
[All five of my tests have still PASSED and I can't figure out why!](./hints/hint-02.md)



  

