package formCustomer.demo.repository;

import formCustomer.demo.entity.system.form.DeviceFormItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceFormItemRepository extends JpaRepository<DeviceFormItem, Integer> {
}
