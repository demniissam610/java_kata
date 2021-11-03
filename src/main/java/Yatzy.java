import java.util.Arrays;
import java.util.stream.IntStream;

public class Yatzy {

    // En terme de lisiblité, c'est mieux de commencer par déclarer les attributs ensuite le constructeur
    // Accessibilité privé et final car il ne changera pas de valeur
    private final int[] dice;

    // Factorisation de ce tableau car c'est utilisé dans plusieurs endroits et à chaque fois il est reconstruit => on le construit une se
    // seule fois dans le constructeur et réutilise dans les différentes méthodes
    // Accessibilité privé et final car il ne changeras pas de valeur
    // tallies est plus parlant que count
    private final int[] tallies;

    /**
     * constructeur
     *
     * @param d1 valeur du dé n° 1
     * @param d2 valeur du dé n° 2
     * @param d3 valeur du dé n° 3
     * @param d4 valeur du dé n° 4
     * @param d5 valeur du dé n° 5
     */
    public Yatzy(int d1, int d2, int d3, int d4, int d5) // Ce n'est pas recommandé de nommer une variable par un nom commançant par _
    {
        /*
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = _5;
         */
        // On stocke chaque valeur des dés dans une case du tableau dans l'ordre donné
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;

        // le tableau doit aller de 1 à 6
        // pour chaque indice correspondant à la valeur du dé, on compte le nombre d'occurences
        tallies = new int[6];
        for (int die : dice)
            tallies[die - 1]++;
    }

    /**
     * On utilise l'attribut dice qui contient les valeurs des dés au lieu de les passer en paramètres
     * méthode non statique : on instanciera la classe et utilisera la méthode de l'objet au lieu de l'appeler via la classe
     * on peut simplifier la méthode en utilisant les streams
     * retourne la somme des valeurs des dés
     *
     * @return
     */
    public int chance() {
        /*
        int total = 0;
        total += d1;
        total += d2;
        total += d3;
        total += d4;
        total += d5;
        return total;
        */
        return Arrays.stream(dice).sum();
    }

    /**
     * On n'a pas besoin de paramètres, on utiliseras l'attribut qui contient le nombre d'occurence pour chaque valeur obtenue
     * méthode non statique : on instanciera la classe et utilisera la méthode de l'objet au lieu de l'appeler via la classe
     * on peut simplifier la méthode en utilisant les streams et lamdas
     * retourne 50 si il y a au moins une valeur 5 dans le tableau tallies (c-à-d on a 5 occurences d'une valeur de dé)
     * sinon retourne 0
     *
     * @return
     */
    public int yatzy() {
        /*
        int[] counts = new int[6];
        for (int die : dice)
            counts[die-1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
         */
        if (Arrays.stream(tallies).anyMatch(x -> x == 5)) {
            return 50;
        }
        return 0;
    }

    /**
     * Factoriser le contenu des méthodes ones, twos, threes, fours, fives et sixes en passant la valeur en paramètres
     * Fonction private car on ne va l'utiliser que dans cette classe
     * on peut simplifier la méthode en utilisant les streams et lamdas
     * retourne la somme des dés ayant la valeur passée en paramètres
     * utilisés dans ones, twos, threes, fours, fives et sixes
     *
     * @param value
     * @return
     */
    private int getScore(int value) {
        return Arrays.stream(dice).filter(x -> x == value).sum();
    }

    /**
     * On utilise l'attribut dice qui contient les valeurs des dés au lieu de les passer en paramètres
     * méthode non statique : on instanciera la classe et utilisera la méthode de l'objet au lieu de l'appeler via la classe
     * On n'a pas besoin de paramètres, on utiliseras l'attribut qui contient le nombre d'occurence pour chaque valeur obtenue
     *
     * @return
     */
    public int ones() {
        /*
        int sum = 0;
        if (d1 == 1) sum++;
        if (d2 == 1) sum++;
        if (d3 == 1) sum++;
        if (d4 == 1) sum++;
        if (d5 == 1)
            sum++;

        return sum;
         */
        return getScore(1);
    }

    /**
     * On utilise l'attribut dice qui contient les valeurs des dés au lieu de les passer en paramètres
     * méthode non statique : on instanciera la classe et utilisera la méthode de l'objet au lieu de l'appeler via la classe
     * On n'a pas besoin de paramètres, on utiliseras l'attribut qui contient le nombre d'occurence pour chaque valeur obtenue
     *
     * @return
     */
    public int twos() {
        /*
        int sum = 0;
        if (d1 == 2) sum += 2;
        if (d2 == 2) sum += 2;
        if (d3 == 2) sum += 2;
        if (d4 == 2) sum += 2;
        if (d5 == 2) sum += 2;
        return sum;
         */
        return getScore(2);
    }

