package ru.job4j.tracker;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HbmTracker implements Store {

    private static final Logger LOG = LoggerFactory.getLogger(HbmTracker.class);

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
            LOG.error(e.getMessage());
            session.getTransaction().rollback();
            throw e;
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sessionFactory.openSession();
        int result;
        try (session) {
            session.beginTransaction();
            result =
                    session.createQuery(
                                    "update Item i "
                                            + " set i.name = :name, "
                                            + " i.description = :description, "
                                            + " i.created = :created"
                                            + " where i.id = :id"
                            ).setParameter("id", id)
                            .setParameter("name", item.getName())
                            .setParameter("description", item.getDescription())
                            .setParameter("created", item.getCreated())
                            .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            session.getTransaction().rollback();
            throw e;
        }
        return result == 1;
    }

    @Override
    public boolean delete(int id) {
        Session session = sessionFactory.openSession();
        int result;
        try (session) {
            session.beginTransaction();
            result =
                    session.createQuery(
                                    "delete Item i where i.id = :id"
                            ).setParameter("id", id)
                            .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            session.getTransaction().rollback();
            throw e;
        }
        return result == 1;
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
            LOG.error(e.getMessage());
            session.getTransaction().rollback();
            throw e;
        }
        return result;
    }

    @Override
    public void findAllByReact(Observe<Item> observe) throws InterruptedException {
        for (Item item : findAll()) {
            Thread.sleep(1000);
            observe.receive(item);
        }
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
            LOG.error(e.getMessage());
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
            LOG.error(e.getMessage());
            session.getTransaction().rollback();
            throw e;
        }
        return result;
    }

    @Override
    public void close() throws Exception {

    }

}
