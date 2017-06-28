package com.application.job.action;

import java.io.Serializable;

import com.opensymphony.xwork2.*;

/**
 * 
 * @Description 招聘信息POJO
 *
 */
public class Job extends ActionSupport implements Serializable{
	private Integer id;       //招聘信息ID
	private String jname;     //职位名称
	private String partment;  //所属部门
	private String worktype;  //工作性质
	private String salary;    //月薪范围
	private String jedu;       //学历要求
	private String pnum;      //招聘人数
	private String jdate;       //更新时间
	private String jperson;     //联系人
	private String jtel;		//手机
	private String jmail;  		//邮箱
	private String message;   //详细信息
	private JobService jobService = new JobService();     //招聘信息业务类
	
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
	 * @Description 添加招聘信息
	 * @return 和struts.xml的result联系的字符串
	 */
	public String execute(){
		//添加成功返回success
		if(jobService.add(jname, partment, worktype, salary, jedu, pnum, jperson, jtel, jmail, message)){
			return "success";
		}else{
			return "error";
		}
	}
}
