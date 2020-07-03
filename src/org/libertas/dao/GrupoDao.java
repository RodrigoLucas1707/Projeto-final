package org.libertas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.libertas.hibernate.HibernateUtil;
import org.libertas.pojo.Cidade;
import org.libertas.pojo.Grupo;
import org.libertas.pojo.Pessoa;

public class GrupoDao {

	public void salvar(Grupo c) {
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			session.saveOrUpdate(c);
			transacao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Grupo> listar() {
		List<Grupo> lista = null; 
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			lista = session.createQuery("from Grupo order by idgrupo").getResultList();
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public Grupo consultar(int id) {
		Grupo g = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			g = (Grupo) session.createQuery("from Grupo WHERE idgrupo = " + id).getSingleResult();
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return g;
	}
	public void excluir(int id) {
		Grupo g = consultar(id);
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			session.delete(g);
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void inserir(Grupo g) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			session.save(g);
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
