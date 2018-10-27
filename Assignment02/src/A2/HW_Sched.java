package A2;
import java.util.*;

class Assignment implements Comparator<Assignment>{
	int number;
	int weight;
	int deadline;
	
	
	protected Assignment() {
	}
	
	protected Assignment(int number, int weight, int deadline) {
		this.number = number;
		this.weight = weight;
		this.deadline = deadline;
	}
	
	
	
	/**
	 * This method is used to sort to compare assignment objects for sorting. 
	 * The way you implement this method will define which order the assignments appear in when you sort.
	 * Return -1 if a1 should appear after a2
	 * Return 1 if a1 should appear before a2
	 * Return 0 if a1 and a2 are equivalent 
	 */
	@Override
	public int compare(Assignment a1, Assignment a2) {
		//YOUR CODE GOES HERE, DONT FORGET TO EDIT THE RETURN STATEMENT
		
		/*
		 * compare assignments according to their deadlines
		 * if two assignments have the same deadline, then order according to weight
		 */
		
		
		// if a1 and a2 have the same deadline, then compare weights
		if (a1.deadline == a2.deadline){
			
			if (a1.weight == a2.weight){
				return 0;
			}
			// a1 more important than a2, then a1 before a2
			else if (a1.weight > a2.weight){
				return -1;
			}
			
			// a1 less important than a2, then a1 after a2
			else{
				return 1;
			}
			
		}
		
		// a1 deadline later than a2, then a1 after a2
		else if (a1.deadline > a2.deadline){
			return 1;
		}
		
		//a1 deadline before a2, then a1 before a2
		else{
			return -1;
		}
	}
}

public class HW_Sched {
	ArrayList<Assignment> Assignments = new ArrayList<Assignment>();
	int m;
	int lastDeadline = 0;
	
	protected HW_Sched(int[] weights, int[] deadlines, int size) {
		for (int i=0; i<size; i++) {
			Assignment homework = new Assignment(i, weights[i], deadlines[i]);
			this.Assignments.add(homework);
			if (homework.deadline > lastDeadline) {
				lastDeadline = homework.deadline;
			}
		}
		m =size;
	}
	
	
	/**
	 * 
	 * @return Array where output[i] corresponds to when assignment #i will be completed. output[i] is 0 if assignment #i is never completed.
	 * The homework you complete first will be given an output of 1, the second, 2, etc.
	 */
	public int[] SelectAssignments() {
		//Use the following command to sort your Assignments: 
		//Collections.sort(Assignments, new Assignment());
		//This will re-order your assignments. The resulting order will depend on how the compare function is implemented
		Collections.sort(Assignments, new Assignment());
		
		//Initializes the homeworkPlan, which you must fill out and output
		int[] homeworkPlan = new int[Assignments.size()];
		//YOUR CODE GOES HERE
		/*
		 * Done in collaboration with Huzaifa Elahi 
		 */
		
		// Starting from time = 0, define latestHomework as the time to do the latest homework
		
		int latestHomework = 0;
		
		
		// loop over all assignments
		for (int i = 0; i < Assignments.size(); i++){
			// from the way we order assignments, we know the first one should be included
			Assignment currentAssignment = Assignments.get(i);
			if (i == 0){
				latestHomework++;
				homeworkPlan[currentAssignment.number] = latestHomework;
			}
			
			
			// if current assignment is NOT the last one
			else if (i < Assignments.size() - 1){
				
				// get next assignment
				Assignment nextAssignment = Assignments.get(i + 1);
				
				// if cur assignment and next assignment have the same deadline
				if (currentAssignment.deadline == nextAssignment.deadline){
					// if the deadline is not due for current assignment, then add current assignment
					if (latestHomework < currentAssignment.deadline){
						latestHomework++;
						homeworkPlan[currentAssignment.number] = latestHomework;
					}
				}
				
				// if current assignment and next assignment have different deadlines, then we know from the way we order our assignments, we have to add the next one
				else{
					latestHomework++;
					homeworkPlan[nextAssignment.number] = latestHomework;
				}
			}
			
			
			// if current assignment is the last one, check if we are not past the deadline, then add
			else{
				if (latestHomework < currentAssignment.deadline){
					latestHomework++;
					homeworkPlan[currentAssignment.number] = latestHomework;
				}
			}
		}
		
		return homeworkPlan;
	}
}
	



