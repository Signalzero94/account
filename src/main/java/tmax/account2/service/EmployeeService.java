package tmax.account2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tmax.account2.domain.Employee;
import tmax.account2.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    private final EmployeeRepository employeeRepository;

    public Long join(Employee employee){
        validateDuplicateEmployee(employee);
        employeeRepository.save(employee);
        return employee.getId();
    }
    private void validateDuplicateEmployee(Employee employee) {
        Optional<Employee> result = employeeRepository.findByResRegiNumber(employee.getResRegiNumber());
        result.ifPresent(a -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    public List<Employee> findEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> findOne(Long id){
        return employeeRepository.findById(id);
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }

    public void deleteByResRegiNumber(String resRegiNumber) {
        employeeRepository.deleteByResRegiNumber(resRegiNumber);
    }

    public void deleteByName(String name) {
        employeeRepository.deleteByName(name);
    }
}