package com.example.ander.fgodamagerecovery.Objects;

public class Servant {
    private int ATK;
    //public ServantType servInfo;
    private String attribute;
    private String className;
    private String skill1, skill2, skill3;
    private double critDamageMod = 0, npDamageMod = 0, atkMod = 0, cardMOD = 0, powerMod = 0, artsMOD = 0, busterMOD = 0, quickMOD = 0;
    private int dmgPlusAdd = 0;

    public double getArtsMOD() {
        return artsMOD;
    }

    public void addArtsMOD(double c) {
        artsMOD += c;
    }

    public double getBusterMOD() {
        return busterMOD;
    }

    public void addBusterMOD(double c) {
        busterMOD += c;
    }

    public double getQuickMOD() {
        return quickMOD;
    }

    public void addQuickMOD(double c) {
        quickMOD += c;
    }

    public void addCritDamageMod(double c) {
        critDamageMod += c;
    }
    public double getCritDamageMod() {
        return critDamageMod;
    }

    public double getNpDamageMod() {
        return npDamageMod;
    }
    public void addNpDamageMod(double c) {
        npDamageMod += c;
    }

    public double getAtkMod() {
        return atkMod;
    }
    public void addAtkMod(double c) {
        atkMod += c;
    }

    public double getCardMOD() {
        return cardMOD;
    }

    public void addCardMOD(double c) {
        cardMOD += c;
    }

    public double getPowerMod() {
        return powerMod;
    }

    public void addPowerMod(double c) {
        powerMod += c;
    }

    public int getDmgPlusAdd() {
        return dmgPlusAdd;
    }

    public void addDmgPlusAdd(int c) {
        dmgPlusAdd += c;
    }

    public Servant(int ATK, String name, String className) {
        this.ATK = ATK;
        this.attribute = FGODamage.servantsMap.get(name + "4");
        this.className = className;
        this.skill1 = FGODamage.servantsMap.get(name + "0");
        this.skill2 = FGODamage.servantsMap.get(name + "1");
        this.skill3 = FGODamage.servantsMap.get(name + "2");
    }

    public double getClassMultiplier() {
        if(className.equals("Saber"))
            return 1.0;
        if(className.equals("Archer"))
            return .95;
        if(className.equals("Lancer"))
            return 1.05;
        if(className.equals("Rider"))
            return 1.0;
        if(className.equals("Caster"))
            return 0.9;
        if(className.equals("Assassin"))
            return 0.9;
        if(className.equals("Berserker"))
            return 1.1;
        if(className.equals("Shielder"))
            return 1.0;
        if(className.equals("Ruler"))
            return 1.1;
        if(className.equals("AlterEgo"))
            return 1.0;
        if(className.equals("Avenger"))
            return 1.1;
        return -1.0;
    }

    public double getAtrributeAdv(Servant o)
    {
        if(this.attribute.equals("Man"))
        {
            if(o.getAttribute().equals("Sky"))
                return 1.1;
            if(o.getAttribute().equals("Earth"))
                return 0.9;
            else
                return 1.0;
        }
        if(this.attribute.equals("Sky"))
        {
            if(o.getAttribute().equals("Earth"))
                return 1.1;
            if(o.getAttribute().equals("Man"))
                return 0.9;
            else
                return 1.0;
        }
        if(this.attribute.equals("Earth"))
        {
            if(o.getAttribute().equals("Man"))
                return 1.1;
            if(o.getAttribute().equals("Sky"))
                return 0.9;
            else
                return 1.0;
        }
        if(this.attribute.equals("Star"))
        {
            if(o.getAttribute().equals("Beast"))
                return 1.1;
            else
                return 1.0;
        }
        if(this.attribute.equals("Beast"))
        {
            if(o.getAttribute().equals("Beast"))
                return 0.0;
            if(o.getAttribute().equals("Star"))
                return 1.1;
            else
                return 1.0;
        }
        return -1;
    }

    public double getClassAdv(Servant enemy){
        if(this.className.equals("Saber")){
            if(enemy.getClassName().equals("Archer") || enemy.getClassName().equals("Ruler"))
                return .5;
            if(enemy.getClassName().equals("Lancer") || enemy.getClassName().equals("AlterEgo") || enemy.getClassName().equals("Berserker"))
                return 2.0;
            else
                return 1.0;
        }
        if(this.className.equals("Archer")){
            if(enemy.getClassName().equals("Lancer") || enemy.getClassName().equals("Ruler"))
                return .5;
            if(enemy.getClassName().equals("Saber") || enemy.getClassName().equals("AlterEgo") || enemy.getClassName().equals("Berserker"))
                return 2.0;
            else
                return 1.0;
        }
        if(this.className.equals("Lancer")){
            if(enemy.getClassName().equals("Saber") || enemy.getClassName().equals("Ruler"))
                return .5;
            if(enemy.getClassName().equals("Archer") || enemy.getClassName().equals("AlterEgo") || enemy.getClassName().equals("Berserker"))
                return 2.0;
            else
                return 1.0;
        }
        if(this.className.equals("Rider")){
            if(enemy.getClassName().equals("Assassin") || enemy.getClassName().equals("Ruler"))
                return .5;
            if(enemy.getClassName().equals("Caster") || enemy.getClassName().equals("Beast") || enemy.getClassName().equals("Berserker"))
                return 2.0;
            else
                return 1.0;
        }
        if(this.className.equals("Caster")){
            if(enemy.getClassName().equals("Rider") || enemy.getClassName().equals("Ruler"))
                return .5;
            if(enemy.getClassName().equals("Assassin") || enemy.getClassName().equals("Beast") || enemy.getClassName().equals("Berserker"))
                return 2.0;
            else
                return 1.0;
        }
        if(this.className.equals("Assassin")){
            if(enemy.getClassName().equals("Caster") || enemy.getClassName().equals("Ruler"))
                return .5;
            if(enemy.getClassName().equals("Rider") || enemy.getClassName().equals("Beast") || enemy.getClassName().equals("Berserker"))
                return 2.0;
            else
                return 1.0;
        }
        if(this.className.equals("Berserker")){
            if(enemy.getClassName().equals("Shielder"))
                return 1.5;
            else
                return 1.0;
        }
        if(this.className.equals("Shielder")){
            return 1.0;
        }
        if(this.className.equals("Ruler")){
            if(enemy.getClassName().equals("Avenger"))
                return .5;
            if(enemy.getClassName().equals("Berserker"))
                return 2.0;
            else
                return 1.0;
        }
        if(this.className.equals("AlterEgo")){
            if(enemy.getClassName().equals("Assassin") || enemy.getClassName().equals("Rider")
                    || enemy.getClassName().equals("Caster")|| enemy.getClassName().equals("Berserker"))
                return 2.0;
            else
                return 1.0;
        }
        if(this.className.equals("Avenger")){
            if(enemy.getClassName().equals("Berserker") || enemy.getClassName().equals("Ruler"))
                return 2.0;
            else
                return 1.0;
        }
        return -1;
    }

    public String getClassName() {
        return className;
    }

    public String getAttribute() {
        return attribute;
    }

}
