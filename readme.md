## Quirks

Using circe syntax can be dangerous because of type inference
```
input.asJson != (input: Parent).asJson
```
