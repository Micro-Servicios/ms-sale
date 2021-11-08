package arquitectura.software.mssale.api;


import arquitectura.software.mssale.entity.Sale;
import arquitectura.software.mssale.repository.SaleRepository;
import arquitectura.software.mssale.service.CustomerService;
import arquitectura.software.mssale.service.ProductService;
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
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public Sale saveCustomer(@RequestBody Sale sale) {
        System.out.println("SE REGISTRO LA COMPRA desde el puerto"+serverPort);

        if (customerService.getValueCustomerId(sale.getCustomerId()) && productService.getValueProductId(sale.getProductId())){
            return saleRepository.save(sale);
        }
        else{
            return null;
            //throw new Exception("No se registro el producto");
        }
    }

    @GetMapping()
    public List<Sale> get(@RequestParam(value = "idCustomer") Integer idCustomer) throws Exception {
        List<Sale> sales= saleRepository.getObjectsCollection(idCustomer);
        if (sales!=null){

            return sales;
        }
        else {
            throw new Exception("No existe el usuario");
        }
    }

}
