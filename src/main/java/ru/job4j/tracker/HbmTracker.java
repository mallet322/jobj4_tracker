package ru.job4j.tracker;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HbmTracker implements Store, AutoCloseable {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    private SessionFactory sessionFactory;

    @Override
    public void init() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        sessionFactory = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();
    }

    @Override
    public Item add(Item item) {
        Session session = sessionFactory.openSession();
        try (session) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sessionFactory.openSession();
        boolean result = true;
        if (findById(id) == null) {
            result = false;
        } else {
            try (session) {
                session.beginTransaction();
                item.setId(id);
                session.update(item);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        Session session = sessionFactory.openSession();
        boolean result = true;
        Item actualItem = findById(id);
        if (actualItem == null) {
            result = false;
        } else {
            try (session) {
                session.beginTransaction();
                session.delete(actualItem);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        Session session = sessionFactory.openSession();
        List<Item> result;
        try (session) {
            session.beginTransaction();
            result = session.createQuery("from Item").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sessionFactory.openSession();
        List<Item> result;
        try (session) {
            session.beginTransaction();
            result =
                    session.createQuery("from Item i where i.name = :name")
                           .setParameter("name", key)
                           .list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
        return result;
    }

    @Override
    public Item findById(int id) {
        Session session = sessionFactory.openSession();
        Item result = null;
        try (session) {
            session.beginTransaction();
            result = session.get(Item.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return result;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }

}
