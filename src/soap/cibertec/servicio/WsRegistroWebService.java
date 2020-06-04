package soap.cibertec.servicio;

import javax.xml.ws.Endpoint;

public class WsRegistroWebService {

	public static void main(String[] args) {
		//1 Se instancia el web service
		ProductoServiceImpl WS = new ProductoServiceImpl();
		//2 Ruta del ws
		String URL="http://localhost:8072/servicioProducto?wsdl";
		//3 Se registra
		Endpoint edp = Endpoint.publish(URL, WS);
		//4 Se verifica la publicación
		System.out.println(edp.isPublished());
		

	}

}

