package com.scaler.productservice.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchReqDto {
   private String Query;
   private int PageNumber;
   private int PageSize;
}
