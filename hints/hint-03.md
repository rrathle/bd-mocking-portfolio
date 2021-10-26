Here we are testing the `getMarketValue` method. We've created mocks of the
`Portfolio` class and the `StockExchangeClient` class and passed them to the
`PortfolioManager` via the constructor. To figure out which behavior we need to
define for this test we need to trace through the source code for the
`getMarketValue` method and see how those classes are used. Which type is used
in `getMarketValue`? `Portfolio`? `StockExchangeClient`? Both?

HINT:
[I've read through the `getMarketValue` method and I still don't know which mock objects are being used in this method!](./hint-04.md)
