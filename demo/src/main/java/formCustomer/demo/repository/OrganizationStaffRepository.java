package formCustomer.demo.repository;

import formCustomer.demo.entity.system.OrganizationStaff;
import formCustomer.demo.entity.system.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrganizationStaffRepository extends JpaRepository<OrganizationStaff,Integer> {
    @Query(value = "SELECT new Staff(s.staffCode, s.staffName, s.position) " +
            "FROM Staff s " +
            "JOIN OrganizationStaff os ON s.staffCode = os.staffCode " +
            "WHERE os.orgCode = ?1")
    List<Staff> findStaffByOrgCode(String orgCode);
}
