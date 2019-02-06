package pl.lukas.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.lukas.hibernate.entity.Employee;

public class PrimaryKeyApp {

    public static void main(String[] args) {
        // tworzenie obiektu Configuration
        Configuration conf = new Configuration();
        // wczytanie pliku konfiguracyjnego
        conf.configure("hibernate.cfg.xml");
        // wczytanie adnotacje klasy
        conf.addAnnotatedClass(Employee.class);
        // tworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        // pobieranie sesji
        Session session = factory.getCurrentSession();
        //tworzenie 3 obiektów
        Employee employee1 = new Employee();
        employee1.setFirstName("Krzysztof");
        employee1.setLastName("Nowak");
        employee1.setSalary(1000);

        Employee employee2 = new Employee();
        employee2.setFirstName("Janina");
        employee2.setLastName("Kowalska");
        employee2.setSalary(1000);

        Employee employee3 = new Employee();
        employee3.setFirstName("Andrzej");
        employee3.setLastName("Sienkiewicz");
        employee3.setSalary(1000);
        // rozpoczęcie transakcji
        session.beginTransaction();
        // zapisanei 3. pracowników
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        // zakończein transakcji
        session.getTransaction().commit();
        // zakończeine obiektu SessionFactory
        factory.close();
    }
}
