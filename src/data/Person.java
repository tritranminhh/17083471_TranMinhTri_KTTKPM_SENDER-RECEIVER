package data;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"mssv","hoten","ngaysinh"})
public class Person {
	private long mssv;
	private String hoten;
	private Date ngaySinh;
	public long getMssv() {
		return mssv;
	}
	public void setMssv(long mssv) {
		this.mssv = mssv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hoten == null) ? 0 : hoten.hashCode());
		result = prime * result + (int) (mssv ^ (mssv >>> 32));
		result = prime * result + ((ngaySinh == null) ? 0 : ngaySinh.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (hoten == null) {
			if (other.hoten != null)
				return false;
		} else if (!hoten.equals(other.hoten))
			return false;
		if (mssv != other.mssv)
			return false;
		if (ngaySinh == null) {
			if (other.ngaySinh != null)
				return false;
		} else if (!ngaySinh.equals(other.ngaySinh))
			return false;
		return true;
	}
	@Override
	public String toString() {
	return mssv+"\t"+hoten+"\t"+ngaySinh;
	}
	public Person(long mssv, String hoten, Date ngaySinh) {
		super();
		this.mssv = mssv;
		this.hoten = hoten;
		this.ngaySinh = ngaySinh;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

}
