import java.util.ArrayList;
import java.util.List;


/**
 * @author chenhuaming
 * 2016-1-13
 * 
 */
public class Test {
	public static void main(String args[]){
		new S().say();
	}
}
class F{
	private String a ="100";
	public void m(){
		System.out.println("fff");
	}
	public void fuck(){try {
		String s =((F)(new S())).a;
		Class<? extends F> clz = this.getClass();
		System.out.println(clz.getName());
		System.out.println((clz.newInstance()).a);
		System.out.println(((F)(new S())).a);
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
}
class S extends F{
	public void m(){
		System.out.println("s");
	}
	public void say(){
		this.fuck();
	}
}