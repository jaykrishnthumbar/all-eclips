import com.school.SchoolRulesFactory;
import com.school.Student;

public class FactoryMain {

	public static void main(String[] args) {

		SchoolRulesFactory scr = new SchoolRulesFactory();
		Student st = scr.getInstance("Help");
		st.stu();
	}

}
