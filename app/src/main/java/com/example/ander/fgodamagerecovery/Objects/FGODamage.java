package com.example.ander.fgodamagerecovery.Objects;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FGODamage {
    public static final Map <String, String> servantsMap; //this map contains general servant info, in the style of "servantname0" = first skill
    //"servantname1" = second skill, "servantname2" = third skill, "servantname3" = servant gender, "servantname4" = servant attribute
    //later on i wanted to add upgraded skills. the "servantnameX" where X is a number is very useful because it allows us to add servant info
    //we feel we need while leaving it extremely easy to access, as long as we keep the same pattern for each servant
    //info from http://fate-go.cirnopedia.org/servant_all.php#


    public static int atk, cardNum, NPdmgMult = 1, criticalModifier = 1,
            isCrit = 0, isNPcard = 0, isSuperEffective = 0; //critmodifier is 1 if not, 2 if yes. isCrit 1 if crit 0 if not. same for np
    public static int skill1Level, skill2Level, skill3Level;
    public static double firstcardBonus = 0, cardDV = -1; //cardmod is for buffs of type arts/buster/quick ste to zero for now
    public static double enemyDefMod = 0; //atkMod for your servants attack modification, enemyDefMod for enemy defense modification....sidenote, note sure if this is where i want to put skill usage but might as well
    public static double extraCardModifier = 1; //1 if not  a brave chain, 2 if just a normal brave chain, 3.5 if in a brave chain with 3 of the same cards
    public static double specialDefMod = 0; //***NOTE ON THIS: only for bosses who have a special damage reduction on them ie gawain in camelot likely will be a while before i implement this***
    //public static double powerMod = 0; //Power Up [Anti-X] includes dragon killer, beast killer, executioner, boudica's skill and whatever else I forget.
    public static double selfDamageMod = 0; //forum says not used yet, not sure if this is still true
    //public static double critDamageMod = 0; //additive modifications to how hard you crit (10% == .1)
    //public static double npDamageMod = 0; //same as above except for NPs NOTE NOT THE AMOUNT OF DAMAGE NP DOES
    public static double superEffectiveModifier = 0; //not sure what this is about maybe something like "weak to enuma elish"
    // public static int dmgPlusAdd = 0; //dmg that is added like divinity and wavers 3rd skill
    public static int enemyDmgCutAdd = 0; //dmg cut like wavers second skill and mashus first, might implement in the future
    public static double busterChainMod = 0; //is .2 if it is a buster card in a buster chain, does not have to be buster brave
    public static String classname, name, cardType, strIsbuster, classnameEnemy, nameEnemy;
    public static boolean isBuster, isNP = false;

    //note on this: i really like this map format and i think it would be useful for storing Noble Phantasm damage info and maybe skills as well
    static{
        Map <String, String> servants = new HashMap<String, String>();
        //http://fate-go.cirnopedia.org/enemy.php stopped at babylonia

        servants.put("Hand3","None");
        servants.put("Hand4","Sky");
        servants.put("Door3","None");
        servants.put("Door4","Sky");
        servants.put("Skeleton3","None");
        servants.put("Skeleton4","Man");
        servants.put("Dragon Tooth Warrior3","None");
        servants.put("Dragon Tooth Warrior4","Earth");
        servants.put("Soldier/Zombie/Pirate3","Male");
        servants.put("Soldier/Zombie/Pirate4","Man");
        servants.put("Amazoness3","Female");
        servants.put("Amazoness4","Man");
        servants.put("Ghost3","None");
        servants.put("Ghost4","Sky");
        servants.put("Wyvern3","None");
        servants.put("Wyvern4","Earth");
        servants.put("Dragon3","None");
        servants.put("Dragon4","Earth");
        servants.put("Werewolf3","Male");
        servants.put("Werewolf4","Earth");
        servants.put("Werejaguar3","Male");
        servants.put("Werejaguar4","Earth");
        servants.put("Goblin3","Male");
        servants.put("Goblin4","Earth");
        servants.put("Centaur3","Male");
        servants.put("Centaur4","Earth");
        servants.put("Chimera3","None");
        servants.put("Chimera4","Earth");
        servants.put("Lamia/Naga3","Female");
        servants.put("Lamia/Naga4","Earth");
        servants.put("Daemon3","None");
        servants.put("Daemon4","Sky");
        servants.put("Demon Pillars3","None");
        servants.put("Demon Pillars4","Sky");
        servants.put("Homunculus3","None");
        servants.put("Homunculus4","Sky");
        servants.put("Golem3","None");
        servants.put("Golem4","Sky");
        servants.put("Automata/Doll/Gear3","None");
        servants.put("Automata/Doll/Gear4","Sky");
        servants.put("Helter Skelter3","None");
        servants.put("Helter Skelter4","Sky");
        servants.put("Mechanized Infantry3","None");
        servants.put("Mechanized Infantry4","Man");
        servants.put("Book3","None");
        servants.put("Book4","Sky");
        servants.put("Soul Eater3","None");
        servants.put("Soul Eater4","Earth");
        servants.put("Gazer/Spotter3","None");
        servants.put("Gazer/Spotter4","Earth");
        servants.put("Bicorn3","None");
        servants.put("Bicorn4","Earth");
        servants.put("Spriggan3","None");
        servants.put("Spriggan4","Earth");
        servants.put("Oni/Kazekoshimaru/Gikuimaru/Gourikimaru3","Male");
        servants.put("Oni/Kazekoshimaru/Gikuimaru/Gourikimaru4","Earth");
        servants.put("Hassan Variants3","Male");
        servants.put("Hassan Variants4","Man");
        servants.put("Knight Enforcer3","Male");
        servants.put("Knight Enforcer4","Man");
        servants.put("Sphinx3","Male");
        servants.put("Sphinx4","Earth");
        servants.put("Malika Sphinx3","Female");
        servants.put("Malika Sphinx4","Earth");
        servants.put("Ifreeta3","Female");
        servants.put("Ifreeta4","Earth");
        servants.put("Mindless3","Male");
        servants.put("Mindless4","Man");
        servants.put("Blade-Wing3","None");
        servants.put("Blade-Wing4","Earth");
        servants.put("Sea Devil3","None");
        servants.put("Sea Devil4","Earth");
        servants.put("Automatic Defense System3","None");
        servants.put("Automatic Defense System4","Sky");
        servants.put("Crabs3","None");
        servants.put("Crabs4","Earth");
        servants.put("Boar3","None");
        servants.put("Boar4","Earth");

        servants.put("Emiya0","Mind's Eye (True) B");
        servants.put("Emiya1","Clairvoyance C");
        servants.put("Emiya2","Magecraft C-");
        servants.put("Emiya3","Male");
        servants.put("Emiya4","Man");
        servants.put("Mash0","Transient Wall of Snowflakes");
        servants.put("Mash1","Obscurant Wall of Chalk");
        servants.put("Mash2","Shield of Rousing Resolution");
        servants.put("Mash3","Female");
        servants.put("Mash4","Earth");
        servants.put("Arturia0","Charisma B");
        servants.put("Arturia1","Mana Burst A");
        servants.put("Arturia2","Intuition A");
        servants.put("Arturia3","Female");
        servants.put("Arturia4","Earth");
        servants.put("Arturia Alter0","Mana Burst A");
        servants.put("Arturia Alter1","Intuition B");
        servants.put("Arturia Alter2","Charisma E");
        servants.put("Arturia Alter3","Female");
        servants.put("Arturia Alter4","Man");
        servants.put("Arturia Lily0","Intuition B");
        servants.put("Arturia Lily1","Mana Burst A");
        servants.put("Arturia Lily2","Journey of the Flowers EX");
        servants.put("Arturia Lily3","Female");
        servants.put("Arturia Lily4","Earth");
        servants.put("Nero0","Migraine B");
        servants.put("Nero1","Imperial Priviledge EX");
        servants.put("Nero2","Thrice Setting Sun A");
        servants.put("Nero3","Female");
        servants.put("Nero4","Man");
        servants.put("Seigried0","Golden Rule C-");
        servants.put("Seigried1","Disengage A");
        servants.put("Seigried2","Dragon Slayer A");
        servants.put("Seigried3","Male");
        servants.put("Seigried4","Earth");
        servants.put("Caesar0","Tactics B");
        servants.put("Caesar1","Charisma C");
        servants.put("Caesar2","Incitement EX");
        servants.put("Caesar3","Male");
        servants.put("Caesar4","Man");
        servants.put("Altera0","Tactics B");
        servants.put("Altera1","Natural Body D");
        servants.put("Altera2","Crest of the Star");
        servants.put("Altera3","Female");
        servants.put("Altera4","Man");
        servants.put("Gilles Saber0","Tactics C");
        servants.put("Gilles Saber1","Golden Rule B");
        servants.put("Gilles Saber2","Prelati's Encouragement B");
        servants.put("Gilles Saber3","Male");
        servants.put("Gilles Saber4","Man");
        servants.put("Chevalier d'Eon0","Mind's Eye (True) C");
        servants.put("Chevalier d'Eon1","Self-Suggestion A");
        servants.put("Chevalier d'Eon2","Aspect of Beauty C");
        servants.put("Chevalier d'Eon3","Trap");
        servants.put("Chevalier d'Eon4","Man");
        servants.put("Gilgamesh0","Charisma A+");
        servants.put("Gilgamesh1","Golden Rule A");
        servants.put("Gilgamesh2","Collector EX");
        servants.put("Gilgamesh3","Male");
        servants.put("Gilgamesh4","Sky");
        servants.put("Robin Hood0","Sabotage A");
        servants.put("Robin Hood1","Golden Rule E");
        servants.put("Robin Hood2","May King B");
        servants.put("Robin Hood3","Male");
        servants.put("Robin Hood4","Man");
        servants.put("Atlante0","Beyond Arcadia B");
        servants.put("Atlante1","Hunter's Aesthetic C");
        servants.put("Atlante2","Calydon Hunt A");
        servants.put("Atlante3","Female");
        servants.put("Atlante4","Earth");
        servants.put("Euryale0","Vampirism C");
        servants.put("Euryale1","Siren Song A");
        servants.put("Euryale2","Whim of the Goddess A");
        servants.put("Euryale3","Female");
        servants.put("Euryale4","Sky");
        servants.put("Arash0","Toughness EX");
        servants.put("Arash1","Clairvoyance A");
        servants.put("Arash2","Bow and Arrow Creation A");
        servants.put("Arash3","Male");
        servants.put("Arash4","Earth");
        servants.put("Cu Chulainn0","Battle COntinuation A");
        servants.put("Cu Chulainn1","Protection from Arrows B");
        servants.put("Cu Chulainn2","Disengage C");
        servants.put("Cu Chulainn3","Male");
        servants.put("Cu Chulainn4","Sky");
        servants.put("Liz0","Charisma C");
        servants.put("Liz1","Charisma of Sadism A");
        servants.put("Liz2","Torture Technique A");
        servants.put("Liz3","Female");
        servants.put("Liz4","Man");
        servants.put("Benkei0","Vengeful Spirit Exorcism A");
        servants.put("Benkei1","Imposing Stance B");
        servants.put("Benkei2","Blank Subscription List");
        servants.put("Benkei3","Male");
        servants.put("Benkei4","Man");
        servants.put("Cu Chulainn (Prototype)0","Rune Spell B");
        servants.put("Cu Chulainn (Prototype)1","Protection from Arrows B");
        servants.put("Cu Chulainn (Prototype)2","Beast-Slayer B+");
        servants.put("Cu Chulainn (Prototype)3","Male");
        servants.put("Cu Chulainn (Prototype)4","Sky");
        servants.put("Leonidas0","Rear Guard's Pride A");
        servants.put("Leonidas1","Battle Continuation A");
        servants.put("Leonidas2","Warrior's Roar B");
        servants.put("Leonidas3","Male");
        servants.put("Leonidas4","Man");
        servants.put("Romulus0","Natural Body C");
        servants.put("Romulus1","Imperial Privilege EX");
        servants.put("Romulus2","Septem Colles A");
        servants.put("Romulus3","Male");
        servants.put("Romulus4","Star");
        servants.put("Medusa0","Mysitc Eyes A+");
        servants.put("Medusa1","Monstrous Strength B");
        servants.put("Medusa2","Bloodfort Andromeda B");
        servants.put("Medusa3","Female");
        servants.put("Medusa4","Earth");
        servants.put("Georgios0","Guardian Knight A+");
        servants.put("Georgios1","Martyr's Soul B+");
        servants.put("Georgios2","Battle Continuation A");
        servants.put("Georgios3","Male");
        servants.put("Georgios4","Man");
        servants.put("Edward Teach0","Voyager of the Storm A");
        servants.put("Edward Teach1","Pirate's Glory B");
        servants.put("Edward Teach2","Loving Gentleman C");
        servants.put("Edward Teach3","Male");
        servants.put("Edward Teach4","Man");
        servants.put("Boudica0","Vow to the Goddess B");
        servants.put("Boudica1","Battle Continuation A");
        servants.put("Boudica2","Protection of Andrasta A");
        servants.put("Boudica3","Female");
        servants.put("Boudica4","Man");
        servants.put("Ushiwakamaru0","Tenga's Strategy A");
        servants.put("Ushiwakamaru1","Charisma C+");
        servants.put("Ushiwakamaru2","Quick-Witted Swallow B");
        servants.put("Ushiwakamaru3","Female");
        servants.put("Ushiwakamaru4","Man");
        servants.put("Alexander0","Charisma C");
        servants.put("Alexander1","Fair Youth B");
        servants.put("Alexander2","Signs of a Supreme Ruler A");
        servants.put("Alexander3","Male");
        servants.put("Alexander4","Man");
        servants.put("Marie Antoinette0","Siren Song C");
        servants.put("Marie Antoinette1","Beautiful Princess A");
        servants.put("Marie Antoinette2","Grace of God B");
        servants.put("Marie Antoinette3","Female");
        servants.put("Marie Antoinette4","Man");
        servants.put("Martha0","Protection of the Faith A");
        servants.put("Martha1","Miracle D");
        servants.put("Martha2","Holy Maiden's Oath C");
        servants.put("Martha3","Female");
        servants.put("Martha4","Man");
        servants.put("Medea0","Rapid Divine Words A");
        servants.put("Medea1","Argon Coin");
        servants.put("Medea2","Circe's Teaching A");
        servants.put("Medea3","Female");
        servants.put("Medea4","Earth");
        servants.put("Gilles Caster0","Mental Corruption A");
        servants.put("Gilles Caster1","Aesthitic Appreciation E-");
        servants.put("Gilles Caster2","Evil Eye of the Abyss C");
        servants.put("Gilles Caster3","Male");
        servants.put("Gilles Caster4","Man");
        servants.put("Hans Christian Andersen0","Human Observation A");
        servants.put("Hans Christian Andersen1","Rapid Casting E");
        servants.put("Hans Christian Andersen2","Innocent Monster D");
        servants.put("Hans Christian Andersen3","Male");
        servants.put("Hans Christian Andersen4","Man");
        servants.put("William Shakespeare0","Enchant A");
        servants.put("William Shakespeare1","Self-Preservation B");
        servants.put("William Shakespeare2","The King's Men C");
        servants.put("William Shakespeare3","Male");
        servants.put("William Shakespeare4","Man");
        servants.put("Mephistopheles0","Curse A");
        servants.put("Mephistopheles1","Innocent Monster B");
        servants.put("Mephistopheles2","Jester's Burst of Laughter A+");
        servants.put("Mephistopheles3","Male");
        servants.put("Mephistopheles4","Earth");
        servants.put("Wolfganag Amadeus Mozart0","Protection of Muse (Fake) EX");
        servants.put("Wolfganag Amadeus Mozart1","Aesthetic Appreciation B");
        servants.put("Wolfganag Amadeus Mozart2","A Little Night Music EX");
        servants.put("Wolfganag Amadeus Mozart3","Male");
        servants.put("Wolfganag Amadeus Mozart4","Star");
        servants.put("Zhuge Liang0","Discerning Eye A");
        servants.put("Zhuge Liang1","Tactician's Advice A+");
        servants.put("Zhuge Liang2","Tactician's Command A+");
        servants.put("Zhuge Liang3","Male");
        servants.put("Zhuge Liang4","Man");
        servants.put("Cu Chulainn (Caster)0","Rune Spell A");
        servants.put("Cu Chulainn (Caster)1","Protection from Arrows A");
        servants.put("Cu Chulainn (Caster)2","Disengage C");
        servants.put("Cu Chulainn (Caster)3","Male");
        servants.put("Cu Chulainn (Caster)4","Sky");
        servants.put("Sasaki Kojirou0","Mind's Eye (Fake) A");
        servants.put("Sasaki Kojirou1","Vitrify B+");
        servants.put("Sasaki Kojirou2","Knowledge of  the Sowa B");
        servants.put("Sasaki Kojirou3","Male");
        servants.put("Sasaki Kojirou4","Man");
        servants.put("Hassan of the Cursed Arm0","Throw (Dagger) B");
        servants.put("Hassan of the Cursed Arm1","Self-Modification C");
        servants.put("Hassan of the Cursed Arm2","Protection from Wind A");
        servants.put("Hassan of the Cursed Arm3","Male");
        servants.put("Hassan of the Cursed Arm4","Man");
        servants.put("Stheno0","Vampirism C");
        servants.put("Stheno1","Siren Song A");
        servants.put("Stheno2","Whim of the Goddess A");
        servants.put("Stheno3","Female");
        servants.put("Stheno4","Sky");
        servants.put("Jing Ke0","Restrain A");
        servants.put("Jing Ke1","Planning B");
        servants.put("Jing Ke2","No Regard for Others A");
        servants.put("Jing Ke3","Female");
        servants.put("Jing Ke4","Man");
        servants.put("Charles-Henri Sanson0","Executioner A++");
        servants.put("Charles-Henri Sanson1","Medicine A");
        servants.put("Charles-Henri Sanson2","Human Study B");
        servants.put("Charles-Henri Sanson3","Male");
        servants.put("Charles-Henri Sanson4","Man");
        servants.put("Phantom of the Opera0","Innocent Monster D");
        servants.put("Phantom of the Opera1","Siren Song B");
        servants.put("Phantom of the Opera2","Mental Corruption A");
        servants.put("Phantom of the Opera3","Male");
        servants.put("Phantom of the Opera4","Earth");
        servants.put("Mata Hari0","Espionage A++");
        servants.put("Mata Hari1","Pheromone B");
        servants.put("Mata Hari2","Double-Cross B");
        servants.put("Mata Hari3","Female");
        servants.put("Mata Hari4","Man");
        servants.put("Carmilla0","Vampirism C");
        servants.put("Carmilla1","Torture Technique A");
        servants.put("Carmilla2","Bathing in Fresh Blood A");
        servants.put("Carmilla3","Female");
        servants.put("Carmilla4","Earth");
        servants.put("Heracles0","Valor A+");
        servants.put("Heracles1","Mind's Eye (Fake) B");
        servants.put("Heracles2","Battle Continuation A");
        servants.put("Heracles3","Male");
        servants.put("Heracles4","Sky");
        servants.put("Lancelot0","Eternal Arms Mastery A+");
        servants.put("Lancelot1","Protection of the Spirits A");
        servants.put("Lancelot2","Mana Inversion A");
        servants.put("Lancelot3","Male");
        servants.put("Lancelot4","Earth");
        servants.put("Lu Bu Fengxian0","Valor B");
        servants.put("Lu Bu Fengxian1","Defiant B");
        servants.put("Lu Bu Fengxian2","Chaotic Ruthless Hero A");
        servants.put("Lu Bu Fengxian3","Male");
        servants.put("Lu Bu Fengxian4","Man");
        servants.put("Spartacus0","Honor of Suffering B");
        servants.put("Spartacus1","Unyielding Will A");
        servants.put("Spartacus2","Triumphant Return of the Sword B");
        servants.put("Spartacus3","Male");
        servants.put("Spartacus4","Man");
        servants.put("Sakata Kintoki0","Monstrous Strength A+");
        servants.put("Sakata Kintoki1","Animal Communication C");
        servants.put("Sakata Kintoki2","Natural Body A");
        servants.put("Sakata Kintoki3","Male");
        servants.put("Sakata Kintoki4","Man");
        servants.put("Vlad III0","Vampirism A");
        servants.put("Vlad III1","Morph C");
        servants.put("Vlad III2","Battle Continuation A");
        servants.put("Vlad III3","Male");
        servants.put("Vlad III4","Earth");
        servants.put("Asterios0","Monstrous Strength A");
        servants.put("Asterios1","Natural Demon A++");
        servants.put("Asterios2","Labrys of the Abyss C");
        servants.put("Asterios3","Male");
        servants.put("Asterios4","Earth");
        servants.put("Caligula0","Sadistic Streak A");
        servants.put("Caligula1","Imperial Privilege A");
        servants.put("Caligula2","Glory of the Past B");
        servants.put("Caligula3","Male");
        servants.put("Caligula4","Man");
        servants.put("Darius III0","Golden Rule B");
        servants.put("Darius III1","Disengage A");
        servants.put("Darius III2","Battle Continuation A");
        servants.put("Darius III3","Male");
        servants.put("Darius III4","Man");
        servants.put("Kiyohime0","Morph C");
        servants.put("Kiyohime1","Stalking B");
        servants.put("Kiyohime2","Flame Colored Kiss A");
        servants.put("Kiyohime3","Female");
        servants.put("Kiyohime4","Earth");
        servants.put("Eric Bloodaxe0","Support Spell C");
        servants.put("Eric Bloodaxe1","Battle Continuation B");
        servants.put("Eric Bloodaxe2","Bloodthirsty Beastial Axe A+");
        servants.put("Eric Bloodaxe3","Male");
        servants.put("Eric Bloodaxe4","Man");
        servants.put("Tamamo Cat0","Monstrous Strength B");
        servants.put("Tamamo Cat1","Curse E");
        servants.put("Tamamo Cat2","Morph B");
        servants.put("Tamamo Cat3","Female");
        servants.put("Tamamo Cat4","Earth");
        servants.put("Jeanne d'Arc0","Revelation A");
        servants.put("Jeanne d'Arc1","True Name Revelation B");
        servants.put("Jeanne d'Arc2","Divine Judgement A");
        servants.put("Jeanne d'Arc3","Female");
        servants.put("Jeanne d'Arc4","Star");
        servants.put("Orion0","Grace of the Goddess EX");
        servants.put("Orion1","Punish the Unfaithful A+");
        servants.put("Orion2","Mind's Eye (Fake) B-");
        servants.put("Orion3","Male");
        servants.put("Orion4","Sky");
        servants.put("Liz (Halloween)0","Innocent Monster EX");
        servants.put("Liz (Halloween)1","Monster Burst (Pumpkin) A");
        servants.put("Liz (Halloween)2","Performance Contintuation A");
        servants.put("Liz (Halloween)3","Female");
        servants.put("Liz (Halloween)4","Man");
        servants.put("Tamamo0","Curse EX");
        servants.put("Tamamo1","Morph A");
        servants.put("Tamamo2","Fox's Wedding EX");
        servants.put("Tamamo3","Female");
        servants.put("Tamamo4","Sky");
        servants.put("David0","Divine Protection A");
        servants.put("David1","Harp of Healing B");
        servants.put("David2","Charisma B");
        servants.put("David3","Male");
        servants.put("David4","Sky");
        servants.put("Hektor0","Tactics C+");
        servants.put("Hektor1","Proof of Friendship C");
        servants.put("Hektor2","Disengage B");
        servants.put("Hektor3","Male");
        servants.put("Hektor4","Man");
        servants.put("Francis Drake0","Voayager of the Storm A+");
        servants.put("Francis Drake1","Golden Rule B");
        servants.put("Francis Drake2","Pioneer of the Stars EX");
        servants.put("Francis Drake3","Female");
        servants.put("Francis Drake4","Star");
        servants.put("Anne Bonny & Mary Read0","Voayage A");
        servants.put("Anne Bonny & Mary Read1","Marksmanship B");
        servants.put("Anne Bonny & Mary Read2","Combination C");
        servants.put("Anne Bonny & Mary Read3","Female");
        servants.put("Anne Bonny & Mary Read4","Man");
        servants.put("Medea (Lily)0","Rapid Divine Words A");
        servants.put("Medea (Lily)1","Poison Resistance A");
        servants.put("Medea (Lily)2","Ephemeral Love B");
        servants.put("Medea (Lily)3","Female");
        servants.put("Medea (Lily)4","Earth");
        servants.put("Okita Souji0","Shukuchi B");
        servants.put("Okita Souji1","Weak Constitution A");
        servants.put("Okita Souji2","Mind's Eye (Fake) A");
        servants.put("Okita Souji3","Female");
        servants.put("Okita Souji4","Man");
        servants.put("Oda Nobunaga0","Strategy B");
        servants.put("Oda Nobunaga1","Unifying the Nation by Force A");
        servants.put("Oda Nobunaga2","The Demonic King A");
        servants.put("Oda Nobunaga3","Female");
        servants.put("Oda Nobunaga4","Man");
        servants.put("Scathach0","Wisdom of Dun Scaith A+");
        servants.put("Scathach1","Primordial Rune");
        servants.put("Scathach2","God Slayer B");
        servants.put("Scathach3","Female");
        servants.put("Scathach4","Star");
        servants.put("Diarmuid Ua Duibhne0","Mind's Eye (True) B");
        servants.put("Diarmuid Ua Duibhne1","Love Spot C");
        servants.put("Diarmuid Ua Duibhne2","Knight's Strategy B");
        servants.put("Diarmuid Ua Duibhne3","Male");
        servants.put("Diarmuid Ua Duibhne4","Earth");
        servants.put("Fergus0","Valor A");
        servants.put("Fergus1","Defiant B");
        servants.put("Fergus2","Mind's Eye (True) A");
        servants.put("Fergus3","Male");
        servants.put("Fergus4","Earth");
        servants.put("Arturia Alter (Santa)0","Saint's Gift EX");
        servants.put("Arturia Alter (Santa)1","Intuition A");
        servants.put("Arturia Alter (Santa)2","Mana Burst A-");
        servants.put("Arturia Alter (Santa)3","Female");
        servants.put("Arturia Alter (Santa)4","Man");
        servants.put("Nursery Rhyme0","Self-Modification A");
        servants.put("Nursery Rhyme1","Morph A+");
        servants.put("Nursery Rhyme2","Meanwhile A");
        servants.put("Nursery Rhyme3","Female");
        servants.put("Nursery Rhyme4","Man");
        servants.put("Jack the Ripper0","Murderer on a Misty Night A");
        servants.put("Jack the Ripper1","Information Erasure B");
        servants.put("Jack the Ripper2","Surgery E");
        servants.put("Jack the Ripper3","Female");
        servants.put("Jack the Ripper4","Earth");
        servants.put("Mordred0","Mana Burst A");
        servants.put("Mordred1","Intuition B");
        servants.put("Mordred2","Secret of Pedigree EX");
        servants.put("Mordred3","Female");
        servants.put("Mordred4","Earth");
        servants.put("Nikola Tesla0","Galvanism A");
        servants.put("Nikola Tesla1","Natural Intelligence EX");
        servants.put("Nikola Tesla2","Pioneer of the Stars EX");
        servants.put("Nikola Tesla3","Male");
        servants.put("Nikola Tesla4","Star");
        servants.put("Arturia Alter (Lancer)0","Mana Burst A+");
        servants.put("Arturia Alter (Lancer)1","Protection of World's End A");
        servants.put("Arturia Alter (Lancer)2","Charisma E");
        servants.put("Arturia Alter (Lancer)3","Female");
        servants.put("Arturia Alter (Lancer)4","Sky");
        servants.put("Paracelsus0","Rapid Casting A");
        servants.put("Paracelsus1","Elemental A+");
        servants.put("Paracelsus2","Philosopher's Stone A");
        servants.put("Paracelsus3","Male");
        servants.put("Paracelsus4","Man");
        servants.put("Charles Babbage0","Single-Minded C");
        servants.put("Charles Babbage1","Mechanical Armor EX");
        servants.put("Charles Babbage2","Overload D");
        servants.put("Charles Babbage3","Male");
        servants.put("Charles Babbage4","Man");
        servants.put("Henry Jekyll & Hyde0","Monstrous Strength B");
        servants.put("Henry Jekyll & Hyde1","Voice of Panic A");
        servants.put("Henry Jekyll & Hyde2","Self-Modification D");
        servants.put("Henry Jekyll & Hyde3","Male");
        servants.put("Henry Jekyll & Hyde4","Earth");
        servants.put("Frankenstein0","Galvanism B");
        servants.put("Frankenstein1","Grief of a Hollow Lifeform D");
        servants.put("Frankenstein2","Overload C");
        servants.put("Frankenstein3","Female");
        servants.put("Frankenstein4","Earth");
        servants.put("Arjuna0","Clairvoyance C+");
        servants.put("Arjuna1","Blessed Hero A");
        servants.put("Arjuna2","Mana Burst (Flame) A");
        servants.put("Arjuna3","Male");
        servants.put("Arjuna4","Sky");
        servants.put("Karna0","Discernment of the Poor A");
        servants.put("Karna1","Mana Burst (Flame) A");
        servants.put("Karna2","Uncrowned Arms Mastery");
        servants.put("Karna3","Male");
        servants.put("Karna4","Sky");
        servants.put("Mysterious Heroine X0","Support Artillery EX");
        servants.put("Mysterious Heroine X1","Intuition C+");
        servants.put("Mysterious Heroine X2","Galactic Meteor Sword C");
        servants.put("Mysterious Heroine X3","Female");
        servants.put("Mysterious Heroine X4","Star");
        servants.put("Fionn mac Cumhaill0","Clairvoyance B");
        servants.put("Fionn mac Cumhaill1","Trouble with Women A");
        servants.put("Fionn mac Cumhaill2","Magecraft B");
        servants.put("Fionn mac Cumhaill3","Male");
        servants.put("Fionn mac Cumhaill4","Sky");
        servants.put("Brynhild0","Mana Burst (Flame) B");
        servants.put("Brynhild1","Primordial Rune");
        servants.put("Brynhild2","Hero's Sidekick C");
        servants.put("Brynhild3","Female");
        servants.put("Brynhild4","Sky");
        servants.put("Beowulf0","Berserk A");
        servants.put("Beowulf1","Intuition B");
        servants.put("Beowulf2","Battle Continuation B");
        servants.put("Beowulf3","Male");
        servants.put("Beowulf4","Earth");
        servants.put("Nero Bride0","Stars for the Sky A");
        servants.put("Nero Bride1","Flowers for the Earth A");
        servants.put("Nero Bride2","Love for the People A");
        servants.put("Nero Bride3","Female");
        servants.put("Nero Bride4","Man");
        servants.put("Shiki Void0","Mystic Eyes of Death Perception C");
        servants.put("Shiki Void1","Shining Cloud B");
        servants.put("Shiki Void2","Ying Yang A");
        servants.put("Shiki Void3","Female");
        servants.put("Shiki Void4","Man");
        servants.put("Shiki0","Mystic Eyes of Death Perception A");
        servants.put("Shiki1","Mind's Eye (Fake) A");
        servants.put("Shiki2","Ying Yang B");
        servants.put("Shiki3","Female");
        servants.put("Shiki4","Man");
        servants.put("Amakusa Shirou0","Revelation A");
        servants.put("Amakusa Shirou1","Baptism Sacrament B+");
        servants.put("Amakusa Shirou2","Divine Judgement C");
        servants.put("Amakusa Shirou3","Male");
        servants.put("Amakusa Shirou4","Man");
        servants.put("Astolfo0","Monstrous Strength C-");
        servants.put("Astolfo1","Down with a Touch! D");
        servants.put("Astolfo2","Disappearing Reason D");
        servants.put("Astolfo3","Trap");
        servants.put("Astolfo4","Earth");
        servants.put("Gilgamesh (Child)0","Charisma A+");
        servants.put("Gilgamesh (Child)1","Fair Youth C");
        servants.put("Gilgamesh (Child)2","Golden Rule A");
        servants.put("Gilgamesh (Child)3","Male");
        servants.put("Gilgamesh (Child)4","Sky");
        servants.put("Edmond Dantes0","Iron Determination EX");
        servants.put("Edmond Dantes1","Golden Rule A");
        servants.put("Edmond Dantes2","Wisdom of Crisis A");
        servants.put("Edmond Dantes3","Male");
        servants.put("Edmond Dantes4","Man");
        servants.put("Nightingale0","Nurse of Steel A");
        servants.put("Nightingale1","Human Body Comprehension A");
        servants.put("Nightingale2","Angel's Outcry EX");
        servants.put("Nightingale3","Female");
        servants.put("Nightingale4","Man");
        servants.put("Cu Chulainn (Alter)0","Frenzy of Spirits A");
        servants.put("Cu Chulainn (Alter)1","Protection from Arrows C");
        servants.put("Cu Chulainn (Alter)2","Battle Continuation A");
        servants.put("Cu Chulainn (Alter)3","Male");
        servants.put("Cu Chulainn (Alter)4","Earth");
        servants.put("Queen Medb0","Golden Rule (Body) A");
        servants.put("Queen Medb1","Charisma B");
        servants.put("Queen Medb2","Siren Song C");
        servants.put("Queen Medb3","Female");
        servants.put("Queen Medb4","Earth");
        servants.put("Helena Blavatsky0","Mana Tuning C");
        servants.put("Helena Blavatsky1","Mahatma A");
        servants.put("Helena Blavatsky2","Pursuit for the Unknown B");
        servants.put("Helena Blavatsky3","Female");
        servants.put("Helena Blavatsky4","Man");
        servants.put("Rama0","Warrior's Blessing A");
        servants.put("Rama1","Charisma B");
        servants.put("Rama2","Cause of Separation A");
        servants.put("Rama3","Male");
        servants.put("Rama4","Sky");
        servants.put("Li Shuwen0","Chinese Martial Arts A++");
        servants.put("Li Shuwen1","Sphere Boundary B");
        servants.put("Li Shuwen2","Juezhao B");
        servants.put("Li Shuwen3","Male");
        servants.put("Li Shuwen4","Man");
        servants.put("Thomas Edison0","Morph C");
        servants.put("Thomas Edison1","Mass Production A");
        servants.put("Thomas Edison2","Concept Improvement A+");
        servants.put("Thomas Edison3","Male");
        servants.put("Thomas Edison4","Man");
        servants.put("Geronimo0","Bloody Devil B");
        servants.put("Geronimo1","Shamanism B");
        servants.put("Geronimo2","Guardian Beast B");
        servants.put("Geronimo3","Male");
        servants.put("Geronimo4","Man");
        servants.put("Billy the Kid0","Marksmanship A++");
        servants.put("Billy the Kid1","Quick Draw A+");
        servants.put("Billy the Kid2","Mind's Eye (Fake) C");
        servants.put("Billy the Kid3","Male");
        servants.put("Billy the Kid4","Man");
        servants.put("Jeanne d'Arc (Alter)0","Self-Modification EX");
        servants.put("Jeanne d'Arc (Alter)1","Dragon WItch EX");
        servants.put("Jeanne d'Arc (Alter)2","Transient Dream A");
        servants.put("Jeanne d'Arc (Alter)3","Female");
        servants.put("Jeanne d'Arc (Alter)4","Man");
        servants.put("Angry Manjew0","Tawrich C");
        servants.put("Angry Manjew1","Zarich C");
        servants.put("Angry Manjew2","Annihilation Wish A");
        servants.put("Angry Manjew3","Male");
        servants.put("Angry Manjew4","Man");
        servants.put("Iskandar0","Charisma A");
        servants.put("Iskandar1","Tactics B");
        servants.put("Iskandar2","Conquerer of Lightning EX");
        servants.put("Iskandar3","Male");
        servants.put("Iskandar4","Man");
        servants.put("Emiya (Assassin)0","Magecraft B");
        servants.put("Emiya (Assassin)1","Grace of the Holy Grail A+");
        servants.put("Emiya (Assassin)2","Scapegoat C");
        servants.put("Emiya (Assassin)3","Male");
        servants.put("Emiya (Assassin)4","Man");

        servantsMap = Collections.unmodifiableMap(servants);
    }

    public static void main(String[] args) {
        Scanner rtz = new Scanner(System.in);
        Scanner rtz1 = new Scanner(System.in);
        //<editor-fold>
//        public static int atk, cardNum, NPdmgMult = 1, criticalModifier = 1, isCrit = 0, isNPcard = 0
//                , isSuperEffective = 0; //critmodifier is 1 if not, 2 if yes. isCrit 1 if crit 0 if not. same for np
//        double firstcardBonus = 0, cardDV = -1, cardMOD = 0; //cardmod is for buffs of type arts/buster/quick ste to zero for now
//        double atkMod = 0, enemyDefMod = 0; //atkMod for your servants attack modification, enemyDefMod for enemy defense modification....sidenote, note sure if this is where i want to put skill usage but might as well
//        double extraCardModifier = 1; //1 if not  abrave chain, 2 if just a normal brave chain, 3.5 if in a brave chain with 3 of the same cards
//        double specialDefMod = 0; //***NOTE ON THIS: only for bosses who have a special damage reduction on them ie gawain in camelot likely will be a while before i implement this***
//        double powerMod = 0; //not sure what this is, check forum/skill wording
//        double selfDamageMod = 0; //forum says not used yet, not sure if this is still true
//        double critDamageMod = 0; //additive modifications to how hard you crit (10% == .1)
//        double npDamageMod = 0; //same as above except for NPs NOTE NOT THE AMOUNT OF DAMAGE NP DOES
//        double superEffectiveModifier = 0; //not sure what this is about maybe something like "weak to enuma elish"
//        int dmgPlusAdd = 0; //dmg that is added like divinity and wavers 3rd skill
//        int enemyDmgCutAdd = 0; //dmg cut like wavers second skill and mashus first, might implement in the future
//        double busterChainMod = 0; //is .2 if it is a buster card in a buster chain, does not have to be buster brave
//        String classname, name, cardType, strIsbuster, classnameEnemy, nameEnemy;
//        boolean isBuster, isNP = false;
        //</editor-fold>
        boolean skill1Active = false, skill2Active = false, skill3Active = false;


        System.out.println("What is the class of the enemy?");
        classnameEnemy = rtz.nextLine();
        System.out.println("What is the name of the enemy?");
        nameEnemy = rtz.nextLine();
        System.out.println("What is the ATK of your servant?");
        atk = rtz.nextInt();
        rtz.nextLine();
        System.out.println("What is the class of your servant?");
        classname = rtz.nextLine();
        //TimeUnit.SECONDS.sleep(1);
        System.out.println("What is the name of your servant?");
        name = rtz.nextLine();
        System.out.println("Is the first card buster?(y/n)");
        strIsbuster = rtz.nextLine();
        System.out.println("Which card is this?(1,2,3)");
        cardNum = rtz.nextInt();
        rtz.nextLine();
        System.out.println("Type of card?");
        cardType = rtz.nextLine();
        System.out.println("Skill level 1?");
        skill1Level = rtz.nextInt();
        rtz.nextLine();
        System.out.println("Skill level 2?");
        skill2Level = rtz.nextInt();
        rtz.nextLine();
        System.out.println("Skill level 3?");
        skill3Level = rtz.nextInt();
        rtz.nextLine();





        if(isNP)
            NPdmgMult = 200; //change to the servants np level and dmg amount later
        if(strIsbuster.equals("y"))
            firstcardBonus = .5;
        if(cardType.equals("Arts"))
        {
            if(cardNum == 1)
                cardDV = 1.00;
            if(cardNum == 2)
                cardDV = 1.20;
            if(cardNum == 3)
                cardDV = 1.40;
        }
        if(cardType.equals("Buster"))
        {
            if(cardNum == 1)
                cardDV = 1.50;
            if(cardNum == 2)
                cardDV = 1.80;
            if(cardNum == 3)
                cardDV = 2.10;
        }
        if(cardType.equals("Quick"))
        {
            if(cardNum == 1)
                cardDV = .80;
            if(cardNum == 2)
                cardDV = .96;
            if(cardNum == 3)
                cardDV = 1.12;
        }
        Servant myServ = new Servant(atk, name, classname);
        if(skill1Active)
            Effects.activateSkill(servantsMap.get(name + "0"), skill1Level, myServ);
        if(skill2Active)
            Effects.activateSkill(servantsMap.get(name + "1"), skill2Level, myServ);
        if(skill3Active)
            Effects.activateSkill(servantsMap.get(name + "2"), skill3Level, myServ);
        Servant enemyServ = new Servant(0, nameEnemy, classnameEnemy);
        double classBonus = myServ.getClassMultiplier();
        double classAdvantage = myServ.getClassAdv(enemyServ);
        double randomlow = .9, randomhigh = 1.1;
        double endDamage = (atk * NPdmgMult *(firstcardBonus +
                (cardDV *(1+ myServ.getCardMOD())))) * classBonus * classAdvantage
                * myServ.getAtrributeAdv(enemyServ)* 1 * .23 *(1 + myServ.getAtkMod() - enemyDefMod)
                * criticalModifier * extraCardModifier * (1 - specialDefMod) *
                (1 + myServ.getPowerMod() + selfDamageMod + (myServ.getCritDamageMod() * isCrit) +
                        (myServ.getNpDamageMod() * isNPcard) * (1 + ((superEffectiveModifier -1) * isSuperEffective)))
                + myServ.getDmgPlusAdd() + enemyDmgCutAdd + (atk * busterChainMod);
        //the times one at the start is to make the high and low points easier to calculate. just mulitply the final result by .9 and 1.1 for low and high bounds
        System.out.println(endDamage);

    }


}
