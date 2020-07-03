package org.libertas.dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.libertas.hibernate.HibernateUtil;
import org.libertas.pojo.Pessoa;

public class PessoaDao {

	public void salvar(Pessoa p) {
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			session.saveOrUpdate(p);
			transacao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Pessoa> listar() {
		List<Pessoa> lista = null; 
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			lista = session.createQuery("from Pessoa order by nome").getResultList();
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public Pessoa consultar(int id) {
		Pessoa p = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = session.beginTransaction();
			p = (Pessoa) session.createQuery("from Pessoa WHERE idpessoa = " + id).getSingleResult();
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	public void excluir(int id) {
		Pessoa p = consultar(id);
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
