public class CustomerAdapter implements CustomerJSON{
    private CustomerCSV customerCSV;
    public CustomerAdapter(CustomerCSV customerCSV) {
        this.customerCSV = customerCSV;
    }
    
    @Override
    public String getFullName() {
        String[] data = customerCSV.getCsv().split(",");
        return data[0] + " " +  data[1];
    }

    @Override
    public String getEmail() {
        return customerCSV.getCsv().split(",")[2];
    }

    @Override
    public String getPhoneNumber() {
        return customerCSV.getCsv().split(",")[3];
    }
}
