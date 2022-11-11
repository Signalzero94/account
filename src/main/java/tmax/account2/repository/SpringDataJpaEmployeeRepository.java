package tmax.account2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tmax.account2.domain.Employee;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringDataJpaEmployeeRepository extends JpaRepository<Employee, Long>, EmployeeRepository {
    @Override
    Optional<Employee> findByName(String name);
    @Override
    Optional<Employee> findById(Long aLong);
    @Override
    Employee save(Employee employee);
    @Override
    List<Employee> findAll();
    @Override
    void delete(Employee employee);
    @Override
    void deleteById(Long id);
    @Override Optional<Employee> deleteByName(String name);
    @Override Optional<String> deleteByResRegiNumber(String resRegiNumber);
}