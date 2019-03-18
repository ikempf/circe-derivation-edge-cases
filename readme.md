## Quirks

Using circe syntax is dangerous because of type inference
```
input.asJson != (input: Parent).asJson
```
