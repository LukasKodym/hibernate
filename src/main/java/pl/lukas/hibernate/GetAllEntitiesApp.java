package pl.lukas.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.lukas.hibernate.entity.Employee;

import java.util.List;

public class GetAllEntitiesApp {

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

        // rozpoczęcie transakcji
        session.beginTransaction();

        List<Employee> resultList = session.createQuery("from Employee").getResultList(); // wczytywanie encij
        for (Employee employee : resultList) {
            System.out.println(employee);
        }
        // zakończein transakcji
        session.getTransaction().commit();
        // zakończeine obiektu SessionFactory
        factory.close();
    }
}
