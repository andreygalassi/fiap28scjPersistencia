package br.com.fiap.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.dao.entity.Pedidos;

public class PedidosDao extends Dao {

	public void incluirCliente(Pedidos pedido) throws Exception{
		try {
			abrirConexao();
			cn.setAutoCommit(false);
			String sql = "INSERT INTO PEDIDOS (ID,IDCLIENTE,DATA,DESCRICAO,VALOR) VALUES (?,?,?,?,?)";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, pedido.getId());
			stmt.setInt(2, pedido.getIdCliente());
			stmt.setDate(3, new java.sql.Date(pedido.getData().getTime()));
			stmt.setString(4, pedido.getDescricao());
			stmt.setDouble(5, pedido.getValor());
			stmt.executeUpdate();
			cn.commit();
			cn.setAutoCommit(true);
		} catch (Exception e) {
			cn.rollback();
			throw e;
		}finally {
			fecharConexao();
		}
	}
	
	public Pedidos buscarPedido(int id) throws Exception{
		Pedidos pedido = null;
		try {
			abrirConexao();
			stmt = cn.prepareStatement("select * from clientes where id=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()){
				pedido = new Pedidos();
				resultSetParaObjeto(pedido, rs);
			}
		} catch (Exception e) {
			throw e;
		}finally {
			fecharConexao();
		}
		return pedido;
	}
	
	public List<Pedidos> listarPedidos(int idCliente) throws Exception{
		List<Pedidos> lista = new ArrayList<>();
		try {
			abrirConexao();
			stmt = cn.prepareStatement("select * from pedidos where idcliente=?");
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();
			while (rs.next()){
				Pedidos pedido = new Pedidos();
				resultSetParaObjeto(pedido, rs);
				lista.add(pedido);
			}
		} catch (Exception e) {
			throw e;
		}finally {
			fecharConexao();
		}
		return lista;
	}

	private void resultSetParaObjeto(Pedidos pedido, ResultSet rs) throws SQLException {
		pedido.setId(rs.getInt("id"));
		pedido.setIdCliente(rs.getInt("idcliente"));
		pedido.setData(rs.getDate("data"));
		pedido.setDescricao(rs.getString("descricao"));
		pedido.setValor(rs.getDouble("valor"));
	}
}
