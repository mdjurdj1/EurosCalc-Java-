
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros += cents / 100;
            cents %= 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return euros;
    }

    public int cents() {
        return cents;
    }
    
    public Money plus(Money added) {
        Money newMoney = new Money(this.euros + added.euros, this.cents + added.cents);
        return newMoney;
    }
    
    public boolean less(Money compared) {
        return (this.euros * 100 + this.cents) < (compared.euros * 100 + compared.cents);
    }
    
    public Money minus(Money decremented) {
        int centsDifference = (this.euros * 100 + this.cents) - (decremented.euros * 100 + decremented.cents);
        Money newMoney = new Money(0, centsDifference);
        Money noMoney = new Money(0, 0);
        if (newMoney.less(noMoney)) {
            return noMoney;
        } else {
            return newMoney;
        }
    }

    @Override
    public String toString() {
        String zero = "";
        if (cents < 10) {
            zero = "0";
        }

        return euros + "." + zero + cents + "e";
    }

}
