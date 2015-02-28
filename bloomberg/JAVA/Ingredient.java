import com.bloomberglp.blpapi.*;

public enum Ingredient
{
    PIZZA_DOUGH ("Pizza Dough", "brown",  0),
    TOMATO      ("Tomato"     , "red",    0),
    CHEESE      ("Cheese"     , "yellow", 0),
    HAM         ("Ham"        , "pink",   0),
    PINEAPPLE   ("Pineapple"  , "yellow", 0),
    PEPPERONI   ("Pepperoni"  , "red",    0),
    BURGER_BUN  ("Burger Bun" , "brown",  0);

    private final String name;
    private final String color;
    private final int    price;
    
    Ingredient(String name, String color, int price)
    {
        Session session = new Session();

        this.name  = name;
        this.color = color;
        this.price = price;
    }

    String getName()
    {
        return name;
    }

    String getColor()
    {
        return color;
    }

    String getPrice()
    {
        return String.format("%10.2f", (float) price);
    }

    static Ingredient random()
    {
        double randomNumber = Math.random() * 70;
        if (randomNumber < 10)
        {
            return Ingredient.PIZZA_DOUGH;
        }
        else if (randomNumber < 20)
        {
            return Ingredient.TOMATO;
        }
        else if (randomNumber < 30)
        {
            return Ingredient.CHEESE;
        }
        else if (randomNumber < 40)
        {
            return Ingredient.HAM;
        }
        else if (randomNumber < 50)
        {
            return Ingredient.PINEAPPLE;
        }
        else if (randomNumber < 60)
        {
            return Ingredient.PEPPERONI;
        }
        else
        {
            return Ingredient.BURGER_BUN;
        }
    }
}