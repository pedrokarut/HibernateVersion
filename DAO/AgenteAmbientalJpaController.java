package DAO;

import ClassesDeInterface.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.AgenteAmbiental;


public class AgenteAmbientalJpaController implements Serializable {

    public AgenteAmbientalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AgenteAmbiental agenteAmbiental) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(agenteAmbiental);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AgenteAmbiental agenteAmbiental) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            agenteAmbiental = em.merge(agenteAmbiental);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = agenteAmbiental.getId();
                if (findAgenteAmbiental(id) == null) {
                    throw new NonexistentEntityException("The agenteAmbiental with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AgenteAmbiental agenteAmbiental;
            try {
                agenteAmbiental = em.getReference(AgenteAmbiental.class, id);
                agenteAmbiental.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The agenteAmbiental with id " + id + " no longer exists.", enfe);
            }
            em.remove(agenteAmbiental);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AgenteAmbiental> findAgenteAmbientalEntities() {
        return findAgenteAmbientalEntities(true, -1, -1);
    }

    public List<AgenteAmbiental> findAgenteAmbientalEntities(int maxResults, int firstResult) {
        return findAgenteAmbientalEntities(false, maxResults, firstResult);
    }

    private List<AgenteAmbiental> findAgenteAmbientalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AgenteAmbiental.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public AgenteAmbiental findAgenteAmbiental(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AgenteAmbiental.class, id);
        } finally {
            em.close();
        }
    }

    public int getAgenteAmbientalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AgenteAmbiental> rt = cq.from(AgenteAmbiental.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
