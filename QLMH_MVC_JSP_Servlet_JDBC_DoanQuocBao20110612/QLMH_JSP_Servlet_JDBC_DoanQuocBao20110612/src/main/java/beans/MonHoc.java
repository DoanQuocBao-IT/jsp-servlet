package beans;

public class MonHoc {
	public int getMaso_monhoc() {
		return maso_monhoc;
	}
	public void setMaso_monhoc(int maso_monhoc) {
		this.maso_monhoc = maso_monhoc;
	}
	public String getTen_monhoc() {
		return ten_monhoc;
	}
	public void setTen_monhoc(String ten_monhoc) {
		this.ten_monhoc = ten_monhoc;
	}
	public int getSotinchi() {
		return sotinchi;
	}
	public void setSotinchi(int sotinchi) {
		this.sotinchi = sotinchi;
	}
	private int maso_monhoc;
	private String ten_monhoc;
	private int sotinchi;
	public MonHoc(int maso_monhoc,String ten_monhoc, int sotinchi) {
		this.maso_monhoc=maso_monhoc;
		this.ten_monhoc=ten_monhoc;
		this.sotinchi=sotinchi;
	}
	public MonHoc() {}
}
