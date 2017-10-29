package br.com.booksw.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import br.com.booksw.models.PaginatedList;
import br.com.booksw.models.Pedidos;

@Repository
public class PedidosDao
{

   @PersistenceContext
   private EntityManager manager;

   public List<Pedidos> all()
   {
      return manager.createQuery("select p from Pedidos p", Pedidos.class).getResultList();
   }

   public void save(Pedidos pedidos)
   {
      manager.persist(pedidos);
   }

   public Pedidos findById(Integer id)
   {
      return manager.find(Pedidos.class, id);
   }

   public void remove(Pedidos pedidos)
   {
      manager.remove(pedidos);
   }

   public void update(Pedidos pedidos)
   {
      manager.merge(pedidos);
   }

   public PaginatedList paginated(int page, int max)
   {
      return new PaginatorQueryHelper().list(manager, Pedidos.class, page, max);
   }

}
