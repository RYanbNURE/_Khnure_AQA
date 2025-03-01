./gradlew bootRun

http://localhost:8080/graphiql

query {
bookById(id: "book-1") {
name
authorName
pageCount
}
}

query {
allBooks {
id
name
authorName
pageCount
}
}