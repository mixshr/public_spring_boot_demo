package com.project.integrated.repository;

import com.project.answer.AnswerNomenclature;
import com.project.integrated.entity.Nomenclature;
import com.project.integrated.repository.hibernate.HibernateUtil;
import com.project.integrated.repository.repositoryInt.NomenclatureRepositoryInt;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public class NomenclatureRepository implements NomenclatureRepositoryInt {

    @Override
    public AnswerNomenclature save(Nomenclature nomenclature) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(nomenclature);
            session.getTransaction().commit();
            session.close();
            return new AnswerNomenclature(true);
        } catch (Exception e) {
            return new AnswerNomenclature(false, e.getMessage());
        }
    }

    @Override
    public AnswerNomenclature find(UUID id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Nomenclature nomenclature = session.get(Nomenclature.class, id);
            session.close();
            AnswerNomenclature answer = new AnswerNomenclature(true);
            answer.addNomenclature(nomenclature);
            return answer;
        } catch (Exception e) {
            return new AnswerNomenclature(false, e.getMessage());
        }
    }

    @Override
    public AnswerNomenclature saveList(ArrayList<Nomenclature> nomenclatureList) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            for (Nomenclature nomenclature:nomenclatureList) {
                session.saveOrUpdate(nomenclature);
            }
            session.getTransaction().commit();
            session.close();
            return new AnswerNomenclature(true);
        } catch (Exception e) {
            return new AnswerNomenclature(false, e.getMessage());
        }
    }
}