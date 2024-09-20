package ca.bcit.creature.yujin.jeong;

/**
 * This class models Orc from a parent class Creature.
 * <p>
 * validateRage() to set range of rage between 0 and 30.
 * <p>
 * validateParameter() to validate data in parameter. Name can't be null or empty, date of birth must be over
 * currentDate, also health must be over 0 as well.
 * <p>
 * getDetails() to prints the creature's name, dateOfBirth, age, health, and rage.
 * <p>
 * berserk() to use skill "berserk". Skill is unavailable to use when low rage.
 *
 * @author Yujin Jeong
 * @version 1.0
 */
public class Orc extends Creature
{

    // Cannot make as final, because rage value changes the value under the conditions
    private int rage;

    private final int maxRage = 30;

    /**
     * Creating a constructor. Validating name, date of birth, health, and rage in constructor.
     *
     * @param name        creature's name
     * @param dateOfBirth creature's date of birth
     * @param health      creatures' health
     * @param rage        Orc's rage
     */
    public Orc(final String name, final Date dateOfBirth, final int health, final int rage)
    {
        super(name, dateOfBirth, health);

        validateParameter(name, dateOfBirth, health);
        validateRage(rage);

        this.rage = rage;
    }

    /**
     * Creating a method to validate data in parameter.
     * Name can't be null or empty, date of birth must be over currentDate, also health must be over 0 as well.
     *
     * @param name        creature's name
     * @param dateOfBirth creature's date of birth
     * @param health      creatures' health
     */
    protected void validateParameter(final String name, final Date dateOfBirth, final int health)
    {
        final Date currentDate = new Date(2024, 9, 15);

        // Validating name
        validateName(name);
        // Validating date of birth
        validateBirthDate(dateOfBirth, currentDate);
        // Validating health
        validHealth(health);
    }

    /**
     * Creating a method to set range of rage between 0 and 30.
     *
     * @param rage from orc
     */
    protected void validateRage(final int rage)
    {
        final int minRage;

        minRage = 0;

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
        builder.append(" , Rage: ");
        builder.append(rage);

        return builder.toString();
    }

    /**
     * Creating a method to use skill "berserk". Skill is unavailable to use when low rage.
     *
     * @param anotherCreature attack another creature
     */
    public void berserk(Creature anotherCreature)
    {
        final int minRageUsage;
        final int minDoubleDamageMode;
        final int normalDamage;
        final int doubleDamage;

        minRageUsage        = 5;
        minDoubleDamageMode = 20;
        normalDamage        = 15;
        doubleDamage        = 30;

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
