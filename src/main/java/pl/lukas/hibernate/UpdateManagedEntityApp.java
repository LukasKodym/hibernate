package pl.lukas.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.lukas.hibernate.entity.Employee;

public class UpdateManagedEntityApp {

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

        session.beginTransaction();

        Employee employee = session.get(Employee.class, 10); // wczytanie pracownika za pomocą metody get
        employee.setFirstName("Tadeusz");
        session.getTransaction().commit();


        System.out.println("Zaktualizowane dane pracownika: " + employee); // sprawdzenie czy pracownik jest wpisany


        // zakończeine obiektu SessionFactory
        factory.close();
    }
}
