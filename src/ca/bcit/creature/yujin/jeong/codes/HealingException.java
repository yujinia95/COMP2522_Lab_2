package ca.bcit.creature.yujin.jeong.codes;

/**
 * Throws checked exception when healing is negative
 *
 * @author Yujin Jeong
 * @author Tommy Phuong
 * @author Evan Vink
 * @version 1
 */
public class HealingException extends Exception
{

    public HealingException(String message)
    {
        super(message);
    }
}
