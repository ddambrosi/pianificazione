package it.soprasteria.pianificazione.v2.bean;

public class TestBean {

	private String attr1;
	private String attr2;
	
	public static TestBean build(String attr1, String attr2) {

		TestBean result = new TestBean();
		result.attr1 = attr1;
		result.attr2 = attr2;
		return result;
	}

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}


}
