package com.example.service.user.impl;

import com.example.dto.PaginateDto;
import com.example.service.user.IPaginatesService;
import org.springframework.stereotype.Service;

@Service
public class PaginatesService implements IPaginatesService {
    @Override
    public PaginateDto getInfoPaginates(int totalData,int limit,int curentPage) {
        PaginateDto paginateDto = new PaginateDto();
        paginateDto.setLimit(limit);
//        paginateDto.setTotalPage(totalData);
      int total =  SetInfoTotalPage(totalData,limit);
        paginateDto.setTotalPage(total);
        paginateDto.setCurrentPage(checkCurrentPage(curentPage,total));
      int start = findStart(paginateDto.getCurrentPage(),limit);
      paginateDto.setStart(start);
      int end = findEnd(paginateDto.getStart(),limit,totalData);
      paginateDto.setEnd(end);

        return paginateDto;
    }

    private int findEnd(int start, int limit, int totalData) {
        return start+limit > totalData ? totalData  :(start+limit)-1   ;
    }


    private int findStart(int currentPage, int limit) {
        return ((currentPage-1)*limit)+1;
    }

    private int checkCurrentPage(int currentPage, int totalPage) {
        if (currentPage < 1){
            return 1;
        }
        if (currentPage > totalPage){
            return totalPage;
        }
        return currentPage;
    }

    private int SetInfoTotalPage(int totalData, int limit) {
        int totalPage = 0;
        totalPage = totalData/limit;
        totalPage = totalPage*limit < totalData ? totalPage+1 : totalPage;
        return totalPage;
    }


}
