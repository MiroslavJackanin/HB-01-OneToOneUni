package sk.it.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.it.hibernate.entity.Instructor;
import sk.it.hibernate.entity.InstructorDetail;

public class Create {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            //Instructor instructor = new Instructor("Miroslav", "Jackanin", "miro@mail.com");
            //InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com", "yes");

            Instructor instructor = new Instructor("Peter", "Maly", "peter@gmail.sk");
            InstructorDetail instructorDetail = new InstructorDetail("www.youtube/peter.com", "COVID-19");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            sessionFactory.close();
        }
    }
}
