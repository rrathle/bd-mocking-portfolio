On line 23 of `PortfolioManager` we see a reference to the `Portfolio` type.
That means our `Portfolio` mock is being used in this method and we need to
define its behavior.

On line 27 of `PortfolioManager` we see a reference to the `StockExchangeClient`
type. That means our `StockExchangeClient` mock is being used in this method and
we need to define its behavior.

Both mocked objects are being used in the `getMarketValue` method.
