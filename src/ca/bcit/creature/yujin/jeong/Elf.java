package ca.bcit.creature.yujin.jeong;

/**
 * This class models Elf from a parent class Creature.
 * <p>
 * validateParameter() to validate data in parameter. Name can't be null or empty, date of birth must be over
 * currentDate, also health must be over 0 as well.
 * <p>
 * validateMana() to set range of mana between 0 and 50.
 * <p>
 * getDetails() to prints the creature's name, dateOfBirth, age, health, and mana.
 * <p>
 * castSpell() to use skill "castSpell". Skill is unavailable to use when low mana.
 * <p>
 * restoreMana() to restore mana for using castSpell skill.
 *
 * @author Yujin Jeong
 * @version 1.0
 */
public class Elf extends Creature
{

    // Cannot make as final, because mana value changes the value under the conditions
    private int mana;

    private final int maxMana = 50;

    /**
     * Creating a constructor. Validating name, date of birth, health, and mana in constructor.
     *
     * @param name        creature's name
     * @param dateOfBirth creature's date of birth
     * @param health      creatures' health
     * @param mana        Elf's mana
     */
    public Elf(final String name, final Date dateOfBirth, final int health, final int mana)
    {
        super(name, dateOfBirth, health);

        validateParameter(name, dateOfBirth, health);
        validateMana(mana);

        this.mana = mana;

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
        final Date currentDate;

        currentDate = new Date(2024, 9, 15);

        // Validating name
        validateName(name);
        // Validating date of birth
        validateBirthDate(dateOfBirth, currentDate);
        // Validating health
        validHealth(health);
    }

    /**
     * Creating a method to set range of mana between 0 and 50.
     *
     * @param mana from elf
     */
    protected void validateMana(final int mana)
    {
        final int minMana;

        minMana = 0;

        if(mana < minMana || mana > maxMana)
        {
            throw new IllegalArgumentException(String.format("Mana can't go below %d and above %d", minMana, maxMana));
        }
    }

    /**
     * Creating a method to prints the creature's name, dateOfBirth, age, health, and mana.
     *
     * @return creature's information in String
     */
    @Override
    public String getDetails()
    {
        final StringBuilder builder;

        builder = new StringBuilder();

        builder.append(super.getDetails());
        builder.append(" , Mana: ");
        builder.append(mana);

        return builder.toString();
    }

    /**
     * Creating a method to use skill "castSpell". Skill is unavailable to use when low mana.
     *
     * @param anotherCreature attack another creature
     *
     * @throws LowManaException to make sure mana is enough to use castSpell
     */
    public void castSpell(Creature anotherCreature) throws LowManaException
    {
        final int minManaUsage;
        final int castSpellDamage;

        minManaUsage    = 5;
        castSpellDamage = 10;

        if(mana >= minManaUsage)
        {
            mana -= minManaUsage;
            anotherCreature.takeDamage(castSpellDamage);
        }
        else
        {
            throw new LowManaException("Mana is not enough to cast spell :/");
        }
    }

    /**
     * Creating a method to restore mana for using castSpell skill.
     *
     * @param amount restore amount
     */
    protected void restoreMana(final int amount)
    {
        if((mana + amount) > maxMana)
        {
            mana = maxMana;
        }
        else
        {
            mana += amount;
        }

        // If mana go above 50 set as 50
        if(mana > maxMana)
        {
            mana = maxMana;
        }
    }
}
