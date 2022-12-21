<table>
<tr>
<td style="vertical-align: top">
<h4>Product</h4>
<pre>
type Query {
    allProducts: [Product]
    product(id: ID!): Product!
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
    review(id: ID!): Review!
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
