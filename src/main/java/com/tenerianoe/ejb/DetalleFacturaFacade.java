/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenerianoe.ejb;

import com.tenerianoe.model.DetalleFactura;
import com.tenerianoe.model.Factura;
import com.tenerianoe.model.catalogo_producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author said
 */
@Stateless
public class DetalleFacturaFacade extends AbstractFacade<DetalleFactura> implements DetalleFacturaFacadeLocal {

      @PersistenceContext(unitName = "com.mycompany_TeneriaApp_war_1.0-SNAPSHOTPU")
      private EntityManager em;

      @Override
      protected EntityManager getEntityManager() {
            return em;
      }

      public DetalleFacturaFacade() {
            super(DetalleFactura.class);
      }

    @Override
    public void insertarDetalleFacturaProcedimiento(DetalleFactura detalle, Factura factura,catalogo_producto producto) {
        Query q= em.createNativeQuery("{call insertarDetalle(?,?,?,?)}");
        q.setParameter(1, detalle.getCantidad());
        q.setParameter(2, detalle.getPrecioUnitario());
        q.setParameter(3, producto.getIdCatalogoProducto());
        q.setParameter(4, factura.getIdFactura());
        q.executeUpdate();
        
        
    }

    @Override
    public List<DetalleFactura> detallesFactura(Factura factura) {
        List<DetalleFactura> lista=null;
        Query q = em.createNativeQuery("select * from DETALLEFACTURA where idFactura= ?1");
        q.setParameter(1, factura.getIdFactura());
        lista= q.getResultList();
        return lista;
    }

    @Override
    public void calcularTotalProcedimiento(Factura factura) {
        Query q= em.createNativeQuery("{call calcularTotalCompra(?)}");
        q.setParameter(1, factura.getIdFactura());
        q.executeUpdate();
    }

  

   
      
}
