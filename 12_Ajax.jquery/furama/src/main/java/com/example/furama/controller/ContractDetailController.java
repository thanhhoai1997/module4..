package com.example.furama.controller;

import com.example.furama.model.Contract;
import com.example.furama.model.ContractDetail;
import com.example.furama.model.ContractDetailDTO;
import com.example.furama.service.contract.IAttachFacilityService;
import com.example.furama.service.contract.IContractDetailService;
import com.example.furama.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IAttachFacilityService iAttachFacilityService;
    private List<ContractDetailDTO> contractDetailDTOS;


    @GetMapping("/create")
    public ModelAndView showCreate(@ModelAttribute("contractDetail")ContractDetail contractDetail){
        ModelAndView mv = new ModelAndView("/contract/create");
        return mv;
    }
    @PostMapping("/create/{attachFacility}/{contract}/{quantity}")
    public ResponseEntity<ContractDetail> create(@PathVariable("attachFacility") Long attachFacilityId,@PathVariable("contract") Long contractId,
                                                @PathVariable("quantity") int quantity ){
//        ContractDetail contractDetail = new ContractDetail();

        List<ContractDetailDTO> list = new ArrayList<>();
        ContractDetailDTO contractDetailDTO = new ContractDetailDTO();
        contractDetailDTO.setAttachFacilityId(attachFacilityId);
        contractDetailDTO.setQuantity(quantity);
        list.add(contractDetailDTO);
            list.forEach(a-> System.out.println(a.getAttachFacilityId() + ":" +  a.getQuantity()));


//        contractDetail.setContract(iContractService.findById(contractId));
//        contractDetail.setAttachFacility(iAttachFacilityService.findById(attachFacilityId));
//        contractDetail.setQuantity(quantity);
//        iContractDetailService.save(contractDetail);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

}
