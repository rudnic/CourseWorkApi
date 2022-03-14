package com.example.courseworkapi.payload.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddReviewRequest {
    private String type;
    private String text;
}
