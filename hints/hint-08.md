For methods with void return types, we start with a `doThrow(Class<? extends
Throwable> toBeThrown)` and chain the `when()` onto it. The other difference is
to specify the method to be called on the mock outside of the when instead of as
a part of the parameters.

For example:
```
doThrow(SsnNotFoundException.class).when(voterDAO).add(012445555L);
```
