import java.util.Date;

/**
 * Created by Varun Menon on 20/12/2016.
 */
public class FixedDeposit implements Asset{ // Fixed deposit class
    private double fdAmount;
    private float rate;
    private Date d1;

    public FixedDeposit(double fdAmount, float rate, Date d1) {
        this.fdAmount = fdAmount;
        this.rate = rate;
        this.d1 = d1;
    }

    public double getFdAmount() {
        return fdAmount;
    }

    public void setFdAmount(double fdAmount) {
        this.fdAmount = fdAmount;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Date getD1() {
        return d1;
    }

    public void setD1(Date d1) {
        this.d1 = d1;
    }

    @Override
    public double calcValueAsOf(Date date) {

            return fdAmount* rate/100 * (date.getTime()-d1.getTime()) /(31536.0*100.0*1000.0);


    }
}
