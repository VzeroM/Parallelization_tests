import java.util.Date;

/**
 * Created by Varun Menon on 21/12/2016.
 */
public class Shares implements Asset {
    long numberOfShares;
    double marketValue;
    String name;

    public Shares(long numberOfShares, double marketValue, String name) {
        this.numberOfShares = numberOfShares;
        this.marketValue = marketValue;
        this.name = name;
    }

    public long getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(long numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double calcValueAsOf(Date date) {
        return numberOfShares*marketValue;
    }
}
