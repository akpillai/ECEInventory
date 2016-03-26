package com.virginiatech.ece.daoImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.virginiatech.ece.model.Temp;
@Repository
public class TestImpl {
	@PersistenceContext
	private EntityManager entityManager;

	@Value("${hibernate.jdbc.batch_size}")
	private int batchSize;

	@Transactional
	public Collection<Temp> bulkSave(Collection<Temp> entities) {
		final List<Temp> savedEntities = new ArrayList<Temp>(entities.size());
		int i = 0;
		for (Temp t : entities) {
			savedEntities.add(persistOrMerge(t));
			i++;
			System.out.println(i);
			if (i % batchSize == 0) {
				// Flush a batch of inserts and release memory.
				entityManager.flush();
				entityManager.clear();
			}
		}
		return savedEntities;
	}

	private Temp persistOrMerge(Temp t) {
		if (t.getCol_Ptag() == null) {
			entityManager.persist(t);
			return t;
		} else {
			return entityManager.merge(t);
		}
	}
}
