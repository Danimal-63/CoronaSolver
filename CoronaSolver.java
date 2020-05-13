import java.util.Scanner;
import java.util.*;
private int n=0;
private int f=0;
private ArrayList newYorkList;
private ArrayList losAngelesList;
//Reads in the file InputFileName and divides it into the following parts:
//n is the number of days the test will be ran for
// f is the number of infections on flights
// newYorkList holds the infection numbers for new york
// losAngelesList holds the infection numbers for los angeles
public class CoronaSolver {
	Scanner scan = new Scanner(InputFileName);
	ArrayList <Integer> list = new ArrayList <Integer>();
	public String solve(String InputFileName) {
		while(scan.hasNext()) {
			list.add(Integer.parseInt(scan.next()));
		}
		for (int i=0;i<list.size;i++){
			if (i==0){
				n=list.get(0);
			}else if (i==1){
				f=list.get(1);
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
	public int solveHelper(int depth, String city){
		//base case where the depth of the tree is equal to the number of days
		//if the base case is met, return the value at that point
		if (depth==n){
			if (city=="New York"){
			return newYorkList.get(depth);
		}else{
			return losAngelesList.get(depth)
		}
	}else{
		//calculate the value of infection for the next day, if in one city, the other city will have f added onto it
		int newYork=solveHelper(depth+1, "New York");
		int losAngeles=solveHelper(depth+1, "Los Angeles");
		if (city=="New York"){
			losAngeles+=f;
		}
		if (city=="Los Angeles"){
			newYork+=f;
		}
		if (newYork<losAngeles){
			return newYork;
		}else
		return losAngeles;
	}
}
