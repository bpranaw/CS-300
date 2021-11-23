package terminal;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class database{

    public static void provider_reader(ArrayList<provider_data> provider_list)
    {
        File file = new File("src\\terminal\\provider_list.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            int count = 0;
            String[]a_provider = new String[7];
            while ((tempString = reader.readLine()) != null)
            {
                a_provider[count] = tempString;
                count++;
                if(count == 7)
                {
                    provider_data pd = new provider_data();
                    pd.num = a_provider[0];
                    pd.provider_name = a_provider[1];
                    pd.ID = Integer.parseInt(a_provider[2]);
                    pd.street_name = a_provider[3];
                    pd.city = a_provider[4];
                    pd.state = a_provider[5];
                    pd.zip = Integer.parseInt(a_provider[6]);
                    provider_list.add(pd);

                    count = 0;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    public static void print_providers(ArrayList<provider_data> provider_list)
    {
        for(provider_data pd:provider_list)
        {
            System.out.println("provider name: " + pd.provider_name);
            System.out.println("provider ID: " + pd.ID);
            System.out.println("provider street name: " + pd.street_name);
            System.out.println("provider city: " + pd.city);
            System.out.println("provider state: " + pd.state);
            System.out.println("provider zip code: " + pd.zip);
        }
    }

    public static void provider_writer(ArrayList<provider_data> provider_list) throws IOException
    {
        FileWriter fw = new FileWriter("src\\terminal\\provider_list.txt");

        BufferedWriter writer = new BufferedWriter(fw);
        int index = 0;
        int order = 1;
        String num;
        for(provider_data pd:provider_list)
        {
            num = Integer.toString(order);
            num += ")";
            writer.write(num);
            writer.newLine();
            writer.write(pd.provider_name);
            writer.newLine();
            writer.write(Integer.toString(pd.ID));
            writer.newLine();
            writer.write(pd.street_name);
            writer.newLine();
            writer.write(pd.city);
            writer.newLine();
            writer.write(pd.state);
            writer.newLine();
            writer.write(Integer.toString(pd.zip));
            if(index != provider_list.size()-1)
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

    public static void add_provider(ArrayList<provider_data> provider_list)
    {
        Scanner sc = new Scanner(System.in);
        provider_data pd = new provider_data();
        String string_input;
        int integer_input;
        System.out.println("Enter provider's name: ");
        string_input = sc.next();
        pd.provider_name = string_input;
        System.out.println("Enter provider's ID: ");
        integer_input = sc.nextInt();
        pd.ID = integer_input;
        System.out.println("Enter street's name: ");
        string_input = sc.next();
        pd.street_name = string_input;
        System.out.println("Enter city: ");
        string_input = sc.next();
        pd.city = string_input;
        System.out.println("Enter state: ");
        string_input = sc.next();
        pd.state = string_input;
        System.out.println("Enter zip code: ");
        integer_input = sc.nextInt();
        pd.zip = integer_input;

        provider_list.add(pd);
    }

    public static void remove_provider(ArrayList<provider_data> provider_list)
    {
        Scanner sc = new Scanner(System.in);
        int ID;
        int index = 0;
        System.out.println("Enter the provider ID to remove: ");
        ID = sc.nextInt();
        for(provider_data pd:provider_list)
        {
            if(ID == pd.ID)
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

    public static void update_provider(ArrayList<provider_data> provider_list)
    {
        Scanner sc = new Scanner(System.in);
        int ID;
        String choice;
        System.out.println("Enter the provider ID to update: ");
        ID = sc.nextInt();
        for(provider_data pd:provider_list)
        {
            if(ID == pd.ID)
            {
                System.out.println("provider name: " + pd.provider_name);
                System.out.println("provider ID: " + pd.ID);
                System.out.println("provider street name: " + pd.street_name);
                System.out.println("provider city: " + pd.city);
                System.out.println("provider state: " + pd.state);
                System.out.println("provider zip code: " + pd.zip);
                System.out.println("Do you want to update the information of this provider?\n1: YES\n2: NO");
                choice = sc.next();
                if(choice.equals("1") || choice.equals("YES")|| choice.equals("yes") || choice.equals("Yes") || choice.equals("y") || choice.equals("Y"))
                {
                    String string_input;
                    int integer_input;
                    System.out.println("Enter provider's name: ");
                    string_input = sc.next();
                    pd.provider_name = string_input;
                    System.out.println("Enter provider's ID: ");
                    integer_input = sc.nextInt();
                    pd.ID = integer_input;
                    System.out.println("Enter street's name: ");
                    string_input = sc.next();
                    pd.street_name = string_input;
                    System.out.println("Enter city: ");
                    string_input = sc.next();
                    pd.city = string_input;
                    System.out.println("Enter state: ");
                    string_input = sc.next();
                    pd.state = string_input;
                    System.out.println("Enter zip code: ");
                    integer_input = sc.nextInt();
                    pd.zip = integer_input;
                    System.out.println("Updated");
                    return;
                }
                if(choice.equals("2") || choice.equals("NO")|| choice.equals("No") || choice.equals("no") || choice.equals("n") || choice.equals("N"))
                {
                    return;
                }
                else
                {
                    System.out.println("Error");
                    return;
                }
            }
        }
        System.out.println("ID not found");
    }



    public static void member_reader(ArrayList<member_data> member_list)
    {
        File file = new File("src\\terminal\\member_list.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            int count = 0;
            String[]a_member = new String[7];
            while ((tempString = reader.readLine()) != null)
            {
                a_member[count] = tempString;
                count++;
                if(count == 7)
                {
                    member_data md = new member_data();
                    md.num = a_member[0];
                    md.member_name = a_member[1];
                    md.ID = Integer.parseInt(a_member[2]);
                    md.street_name = a_member[3];
                    md.city = a_member[4];
                    md.state = a_member[5];
                    md.zip = Integer.parseInt(a_member[6]);
                    member_list.add(md);

                    count = 0;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    public static void print_members(ArrayList<member_data> member_list)
    {
        for(member_data md:member_list)
        {
            System.out.println("member name: " + md.member_name);
            System.out.println("member ID: " + md.ID);
            System.out.println("member street name: " + md.street_name);
            System.out.println("member city: " + md.city);
            System.out.println("member state: " + md.state);
            System.out.println("member zip code: " + md.zip);
        }
    }

    public static void member_writer(ArrayList<member_data> member_list) throws IOException
    {
        FileWriter fw = new FileWriter("src\\terminal\\member_list.txt");

        BufferedWriter writer = new BufferedWriter(fw);
        int order = 1;
        int index = 0;
        String num;
        for(member_data md:member_list)
        {
            num = Integer.toString(order);
            num += ")";
            writer.write(num);
            writer.newLine();
            writer.write(md.member_name);
            writer.newLine();
            writer.write(Integer.toString(md.ID));
            writer.newLine();
            writer.write(md.street_name);
            writer.newLine();
            writer.write(md.city);
            writer.newLine();
            writer.write(md.state);
            writer.newLine();
            writer.write(Integer.toString(md.zip));
            if(index != member_list.size()-1)
            {
                writer.newLine();
            }
            writer.flush();
            index++;
            order++;
        }
        writer.close();

    }

    public static void add_member(ArrayList<member_data> member_list)
    {
        Scanner sc = new Scanner(System.in);
        member_data md = new member_data();
        String string_input;
        int integer_input;
        System.out.println("Enter member's name: ");
        string_input = sc.next();
        md.member_name = string_input;
        System.out.println("Enter member's ID: ");
        integer_input = sc.nextInt();
        md.ID = integer_input;
        System.out.println("Enter member's name: ");
        string_input = sc.next();
        md.street_name = string_input;
        System.out.println("Enter city: ");
        string_input = sc.next();
        md.city = string_input;
        System.out.println("Enter state: ");
        string_input = sc.next();
        md.state = string_input;
        System.out.println("Enter zip code: ");
        integer_input = sc.nextInt();
        md.zip = integer_input;

        member_list.add(md);
    }


    public static void remove_member(ArrayList<member_data> member_list)
    {
        Scanner sc = new Scanner(System.in);
        int ID;
        int index = 0;
        System.out.println("Enter the member ID to remove: ");
        ID = sc.nextInt();
        for(member_data md:member_list)
        {
            if(ID == md.ID)
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

    public static void update_member(ArrayList<member_data> member_list)
    {
        Scanner sc = new Scanner(System.in);
        int ID;
        String choice;
        System.out.println("Enter the member ID to update: ");
        ID = sc.nextInt();
        for(member_data md:member_list)
        {
            if(ID == md.ID)
            {
                System.out.println("provider name: " + md.member_name);
                System.out.println("provider ID: " + md.ID);
                System.out.println("provider street name: " + md.street_name);
                System.out.println("provider city: " + md.city);
                System.out.println("provider state: " + md.state);
                System.out.println("provider zip code: " + md.zip);
                System.out.println("Do you want to update the information of this member?\n1: YES\n2: NO");
                choice = sc.next();
                if(choice.equals("1") || choice.equals("YES")|| choice.equals("yes") || choice.equals("Yes") || choice.equals("y") || choice.equals("Y"))
                {
                    String string_input;
                    int integer_input;
                    System.out.println("Enter member's name: ");
                    string_input = sc.next();
                    md.member_name = string_input;
                    System.out.println("Enter member's ID: ");
                    integer_input = sc.nextInt();
                    md.ID = integer_input;
                    System.out.println("Enter street's name: ");
                    string_input = sc.next();
                    md.street_name = string_input;
                    System.out.println("Enter city: ");
                    string_input = sc.next();
                    md.city = string_input;
                    System.out.println("Enter state: ");
                    string_input = sc.next();
                    md.state = string_input;
                    System.out.println("Enter zip code: ");
                    integer_input = sc.nextInt();
                    md.zip = integer_input;
                    System.out.println("Updated");
                    return;
                }
                if(choice.equals("2") || choice.equals("NO")|| choice.equals("No") || choice.equals("no") || choice.equals("n") || choice.equals("N"))
                {
                    return;
                }
                else
                {
                    System.out.println("Error");
                    return;
                }
            }
        }
        System.out.println("ID not found");

    }
    //for testing
    /*
    public static void main(String[] args) throws IOException
    {
        ArrayList<provider_data> provider_list = new ArrayList<>();
        ArrayList<member_data> member_list = new ArrayList<>();
        provider_reader(provider_list);
        member_reader(member_list);

        Scanner sc = new Scanner(System.in);

        int choice = 1;
        while(choice != 0)
        {
            System.out.println("1: print provider \n2: print member \n3: add provider\n4: add member\n5: remove provider\n6: remove " +
                    "member\n7: update provider\n8: update member");
            choice = sc.nextInt();
            if(choice == 1)
            {
                print_providers(provider_list);
            }
            if(choice == 2)
            {
                print_members(member_list);
            }
            if(choice == 3)
            {
                add_provider(provider_list);
            }
            if (choice == 4)
            {
                add_member(member_list);
            }
            if(choice == 5)
            {
                remove_provider(provider_list);
            }
            if(choice == 6)
            {
                remove_member(member_list);
            }
            if(choice == 7)
            {
                update_provider(provider_list);
            }
            if (choice == 8)
            {
                update_member(member_list);
            }
        }
        provider_writer(provider_list);
        member_writer(member_list);
    }
    */
}
