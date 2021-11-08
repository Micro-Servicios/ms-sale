package arquitectura.software.mssale.repository;

import arquitectura.software.mssale.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaleRepository extends JpaRepository<Sale,Integer> {



    @Query(value = "select  * from sale  where customer_Id =  ? ", nativeQuery = true)
    List<Sale> getObjectsCollection(Integer idCustomer);
}
