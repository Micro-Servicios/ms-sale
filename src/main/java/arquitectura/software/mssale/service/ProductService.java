package arquitectura.software.mssale.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name="ms-product")
public interface ProductService {

    @RequestMapping(path = "v1/api/product/productId",method = RequestMethod.GET)
    public Boolean getValueProductId(@RequestParam Integer productId);
}
