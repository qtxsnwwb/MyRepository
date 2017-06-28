package com.application.job.action;

import java.io.Serializable;

import com.opensymphony.xwork2.*;

/**
 * 
 * @Description ��Ƹ��ϢPOJO
 *
 */
public class Job extends ActionSupport implements Serializable{
	private Integer id;       //��Ƹ��ϢID
	private String jname;     //ְλ����
	private String partment;  //��������
	private String worktype;  //��������
	private String salary;    //��н��Χ
	private String jedu;       //ѧ��Ҫ��
	private String pnum;      //��Ƹ����
	private String jdate;       //����ʱ��
	private String jperson;     //��ϵ��
	private String jtel;		//�ֻ�
	private String jmail;  		//����
	private String message;   //��ϸ��Ϣ
	private JobService jobService = new JobService();     //��Ƹ��Ϣҵ����
	
	public Job(){
		super();
	}
	public Job(String jname, String partment, String worktype, String salary,
			String jedu, String pnum, String jdate, String jperson,
			String jtel, String jmail, String message) {
		super();
		this.jname = jname;
		this.partment = partment;
		this.worktype = worktype;
		this.salary = salary;
		this.jedu = jedu;
		this.pnum = pnum;
		this.jdate = jdate;
		this.jperson = jperson;
		this.jtel = jtel;
		this.jmail = jmail;
		this.message = message;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public String getPartment() {
		return partment;
	}
	public void setPartment(String partment) {
		this.partment = partment;
	}
	public String getWorktype() {
		return worktype;
	}
	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getJedu() {
		return jedu;
	}
	public void setJedu(String jedu) {
		this.jedu = jedu;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getJdate() {
		return jdate;
	}
	public void setJdate(String jdate) {
		this.jdate = jdate;
	}
	public String getJperson() {
		return jperson;
	}
	public void setJperson(String jperson) {
		this.jperson = jperson;
	}
	public String getJtel() {
		return jtel;
	}
	public void setJtel(String jtel) {
		this.jtel = jtel;
	}
	public String getJmail() {
		return jmail;
	}
	public void setJmail(String jmail) {
		this.jmail = jmail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * @Description �����Ƹ��Ϣ
	 * @return ��struts.xml��result��ϵ���ַ���
	 */
	public String execute(){
		//��ӳɹ�����success
		if(jobService.add(jname, partment, worktype, salary, jedu, pnum, jperson, jtel, jmail, message)){
			return "success";
		}else{
			return "error";
		}
	}
}
