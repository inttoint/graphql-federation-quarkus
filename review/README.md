### Request

```graphql
{
    allReviews {
        id
        comment
        product {
            __typename
            id
            name
        }
    }
}
```

### Response

```json
{
  "data": {
    "allReviews": [
      {
        "id": "1",
        "comment": "text",
        "product": {
          "__typename": "Product",
          "id": "1"
        }
      },
      {
        "id": "2",
        "comment": "text",
        "product": {
          "__typename": "Product",
          "id": "2"
        }
      }
    ]
  }
}
```