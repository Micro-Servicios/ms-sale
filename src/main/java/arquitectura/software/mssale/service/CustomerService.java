package arquitectura.software.mssale.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name="ms-customer")
public interface CustomerService {

    @RequestMapping(path = "v1/api/customer/customerId",method = RequestMethod.GET)
    public Boolean getValueCustomerId(@RequestParam Integer customerId);
}
