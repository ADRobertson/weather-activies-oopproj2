//Aidan Robertson
//OOP Project 1
package project2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Predictor {

	private ArrayList<Instance> instances;
	private String fn;

	public Predictor(String file) {
		instances = new ArrayList<Instance>();
		fn = file;
		readFile();
	}
	
	//private method to read data from passed filename and path, this is called in constructor
	private void readFile() {
		BufferedReader lineReader = null;
		try {
			FileReader fr = new FileReader(fn);
			lineReader = new BufferedReader(fr);
			String line = null;
			while ((line = lineReader.readLine())!=null) {
				String[] pieces = line.split(",");
				Instance temp = new Instance(pieces[0], Integer.parseInt(pieces[1]), Integer.parseInt(pieces[2]), pieces[3], pieces[4]);
				instances.add(temp);
			} 
		}catch (Exception e) {
			System.err.println("there was a problem with the file reader, try different read type.");				
		}
	}

	//public wrapper for writeFile
	public void saveFile() {
		writeFile(this.fn);
	}

	//prints instances objects to string into the file is initially read from
	private void writeFile(String fn) {
		FileWriter fw;
		try {
			fw = new FileWriter(fn);
			BufferedWriter myOutFile = new BufferedWriter(fw);
			myOutFile.write(this.toString());
			myOutFile.flush();
			myOutFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("***There was an error writting the file***!");
			e.printStackTrace();
		}		
	}
	
	
	//  queries instances in arrayList and returns what it thinks would be a good activity for today given an instance of weather conditions (using score method from Instance class)
	public String using(Instance newInstance) {
		Instance match = null;
		int highestScore = 0;
		String activityToReturn = "";
		
		for (Instance instance : instances) {
			if (instance.score(newInstance) >= highestScore) { // if an instance was closer to the weather than any previous one
				highestScore = instance.score(newInstance); // change highest score to this value
				match = instance; // set match variable to instance object that was closest
			}
		}
		if (highestScore == 0) { // if nothing similar could be found, default to take a nap
			activityToReturn = "take a nap";
		}
		else {
			activityToReturn = match.getActivity(); // grab activity of closest matching instance
		}
		
		return activityToReturn;
	}
	
	// wrapper function for adding new Instance to arrayList
	private void add(Instance newInstance) {
		instances.add(newInstance);
	}
	
	// is passed a new Instance - if the exact weather conditions are already in the arrayList, update the activity
	// if not, add the new weather Instance to the arrayList
	public void updating(Instance newInstance) {
		boolean update = false;
		for (Instance instance : instances) {
			if (instance.equals(newInstance)) { // if it finds a weather match, change the activity
					update = true; // will be used to check if the we need to add a new record later in this method
					instance.setActivity(newInstance.getActivity());
			}
		}
		if (!update) {
			add(newInstance); // if there isn't a weather match in the data, add a new instance to the ArrayList
		}
	}
	
	//toString - just uses the Instance class toString to print all weather/activity instances
	public String toString() {
		String toReturn = "";
		for (Instance instance : instances) {
			toReturn += instance + "\n";
		}
		return toReturn;
	}
	
	public Object[] getArrInstances() {
		Object[] array = instances.toArray();
		return array;
	}
	
	public String[] getActivities( ) {
		ArrayList<String> toReturn = new ArrayList<String>();
		for (Instance instance: instances) {
			if (!toReturn.contains(instance.getActivity())) {
				toReturn.add(instance.getActivity());
			}
		}
		
		String[] toReturn2 = new String[toReturn.size()];
		int index = 0;
		for (String string : toReturn) {
			toReturn2[index] = string;
			index++;
		}
		
		return toReturn2;
	}
}

