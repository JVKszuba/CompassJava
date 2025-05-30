public class Company extends TaxPayer {

    private Integer numberEmployees;

    //Constructors
    public Company() {super();}
    public Company(String name, Double annualIncome, Integer numberEmployees) {

        super(name, annualIncome);

        this.numberEmployees = numberEmployees;
    }

    //Getters and setters methods
    public Integer getNumberEmployees() {return numberEmployees;}

    public void setNumberEmployees(Integer numberEmployees) {this.numberEmployees = numberEmployees;}

    //General methods
    @Override
    public Double calculateTax() {

        double tax = 0;

        if (numberEmployees > 10) tax = (annualIncome * 0.14);
        else tax = (annualIncome * 0.16);

        return tax;
    }
}
