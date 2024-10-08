package formCustomer.demo.repository;

import formCustomer.demo.entity.system.form.DeviceForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<DeviceForm, Integer> {

}
