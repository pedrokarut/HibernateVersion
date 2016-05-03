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
import model.ItensColeta;


public class ItensColetaJpaController implements Serializable {

    public ItensColetaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ItensColeta itensColeta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(itensColeta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ItensColeta itensColeta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            itensColeta = em.merge(itensColeta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = itensColeta.getId();
                if (findItensColeta(id) == null) {
                    throw new NonexistentEntityException("The itensColeta with id " + id + " no longer exists.");
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
            ItensColeta itensColeta;
            try {
                itensColeta = em.getReference(ItensColeta.class, id);
                itensColeta.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itensColeta with id " + id + " no longer exists.", enfe);
            }
            em.remove(itensColeta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ItensColeta> findItensColetaEntities() {
        return findItensColetaEntities(true, -1, -1);
    }

    public List<ItensColeta> findItensColetaEntities(int maxResults, int firstResult) {
        return findItensColetaEntities(false, maxResults, firstResult);
    }

    private List<ItensColeta> findItensColetaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ItensColeta.class));
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

    public ItensColeta findItensColeta(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ItensColeta.class, id);
        } finally {
            em.close();
        }
    }

    public int getItensColetaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ItensColeta> rt = cq.from(ItensColeta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
