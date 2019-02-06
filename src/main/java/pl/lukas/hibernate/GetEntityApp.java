package pl.lukas.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.lukas.hibernate.entity.Employee;

public class GetEntityApp {
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
        employee.setFirstName("Tadeusz");
        employee.setLastName("Wiśniewski");
        employee.setSalary(1000);
        // rozpoczęcie transakcji
        session.beginTransaction();
        // zapisanei pracownika, metoda save zwraca identyfikator który pobieramy do zmiennej - trzeba rzutować
        Integer id = (Integer) session.save(employee);
        // zakończein transakcji
        session.getTransaction().commit();
        // pobieranie nowej sesji
        session = factory.getCurrentSession();
        
        session.beginTransaction();

        Employee retrievedEmployee = session.get(Employee.class, id); // wczytanie pracownika za pomocą metody get

        session.getTransaction().commit();

        System.out.println("Dane pracownika: " + retrievedEmployee); // sprawdzenie czy pracownik jest wpisany

        // zakończeine obiektu SessionFactory
        factory.close();
    }
}
