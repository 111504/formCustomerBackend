package formCustomer.demo.repository;

import formCustomer.demo.entity.system.Form;
import formCustomer.demo.entity.system.FormApprovalflow;
import formCustomer.demo.entity.system.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormRepository extends JpaRepository<Form, Integer> {

}
