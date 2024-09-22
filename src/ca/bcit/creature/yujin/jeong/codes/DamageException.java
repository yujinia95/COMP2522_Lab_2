package ca.bcit.creature.yujin.jeong.codes;

/**
 * Throws unchecked exception when damage is negative
 *
 * @author Yujin Jeong
 * @author Tommy Phuong
 * @author Evan Vink
 * @version 1
 */
public class DamageException extends RuntimeException
{

    public DamageException(String message)
    {
        super(message);
    }
}
