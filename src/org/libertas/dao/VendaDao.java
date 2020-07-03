package org.libertas.dao;

import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.libertas.hibernate.HibernateUtil;
import org.libertas.pojo.Venda;

public class VendaDao {

	public void salvar(Venda v) {
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			session.saveOrUpdate(v);
			transacao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Venda> listar() {
		List<Venda> lista = null; 
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			lista = session.createQuery("from Venda").getResultList();
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public Venda consultar(int id) {
		Venda v = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			v = (Venda) session.createQuery("from Venda WHERE idvenda = " + id).getSingleResult();
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	public void excluir(int id) {
		Venda v = consultar(id);
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			session.delete(v);
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
