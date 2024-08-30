package formCustomer.demo.service;

import formCustomer.demo.entity.system.Organization;
import formCustomer.demo.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {
    @Autowired
    private static OrganizationRepository organizationRepository;

    public static  List<Organization> getAllOrganizations() {return organizationRepository.findAll();}

    public Optional<Organization> getOrganizationById(int id) {return organizationRepository.findById(id);}

    public Organization saveOrganization(Organization organization) {return organizationRepository.save(organization);}

    public void deleteOrganizationById(int id) {organizationRepository.deleteById(id);}

}
