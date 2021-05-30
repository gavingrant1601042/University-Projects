package GoldFish;

import java.util.Random;

public class Deck 
{

    private int top;
    private Card[] _hand;
    private static final int MAX = 52;
    private static Random random = new Random();

    public Deck() 
    {
        _hand = new Card[MAX]; 
        top = 0; 
    }

    public void fillDeck() 
    {
        Card card;
        
        for(int i = 1; i <= 4; i++) 
        {
            for(int j = 1; j <= 13; j++) 
            {
                card = new Card(j,i); 
                push(card); 
            } 
        } 
    } 

    public void push(Card card) 
    {
        if(top > MAX ) 
            System.out.println("Stack Overflow"); 
        else 
        {
            _hand[top] = card; 
            top++; 
        } 
    } 

    public Card pop() 
    {
        if(top < 0) 
            System.out.println("Stack Underflow"); 
        else 
        {
            Card temp = _hand[top-1]; 
            top--; 
            
            return temp; 
        } 

        return null; 
    } 

    public Card removecard(int value) 
    {
        Card temp;
        Card deleted;
        
        for(int i = 0; i<top; i++) 
        {
            temp = _hand[i]; 
            if(temp.getValue() == value) 
            {
                deleted = temp; 
                _hand[i] = pop(); 
                
                return deleted; 
            } 
        } 
        return null; 
    } 

    public Card deleteAnyCard() 
    {
        try
        { 
            if(top == 0) 
            {
                return null; 
            }
            else
            {
                int randoIx = random.nextInt(top); 
                Card temp = _hand[randoIx]; 
                if(randoIx != top-1) 
                {
                    _hand[randoIx] = _hand[top-1]; 
                    top--;
                }
                else
                {
                    _hand[top-1] = null; 
                    top--;
                }
                return temp; 
            }
        }
        
        catch (Exception e)
        { 
            System.err.println(e.toString()); 
            return null;
        }
    }

    public int checkstock() 
    {
        for(int i = 0; i<4 ; i++) 
        {
            if(getCount(_hand[i].getValue()) == 2) 
            {
                return _hand[i].getValue(); 
            }
        }
        return 0; 
    }

    public int getCount(int value) 
    {
        int occurences = 0;
        for(int i = 0; i<top;i++) 
        {
            if(_hand[i].getValue() == value) 
            {
                occurences++; 
            }
        }
        return occurences; 
    }

    public int getSize() 
    {
        return top; 
    }


    public String toString()
    {
        if(top != 0) 
        {
            String result = "User Deck: \n"; 
            for(int i = 0; i<top; i++) 
            {
                result = result + _hand[i] + "\n"; 
            }
            return result; 
        }
        return "Empty Hand"; 
    }

}
