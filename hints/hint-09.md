Here we want to test buying a nonexistent stock. Remember that when we ask the
`StockExchangeClient` to submit a buy for a nonexistent stock it will return
null and `buy` returns early when the client returns null. That means we never
interact with the `Portfolio`. In fact, we want to prove that we never interact
with the `Portfolio`.
