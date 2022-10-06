package co.edu.unbosque.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Algoritmo{
	private List<int[]> listam=new ArrayList<>();
	private List<int[]> listaFinalistas= new ArrayList<>();
	private int [] listR = new int [16]; 
	
	public Algoritmo() {
		listam=new ArrayList<>();
		generatemuestra();
		firsfilter();
		secondfilter();
		thirdfilter();
		fourfilter();
		posr();
		Rselection();
	}
	
	public int[] generatePoblation() {
		int[] intArray = new int[9];
		for(int i=0;i<9;i++) {
			intArray[i]=(int) (Math.random()*10);
			
		}
		
		return intArray;
	}
	
	public void generatemuestra() {
		for(int i=0;i<2000000
				;i++) {
			listam.add(generatePoblation());
		}
		
	}
	
	public void firsfilter() {
		for(int i=0;i<listam.size();i++) {
			
		
			if(Trepetidos(listam.get(i))==true) {
				
				listam.set(i, null);
			}
			
		}
		listam.removeIf(s -> s == null);
		System.out.println("quedan "+listam.size()+" elementos");
	}
	
	public boolean Trepetidos(int[] arr) {
		boolean res=false;
		int end = arr.length;
		Set<Integer> set = new HashSet<Integer>();

		for(int i = 0; i < end; i++){
		  set.add(arr[i]);
		}
		if(set.size()<9) {
			res=true;
		}
		return res;
	}
	
	public void secondfilter() {
for(int i=0;i<listam.size();i++) {		
			if(listam.get(i)[4]!=5) {
				System.out.println(i);
				listam.set(i, null);
			}		
		}
listam.removeIf(s -> s == null);
System.out.println("quedan "+listam.size()+" elementos2");
	}
	
	public void thirdfilter() {
		for(int i=0;i<listam.size();i++) {		
			if(listam.get(i)[0]%2==0 && listam.get(i)[2]%2==0 && listam.get(i)[6]%2==0 && listam.get(i)[8]%2==0 ) {
				System.out.println(i);
				listam.set(i, null);
			}		
		}
		listam.removeIf(s -> s == null);
		System.out.println("quedan "+listam.size()+" elementos3");
		System.out.println("["+listam.get(0)[0]+"]"+"["+listam.get(0)[1]+"]"+"["+listam.get(0)[2]+"]"+"\n"+"["+listam.get(0)[3]+"]"+"["+listam.get(0)[4]+"]"+"["+listam.get(0)[5]+"]"+"\n"+"["+listam.get(0)[6]+"]"+"["+listam.get(0)[7]+"]"+"["+listam.get(0)[8]+"]");
		System.out.println(" ");
		System.out.println("["+listam.get(1)[0]+"]"+"["+listam.get(1)[1]+"]"+"["+listam.get(1)[2]+"]"+"\n"+"["+listam.get(1)[3]+"]"+"["+listam.get(1)[4]+"]"+"["+listam.get(1)[5]+"]"+"\n"+"["+listam.get(1)[6]+"]"+"["+listam.get(1)[7]+"]"+"["+listam.get(1)[8]+"]");
		System.out.println(" ");
		System.out.println("["+listam.get(2)[0]+"]"+"["+listam.get(2)[1]+"]"+"["+listam.get(2)[2]+"]"+"\n"+"["+listam.get(2)[3]+"]"+"["+listam.get(2)[4]+"]"+"["+listam.get(2)[5]+"]"+"\n"+"["+listam.get(2)[6]+"]"+"["+listam.get(2)[7]+"]"+"["+listam.get(2)[8]+"]");
	}
	
	public void fourfilter() {
		for(int i=0;i<listam.size();i++) {		
			if(contiene(listam.get(i)) ) {
				System.out.println(i);
				listam.set(i, null);
			}		
		}
		listam.removeIf(s -> s == null);
		System.out.println("quedan "+listam.size()+" elementos4");
		System.out.println("["+listam.get(0)[0]+"]"+"["+listam.get(0)[1]+"]"+"["+listam.get(0)[2]+"]"+"\n"+"["+listam.get(0)[3]+"]"+"["+listam.get(0)[4]+"]"+"["+listam.get(0)[5]+"]"+"\n"+"["+listam.get(0)[6]+"]"+"["+listam.get(0)[7]+"]"+"["+listam.get(0)[8]+"]");
		System.out.println(" ");
		System.out.println("["+listam.get(1)[0]+"]"+"["+listam.get(1)[1]+"]"+"["+listam.get(1)[2]+"]"+"\n"+"["+listam.get(1)[3]+"]"+"["+listam.get(1)[4]+"]"+"["+listam.get(1)[5]+"]"+"\n"+"["+listam.get(1)[6]+"]"+"["+listam.get(1)[7]+"]"+"["+listam.get(1)[8]+"]");
		System.out.println(" ");
		System.out.println("["+listam.get(2)[0]+"]"+"["+listam.get(2)[1]+"]"+"["+listam.get(2)[2]+"]"+"\n"+"["+listam.get(2)[3]+"]"+"["+listam.get(2)[4]+"]"+"["+listam.get(2)[5]+"]"+"\n"+"["+listam.get(2)[6]+"]"+"["+listam.get(2)[7]+"]"+"["+listam.get(2)[8]+"]");
	}
	
	public boolean contiene(int[] arr) {
		boolean res=false;
		for(int i:arr) {
			if(i==0) {
				res=true;
			}
		}
		return res;
	}
	public void posr() {
		for(int i=0;i<listR.length;i++) {
			listR[i]=(int) (Math.random()*listam.size());
			System.out.println(listR[i]+" in list");
		}
		
	}
	
		public void Rselection() {
			for(int i=0;i<listR.length;i++) {
				listaFinalistas.add(listam.get(listR[i]));
			}
			System.out.println("quedan "+listam.size()+" elementos4");
			System.out.println("["+listaFinalistas.get(0)[0]+"]"+"["+listaFinalistas.get(0)[1]+"]"+"["+listaFinalistas.get(0)[2]+"]"+"\n"+"["+listaFinalistas.get(0)[3]+"]"+"["+listaFinalistas.get(0)[4]+"]"+"["+listaFinalistas.get(0)[5]+"]"+"\n"+"["+listaFinalistas.get(0)[6]+"]"+"["+listaFinalistas.get(0)[7]+"]"+"["+listaFinalistas.get(0)[8]+"]");
			System.out.println(" ");
			System.out.println("["+listaFinalistas.get(1)[0]+"]"+"["+listaFinalistas.get(1)[1]+"]"+"["+listaFinalistas.get(1)[2]+"]"+"\n"+"["+listaFinalistas.get(1)[3]+"]"+"["+listaFinalistas.get(1)[4]+"]"+"["+listaFinalistas.get(1)[5]+"]"+"\n"+"["+listaFinalistas.get(1)[6]+"]"+"["+listaFinalistas.get(1)[7]+"]"+"["+listaFinalistas.get(1)[8]+"]");
			System.out.println(" ");
			System.out.println("["+listaFinalistas.get(2)[0]+"]"+"["+listaFinalistas.get(2)[1]+"]"+"["+listaFinalistas.get(2)[2]+"]"+"\n"+"["+listaFinalistas.get(2)[3]+"]"+"["+listaFinalistas.get(2)[4]+"]"+"["+listaFinalistas.get(2)[5]+"]"+"\n"+"["+listaFinalistas.get(2)[6]+"]"+"["+listaFinalistas.get(2)[7]+"]"+"["+listaFinalistas.get(2)[8]+"]");
		}
		
		
}
