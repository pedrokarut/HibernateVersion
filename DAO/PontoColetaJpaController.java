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
import model.PontoColeta;


public class PontoColetaJpaController implements Serializable {

    public PontoColetaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PontoColeta pontoColeta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pontoColeta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PontoColeta pontoColeta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pontoColeta = em.merge(pontoColeta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pontoColeta.getId();
                if (findPontoColeta(id) == null) {
                    throw new NonexistentEntityException("The pontoColeta with id " + id + " no longer exists.");
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
            PontoColeta pontoColeta;
            try {
                pontoColeta = em.getReference(PontoColeta.class, id);
                pontoColeta.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pontoColeta with id " + id + " no longer exists.", enfe);
            }
            em.remove(pontoColeta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PontoColeta> findPontoColetaEntities() {
        return findPontoColetaEntities(true, -1, -1);
    }

    public List<PontoColeta> findPontoColetaEntities(int maxResults, int firstResult) {
        return findPontoColetaEntities(false, maxResults, firstResult);
    }

    private List<PontoColeta> findPontoColetaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PontoColeta.class));
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

    public PontoColeta findPontoColeta(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PontoColeta.class, id);
        } finally {
            em.close();
        }
    }

    public int getPontoColetaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PontoColeta> rt = cq.from(PontoColeta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
