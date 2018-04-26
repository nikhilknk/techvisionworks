/**
 * 
 */
package com.techvisionworks.queue;

import java.util.ArrayList;
import java.util.List;

import com.techvision.common.PetrolPump;

/**
 * @author nikhil.k
 *
 */
public class PetrolPumpAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PetrolPump[] petrolPumpArray = new PetrolPump[3];
		petrolPumpArray[0] = new PetrolPump(6,4);
		petrolPumpArray[1] = new PetrolPump(3,6);
		petrolPumpArray[2] = new PetrolPump(7,3);
		int start = 0;
		int current= start ;
		int petrolLeft = 0;
		int visited = 0;
		while(visited < petrolPumpArray.length) {
			if (petrolLeft + petrolPumpArray[current].getPetrol() > petrolPumpArray[current].getNextPetrolPumpDist())
			{
				petrolLeft += (petrolPumpArray[current].getPetrol() - petrolPumpArray[current].getNextPetrolPumpDist());
				current = current+1;
				visited++;
			}
			else {
				start = current +1;
				petrolLeft = 0;
				visited = 0;
				current = start;
			}
			if(current == petrolPumpArray.length)
				current  = 0;
		}
		System.out.println(start);
	}

}
