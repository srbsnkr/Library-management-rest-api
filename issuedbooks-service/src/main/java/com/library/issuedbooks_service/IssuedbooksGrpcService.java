package com.library.issuedbooks_service;


import issuedbooks.IssuedBooksServiceGrpc;
import issuedbooks.GetIssuedBooksResponse;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class IssuedbooksGrpcService extends IssuedBooksServiceGrpc.IssuedBooksServiceImplBase {

    @Override
    public void getIssuedBooks(issuedbooks.GetIssuedBooksRequest request,
                               io.grpc.stub.StreamObserver<GetIssuedBooksResponse> responseObserver) {
        GetIssuedBooksResponse response = GetIssuedBooksResponse.newBuilder()
                .setBookId("12345")
                .setBookName("World of Java")
                .setAssignedOn("1 Jan 2014")
                .setValidTill("5 Dec 2014")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    // Implement the methods defined in the IssuedbooksServiceGrpc class here
    //

}
