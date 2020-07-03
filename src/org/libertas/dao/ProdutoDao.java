package org.libertas.dao;

import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.libertas.hibernate.HibernateUtil;
import org.libertas.pojo.Produto;

public class ProdutoDao {

	public void salvar(Produto p) {
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			session.saveOrUpdate(p);
			transacao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Produto> listar() {
		List<Produto> lista = null; 
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			lista = session.createQuery("from Produto order by descricao").getResultList();
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public Produto consultar(int id) {
		Produto p = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			p = (Produto) session.createQuery("from Produto WHERE idproduto = " + id).getSingleResult();
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	public void excluir(int id) {
		Produto p = consultar(id);
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			session.delete(p);
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
