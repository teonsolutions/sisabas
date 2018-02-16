package pe.com.sisabas.dto;

public class ItemIntResponse {
	private Integer value;
	private String text;
	
	public ItemIntResponse(){
		
	}
	
	public ItemIntResponse(Integer value, String text){
		this.value = value;
		this.text = text;
	}
	
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}		
}
