package formCustomer.demo.repository;

import formCustomer.demo.entity.system.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffRepository  extends JpaRepository<Staff, String> {

    @Query("SELECT s FROM FormApprovalflow f LEFT JOIN Staff s ON f.staffCode = s.staffCode WHERE f.form.formId = :formId")
    List<Staff> findStaffDetailsByFormId(@Param("formId") int formId);
}

