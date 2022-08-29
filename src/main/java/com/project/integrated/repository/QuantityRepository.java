package com.project.integrated.repository;

import com.project.answer.AnswerQuantity;
import com.project.integrated.entity.Quantity;
import com.project.integrated.repository.hibernate.HibernateUtil;
import com.project.integrated.repository.repositoryInt.QuantityRepositoryInt;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class QuantityRepository implements QuantityRepositoryInt{

    @Override
    public AnswerQuantity save(Quantity quantity) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(quantity);
            session.getTransaction().commit();
            session.close();
            return new AnswerQuantity(true);
        } catch (Exception e) {
            return new AnswerQuantity(false, e.getMessage());
        }
    }

    @Override
    public AnswerQuantity saveArray(List<Quantity> array) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            for (Quantity quantity:array) {
                session.saveOrUpdate(quantity);
            }
            session.getTransaction().commit();
            session.close();
            return new AnswerQuantity(true);
        } catch (Exception e) {
            return new AnswerQuantity(false, e.getMessage());
        }
    }

    @Override
    public AnswerQuantity find(UUID nomenclatureId) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query<Quantity> query = session.createQuery("from quantity_in_warehouse where nomenclature =: nomenclatureId");
            query.setParameter("nomenclatureId", nomenclatureId);
            List<Quantity> quantityList = query.getResultList();
            session.close();
            AnswerQuantity answerQuantity = new AnswerQuantity(true);
            answerQuantity.setQuantityList(quantityList);
            return answerQuantity;
        } catch (Exception e) {
            return new AnswerQuantity(false, e.getMessage());
        }
    }

    @Override
    public AnswerQuantity find(UUID nomenclatureId, UUID warehouseId) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query<Quantity> query = session.createQuery("from quantity_in_warehouse where nomenclature =: nomenclatureId and warehouse =: warehouseId");
            query.setParameter("nomenclatureId", nomenclatureId);
            query.setParameter("warehouseId", warehouseId);
            List<Quantity> quantityList = query.getResultList();
            session.close();
            AnswerQuantity answerQuantity = new AnswerQuantity(true);
            answerQuantity.setQuantityList(quantityList);
            return answerQuantity;
        } catch (Exception e) {
            return new AnswerQuantity(false, e.getMessage());
        }
    }

    @Override
    public AnswerQuantity findAll() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query<Quantity> query = session.createQuery("from quantity_in_warehouse");
            List<Quantity> quantityList = query.getResultList();
            session.close();
            AnswerQuantity answerQuantity = new AnswerQuantity(true);
            answerQuantity.setQuantityList(quantityList);
            return answerQuantity;
        } catch (Exception e) {
            return new AnswerQuantity(false, e.getMessage());
        }
    }

    @Override
    public AnswerQuantity findAll(UUID warehouseId) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query<Quantity> query = session.createQuery("from quantity_in_warehouse where warehouse =: warehouseId");
            query.setParameter("warehouseId", warehouseId);
            List<Quantity> quantityList = query.getResultList();
            session.close();
            AnswerQuantity answerQuantity = new AnswerQuantity(true);
            answerQuantity.setQuantityList(quantityList);
            return answerQuantity;
        } catch (Exception e) {
            return new AnswerQuantity(false, e.getMessage());
        }
    }
}