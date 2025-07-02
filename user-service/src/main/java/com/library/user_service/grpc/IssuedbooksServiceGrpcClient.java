package com.library.user_service.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import issuedbooks.GetIssuedBooksRequest;
import issuedbooks.GetIssuedBooksResponse;
import issuedbooks.IssuedBooksServiceGrpc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IssuedbooksServiceGrpcClient {

    private final IssuedBooksServiceGrpc.IssuedBooksServiceBlockingStub blockingStub;

    public IssuedbooksServiceGrpcClient(
            @Value("${issuedbooks.service.address:localhost}") String serverAddess,
            @Value("${issuedbooks.service.grpc.port:9001}") int serverPort) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddess, serverPort)
                .usePlaintext() // Use plaintext for simplicity; consider using TLS in production
                .build();
        blockingStub = IssuedBooksServiceGrpc.newBlockingStub(channel);
    }

    public GetIssuedBooksResponse getIssuedBookDetails(String userId) {
        GetIssuedBooksRequest request = GetIssuedBooksRequest.newBuilder()
                .setUserId(userId)
                .build();
        return blockingStub.getIssuedBooks(request);
    }
}
