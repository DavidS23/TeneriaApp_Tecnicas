/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenerianoe.ejb;

import com.tenerianoe.model.CatalogoProveedor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author said
 */
@Stateless
public class CatalogoProveedorFacade extends AbstractFacade<CatalogoProveedor> implements CatalogoProveedorFacadeLocal {

      @PersistenceContext(unitName = "com.mycompany_TeneriaApp_war_1.0-SNAPSHOTPU")
      private EntityManager em;

      @Override
      protected EntityManager getEntityManager() {
            return em;
      }

      public CatalogoProveedorFacade() {
            super(CatalogoProveedor.class);
      }

    @Override
    public void registrarProcedimiento(CatalogoProveedor proveedor) {
            Query q= em.createNativeQuery("{call insertar_proveedor(?,?,?,?,?,?)}");
            q.setParameter(1, proveedor.getDireccion());
            q.setParameter(2, proveedor.getDui());
            q.setParameter(3, proveedor.getNit());
            q.setParameter(4, proveedor.getPropietario());
            q.setParameter(5, proveedor.getProveedor());
            q.setParameter(6, proveedor.getTelefono());
            q.executeUpdate();
            
    }
      
      
}
