### Entity request

```graphql
query entities($rep: [_Any!]!) {
    _entities(representations: $rep) {
        ... on Product {
            name
            price
        }
    }
}
```

```json
{
  "rep": [
    {
      "__typename": "Product",
      "id": "1"
    },
    {
      "__typename": "Product",
      "id": "2"
    }
  ]
}
```