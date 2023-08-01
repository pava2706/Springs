package studentDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import studentDto.StudentMarks;

public class StudentMarksDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public String insert(StudentMarks dto) {
		et.begin();
		em.persist(dto);
		et.commit();
		return "data inserted Sucessfully";

	}

	public List<StudentMarks> fetchAll() {
		Query q = em.createQuery("select data from StudentMarks data");

		List<StudentMarks> d1 = q.getResultList();
		return d1;
	}

	public StudentMarks login(String regno) {
		StudentMarks dt = em.find(StudentMarks.class, regno);
		return dt;
	}

	public void update(StudentMarks dto) {
		et.begin();
		em.merge(dto);
		et.commit();

	}

	public void remove(String cid) {
		StudentMarks sm = em.find(StudentMarks.class, cid);
		et.begin();
		em.remove(sm);
		et.commit();

	}
}
