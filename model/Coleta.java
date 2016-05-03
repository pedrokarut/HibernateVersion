package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Coleta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    private AgenteAmbiental codAgente;
    
    @OneToOne
    private PontoColeta codPonto;
    
    @Column
    private String dataColeta;
    
    public Coleta()
    {
        
    }
    

    public AgenteAmbiental getCodAgente() {
        return codAgente;
    }

    public void setCodAgente(AgenteAmbiental codAgente) {
        this.codAgente = codAgente;
    }

    public PontoColeta getCodPonto() {
        return codPonto;
    }

    public void setCodPonto(PontoColeta codPonto) {
        this.codPonto = codPonto;
    }

    public String getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(String dataColeta) {
        this.dataColeta = dataColeta;
    }
    

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coleta)) {
            return false;
        }
        Coleta other = (Coleta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Coleta[ id=" + id + " ]";
    }
    
}
