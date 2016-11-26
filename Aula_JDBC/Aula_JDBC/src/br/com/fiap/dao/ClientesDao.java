package br.com.fiap.dao;

import br.com.fiap.dao.entity.Clientes;

public class ClientesDao extends Dao {

	public void incluirCliente(Clientes cliente) throws Exception{
		try {
			abrirConexao();
			cn.setAutoCommit(false);
			String sql = "INSERT INTO CLIENTES (ID,NOME,EMAIL) VALUES (?,?,?)";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, cliente.getId());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getEmail());
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
}
