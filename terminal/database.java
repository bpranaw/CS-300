package terminal;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/***********************
 * Example to use database:
 * database d = new database();
 * d.boot();
 * ...
 * d.print_provider();
 * ...
 * d.shut();
 * ***********************/


public class database
{

    private static ArrayList<provider_data> provider_list;
    private static ArrayList<member_data> member_list;

    public static void boot()       //remember to boot() before use the database
    {
        provider_list = new ArrayList<>();
        member_list = new ArrayList<>();
        provider_reader();
        member_reader();
    }

    public static void shut() throws IOException    //remember to shut() after use the database
    {
        provider_writer();
        member_writer();
    }

    public static void provider_reader()
    {
        File file = new File("src\\terminal\\provider_list.txt");
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            int count = 0;
            String[] a_provider = new String[7];
            while ((tempString = reader.readLine()) != null)
            {
                a_provider[count] = tempString;
                count++;
                if (count == 7)
                {
                    provider_data pd = new provider_data();
                    pd.setNum(a_provider[0]);
                    pd.setProvider_name(a_provider[1]);
                    pd.setID(Integer.parseInt(a_provider[2]));
                    pd.setStreet_name(a_provider[3]);
                    pd.setCity(a_provider[4]);
                    pd.setState(a_provider[5]);
                    pd.setZip(Integer.parseInt(a_provider[6]));
                    provider_list.add(pd);

                    count = 0;
                }
            }
            reader.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                } catch (IOException e1)
                {
                }
            }
        }
    }

    public static void print_providers()
    {
        int i = 1;
        for (provider_data pd : provider_list)
        {
            System.out.println(i++);
            System.out.println("provider name: " + pd.getProvider_name());
            System.out.println("provider ID: " + pd.getID());
            System.out.println("provider street name: " + pd.getStreet_name());
            System.out.println("provider city: " + pd.getCity());
            System.out.println("provider state: " + pd.getState());
            System.out.println("provider zip code: " + pd.getZip());
            System.out.println();
        }
    }

    public static void provider_writer() throws IOException
    {
        FileWriter fw = new FileWriter("src\\terminal\\provider_list.txt");

        BufferedWriter writer = new BufferedWriter(fw);
        int index = 0;
        int order = 1;
        String num;
        for (provider_data pd : provider_list)
        {
            num = Integer.toString(order);
            num += ")";
            writer.write(num);
            writer.newLine();
            writer.write(pd.getProvider_name());
            writer.newLine();
            writer.write(Integer.toString(pd.getID()));
            writer.newLine();
            writer.write(pd.getStreet_name());
            writer.newLine();
            writer.write(pd.getCity());
            writer.newLine();
            writer.write(pd.getState());
            writer.newLine();
            writer.write(Integer.toString(pd.getZip()));
            if (index != provider_list.size() - 1)
            {
                writer.newLine();
            }
            writer.flush();
            index++;
            order++;
        }
        //writer.flush();
        writer.close();

    }

    public static void add_provider()
    {
        Scanner sc = new Scanner(System.in);
        provider_data pd = new provider_data();
        String string_input;
        int integer_input;
        System.out.println("Enter provider's name: ");
        string_input = sc.next();
        pd.setProvider_name(string_input);
        System.out.println("Enter provider's ID: ");
        integer_input = sc.nextInt();
        pd.setID(integer_input);
        System.out.println("Enter street's name: ");
        string_input = sc.next();
        pd.setStreet_name(string_input);
        System.out.println("Enter city: ");
        string_input = sc.next();
        pd.setCity(string_input);
        System.out.println("Enter state: ");
        string_input = sc.next();
        pd.setState(string_input);
        System.out.println("Enter zip code: ");
        integer_input = sc.nextInt();
        pd.setZip(integer_input);

        provider_list.add(pd);
    }

    public static void remove_provider()
    {
        Scanner sc = new Scanner(System.in);
        int ID;
        int index = 0;
        System.out.println("Enter the provider ID to remove: ");
        ID = sc.nextInt();
        for (provider_data pd : provider_list)
        {
            if (ID == pd.getID())
            {
                provider_list.remove(index);
                System.out.println("Removed");
                return;
            }
            index++;
        }
        System.out.println("ID not found");
        return;

    }

    public static void update_provider()
    {
        Scanner sc = new Scanner(System.in);
        int ID;
        String choice;
        System.out.println("Enter the provider ID to update: ");
        ID = sc.nextInt();
        for (provider_data pd : provider_list)
        {
            if (ID == pd.getID())
            {
                System.out.println("provider name: " + pd.getProvider_name());
                System.out.println("provider ID: " + pd.getID());
                System.out.println("provider street name: " + pd.getStreet_name());
                System.out.println("provider city: " + pd.getCity());
                System.out.println("provider state: " + pd.getState());
                System.out.println("provider zip code: " + pd.getZip());
                System.out.println("Do you want to update the information of this provider?\n1: YES\n2: NO");
                choice = sc.next();
                if (choice.equals("1") || choice.equals("YES") || choice.equals("yes") || choice.equals("Yes") || choice.equals("y") || choice.equals("Y"))
                {
                    String string_input;
                    int integer_input;
                    System.out.println("Enter provider's name: ");
                    string_input = sc.next();
                    pd.setProvider_name(string_input);
                    System.out.println("Enter provider's ID: ");
                    integer_input = sc.nextInt();
                    pd.setID(integer_input);
                    System.out.println("Enter street's name: ");
                    string_input = sc.next();
                    pd.setStreet_name(string_input);
                    System.out.println("Enter city: ");
                    string_input = sc.next();
                    pd.setCity(string_input);
                    System.out.println("Enter state: ");
                    string_input = sc.next();
                    pd.setState(string_input);
                    System.out.println("Enter zip code: ");
                    integer_input = sc.nextInt();
                    pd.setZip(integer_input);
                    System.out.println("Updated");
                    return;
                }
                if (!choice.equals("2") || !choice.equals("NO") || !choice.equals("No") || !choice.equals("no") || !choice.equals("n") || !choice.equals("N"))
                {
                    System.out.println("Error");
                }
                return;
            }
        }
        System.out.println("ID not found");
    }


    public static void member_reader()
    {
        File file = new File("src\\terminal\\member_list.txt");
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            int count = 0;
            String[] a_member = new String[7];
            while ((tempString = reader.readLine()) != null)
            {
                a_member[count] = tempString;
                count++;
                if (count == 7)
                {
                    member_data md = new member_data();
                    md.setNum(a_member[0]);
                    md.setMember_name(a_member[1]);
                    md.setID(Integer.parseInt(a_member[2]));
                    md.setStreet_name(a_member[3]);
                    md.setCity(a_member[4]);
                    md.setState(a_member[5]);
                    md.setZip(Integer.parseInt(a_member[6]));
                    member_list.add(md);
                    count = 0;
                }
            }
            reader.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                } catch (IOException e1)
                {
                }
            }
        }
    }

    public static void print_members()
    {
        int i = 1;
        for (member_data md : member_list)
        {
            System.out.println(i++);
            System.out.println("member name: " + md.getMember_name());
            System.out.println("member ID: " + md.getID());
            System.out.println("member street name: " + md.getStreet_name());
            System.out.println("member city: " + md.getCity());
            System.out.println("member state: " + md.getState());
            System.out.println("member zip code: " + md.getZip());
            System.out.println();
        }
    }

    public static void member_writer() throws IOException
    {
        FileWriter fw = new FileWriter("src\\terminal\\member_list.txt");

        BufferedWriter writer = new BufferedWriter(fw);
        int order = 1;
        int index = 0;
        String num;
        for (member_data md : member_list)
        {
            num = Integer.toString(order);
            num += ")";
            writer.write(num);
            writer.newLine();
            writer.write(md.getMember_name());
            writer.newLine();
            writer.write(Integer.toString(md.getID()));
            writer.newLine();
            writer.write(md.getStreet_name());
            writer.newLine();
            writer.write(md.getCity());
            writer.newLine();
            writer.write(md.getState());
            writer.newLine();
            writer.write(Integer.toString(md.getZip()));
            if (index != member_list.size() - 1)
            {
                writer.newLine();
            }
            writer.flush();
            index++;
            order++;
        }
        writer.close();

    }

    public static void add_member()
    {
        Scanner sc = new Scanner(System.in);
        member_data md = new member_data();
        String string_input;
        int integer_input;
        System.out.println("Enter member's name: ");
        string_input = sc.next();
        md.setMember_name(string_input);
        System.out.println("Enter member's ID: ");
        integer_input = sc.nextInt();
        md.setID(integer_input);
        System.out.println("Enter member's name: ");
        string_input = sc.next();
        md.setStreet_name(string_input);
        System.out.println("Enter city: ");
        string_input = sc.next();
        md.setCity(string_input);
        System.out.println("Enter state: ");
        string_input = sc.next();
        md.setState(string_input);
        System.out.println("Enter zip code: ");
        integer_input = sc.nextInt();
        md.setZip(integer_input);

        member_list.add(md);
    }


    public static void remove_member()
    {
        Scanner sc = new Scanner(System.in);
        int ID;
        int index = 0;
        System.out.println("Enter the member ID to remove: ");
        ID = sc.nextInt();
        for (member_data md : member_list)
        {
            if (ID == md.getID())
            {
                member_list.remove(index);
                System.out.println("Removed");
                return;
            }
            index++;
        }
        System.out.println("ID not found");
        return;

    }

    public static void update_member()
    {
        Scanner sc = new Scanner(System.in);
        int ID;
        String choice;
        System.out.println("Enter the member ID to update: ");
        ID = sc.nextInt();
        for (member_data md : member_list)
        {
            if (ID == md.getID())
            {
                System.out.println("provider name: " + md.getMember_name());
                System.out.println("provider ID: " + md.getID());
                System.out.println("provider street name: " + md.getStreet_name());
                System.out.println("provider city: " + md.getCity());
                System.out.println("provider state: " + md.getState());
                System.out.println("provider zip code: " + md.getZip());
                System.out.println("Do you want to update the information of this member?\n1: YES\n2: NO");
                choice = sc.next();
                if (choice.equals("1") || choice.equals("YES") || choice.equals("yes") || choice.equals("Yes") || choice.equals("y") || choice.equals("Y"))
                {
                    String string_input;
                    int integer_input;
                    System.out.println("Enter member's name: ");
                    string_input = sc.next();
                    md.setMember_name(string_input);
                    System.out.println("Enter member's ID: ");
                    integer_input = sc.nextInt();
                    md.setID(integer_input);
                    System.out.println("Enter member's name: ");
                    string_input = sc.next();
                    md.setStreet_name(string_input);
                    System.out.println("Enter city: ");
                    string_input = sc.next();
                    md.setCity(string_input);
                    System.out.println("Enter state: ");
                    string_input = sc.next();
                    md.setState(string_input);
                    System.out.println("Enter zip code: ");
                    integer_input = sc.nextInt();
                    md.setZip(integer_input);
                    System.out.println("Updated");

                    return;
                }
                if (choice.equals("2") || choice.equals("NO") || choice.equals("No") || choice.equals("no") || choice.equals("n") || choice.equals("N"))
                {
                    return;
                } else
                {
                    System.out.println("Error");
                    return;
                }
            }
        }
        System.out.println("ID not found");

    }
}
