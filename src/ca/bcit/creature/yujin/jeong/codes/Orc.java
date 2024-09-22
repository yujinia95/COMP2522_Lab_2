package ca.bcit.creature.yujin.jeong.codes;

/**
 * This class models Orc from a parent class Creature.
 * <p>
 * validateRage() to set range of rage between minRage and maxRage.
 * <p>
 * getDetails() to prints the creature's name, dateOfBirth, age, health, and rage.
 * <p>
 * berserk() to use skill "berserk". Skill is unavailable to use when low rage.
 *
 * @author Yujin Jeong
 * @author Tommy Phuong
 * @author Evan Vink
 * @version 1.0
 */
public class Orc extends Creature
{

    // Cannot make as final, because rage value changes the value under the conditions
    private int rage;

    private final int maxRage = 30;
    final         int minRage = 0;

    private final int minRageUsage        = 5;
    private final int minDoubleDamageMode = 20;
    private final int normalDamage        = 15;
    private final int doubleDamage        = 30;

    /**
     * Creating a constructor. Validating name, date of birth, health, and rage in constructor.
     *
     * @param name        creature's name
     * @param dateOfBirth creature's date of birth
     * @param health      creatures' health
     * @param rage        Orc's rage
     */
    public Orc(final String name,
               final Date dateOfBirth,
               final int health,
               final int rage)
    {
        super(name, dateOfBirth, health);

        validateRage(rage);

        this.rage = rage;
    }

    /**
     * Creating a method to set range of rage between minRage and maxRage.
     *
     * @param rage from orc
     */
    protected void validateRage(final int rage)
    {
        if(rage < minRage || rage > maxRage)
        {
            throw new IllegalArgumentException(String.format("Rage can't go below %d and above %d", minRage, maxRage));
        }
    }

    /**
     * Creating a method to prints the creature's name, dateOfBirth, age, health, and rage.
     *
     * @return creature's information in String
     */
    @Override
    public String getDetails()
    {
        final StringBuilder builder;

        builder = new StringBuilder();

        builder.append(super.getDetails());
        builder.append("\nRage: ");
        builder.append(rage);
        builder.append("\n");

        return builder.toString();
    }

    /**
     * Creating a method to use skill "berserk". Skill is unavailable to use when low rage.
     *
     * @param anotherCreature attack another creature
     */
    public void berserk(Creature anotherCreature)
    {
        rage += minRageUsage;

        if(rage >= minRageUsage && rage < minDoubleDamageMode)
        {
            anotherCreature.takeDamage(normalDamage);
        }
        else if(rage > minDoubleDamageMode)
        {
            anotherCreature.takeDamage(doubleDamage);
        }
        else
        {
            throw new LowRageException("Rage is not enough to be berserk mode");
        }
    }
}
