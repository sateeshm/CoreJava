package hello;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class HclDemo {

	private final Set<String> names;
	
	public HclDemo(Set<String> name){
		this.names = name;
	}
	
	private Set<String> getNames(){
		return names;
	}
	
	public static void main(String args[]){
		
		Set<String> pc = new HashSet<String>();
		pc.add("Mars");
		pc.add("Zupitar");
		
		HclDemo pc1 = new HclDemo(pc);
		
		HclDemo pc3 = new HclDemo(new HashSet<String>());
		
		System.out.println("Set: Before: "+ pc1.getNames());
		//pc.add("Moon");
		
		Set<String> pc2 = Collections.unmodifiableSet(pc);
		pc2.add("Sun");
		
		System.out.println("Set: After: "+ pc1.getNames());
	}
}


