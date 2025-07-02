package com.library.user_service.mapper;

import com.library.user_service.dto.IssuedbookDTO;
import issuedbooks.GetIssuedBooksResponse;

public class IssuedbookMapper {
    public static IssuedbookDTO fromGrpc(GetIssuedBooksResponse grpcResponse) {
        IssuedbookDTO dto = new IssuedbookDTO();
        dto.setBookId(grpcResponse.getBookId());
        dto.setBookName(grpcResponse.getBookName());
        dto.setValidTill(grpcResponse.getValidTill());
        dto.setAssignedOn(grpcResponse.getAssignedOn());
        return dto;
    }
}
