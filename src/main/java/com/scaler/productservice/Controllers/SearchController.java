package com.scaler.productservice.Controllers;

import com.scaler.productservice.Dtos.SearchReqDto;
import com.scaler.productservice.Models.Products;
import com.scaler.productservice.Services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    private SearchService searchService;
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/search")
    public Page<Products> search(@RequestBody SearchReqDto searchReqDto){
        return searchService.search(searchReqDto.getQuery(),
                                    searchReqDto.getPageNumber(),
                                    searchReqDto.getPageSize());
    }
}
