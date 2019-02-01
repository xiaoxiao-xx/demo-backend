import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {
	public static void main(String[] args) {
		PasswordEncoder p = passwordEncoderBean();
		System.out.println(p.encode("11111111"));
		trace("000000220000a02d000400000022da815a3936542f2f6d4c3669327a4a3844755267337435773d3d");
	}
	
	public static PasswordEncoder passwordEncoderBean() {
        return new BCryptPasswordEncoder();
    }
	
	
	public static void trace(String label) {
		
	}
}	

