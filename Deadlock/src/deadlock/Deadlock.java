package deadlock;

/**
 *
 * @authors Eric Ruppert, Susan Tabassum, Erik Galloway, Miao Yu
 */


/**
 * Implementing Deadlock through impassable lock conditions
 * Utilizes the bank account example from the text to create the condition
 */
public class Deadlock {
    
    public static final int NUMBER_ACCOUNTS = 10;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 2500;
    
    public static void main(String[] args) {
        Bank deadlockBank = new Bank(NUMBER_ACCOUNTS, INITIAL_BALANCE);
        
        for (int i = 0; i < NUMBER_ACCOUNTS; i++){
            int fromAccount = i;
            Runnable r = () -> {
                try{
                    while (true){
                        int toAccount = (int) (NUMBER_ACCOUNTS * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        deadlockBank.transfer(fromAccount, toAccount, amount);
                        
                    }
                }
                catch (InterruptedException e){
                    
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
        
    }
    
}
