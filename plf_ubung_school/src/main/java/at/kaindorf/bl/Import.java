package at.kaindorf.bl;

import at.kaindorf.beans.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.JAXB;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 10.11.2021
    Time: 17:16
*/
public class Import {

    private static List<Dummy> dummies;

    private static String filepath = System.getProperty("user.dir") + File.separator + "src" +  File.separator + "main" +
            File.separator + "resources" + File.separator + "META-INF" + File.separator + "schooldata.xml";

    private static void loadDummies(){
        dummies = JAXB.unmarshal(new File(filepath), DummyList.class).getDummies();
    }

    public static void importDB(){
        if(dummies==null){
            loadDummies();
        }

        List<Room> rooms = new ArrayList<>();
        List<Classname> classnames = new ArrayList<>();
        List<ClassTeacher> classTeachers = new ArrayList<>();

        for (Dummy d: dummies) {
            String room = d.getRoom();
            int f = Integer.parseInt(d.getRoom().charAt(0)+"");
            Floor floor;
            if(f<=2){
                floor = Floor.GROUND;
            }else{
                floor = Floor.FIRST;
            }

            String name = d.getClassname();
            int grade = Integer.parseInt(d.getRoom().charAt(0)+"");
            int size = Integer.parseInt(d.getSize());

            String initials = d.getInitials();
            String firstname = d.getFirstname();
            String lastname = d.getLastname();
            String title = d.getTitle();

            Room r = new Room(room, floor);
            ClassTeacher ct = new ClassTeacher(initials, firstname, lastname, title);
            Classname cn = new Classname(name, grade, size);

            r.setClassname(cn);
            cn.setRoom(r);
            cn.setClassTeacher(ct);
            ct.setClassname(cn);

            rooms.add(r);
            classTeachers.add(ct);
            classnames.add(cn);
        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_SCHOOL");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        for (Room r: rooms) {
            em.persist(r);
        }
        for (Classname c: classnames) {
            em.persist(c);
        }
        for (ClassTeacher c: classTeachers) {
            em.persist(c);
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
