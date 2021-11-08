package arquitectura.software.mssale.repository;

import arquitectura.software.mssale.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface SaleRepository extends JpaRepository<Sale,Integer> {
}
