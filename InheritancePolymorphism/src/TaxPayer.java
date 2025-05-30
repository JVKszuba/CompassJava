public abstract class TaxPayer {

    protected String name;
    protected Double annualIncome;

    //Constructors
    public TaxPayer() {}
    public TaxPayer(String name, Double annualIncome) {

        this.name = name;
        this.annualIncome = annualIncome;
    }

    //Getters and setters methods
    public String getName() {return name;}
    public Double getAnnualIncome() {return annualIncome;}

    public void setName(String name) {this.name = name;}
    public void setAnnualIncome(Double annualIncome) {this.annualIncome = annualIncome;}

    //General methods
    public abstract Double calculateTax();
}
