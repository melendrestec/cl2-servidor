package soap.cibertec.servicio;

import java.util.List;

import javax.jws.WebService;

import soap.cibertec.dao.ProductoDAOImpl;
import soap.cibertec.entidad.Producto;
import soap.cibertec.interfaces.ProductoDAO;

@WebService(name="servicioProducto",endpointInterface ="soap.cibertec.interfaces.ProductoDAO" )
public class ProductoServiceImpl implements ProductoDAO {

	private ProductoDAOImpl dao = new ProductoDAOImpl();
	@Override
	public int saveProducto(Producto bean) {
		// TODO Auto-generated method stub
		return dao.saveProducto(bean);
	}

	@Override
	public List<Producto> listAllProducto(double pre1, double pre2) {
		// TODO Auto-generated method stub
		return dao.listAllProducto(pre1, pre2);
	}

}
