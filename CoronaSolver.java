import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
//Reads in the file InputFileName and divides it into the following parts:
//n is the number of days the test will be ran for
// f is the number of infections on flights
// newYorkList holds the infection numbers for new york
// losAngelesList holds the infection numbers for los angeles
public class CoronaSolver {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println( new CoronaSolver("testInputFile.txt"));
	}
	public  int n;
	public  int f;
	public  ArrayList<Object> newYorkList=new ArrayList<Object>();
	public  ArrayList<Object> losAngelesList=new ArrayList<Object>();
	public  ArrayList<Object> scanFile(String inputFileName) throws FileNotFoundException{
		File text = new File(inputFileName);
		Scanner scan = new Scanner(text);
		ArrayList<Object> list = new ArrayList<Object>();
		while(scan.hasNext()) {
			list.add((scan.next()));
		}
		scan.close();
		return list;
	}
	public CoronaSolver(String inputFileName) throws FileNotFoundException {
		System.out.println(solve(inputFileName));
	}
	public String solve(String inputFileName) throws FileNotFoundException {
		ArrayList<Object> list = scanFile(inputFileName);
	for (int i=0;i<list.size();i++){
			if (i==0){
				n=Integer.parseInt((String) list.get(0));
			}else if (i==1){
				f=Integer.parseInt((String) list.get(1));
			}else if (i%2==0){
				newYorkList.add(list.get(i));
			}else{
				losAngelesList.add(list.get(i));
			}
		}
		int startNewYork = solveHelper(1, "New York");
		int startLosAngeles = solveHelper(1, "Los Angeles");
		if (startNewYork<startLosAngeles){
			return startNewYork+"";
		}else{
			return startNewYork+"";
		}
	}
	//depth shows how deep into the tree
	public  int solveHelper(int depth, String city){
		//base case where the depth of the tree is equal to the number of days
		//if the base case is met, return the value at that point
		if (depth==n){
			if (city=="New York"){
				return Integer.parseInt((String) newYorkList.get(depth-1));
			}else{
				return Integer.parseInt((String) losAngelesList.get(depth-1));
			}
		}else{
			//calculate the value of infection for the next day, if in one city, the other city will have f added onto it
			int newYork=solveHelper(depth+1, "New York");
			int losAngeles=solveHelper(depth+1, "Los Angeles");
			if (city=="New York"){
				losAngeles+=f;
				losAngeles+=Integer.parseInt((String) newYorkList.get(depth-1));
				newYork+=Integer.parseInt((String) newYorkList.get(depth-1));
				}
			if (city=="Los Angeles"){
				newYork+=f;
				losAngeles+=Integer.parseInt((String) losAngelesList.get(depth-1));
				newYork+=Integer.parseInt((String) losAngelesList.get(depth-1));
			}
			if (newYork<losAngeles){
				return newYork;
			}else
				return losAngeles;
		}
	}
}