    /**
     * On utilise l'attribut dice qui contient les valeurs des dés au lieu de les passer en paramètres
     * méthode non statique : on instanciera la classe et utilisera la méthode de l'objet au lieu de l'appeler via la classe
     * On n'a pas besoin de paramètres, on utiliseras l'attribut qui contient le nombre d'occurence pour chaque valeur obtenue
     *
     * @return
     */
    public int threes() {
        /*
        int s;
        s = 0;
        if (d1 == 3) s += 3;
        if (d2 == 3) s += 3;
        if (d3 == 3) s += 3;
        if (d4 == 3) s += 3;
        if (d5 == 3) s += 3;
        return s;
         */
        return getScore(3);
    }

    /**
     * On utilise l'attribut dice qui contient les valeurs des dés au lieu de les passer en paramètres
     * méthode non statique : on instanciera la classe et utilisera la méthode de l'objet au lieu de l'appeler via la classe
     * On n'a pas besoin de paramètres, on utiliseras l'attribut qui contient le nombre d'occurence pour chaque valeur obtenue
     *
     * @return
     */
    public int fours() {
        /*
        int sum;
        sum = 0;
        for (int at = 0; at != 5; at++) {
            if (dice[at] == 4) {
                sum += 4;
            }
        }
        return sum;
         */
        return getScore(4);
    }

    /**
     * On utilise l'attribut dice qui contient les valeurs des dés au lieu de les passer en paramètres
     * méthode non statique : on instanciera la classe et utilisera la méthode de l'objet au lieu de l'appeler via la classe
     * On n'a pas besoin de paramètres, on utiliseras l'attribut qui contient le nombre d'occurence pour chaque valeur obtenue
     *
     * @return
     */
    public int fives() {
        /*
        int s = 0;
        int i;
        for (i = 0; i < dice.length; i++)
            if (dice[i] == 5)
                s = s + 5;
        return s;
         */
        return getScore(5);
    }

    /**
     * On utilise l'attribut dice qui contient les valeurs des dés au lieu de les passer en paramètres
     * méthode non statique : on instanciera la classe et utilisera la méthode de l'objet au lieu de l'appeler via la classe
     * On n'a pas besoin de paramètres, on utiliseras l'attribut qui contient le nombre d'occurence pour chaque valeur obtenue
     *
     * @return
     */
    public int sixes() {
        /*
        int sum = 0;
        for (int at = 0; at < dice.length; at++)
            if (dice[at] == 6)
                sum = sum + 6;
        return sum;
         */
        return getScore(6);
    }

    /**
     * méthode non statique : on instanciera la classe et utilisera la méthode de l'objet au lieu de l'appeler via la classe
     * On n'a pas besoin de paramètres, on utiliseras l'attribut qui contient le nombre d'occurence pour chaque valeur obtenue
     * Si on a plusieur paires, on retourne q'un seul (s est le plus grand car c'est ordonné)
     *
     * @return
     */
    public int scorePair() {
        /*
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6-at-1] >= 2)
                return (6-at)*2;
        return 0;
         */
        return getSumOccurencesByNbOccurences(2).reduce((a, b) -> b).orElse(0);
    }

    /**
     * méthode non statique : on instanciera la classe et utilisera la méthode de l'objet au lieu de l'appeler via la classe
     * On n'a pas besoin de paramètres, on utiliseras l'attribut qui contient le nombre d'occurence pour chaque valeur obtenue
     * retourne la somme des pairs si on a exactement 2 paires sinon 0
     *
     * @return
     */
    public int twoPair() {
        /*
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
         */
        return getSumOccurencesByNbOccurences(2).count() == 2 ? getSumOccurencesByNbOccurences(2).sum() : 0;
    }

    /**
     * méthode non statique : on instanciera la classe et utilisera la méthode de l'objet au lieu de l'appeler via la classe
     * On n'a pas besoin de paramètres, on utiliseras l'attribut qui contient le nombre d'occurence pour chaque valeur obtenue
     * retourne la somme des valeurs présents 4 fois
     *
     * @return
     */
    public int fourOfAKind() {
        /*
        int[] tallies;
        tallies = new int[6];
        tallies[_1-1]++;
        tallies[_2-1]++;
        tallies[d3-1]++;
        tallies[d4-1]++;
        tallies[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;
        return 0;
         */
        return getSumOccurencesByNbOccurences(4).sum();
    }

