package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class ItensColeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    private Material  codMaterial;
    
    @OneToOne
    private Coleta codColeta;
    
    @Column
    private int quantidade;
    
    public ItensColeta()
    {
        
    }
    

    public Material getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(Material codMaterial) {
        this.codMaterial = codMaterial;
    }

    public Coleta getCodColeta() {
        return codColeta;
    }

    public void setCodColeta(Coleta codColeta) {
        this.codColeta = codColeta;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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
        if (!(object instanceof ItensColeta)) {
            return false;
        }
        ItensColeta other = (ItensColeta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ItensColeta[ id=" + id + " ]";
    }
    
}
