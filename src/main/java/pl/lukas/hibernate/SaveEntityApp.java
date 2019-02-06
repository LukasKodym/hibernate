package pl.lukas.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.lukas.hibernate.entity.Employee;

public class SaveEntityApp {

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
        //tworzenie obiektu
        Employee employee = new Employee();
        employee.setIdEmployee(1); // nadanie ręczne id, w przypadku uzycia adnotacji @GeneratedValue, ta linijka jest redundantna
        employee.setFirstName("Jan");
        employee.setLastName("Kowalski");
        employee.setSalary(1000);
        // rozpoczęcie transakcji
        session.beginTransaction();
        // zapisanei pracownika
        session.save(employee);
        // zakończein transakcji
        session.getTransaction().commit();
        // zakończeine obiektu SessionFactory
        factory.close();
    }
}
