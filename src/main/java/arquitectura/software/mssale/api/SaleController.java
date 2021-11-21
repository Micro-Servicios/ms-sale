package arquitectura.software.mssale.api;


import arquitectura.software.mssale.entity.Sale;
import arquitectura.software.mssale.repository.SaleRepository;
import arquitectura.software.mssale.service.CustomerService;
import arquitectura.software.mssale.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/sale")
public class SaleController {

    private static Logger LOGGER = LoggerFactory.getLogger(SaleController.class);
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

            LOGGER.info("SE REGISTRO LA COMPRA");
            return saleRepository.save(sale);
        }
        else{

            LOGGER.error(" NO SE REGISTRO LA COMPRA");
            return null;
        }
    }

    @GetMapping()
    public List<Sale> get(@RequestParam(value = "idCustomer") Integer idCustomer) throws Exception {
        List<Sale> sales= saleRepository.getObjectsCollection(idCustomer);
        if (sales!=null){

            LOGGER.info("SE ENCONTRO LA VENTA");
            return sales;
        }
        else {
            LOGGER.warn("NO SE ENCOTRO LA VENTA");
            throw new Exception("No existe el usuario");
        }
    }

    @DeleteMapping()
    public String deleteByCustomerId(@RequestParam(value = "customerId") Integer customerId) {
        //saleRepository.deleteAllById(customerId);

        Integer val=saleRepository.deleteAllByCustomerId(customerId);
        if (val>0){

            LOGGER.info("SE ELIMINO LOS PRODUCTOS DEL USUARIO");
            return "Se elimino los productos del usuario: "+customerId;
        }else{
            LOGGER.error("NO SE ELIMINO LOS PRODUCTOS DEL USUARIO   ");
            return "No se elimino los productos del usuario: "+customerId;
        }
    }

}
