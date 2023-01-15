import java.util.List;

public class Sum {
    Sum(){}
    public static Long SumTheData(List<Long> listOfCityPopulation){
        return listOfCityPopulation.stream().mapToLong(Long::longValue).sum();
    }
}
