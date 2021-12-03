package terminal;

public class EFT_data {
    private float total_fee;
    private String num;
    private String provider_name;


    public EFT_data()
    {
    }

    public EFT_data(float total_fee, String num, String provider_name)
    {
        this.total_fee = total_fee;
        this.num = num;
        this.provider_name = provider_name;
    }

    public float getFee()
    {
        return total_fee;
    }

    public String getNum()
    {
        return num;
    }

    public String getProvider_name()
    {
        return provider_name;
    }

    public void setFee(float total_fee)
    {
        this.total_fee = total_fee;
    }

    public void setNum(String num)
    {
        this.num = num;
    }

    public void setProvider_name(String provider_name)
    {
        this.provider_name = provider_name;
    }

}
