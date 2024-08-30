package structures.commands;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeConfigCommand implements  Command{
    private Class<?> dataType;
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter type of data for tree:");

        switch(scanner.next().toLowerCase()){
            case "int":
            case "integer":
                System.out.println("Datatype is integer");
                dataType = Integer.class;
                break;
            case "long":
                System.out.println("Datatype is long");
                dataType = Long.class;
                break;
            case "float":

                System.out.println("Datatype is float");
                dataType = Float.class;
                break;
            case "double":

                System.out.println("Datatype is double");
                dataType = Double.class;
                break;
        }
    }

}