    /**
     * méthode non statique : on instanciera la classe et utilisera la méthode de l'objet au lieu de l'appeler via la classe
     * On n'a pas besoin de paramètres, on utiliseras l'attribut qui contient le nombre d'occurence pour chaque valeur obtenue
     * retourne la somme des valeurs présents 4 fois
     *
     * @return
     */
    public int threeOfAKind() {
        /*
        int[] t;
        t = new int[6];
        t[d1-1]++;
        t[d2-1]++;
        t[d3-1]++;
        t[d4-1]++;
        t[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i+1) * 3;
        return 0;
         */
        return getSumOccurencesByNbOccurences(3).sum();
    }

    /**
     * Factoriser le contenu des méthodes en passant la valeur en paramètres
     * Fonction private car on ne va l'utiliser que dans cette classe
     * on peut simplifier la méthode en utilisant les streams et lamdas
     * on multiplie les deuxième valeurs ayant un nombre d'occurences >= la valeur passée en paramètre par le nombre lui même
     * pour nous servir dans score_pair, two_pair, four_of_a_kind, three_of_a_kind (ex 4+4 = 4*2, 6+6 = 6*2, 5+5+5 = 5*3, 1+1+1+1 = 1*4 ),
     *
     * @param nb
     * @return
     */
    private IntStream getSumOccurencesByNbOccurences(int nb) {
        return getOccurencesByOccurence(nb).map(x -> (x + 1) * nb);
    }

    /**
     * Factoriser le contenu des méthodes en passant la valeur en paramètres
     * Fonction private car on ne va l'utiliser que dans cette classe
     * IntStream.range(start, end) retourne une séquence ordonnée de IntStream allant de start jusqu'à end avec un incrément de 1 (remplace une boucle for)
     * On filtre après les valeurs ayant un nombre d'occurences >= la valeur passée en paramètre
     * retourne donc les valeurs ayant un nombre d'occurences > nb
     *
     * @param nb
     * @return
     */
    private IntStream getOccurencesByOccurence(int nb) {
        return IntStream.range(0, tallies.length).filter(x -> tallies[x] >= nb);
    }

    /**
     * méthode non statique : on instanciera la classe et utilisera la méthode de l'objet au lieu de l'appeler via la classe
     * On n'a pas besoin de paramètres, on utiliseras l'attribut qui contient le nombre d'occurence pour chaque valeur obtenue
     * on peut simplifier la méthode en utilisant les streams et lamdas
     * si on a 5 valeurs successifs de 1 à 5 on retourne 15 sinon 0
     *
     * @return
     */
    public int smallStraight() {
        /*
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
         */
        if (Arrays.stream(tallies).limit(5).allMatch(x -> x == 1)) {
            return 15;
        }
        return 0;
    }

    /**
     * méthode non statique : on instanciera la classe et utilisera la méthode de l'objet au lieu de l'appeler via la classe
     * On n'a pas besoin de paramètres, on utiliseras l'attribut qui contient le nombre d'occurence pour chaque valeur obtenue
     * si on a 5 valeurs successifs de 2 à 6 on retourne 20 sinon 0
     * on peut simplifier la méthode en utilisant les streams et lamdas
     *
     * @return
     */
    public int largeStraight() {
        /*
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
         */
        if (Arrays.stream(tallies).skip(1).allMatch(x -> x == 1)) {
            return 20;
        }
        return 0;
    }

    /**
     * méthode non statique : on instanciera la classe et utilisera la méthode de l'objet au lieu de l'appeler via la classe
     * On n'a pas besoin de paramètres, on utiliseras l'attribut qui contient le nombre d'occurence pour chaque valeur obtenue
     * on peut simplifier la méthode en utilisant les streams et lamdas
     * on calcule les valeurs ayant un nombre d'occurences > nb, on les multiplie par leur nb d'occurences et
     * si on a quatre valeurs qui sont pas présent, on retourne la somme sinon on retourne 0
     *
     * @return
     */
    public int fullHouse() {
        /*
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
         */
        return Arrays.stream(tallies).filter(x -> x == 0).count() == 4 ? getOccurencesByOccurence(2).map(x -> (x + 1) * tallies[x]).sum() : 0;
    }
}



