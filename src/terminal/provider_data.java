package terminal;

import java.util.ArrayList;

public class provider_data
{
    private int ID;
    private int zip;
    private String num;
    private String provider_name;
    private String street_name;
    private String city;
    private String state;
    private int consultation;

    private ArrayList<provider_record> provider_records_list;

    public ArrayList<provider_record> getProvider_records_list()
    {
        return provider_records_list;
    }

    public provider_data()
    {
        consultation = 0;
    }

    public int getConsultation()
    {
        return consultation;
    }

    public void setConsultation(int consultation)
    {
        this.consultation = consultation;
    }

    public provider_data(int ID, int zip, String num, String provider_name, String street_name, String city, String state)
    {
        this.ID = ID;
        this.zip = zip;
        this.num = num;
        this.provider_name = provider_name;
        this.street_name = street_name;
        this.city = city;
        this.state = state;
    }

    public int getID()
    {
        return ID;
    }

    public int getZip()
    {
        return zip;
    }

    public String getNum()
    {
        return num;
    }

    public String getProvider_name()
    {
        return provider_name;
    }

    public String getStreet_name()
    {
        return street_name;
    }

    public String getCity()
    {
        return city;
    }

    public String getState()
    {
        return state;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public void setZip(int zip)
    {
        this.zip = zip;
    }

    public void setNum(String num)
    {
        this.num = num;
    }

    public void setProvider_name(String provider_name)
    {
        this.provider_name = provider_name;
    }

    public void setStreet_name(String street_name)
    {
        this.street_name = street_name;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public void add_report(String date, String time, String member_name, String ID, String code, String fee)
    {
        if(provider_records_list == null)
        {
            provider_records_list = new ArrayList<>();
        }
        provider_record pr = new provider_record(date,time,member_name,ID,code,fee);
        provider_records_list.add(pr);
        //System.out.println(member_records_list.get(0).getDate());
    }
}
