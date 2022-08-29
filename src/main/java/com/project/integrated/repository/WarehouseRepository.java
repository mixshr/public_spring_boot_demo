package com.project.integrated.repository;

import com.project.answer.AnswerWarehouse;
import com.project.integrated.entity.Warehouse;
import com.project.integrated.repository.hibernate.HibernateUtil;
import com.project.integrated.repository.repositoryInt.WarehouseRepositoryInt;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public class WarehouseRepository implements WarehouseRepositoryInt {

    @Override
    public AnswerWarehouse save(Warehouse warehouse) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(warehouse);
            session.getTransaction().commit();
            session.close();
            return new AnswerWarehouse(true);
        } catch (Exception e) {
            return new AnswerWarehouse(false, e.getMessage());
        }
    }

    @Override
    public AnswerWarehouse find(UUID id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Warehouse warehouse = session.get(Warehouse.class, id);
            session.close();
            AnswerWarehouse answer = new AnswerWarehouse(true);
            answer.addWareHouse(warehouse);
            return answer;
        } catch (Exception e) {
            return new AnswerWarehouse(false, e.getMessage());
        }
    }

    @Override
    public AnswerWarehouse saveList(ArrayList<Warehouse> warehouseList) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            for (Warehouse warehouse:warehouseList) {
                session.saveOrUpdate(warehouse);
            }
            session.getTransaction().commit();
            session.close();
            return new AnswerWarehouse(true);
        } catch (Exception e) {
            return new AnswerWarehouse(false, e.getMessage());
        }
    }
}