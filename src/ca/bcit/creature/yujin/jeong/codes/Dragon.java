package ca.bcit.creature.yujin.jeong.codes;

/**
 * This class models Dragon from a parent class Creature.
 * <p>
 * validateFirePower() to set range of firepower between minFirePower and maxFirePower.
 * <p>
 * getDetails() to prints the creature's name, dateOfBirth, age, health, and firepower.
 * <p>
 * breatheFire() to use skill "breatherFire". Skill is unavailable to use when low firePower.
 * <p>
 * restoreFirePower() to restore Fire power for using breatherFire skill.
 *
 * @author Yujin Jeong
 * @author Tommy Phuong
 * @author Evan Vink
 * @version 1.0
 */
public class Dragon extends Creature
{

    // Cannot make as final, because firePower value changes the value under the conditions
    private int firePower;

    // Setting max and min firepower
    private final int maxFirePower = 100;
    private final int minFirePower = 0;

    // Setting max and min firepower usage
    final int minFirePowerUsage = 10;
    final int firePowerDamage   = 20;

    /**
     * Creating a constructor. Validating name, date of birth, health, and firepower in constructor.
     *
     * @param name        creature's name
     * @param dateOfBirth creature's date of birth
     * @param health      creatures' health
     * @param firePower   dragon's firePower
     */
    public Dragon(final String name,
                  final Date dateOfBirth,
                  final int health,
                  final int firePower)
    {
        super(name, dateOfBirth, health);

        // Validate parameters
        validateFirePower(firePower);
        this.firePower = firePower;
    }

    /**
     * Creating a method to set range of firepower between minFirePower and maxFirePower.
     *
     * @param firePower from dragon
     */
    protected void validateFirePower(final int firePower)
    {
        if(firePower < minFirePower || firePower > maxFirePower)
        {
            throw new IllegalArgumentException(String.format("Fire power can't go below %d and above %d", minFirePower, maxFirePower));
        }
    }

    /**
     * Creating a method to prints the creature's name, dateOfBirth, age, health, and firepower.
     *
     * @return creature's information in String
     */
    @Override
    public String getDetails()
    {
        final StringBuilder builder;

        builder = new StringBuilder();

        builder.append(super.getDetails());
        builder.append("\nFirepower: ");
        builder.append(firePower);
        builder.append("\n");

        return builder.toString();
    }

    /**
     * Creating a method to use skill "breatherFire". Skill is unavailable to use when low firePower.
     *
     * @param anotherCreature attack another creature
     *
     * @throws LowFirePowerException to make sure firePower is enough to use breatheFire
     */
    public void breatheFire(Creature anotherCreature) throws LowFirePowerException
    {
        if(firePower >= minFirePowerUsage)
        {
            firePower -= minFirePowerUsage;
            anotherCreature.takeDamage(firePowerDamage);
        }
        else
        {
            throw new LowFirePowerException("Fire power is not enough to use breathe fire:(");
        }
    }

    /**
     * Creating a method to restore Fire power for using breatherFire skill.
     *
     * @param amount restore amount
     */
    protected void restoreFirePower(int amount)
    {
        if((firePower + amount) > maxFirePower)
        {
            firePower = maxFirePower;
        }
        else
        {
            firePower += amount;
        }
    }
}
