package spms.vo;

import java.util.Date;

public class MemberDTO {
	protected int 		no;
	protected String 	name;
	protected String 	email;
	protected String 	password;
	protected Date		createdDate;
	protected Date		modifiedDate;
	
	public int getNo() {
		return no;
	}
	public MemberDTO setNo(int no) {
		this.no = no;
		return this;
	}
	public String getName() {
		return name;
	}
	public MemberDTO setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public MemberDTO setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public MemberDTO setPassword(String password) {
		this.password = password;
		return this;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public MemberDTO setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public MemberDTO setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
		return this;
	}
}
