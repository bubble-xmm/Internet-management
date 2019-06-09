package com.soft.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.soft.services.support.JdbcServicesSupport;

public class UServicesImpl extends JdbcServicesSupport 
{
	/**
	 * ���²���
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean update(String updateType) throws Exception 
	{
		switch(updateType)
		{
		case"login"  : return this.login();
		case"modify" : return this.modify();
		case"add"    : return this.add();
		case"delete" : return this.delete();
		default      : throw new Exception("����"+this.getClass().getName()+"�У�����������Ϊ"+updateType+"�ĸ��²�����");
		}
	}
	
	/**
	 * ��½�˺�
	 * @return
	 * @throws Exception
	 */
	public boolean login()throws Exception
	{
		boolean tag = false;
		StringBuilder sql = new StringBuilder()
				.append("select a.uid,a.password ")
				.append("from user a ")
				.append("where a.account = ? ")
				;
        Object[] args = {
        		this.getVal("login")	
	};
        Map<String,String> ins = this.queryForMap(sql.toString(), args);
        if(ins!=null)
        {
        	this.addEntry("uid", ins.get("uid"));
        	this.addEntry("password", ins.get("password"));
        	tag = true;
        }      
        return tag;
	}
	
	/**
	 * ������ѯ
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, String>> queryForPage() throws Exception 
	{
		Object uname = this.getVal("qname");
		Object uid = this.getVal("uid");
		System.out.println(uid);
		this.addEntry("uid", uid);
		StringBuilder sql = new StringBuilder()
				.append("select a.cid,a.name,a.age,a.gender,a.phone,a.mail,a.address")
				.append("  from connection a")
				.append(" where a.uid = "+uid+" ")
				;
		List<Object> paramList = new ArrayList<>();
		if(this.isNotNull(uname))
		{
			sql.append("  and a.name like ?");
			paramList.add("%"+uname+"%");
		}
		return this.queryForList(sql.toString(), paramList.toArray());
	}
	
	/**
	 * ��һʵ����ѯ
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, String> findById() throws Exception 
	{
		StringBuilder sql = new StringBuilder()
				.append("select a.cid,a.name,a.gender,a.age,a.phone,a.mail,a.address,a.uid")
				.append("  from connection a")
				.append(" where a.cid = ? ")
				;
		Object args = this.getVal("cid");
		Map<String,String> ins = this.queryForMap(sql.toString(), args);
		this.addEntry("uid", ins.get("uid"));
		return ins;
	}
	
	/**
	 * �޸�
	 * @return
	 * @throws Exception
	 */
	public boolean modify()throws Exception
	{
		this.addEntry("uid", this.getVal("uid"));
		StringBuilder sql = new StringBuilder()
				.append("update connection ")
				.append("   set name = ?,gender = ?,age = ?,phone = ?,mail = ?,address = ?")
				.append(" where cid = ?")
				;
		Object[] args = {
				this.getVal("name"),
				this.getVal("gender"),
				this.getVal("age"),
				this.getVal("phone"),
				this.getVal("mail"),
				this.getVal("address"),
				this.getVal("cid")
		};
		return this.executeUpdate(sql.toString(), args)>0;
	}
	
	/**
	 * ���
	 * @return
	 * @throws Exception
	 */
	public boolean add()throws Exception
	{
		boolean tag = false;
		StringBuilder sql = new StringBuilder()
				.append("insert into connection(name,age,gender,phone,mail,address,uid)")
				.append("          values(?,?,?,?,?,?,?)")
				;
		Object[] args = {
				this.getVal("name"),
				this.getVal("age"),
				this.getVal("gender"),
				this.getVal("phone"),
				this.getVal("mail"),
				this.getVal("address"),
                this.getVal("uid")
		};
		if(this.executeUpdate(sql.toString(), args)>0)
		{
			tag = true;
			this.addEntry("uid", this.getVal("uid"));
		}
		return tag;
	}
	
	/**
	 * ɾ��
	 * @return
	 * @throws Exception
	 */
	public boolean delete()throws Exception
	{
		String sql = "delete from connection where cid = ?";
		Object[] idlist = this.getArray("idlist");
		return this.batchTransaction(sql, idlist);
	}
	
}
