public class Individual extends TaxPayer {

    private Double healthExpenditures;

    //Constructors
    public Individual() {super();}
    public Individual(String name, Double annualIncome, Double healthExpenditures) {

        super(name, annualIncome);

        this.healthExpenditures = healthExpenditures;
    }

    //Getters and setters methods
    public Double getHealthExpenditures() {return healthExpenditures;}

    public void setHealthExpenditures(Double healthExpenditures) {this.healthExpenditures = healthExpenditures;}

    //General methods
    @Override
    public Double calculateTax() {

        double tax = 0;

        if (annualIncome < 20000) tax = (annualIncome * 0.15);
        else tax = (annualIncome * 0.25);

        tax -= (healthExpenditures * 0.5);

        return tax;
    }
}
