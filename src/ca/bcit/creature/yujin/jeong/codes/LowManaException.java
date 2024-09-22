package ca.bcit.creature.yujin.jeong.codes;

/**
 * Throws checked exception when mana is too low to attack
 *
 * @author Yujin Jeong
 * @author Tommy Phuong
 * @author Evan Vink
 * @version 1
 */

public class LowManaException extends Exception
{

    public LowManaException(String message)
    {

        super(message);
    }
}
