# Defining Behavior

## Define behavior in `PortfolioManagerTest`

Let's get our first test passing again! Refactor
`getMarketValue_portfolioWithStocks_returnsValueOfStocks()` defining the
behavior of the mock(s) used in this method. What methods of these mocked
objects will `getMarketValue` call? What should the mocks return to satisfy
the test case that the portfolio has stocks.

&nbsp;

Run the `PortfolioManagerTest` tests. We should see the
`getMarketValue_portfolioWithStocks_returnsValueOfStocks()` now pass.
```
* FAILED
  * buy_existingStock_returnsCostOfBuyingStock()
  * sell_enoughStocksToSell_returnValueSoldFor()
  * sell_notEnoughStocksToSell_returnZeroValue()
* PASSED
  * getMarketValue_portfolioWithStocks_returnsValueOfStocks()
  * buy_nonExistingStock_returnsNull()
```

HINT:
[I'm not sure what mock object(s) are being used in this method!](./hints/hint-03.md)

HINT:
[I'm not sure which method(s) are being called on the mock object(s)!](./hints/hint-05.md)

## Define exceptional behavior in `PortfolioManagerTest`

Time to tackle another test method! Refactor
`sell_notEnoughStocksToSell_returnZeroValue()` defining the behavior of the
mock(s) used in this method. What method(s) are you calling on these mocks and
what are you expecting them to return? Are you expecting them to throw any
exceptions?

&nbsp;

Run the `PortfolioManagerTest` tests. We should see the
`sell_notEnoughStocksToSell_returnZeroValue()` now pass.
```
* FAILED
  * buy_existingStock_returnsCostOfBuyingStock()
  * sell_enoughStocksToSell_returnValueSoldFor()
* PASSED
  * getMarketValue_portfolioWithStocks_returnsValueOfStocks()
  * buy_nonExistingStock_returnsNull()
  * sell_notEnoughStocksToSell_returnZeroValue()
```

HINT:
[I'm seeing an error message and my code is not compiling when trying to define the behavior of my mock!](./hints/hint-07.md)

## Verifying interactions with mocks

Okay let's fix those remaining tests! It may surprise you that we even need to
fix the test that's been passing this entire time.
`buy_nonExistingStock_returnsNull()` has been passing because mocks with
undefined behavior return null, which is exactly what this test requires. But
for readability and increased documentation of our code, we want to make that
explicit. We also want to verify some interactions with mocks in this test! This
is true for all 3 remaining tests we want to refactor - we want to both define
behavior (when/then) and verify interactions with the mocks.
 * buy_existingStock_returnsCostOfBuyingStock()
 * buy_nonExistingStock_returnsNull()
 * sell_enoughStocksToSell_returnValueSoldFor()

&nbsp;

Run the `PortfolioManagerTest` tests. You should now see all
of the tests pass!
```
* PASSED
  * getMarketValue_portfolioWithStocks_returnsValueOfStocks()
  * buy_existingStock_returnsCostOfBuyingStock()
  * buy_nonExistingStock_returnsNull()
  * sell_enoughStocksToSell_returnValueSoldFor()
  * sell_notEnoughStocksToSell_returnZeroValue()
```

HINT:
[I'm having trouble figuring out what to verify in buy_nonExistingStock_returnsNull!](./hints/hint-09.md)

## Fixing the unit tests in StockExchangeClientTest

Let's take a look at the `StockExchangeClientTest`. This test class is already set up to
use mocks in its tests, but one of the test methods is failing: `getPrice_nonExistentStock_returnsNull`.
Run the `StockExchangeClient` tests to prove to yourself that this test is failing. We haven't
defined any behavior for our mocks yet in this method. Let's go ahead and define the expected behavior in
this test method. When you've completed this, you should see all of
the tests passing.
