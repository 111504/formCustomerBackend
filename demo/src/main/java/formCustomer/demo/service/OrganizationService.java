package formCustomer.demo.service;

import formCustomer.demo.entity.system.Organization;
import formCustomer.demo.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService   {

    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public  List<Organization> getAllOrganizations() {   List<Organization> organizations = organizationRepository.findAll();
        System.out.println("Organizations: " + organizations);
        return organizations;
    }

    public Optional<Organization> getOrganizationById(int id) {return organizationRepository.findById(id);}

    public Organization saveOrganization(Organization organization) {return organizationRepository.save(organization);}

    public void deleteOrganizationById(int id) {organizationRepository.deleteById(id);}

}
