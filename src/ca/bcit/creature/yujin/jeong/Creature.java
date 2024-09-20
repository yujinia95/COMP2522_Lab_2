package ca.bcit.creature.yujin.jeong;

/**
 * <p> This class models Creature.
 * validateName() to check if name is valid (No null, no empty String).
 * <p>
 * validateBirthDate() Validating if name is valid (No null, no empty String).
 * <p>
 * validateHealth() to check if the given date of birth is not after the current date. If return value is negative
 * than date of birth is before the current date. If it's 0 then both dates are the same, and positive value will
 * return date of birth is after the current date, which is not supposed to be.
 * <p>
 * isAlive() to return true if health is greater than 0.
 * <p>
 * takeDamage() to apply the amount of damage to health. Also, prevent health going below zero, and damage going
 * below zero as well.
 * <p>
 * heal() to increase health by healing and setting the range of healing from 0 to 100.
 * <p>
 * getAgeYears() to calculate age based on current date. If birth month is above current month or if the birth month.
 * and current month are the same but the day of birthday is after the current day, the age is decreased by one year.
 * <p>
 * getDetails() to prints the creature's name, dateOfBirth, age, and health. </p>
 *
 * @author Yujin Jeong
 * @version 1.0
 */
public class Creature
{

    private final String name;
    private final Date   dateOfBirth;
    private final Date   currentDate;

    // Cannot make as final, because health, and age changes the value under the conditions
    private int health;
    private int age;

    //Creating global variable to set minimum health is above 0.
    private final int minHealth = 0;

    /**
     * Creating a constructor. Validating name and date of birth in constructor.
     *
     * @param name        creature name
     * @param dateOfBirth date of birth
     * @param health      creature's health
     */
    protected Creature(final String name, final Date dateOfBirth, final int health)
    {
        // Initializing current date before validate the date of birth and age
        this.currentDate = new Date(2024, 9, 15);

        // Validating name,date of birth and current date
        validateName(name);
        validateBirthDate(dateOfBirth, currentDate);

        this.name        = name;
        this.dateOfBirth = dateOfBirth;
        this.age         = getAgeYears(dateOfBirth, currentDate);
        this.health      = health;
    }

    /**
     * Creating a method. Validating if name is valid (No null, no empty String).
     *
     * @param name Creature name
     */
    protected void validateName(final String name)
    {
        if(name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("Name cannot be null or empty :/");
        }
    }

    /**
     * Creating a method to check if the given date of birth is not after the current date.
     * If return value is negative than date of birth is before the current date. If it's 0 then both dates are
     * the same, and positive value will return date of birth is after the current date, which is not supposed to be.
     *
     * @param dateOfBirth date of birth
     * @param currentDate current date
     */
    protected void validateBirthDate(final Date dateOfBirth, final Date currentDate)
    {

        final int zeroChecksValidBirthDate;

        zeroChecksValidBirthDate = 0;

        if(dateOfBirth.compareTo(currentDate) > zeroChecksValidBirthDate)
        {
            throw new IllegalArgumentException("You cannot type your date of birth after the current date :/");
        }
    }

    /**
     * Creating a method to set health can't go below 0.
     *
     * @param health Dragon's health
     */
    protected void validHealth(final int health)
    {
        final int healthAboveZero;

        healthAboveZero = 0;

        if(health < healthAboveZero)
        {
            throw new IllegalArgumentException("Health cannot be negative :/");
        }
    }

    /**
     * Creating a method to return true if health is greater than 0.
     *
     * @param health creature's health
     */
    protected boolean isAlive(final int health)
    {
        return health > minHealth;
    }

    /**
     * Creating a method to apply the amount of damage to health.
     * Also, prevent health going below zero, and damage going below zero as well
     *
     * @param damage from attack
     */
    protected void takeDamage(final int damage)
    {

        final int minDamage;

        minDamage = 0;

        if(damage < minDamage)
        {
            throw new DamageException("Damage cannot be negative :/");
        }
        else
        {
            health -= damage;
        }

        // If health goes negative, set as 0
        if(health < minHealth)
        {
            health = minHealth;
        }
    }

    /**
     * Creating a method to increase health by healing and setting the range of healing from 0 to 100.
     *
     * @param healAmount heal health
     *
     * @throws HealingException set healing range to make sure not go below 0
     */
    protected void heal(final int healAmount) throws HealingException
    {

        final int maxHealAmount;
        final int minHealAmount;

        maxHealAmount = 100;
        minHealAmount = 0;

        // Set range of healing from 0 to 100
        if(healAmount > maxHealAmount || healAmount < minHealAmount)
        {
            throw new HealingException(String.format("Heal amount cannot be negative or exceed %d :/", maxHealAmount));
        }
        else
        {
            health += healAmount;
        }

        // If health go above 100 set as 100 (Used for healCreature() in CreatureHealer)
        if(health > maxHealAmount)
        {
            health = maxHealAmount;
        }
    }

    /**
     * Creating a method to calculate age based on current date.
     * If birth month is above current month or if the birth month and current month are the same
     * but the day of birthday is after the current day, the age is decreased by one year.
     *
     * @param currentDate current year,month, and day
     *
     * @return ageYear after calculate the age
     */
    protected int getAgeYears(final Date dateOfBirth, final Date currentDate)
    {

        age = currentDate.getYear() - dateOfBirth.getYear();

        // If birth month is above current month or if the birth month and current month are the same
        // but the day of birthday is after the current day, the age is decreased by one year.
        if(dateOfBirth.getMonth() > currentDate.getMonth() || (dateOfBirth.getMonth() == currentDate.getMonth() && dateOfBirth.day > currentDate.day))
        {
            age--;
        }
        return age;
    }

    /**
     * Creating a method to prints the creature's name, dateOfBirth, age, and health
     *
     * @return creature's information in String
     */
    public String getDetails()
    {

        final StringBuilder builder;

        builder = new StringBuilder();

        builder.append("Creature's name: ");
        builder.append(name);
        builder.append(" , Date of Birth: ");
        builder.append(dateOfBirth.getYYYYMMDD());
        builder.append(" , Age: ");
        builder.append(age);
        builder.append(" , Health: ");
        builder.append(health);

        return builder.toString();
    }
}
