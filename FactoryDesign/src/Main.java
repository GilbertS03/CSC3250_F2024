import java.util.*;
abstract class Pizza{
    private String _name;
    private String _dough;
    private String _sauce;
    public Pizza(String n, String d, String s){_name = n;  _dough = d; _sauce = s;   }
    public abstract void prepare();
    public abstract void bake();
    public String toString(){return _name + " " + _dough + " " + _sauce;}
}
class ChicagoThinCheese extends Pizza{
    public ChicagoThinCheese(){super("chicagocheese", "thin", "plumtomato");}
    public void prepare(){System.out.println("Prepare: little sauce");}
    public void bake(){System.out.println("Bake: 30 minutes to bake");}
    public String toString(){return super.toString();}
}
class ChicagoThickCheese extends Pizza{
    public ChicagoThickCheese(){super("chicagothickcheese", "thick", "plumtomato");}
    public void prepare(){System.out.println("Prepare: lots of sauce");}
    public void bake(){System.out.println("Bake: one hour to bake");}
    public String toString(){return super.toString();}
}
class ChicagoThinPepperoni extends Pizza{
    private String _topping;
    public ChicagoThinPepperoni(){
        super("chicagothinpepperoni", "thin", "plumtomato");
        _topping = "pepperoni";
    }
    public void prepare(){System.out.println("Prepare: little sauce");}
    public void bake(){System.out.println("Bake: 30 minutes to bake");}
    public String toString(){return super.toString() + " " + _topping;}
}
class NYThinCheese extends Pizza{
    private String _topping;
    public NYThinCheese(){super("nythincheese", "thin", "marinara");}
    public void prepare(){System.out.println("Prepare: little sauce");}
    public void bake(){System.out.println("Bake: 25 minutes to bake");}
    public String toString(){return super.toString() + " " + _topping;}
}
class NYThinPepperoni extends Pizza{
    private String _topping;
    public NYThinPepperoni(){
        super("nythinpepperoni", "thin", "marinara");
        _topping = "pepperoni";
    }
    public void prepare(){System.out.println("Prepare: little sauce");}
    public void bake(){System.out.println("Bake: 25 minutes to bake");}
    public String toString(){return super.toString() + " " + _topping;}
}

abstract class PizzaStore{
    public Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        return pizza;
    }
    public abstract Pizza createPizza(String type);
}
class ChicagoStore extends PizzaStore{
    public Pizza createPizza(String type){
        if (type == "thinpepperoni")
            return new ChicagoThinPepperoni();
        else if (type == "thincheese")
            return new ChicagoThinCheese();
        else //if (type == "thickcheese")
            return new ChicagoThickCheese();
    }
}
class NYStore extends PizzaStore{
    public Pizza createPizza(String type){
        if (type == "thinpepperoni")
            return new NYThinPepperoni();
        else //if (type == "thincheese")
            return new NYThinCheese();
    }
}

public class Main {
    public static int showMenu(Scanner scan) {
        System.out.println("What type of pizza do you want to order?");
        System.out.println("1. Chicago Style Thin Cheese");
        System.out.println("2. Chicago Style Thick Cheese");
        System.out.println("3. Chicago Style Thin Pepperoni");
        System.out.println("4. NY Style Thin Cheese");
        System.out.println("5. NY Style Thin Pepperoni");
        System.out.println("6. Exit");
        int choice = scan.nextInt();
        return choice;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PizzaStore nyStore = new NYStore();
        PizzaStore chicagoStore = new ChicagoStore();
        Pizza pizza;
        int choice = showMenu(scan);
        while (choice != 6) {
            if (choice == 1)
                pizza = chicagoStore.orderPizza("thincheese");
            else if (choice == 2)
                pizza = chicagoStore.orderPizza("thickcheese");
            else if (choice == 2)
                pizza = chicagoStore.orderPizza("thinpepperoni");
            else if (choice == 2)
                pizza = nyStore.orderPizza("thincheese");
            else
                pizza = nyStore.orderPizza("thinpepperoni");
            System.out.println("You ordered: " + pizza.toString());
            pizza.prepare();
            pizza.bake();
            choice = showMenu(scan);
        }
    }
}