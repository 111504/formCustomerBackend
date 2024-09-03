package formCustomer.demo.repository;

import formCustomer.demo.entity.system.form.DeviceForm;
import formCustomer.demo.entity.system.form.DeviceFormContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceFormRepository extends JpaRepository<DeviceForm, Integer>{
}
