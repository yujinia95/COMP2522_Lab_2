package ca.bcit.creature.yujin.jeong.codes;

/**
 * <p> This class models Creature.
 * validateName() to check if name is valid (No null, no empty String).
 * <p>
 * validateHealth() to check if the health can't go below minHealth.
 * <p>
 * isAlive() to return true if health is greater than minHealth.
 * <p>
 * takeDamage() to apply the amount of damage to health. Also, prevent health going below minHealth,
 * and negative damage.
 * <p>
 * heal() to increase health by healing and setting the range of healing from minHealAmount too maxHealAmount.
 * <p>
 * getAgeYears() to calculate age based on current date. If birth month is above current month or if the birth month.
 * and current month are the same but the day of birthday is after the current day, the age is decreased by one year.
 * <p>
 * getDetails() to prints the creature's name, dateOfBirth, age, and health. </p>
 *
 * @author Yujin Jeong
 * @author Tommy Phuong
 * @author Evan Vink
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

    // Current date
    private final int currentYear  = 2024;
    private final int currentMonth = 9;
    private final int currentDay   = 15;

    // Creating global variable to set minimum health is above zero.
    private final int minHealth = 0;

    // Creating global variable set health can't go below zero.
    final int healthAboveZero = 0;

    // Creating global variable to set minimum heal amount and maximum heal amount
    final int maxHealAmount = 100;
    final int minHealAmount = 0;

    final int minDamage = 0;

    /**
     * Creating a constructor. Validating name and date of birth in constructor.
     *
     * @param name        creature name
     * @param dateOfBirth date of birth
     * @param health      creature's health
     */
    public Creature(final String name,
                    final Date dateOfBirth,
                    final int health)
    {
        // Initializing current date before validate the date of birth and age
        this.currentDate = new Date(currentYear, currentMonth, currentDay);

        // Validating name,date of birth and current date
        validateName(name);
        dateOfBirth.validateDate(currentDate);

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
    public void validateName(final String name)
    {
        if(name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("Name cannot be null or empty :/");
        }
    }

    /**
     * Creating a method to set health can't go below minHealth.
     *
     * @param health Dragon's health
     */
    public void validHealth(final int health)
    {

        if(health < healthAboveZero)
        {
            throw new IllegalArgumentException("Health cannot be negative :/");
        }
    }

    /**
     * Creating a method to return true if health is greater than minHealth.
     *
     * @param health creature's health
     */
    public boolean isAlive(final int health)
    {
        return health > minHealth;
    }

    /**
     * Creating a method to apply the amount of damage to health.
     * Also, prevent health going below zero, and damage going below zero as well
     *
     * @param damage from attack
     */
    public void takeDamage(final int damage)
    {
        if(damage < minDamage)
        {
            throw new DamageException("Damage cannot be negative :/");
        }
        else
        {
            health -= damage;
        }

        // If health goes negative, set as minHealth
        if(health < minHealth)
        {
            health = minHealth;
        }
    }

    /**
     * Creating a method to increase health by healing and setting the range of healing from minHealAmount to
     * maxHealAmount.
     *
     * @param healAmount heal health
     *
     * @throws HealingException set healing range to make sure not go below minHealAmount
     */
    public void heal(final int healAmount) throws HealingException
    {

        // Set range of healing from minHealAmount to maxHealAmount
        if(healAmount > maxHealAmount || healAmount < minHealAmount)
        {
            throw new HealingException(String.format("Heal amount cannot be negative or exceed %d :/", maxHealAmount));
        }
        else
        {
            health += healAmount;
        }

        // If health goes above maxHealthAmount set as maxHealthAmount (Used for healCreature() in CreatureHealer)
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
    public int getAgeYears(final Date dateOfBirth,
                           final Date currentDate)
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
        builder.append("\nDate of Birth: ");
        builder.append(dateOfBirth.getYYYYMMDD());
        builder.append("\nAge: ");
        builder.append(age);
        builder.append("\nHealth: ");
        builder.append(health);

        return builder.toString();
    }
}
