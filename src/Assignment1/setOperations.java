package Assignment1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class setOperations {
	private static void operate(ArrayList<String> first, ArrayList<String> second,int operationNumber) {
		 ArrayList<String> one;
		 ArrayList<String> two;
		 if(first.size()<=second.size()) {
			 one=first;
			 two=second;
		 }
		 else {
			 one=second;
			 two=first;
		 }
	      ArrayList<String> intersection=new ArrayList<String>();
	      ArrayList<String> union=new ArrayList<String>();
	      ArrayList<String> complement=new ArrayList<String>();

	      int [] checkInter=new int[one.size()];
	      int [] checkUnio=new int[two.size()];

	    	  for(int i=0;i<two.size();i++) {
	    		  for(int j=0;j<one.size();j++) {
	    				  if (one.get(j).equals(two.get(i))) {
	    					  if(checkInter[j]!=1) {
	    					  intersection.add(one.get(j));
	    					  union.add(one.get(j));
	    					  checkInter[j]=1;
	    					  checkUnio[i]=1;
	    					  }
	    				  }	    				  	    			  
	    		  } 
	    	  }
			
	    	  ////////////////////////////////////////////////	    	
	    	  for(int i=0;i<checkInter.length;i++) {
	    		  if(checkInter[i]!=1) {
				  union.add(one.get(i));}
			  }

	    	  for(int i=0;i<checkUnio.length;i++) {
	    		  if(checkUnio[i]!=1) {
				  union.add(two.get(i));
				  complement.add(two.get(i));}
			  }
	    	  if(operationNumber ==2) {
	      System.out.println("Size of Intersection set is equal to "+intersection.size());
	      System.out.println("= "+intersection);}
	    	  else if(operationNumber==1) {
		  System.out.println("Size of Union set is equal to "+union.size());
		  System.out.println("= "+union);}
	    	  else if(operationNumber==3) {
	      System.out.println("Size of complement set is equal to "+complement.size());
	      System.out.println("= "+complement);}
	        	         
	    }
      
      //////////////////////////////////////////////////////////////////////////////////////////////
      static class type{
    	  ArrayList<String> result;
    	  int c;
      }
      
      public static type space(String expression, int check, ArrayList<String> Universe){
    	  type results = new type();
    	  results.c=0;
	    	ArrayList<String> result = new ArrayList<String>();
	        int size=expression.length();
	        String word="";
	        for (int i=0; i<size; i++){
	            char digit = expression.charAt(i);
	            if(digit!=' ' && digit!=','){
	                word+=digit;
	                if(i==size-1) {
	                	if(check==0) {
	                		result.add(word);
	                	}else {
	                		if(Universe.contains(word)) {
	                			result.add(word);
	                		}else {
	                			results.c=1;
	                		}
	                	}
	                }
	            }else if((digit==' ' || digit==',') && word.length()!=0){
	            	if(check==0) {
	            		result.add(word);
		            	word="";	
	            	}else {
	            		if(Universe.contains(word)) {
	            			result.add(word);
			            	word="";
	            		}else {
	            			results.c=1;
	            			break;
	            		}
	            	}
	            }
	        }
	        results.result = result;
	        return results;
	    }
      
      //////////////////////////////////////////////////////////////////////////////////////////////
      public static int check(int size) {
    	  Scanner s = new Scanner(System.in);
    	  String num = s.nextLine();
    	  while(num.matches("\\D") || Integer.parseInt(num)>=size || Integer.parseInt(num)<0 || num=="") {
    		  System.out.println("Enter number of set again:");
    		  num = s.nextLine();
    	  }
    	  return Integer.parseInt(num);
      }
      
      //////////////////////////////////////////////////////////////////////////////////////////////
      static boolean exit = false;
      public static void menu (  ArrayList<ArrayList<String>> sets) {
    		while ( !exit ) {
    		System.out.println("====================================================================");
    		System.out.println("Please choose an action:");
    		System.out.println("-----------------------");
    		System.out.println("set number 0 is Universe subsets begin from 1");
    		System.out.println("1- Union of 2 sets");
    		System.out.println("2- Intersection of 2 sets");
    		System.out.println("3- Complement of a set");
    		System.out.println("4- Show a set");
    		System.out.println("5- Exit the menu");
    		System.out.println("====================================================================");
    
    		   Scanner sc = new Scanner(System.in);
    		   char op = sc.next().charAt(0);
    		    switch ( op ) {
    			case '1' :
    					if(sets.size()>2) {
    						System.out.println("Enter the number of set A:");
        					int  setA = check(sets.size());
        					System.out.println("Enter the number of set B:");
        					int  setB = check(sets.size());
        			        operate(sets.get(setA), sets.get(setB),1); 
    					}else {
    						System.out.println(sets.get(0));
    					}  			    
    			    break;
    			    
    			case '2' :
    				if(sets.size()>2) {
    					System.out.println("Enter the number of set A:");
    					int  setA1 = check(sets.size());
    					System.out.println("Enter the number of set B:");
    					int  setB1 = check(sets.size());
    			        operate(sets.get(setA1), sets.get(setB1),2);  
    				}else {
    					System.out.println(sets.get(1));
    				}
    				break;
    				
    			case '3' :
    				if(sets.size()>2) {
    					System.out.println("Enter the number of set:");
						int  setC = check(sets.size());
			        	operate(sets.get(0), sets.get(setC),3); 
    				}else {
    					operate(sets.get(0), sets.get(1),3);
    				}
    				break;
    				
    			case '4' :
    				System.out.println("Enter the number of set: (0 for Universe)");
					int  showSet = check(sets.size());
					System.out.println(Arrays.toString(sets.get(showSet).toArray()));
	    				break;
    			case '5' :
    				exit = true;
    				break;
    				
    			default :
    				System.out.println(" invalid input");	
    			}
    		}
    	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Universe:");
        String Universe = scanner.nextLine();
        ArrayList<String> a = space(Universe,0,null).result;
        System.out.println("Enter number of sets:");
        String num = scanner.nextLine();
        while(num.matches("\\D") || Integer.parseInt(num)<=0 || num=="") {
        	System.out.println("Enter valid number of sets:");
        	num = scanner.nextLine();
        }
        ArrayList<ArrayList<String>> sets = new ArrayList<ArrayList<String>>();
        sets.add(a);
        for(int i=1; i<=Integer.parseInt(num); i++) {
        	System.out.println("Enter set "+ (i) +":");
        	String temp = scanner.nextLine();
        	type res = space(temp,i,a);
        	ArrayList<String> temp1 = res.result;
        	if(temp1.size()<=a.size() && res.c==0) {
            	sets.add(temp1);
        	}else {
        		i--;
        		System.out.println("The set is invalid, Enter another set:");
        	}
        }
        menu(sets);
    }
}