import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Varun Menon on 20/12/2016.
 */
public class Calc_interest {

    Calc_interest(){}



    void compute_sum(int y , List<Asset> fdList, int z, Date d) // adds all interests for one user
    {


            final double[] sum = {0};


            fdList.stream().parallel().forEach(i ->{
                synchronized (sum) {
                    sum[0] = sum[0] + i.calcValueAsOf(d);
                }
            });
            // 9.901239043341127E12
            //IntStream.range(0,y).forEach(i-> sum[0] = sum[0] + fdList.get(z+i).calcValueAsOf(d));
            System.out.println(sum[0]);

    }





}
