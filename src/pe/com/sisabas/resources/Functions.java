package pe.com.sisabas.resources;

public final class Functions {

    private Functions() {
        // Hide constructor.
    }

    /***/
    public static boolean equals(Object obj1, Object obj2) {
    	String s1=String.valueOf(obj1);
		String s2=String.valueOf(obj2);		
		if(s1.equalsIgnoreCase(s2)){
			return true;
		}else{
			return false;
		}
    }

}