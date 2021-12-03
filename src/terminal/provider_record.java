package terminal;

public class provider_record
{
    private String date;
    private String time;
    private String member_name;
    private String member_ID;
    private String service_code;
    private String fee;

    public provider_record()
    {
    }

    public provider_record(String date, String time, String member_name, String member_ID, String service_code, String fee)
    {
        this.date = date;
        this.time = time;
        this.member_name = member_name;
        this.member_ID = member_ID;
        this.service_code = service_code;
        this.fee = fee;
    }

    public String getDate()
    {
        return date;
    }

    public String getTime()
    {
        return time;
    }

    public String getMember_name()
    {
        return member_name;
    }

    public String getMember_ID()
    {
        return member_ID;
    }

    public String getService_code()
    {
        return service_code;
    }

    public String getFee()
    {
        return fee;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public void setMember_name(String member_name)
    {
        this.member_name = member_name;
    }

    public void setMember_ID(String member_ID)
    {
        this.member_ID = member_ID;
    }

    public void setService_code(String service_code)
    {
        this.service_code = service_code;
    }

    public void setFee(String fee)
    {
        this.fee = fee;
    }
}
