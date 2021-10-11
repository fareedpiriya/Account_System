package za.ac.nwu.ac.logic.flow.impl.impl;

public class Modulo {
    public Integer doMod(int divided, int divisor)  {
        if(divisor == 0)
        {
            throw new RuntimeException("Some Reason");
        }
        return divided % divisor;
    }


}