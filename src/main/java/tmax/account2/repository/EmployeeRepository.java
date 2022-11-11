package tmax.account2.repository;

import tmax.account2.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Employee save(Employee employee);
    Optional<Employee> findById(Long id);
    Optional<Employee> findByName(String name);
    Optional<Employee> findByResRegiNumber(String resRegiNumber);
    List<Employee> findAll();
    void delete(Employee employee);
    void deleteById(Long id);
    Optional<Employee> deleteByName(String name);
    Optional<String> deleteByResRegiNumber(String resRegiNumber);
}