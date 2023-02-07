package greedy;


public class GasStation {
	public static void main(String[] args) {
		System.out.println(canCompleteCircuit(new int[] { 1,2,3,4,5 }, new int[] {3,4,5,1,2 }));
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int rslt = 0;

		int length = gas.length;
		int totalGas = 0;
		int totalCost = 0;
		int tank = 0;
		for (int i = 0; i < length; i++) {
			totalGas += gas[i];
			totalCost += cost[i];
			tank = tank + gas[i] - cost[i];
			if (tank < 0) {
				rslt = i + 1;
				tank = 0;
			}
		}

		if(totalGas < totalCost) {
			rslt = -1;
		}
		
		return rslt;
	}


}
