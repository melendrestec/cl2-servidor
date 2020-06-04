package soap.cibertec.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import soap.cibertec.entidad.Producto;
@WebService(name="servicio")
public interface ProductoDAO {
	@WebMethod
	public int saveProducto(@WebParam (name="producto") Producto bean);
	@WebMethod
	public List<Producto> listAllProducto(@WebParam (name="precio1") double pre1,@WebParam (name="precio2") double pre2);
	

}
