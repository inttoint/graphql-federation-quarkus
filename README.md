<table>
<tr>
<td style="vertical-align: top">
<h4>Product</h4>
<pre>
type Query {
    allProducts: [Product]
    productResolver(id: ID!): Product
}

type Product @key(fields : ["id"]) {
    id: ID!
    name: String
    price: BigDecimal
}
</pre>
</td>
<td style="vertical-align: top">
<h4>Review</h4>
<pre>
type Query {
    allReviews: [Review]
}

type Product @extends @key(fields : ["id"]) {
    id: ID! @external
}

type Review {
    id: ID!
    comment: String
    product: Product
}
</pre>
</td>
</tr>
</table>


### Request

```graphql
{
    allReviews {
        id
        comment
        product {
            id
            name
            price
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
          "id": "1",
          "name": "first",
          "price": 1
        }
      },
      {
        "id": "2",
        "comment": "text",
        "product": {
          "id": "2",
          "name": "second",
          "price": 10
        }
      },
      {
        "id": "3",
        "comment": "text",
        "product": {
          "id": "1",
          "name": "first",
          "price": 1
        }
      }
    ]
  }
}
```

### Query plan

```graphql
QueryPlan {
  Sequence {
    Fetch(service: "review") {
      {
        allReviews {
          id
          comment
          product {
            id
            name
            __typename
          }
        }
      }
    },
    Flatten(path: "allReviews.@.product") {
      Fetch(service: "product") {
        {
          ... on Product {
            __typename
            id
          }
        } =>
        {
          ... on Product {
            price
          }
        }
      },
    },
  },
}
```