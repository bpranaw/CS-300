package terminal;

import java.io.*;
import java.util.ArrayList;

public class database{


    public static void provider_reader(ArrayList<provider_data> provider_list)
    {
        File file = new File("src\\terminal\\provider_list.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            int line = 1;
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
            System.out.println(pd.provider_name);
            System.out.println(pd.ID);
            System.out.println(pd.street_name);
            System.out.println(pd.city);
            System.out.println(pd.state);
            System.out.println(pd.zip);
        }
    }

    public static void provider_writer(ArrayList<provider_data> provider_list) throws IOException
    {
        FileWriter fw = new FileWriter("src\\terminal\\provider_list.txt");

        BufferedWriter writer = new BufferedWriter(fw);
        int index = 0;
        for(provider_data pd:provider_list)
        {
            writer.write(pd.num);
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
        }
        //writer.flush();
        writer.close();

    }
 

    public static void main(String[] args) throws IOException
    {

        ArrayList<provider_data> provider_list = new ArrayList<>();

        provider_reader(provider_list);
        //provider_list.remove(0);
        print_providers(provider_list);
        provider_writer(provider_list);
        
    }
}
