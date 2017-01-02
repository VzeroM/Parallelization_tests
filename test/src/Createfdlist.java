import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Varun Menon on 20/12/2016.
 */
public class Createfdlist {

     void assign(int numberOfFds,List<Asset> FDlist) // set all fdlist values
    {
        DateFormat df= new SimpleDateFormat("DD/MM/YYYY");
        final double amount = 123456;
        final float intRate = 5.3f;
        final String dateAsString = "12/3/2013";
        Date tmpStartDateOfFd = new Date();
        try {
            tmpStartDateOfFd =df.parse(dateAsString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        final Date startDateOfFd = tmpStartDateOfFd;
        FixedDeposit deposit = new FixedDeposit(amount, intRate, startDateOfFd);

        List<Asset> fdlist = IntStream.range(0, numberOfFds).mapToObj(i -> deposit).collect(Collectors.toList());

        FDlist.addAll(fdlist);

        /*
        IntStream.range(0,numberOfFds).forEach(i-> { // loop for each user
            FDlist.add(deposit);
        });
    `       */
    }

    void createShareslist(int numberOfFDs,List<Asset> fdList)
    {
         final double marketValue = 2345.123;
         final long numberOfShares = 2000;
         Shares share =new Shares(numberOfShares,marketValue,"Hexagon");
        List<Asset> fdlist = IntStream.range(0, numberOfFDs).mapToObj(i -> share).collect(Collectors.toList());
        fdList.addAll(fdlist);




    }


}

