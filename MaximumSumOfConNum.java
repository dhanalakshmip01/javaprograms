import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumSumOfConNum {
public static void main(String[] args) {
			
	int[] numArr = {1,3,5,6,7,12,14,2,3,4};
	List<Integer> elementslist =Arrays.stream(numArr).boxed().collect(Collectors.toList());
	List<Integer> intsum = new ArrayList<>();
	for(int i=0;i<=numArr.length-3;i++) {
	int	sum = elementslist.stream().skip(i).limit(3).mapToInt(Integer::intValue).sum();
	intsum.add(Integer.valueOf(sum));	
	}
	int maximumsum = intsum.stream().reduce(Integer::max).get();
	System.out.println(maximumsum);
	
}
}
