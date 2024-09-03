package formCustomer.demo.repository;

import formCustomer.demo.entity.system.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffRepository  extends JpaRepository<Staff, String> {

    @Query("SELECT s FROM DefaultApprovalFlow f LEFT JOIN Staff s ON f.defaultStaffCode = s.staffCode WHERE f.formType=?1")
    List<Staff> findStaffDefaultByFormType(@Param("formType") String formType);
}

