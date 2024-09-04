package formCustomer.demo.repository;

import formCustomer.demo.dto.FormToSignDto;
import formCustomer.demo.entity.system.Staff;
import formCustomer.demo.entity.system.form.DeviceForm;
import formCustomer.demo.entity.system.form.DeviceFormContent;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeviceFormRepository extends JpaRepository<DeviceForm, String>{

    @Query(value = "SELECT f.form_id, f.submitter_id, f.submit_date, f.form_type, s.staff_name " +
            "FROM DeviceForm f " +
            "LEFT JOIN Staff s ON f.submitter_id = s.staff_code " +
            "WHERE f.current_approver_id = ?1",nativeQuery = true)
            List<Object[]>  findFormNeedToSign(String currentApprovalId);

    // List<Staff> findStaffDefaultByFormType(@Param("formType") String formType);

    @Query(value = "SELECT f.form_id, f.current_approver_id,f.current_approval_order, f.submit_date, f.form_type, s.staff_name " +
            "FROM DeviceForm f " +
            "LEFT JOIN Staff s ON f.current_approver_id = s.staff_code  " +
            "WHERE f.submitter_id = ?1",nativeQuery = true)
             List<Object[]>  findFormOwnSub(String submitterId);

}
