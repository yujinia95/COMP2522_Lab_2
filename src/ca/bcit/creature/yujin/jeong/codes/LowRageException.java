package ca.bcit.creature.yujin.jeong.codes;

/**
 * Throws unchecked exception when rage is too low
 *
 * @author Yujin Jeong
 * @author Tommy Phuong
 * @author Evan Vink
 * @version 1
 */
public class LowRageException extends RuntimeException
{
    public LowRageException(String message)
    {
        super(message);
    }
}
