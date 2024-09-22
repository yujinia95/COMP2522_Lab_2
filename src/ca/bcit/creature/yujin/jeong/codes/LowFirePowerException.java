package ca.bcit.creature.yujin.jeong.codes;

/**
 * Throws checked exception when fire power is of dragon is too low
 *
 * @author Yujin Jeong
 * @author Tommy Phuong
 * @author Evan Vink
 * @version 1
 */

public class LowFirePowerException extends Exception
{

    public LowFirePowerException(String message)
    {

        super(message);
    }
}
