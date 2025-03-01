package com.example.grpcdemo.service;

import com.example.grpcdemo.proto.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.Arrays;
import java.util.List;

@GrpcService
public class BookServiceImpl extends BookServiceGrpc.BookServiceImplBase {

    private List<Book> books = Arrays.asList(
            Book.newBuilder().setId("book-1").setName("Effective Java").setPageCount(416).setAuthorName("Joshua Bloch").build(),
            Book.newBuilder().setId("book-2").setName("Thinking in Java").setPageCount(1150).setAuthorName("Bruce Eckel").build(),
            Book.newBuilder().setId("book-3").setName("Clean Code").setPageCount(464).setAuthorName("Robert C. Martin").build()
    );

    @Override
    public void getBook(GetBookRequest request, StreamObserver<Book> responseObserver) {
        books.stream()
                .filter(book -> book.getId().equals(request.getId()))
                .findFirst()
                .ifPresentOrElse(
                        book -> {
                            responseObserver.onNext(book);
                            responseObserver.onCompleted();
                        },
                        () -> responseObserver.onError(new RuntimeException("Book not found"))
                );
    }

    @Override
    public void listBooks(ListBooksRequest request, StreamObserver<ListBooksResponse> responseObserver) {
        ListBooksResponse response = ListBooksResponse.newBuilder().addAllBooks(books).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}