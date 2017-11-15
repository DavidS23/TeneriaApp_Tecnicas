/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenerianoe.ejb;

import com.tenerianoe.model.DetalleProduccion;
import com.tenerianoe.model.Factura;
import com.tenerianoe.model.Produccion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author admin
 */
@Stateless
public class DetalleProduccionFacade extends AbstractFacade<DetalleProduccion> implements DetalleProduccionFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_TeneriaApp_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleProduccionFacade() {
        super(DetalleProduccion.class);
    }

    @Override
    public List<DetalleProduccion> listaDetallesPorProceso(Produccion produccion) {
        List<DetalleProduccion> lista;
        Query q = em.createQuery("SELECT U FROM DetalleProduccion U "
                + "WHERE U.idProduccion.numeroProceso=?1");
        q.setParameter(2,produccion);
        lista = q.getResultList();
        return lista;
    }



}
