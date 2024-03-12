package com.example.furama.controller;

import com.example.furama.model.*;
import com.example.furama.model.dto.ContractDTO;
import com.example.furama.service.contract.IAttachFacilityService;
import com.example.furama.service.contract.IContractDetailService;
import com.example.furama.service.contract.IContractService;
import com.example.furama.service.customer.ICustomerService;
import com.example.furama.service.dto.IContractDetailDtoService;
import com.example.furama.service.employee.IEmployeeService;
import com.example.furama.service.facility.IFacilityService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IContractDetailDtoService iContractDetailDtoService;

    @GetMapping("")
    public ModelAndView showList(@RequestParam("page") Optional<Integer> page,@RequestParam("name") Optional<String> name){
        ModelAndView mv = new ModelAndView("/contract/list");
        Sort sort = Sort.by("startDate").descending();

        Pageable pageable = PageRequest.of(page.orElse(0),3,sort);
        Page<Contract> contracts ;
        if (name.isPresent()){
            contracts = iContractService.findAllByNameCustomer(pageable,name.get());
        }else {
            contracts = iContractService.findAll(pageable);
        }
        List<Integer> numPage = new ArrayList<>();
        for (int i = 1 ;i <= contracts.getTotalPages(); i++){
            numPage.add(i);
        }
        mv.addObject("numPage",numPage);
        mv.addObject("attachFacilities",iAttachFacilityService.findAll());
        mv.addObject("contracts",contracts);
        mv.addObject("contractDetails",iContractDetailService.findAll());
        mv.addObject("contractDetail",new ContractDetail());
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(@ModelAttribute("contract") ContractDTO contract) {
        ModelAndView mv = new ModelAndView("/contract/create");
        mv.addObject("contractDetails", iContractDetailService.findAll());
        mv.addObject("attachFacilities", iAttachFacilityService.findAll());
        mv.addObject("customers", iCustomerService.findAll());
        mv.addObject("employees", iEmployeeService.findAll());
        mv.addObject("facilities", iFacilityService.findAll());

        return mv;

    }
    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("contract") ContractDTO contractDTO, BindingResult bindingResult){
        new ContractDTO().validate(contractDTO,bindingResult);
        ModelAndView mv;

        if (bindingResult.hasErrors()){

            mv =new ModelAndView("/contract/create");

            mv.addObject("contractDetails", iContractDetailService.findAll());
            mv.addObject("attachFacilities", iAttachFacilityService.findAll());
            mv.addObject("customers", iCustomerService.findAll());
            mv.addObject("employees", iEmployeeService.findAll());
            mv.addObject("facilities", iFacilityService.findAll());
            return mv;
        }
        mv = new ModelAndView("redirect:/contract");
        Contract contract = new Contract();



        Employee employee = iEmployeeService.findById(contractDTO.getEmployee());
        Customer customer = iCustomerService.findById(contractDTO.getCustomer());
        Facility facility = iFacilityService.findById(contractDTO.getFacility());
        BeanUtils.copyProperties(contractDTO,contract);
        contract.setEmployee(employee);
        contract.setCustomer(customer);
        contract.setFacility(facility);



        List<ContractDetailDTO> contractDetailDTOS = iContractDetailDtoService.findAll();
        double totalMoney  = contract.getFacility().getCost() - contract.getDeposit();
        for (ContractDetailDTO c: iContractDetailDtoService.findAll()
             ) {
            totalMoney += iAttachFacilityService.findById(c.getAttachFacilityId()).getCost()*c.getQuantity();

        }
        contract.setTotalMoney(totalMoney);


       Contract getContract = iContractService.save(contract);



        for (ContractDetailDTO c : contractDetailDTOS
             ) {
            AttachFacility attachFacility = iAttachFacilityService.findById(c.getAttachFacilityId());
            ContractDetail contractDetail = new ContractDetail();
            contractDetail.setContract(getContract);
            contractDetail.setAttachFacility(attachFacility);
            contractDetail.setQuantity(c.getQuantity());
            iContractDetailService.save(contractDetail);
        }

        for (ContractDetailDTO c: iContractDetailDtoService.findAll()
             ) {
            iContractDetailDtoService.deleteById(c.getId());

        }
//        iContractDetailDtoService.deleteAllById();



        return mv;
    }

    @PostMapping("/addAttachedFacility/{attachFacility}/{quantity}")
    public ResponseEntity<Iterable<ContractDetailDTO>> getList(@PathVariable("attachFacility") Long attachFacility, @PathVariable("quantity") int quantity){

            ContractDetailDTO contractDetailDTO = new ContractDetailDTO();
            contractDetailDTO.setAttachFacilityId(attachFacility);
            contractDetailDTO.setQuantity(quantity);
            iContractDetailDtoService.save(contractDetailDTO);

            return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/createContractDetail")
    public ModelAndView createContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail){
        ModelAndView mv = new ModelAndView("redirect:/contract");

        iContractDetailService.save(contractDetail);


        Contract contract = iContractService.findById(contractDetail.getContract().getId());
        double totalMoney  = contract.getFacility().getCost() - contract.getDeposit();
        for (ContractDetail c: iContractDetailService.findAll()
        ) {
            totalMoney += iAttachFacilityService.findById(c.getAttachFacility().getId()).getCost()*c.getQuantity();

        }
        contract.setTotalMoney(totalMoney);
        iContractService.save(contract);
        return mv;


    }

}
