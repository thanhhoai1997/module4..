package com.example.service.user;

import com.example.dto.PaginateDto;
import org.springframework.stereotype.Service;

@Service
public interface IPaginatesService {
    public PaginateDto getInfoPaginates(int totalData,int limit,int curentPage);
}
