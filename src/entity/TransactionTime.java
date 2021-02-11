package entity;

import java.util.Calendar;

public class TransactionTime {

    private Calendar startTime;
    private Calendar endTime;

    public TransactionTime(Calendar startTime, Calendar endTime) throws NullPointerException {
        if (startTime.before(endTime)) {
            this.startTime = startTime;
            this.endTime = endTime;
        } else {
            throw new NullPointerException();
        }
    }

    public boolean isInside(TransactionTime transactionTime) {
        return transactionTime.startTime.before(startTime) &&
                transactionTime.endTime.after(endTime);
    }
}
