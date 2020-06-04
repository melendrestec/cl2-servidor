package soap.cibertec.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import soap.cibertec.entidad.Producto;
import soap.cibertec.interfaces.ProductoDAO;
import soap.cibertec.utils.MysqlDBConexion;

public class ProductoDAOImpl implements ProductoDAO {

	@Override
	public int saveProducto(Producto bean) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_saveProd(?,?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1,bean.getNombre());
			cstm.setString(2,bean.getMarca());
			cstm.setDouble(3,bean.getPrecio());
			cstm.setInt(4,bean.getStock());
			estado=cstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public List<Producto> listAllProducto(double pre1, double pre2) {
		List<Producto> lista=new ArrayList<Producto>();
		Producto bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_listaProd(?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setDouble(1, pre1);
			cstm.setDouble(2, pre2);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean = new Producto();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setMarca(rs.getString(3));
				bean.setPrecio(rs.getDouble(4));
				bean.setStock(rs.getInt(5));
				lista.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

}
