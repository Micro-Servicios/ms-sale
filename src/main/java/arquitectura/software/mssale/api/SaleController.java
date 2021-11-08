package arquitectura.software.mssale.api;


import arquitectura.software.mssale.entity.Sale;
import arquitectura.software.mssale.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/sale")
public class SaleController {

    @Autowired
    private SaleRepository saleRepository;
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public Sale saveCustomer(@RequestBody Sale sale){
        System.out.println("SE REGISTRO LA COMPRA desde el puerto"+serverPort);
        return saleRepository.save(sale);
    }


    @GetMapping()
    public List<Sale> get(@RequestParam(value = "idCustomer") Integer idCustomer)  {
        return saleRepository.getObjectsCollection(idCustomer);
    }

    /*@RequestMapping( method = RequestMethod.GET)
    public Sale getCustomer(@RequestParam Integer customerId) throws Exception {
        Optional<Sale> customerOptional =saleRepository.findById(customerId);
        if(customerOptional.isPresent()){
            Sale sale = customerOptional.get();
            return sale;
        }else{
            throw new Exception("No se encuentra la compra");
        }
    }

     */



}
