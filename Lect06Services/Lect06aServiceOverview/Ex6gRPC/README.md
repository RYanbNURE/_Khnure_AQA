grpcurl -plaintext localhost:9090 com.example.grpcdemo.BookService/ListBooks

grpcurl -plaintext -d "{\"id\":\"book-1\"}" localhost:9090 com.example.grpcdemo.BookService/GetBook

grpcurl -plaintext -d '{"id": "book-1"}' localhost:9090 com.example.grpcdemo.BookService/GetBook

grpcurl -plaintext localhost:9090 list

grpcurl -plaintext localhost:9090 list com.example.grpcdemo.BookService

grpcurl -plaintext localhost:9090 describe com.example.grpcdemo.BookService.GetBook
