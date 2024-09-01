package formCustomer.demo.service;


import formCustomer.demo.entity.system.Form;
import formCustomer.demo.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormService {


    private final FormRepository formRepository;

    @Autowired
    public FormService(FormRepository formRepository) {
        this.formRepository = formRepository;
    }
    //列出所有表單
    public List<Form> getAllForms() {
        return formRepository.findAll();
    }

    //查詢表單資訊
    public Optional<Form> getFormById(int id) {
        return formRepository.findById(id);
    }
    //儲存表單資訊
    public Form saveForm(Form form) {
        return formRepository.save(form);
    }
    //刪除表單
    public void deleteFormById(int id) {
        formRepository.deleteById(id);
    }

}
