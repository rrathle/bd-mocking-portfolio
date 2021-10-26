On line 23 of `PortfolioManager` we see a call to `portfolio.getStocks()`. That
means we need to define what we expect returned when `getStocks` is called on
our mock `Portfolio` object.

On line 27 of `PortfolioManager` we see a call to
`stockExchangeClient.getPrice(stockQuantity.getKey())`. That means we need to
define what we expect returned when `getPrice` is called on our mock
`StockExchangeClient` object for a particular input.
