Потребно е да направите систем за синхронизација на турнир во кошарка, кој се одржува според следните правила:

На турнирот учествуваат 100 кошаркари, кои произволно се групираат во тимови. Во салата истовремено може да влезат
најмногу 20 играчи. По влегувањето во салата, секој кошаркар треба да испечати Player inside.. Потоа кошаркарите треба
да се пресоблечат за што имаат на располагање кабина со капацитет 10, односно може да се пресоблекуваат 10 играчи во
исто време. При влегувањето во соблекувалната, треба да се испечати In dressing room.. По пресоблекувањето, играчите се
чекаат меѓусебно. Откако сите ќе завршат со пресоблекувањето, започнуваат со натпреварот, при што сите печатат Game
started.. Откако ќе заврши натпреварот, сите печатат Player done., а последниот го повикува печати Game finished., со
што означува дека салата е слободна. Потоа, во салата може да влезат нови 20 играчи и да започне нов натпревар.

Во почетниот код кој е даден, дефинирани се класите BasketballTournament и Player. Во main методот од класата
BasketballTournament потребно е да стартувате 100 играчи, кои се репрезентирани преку класата Player. Потоа секој од
играчите треба да започне да го извршува претходно дефинираното сценарио во позадина. Однесувањето на играчите треба да
го дефинрате во execute методот од Player класата, кој треба да се извршува паралелно кај сите играчи. По стартувањето
на сите играчи, во main треба да се чека секој од играчите да заврши за 5 секунди (5000 ms). Доколку некој од играчите
не заврши за 5 секунди, треба да се испечати Possible deadlock! и да се терминира, а доколку сите играчи завршиле во
предвиденото време, да се испечати Tournament finished..

Вашата задача е да го дополните дадениот код според барањата на задачата, при што треба да внимавате не настане Race
Condition и Deadlock.

--------
You need to implement a system for synchronizing a basketball tournament according to the following rules:

There are 100 players participating to the tournament grouped in arbitrary teams. At most 20 players can enter in the
tournament arena at once. After the enterence in the arena, each player should print Player inside.. Then the players
should change their clothes in a dressing room with capacity of 10, meaning that at most 10 players can be in the
dressing room at once. When the players enter in the dressing room, they should print In dressing room.. When a player
exits from the dressing room, it waits for the other players in order to start with the game. After all players are
ready, the game can start, and every player should print Game started.. After the game is over, all players should print
Player done., and the last one should print Game finished., denoting that the arena is free for another game. Then,
another 20 players can enter in the arena.

The classes BasketballTournament and Payer are given in the starter code below. In the main method from the class
BasketballTournament you should start 100 basketball players, which are represented with the class Payer. Then, each of
the players should start executing the previously defined scenario in background. The players behavior should be
implemented in the execute method from the Payer class, which should be executed in parallel for all players. After
starting all players, the main method should wait for each of the players to finish for 5 seconds (5000 ms). If some of
the players does not finish for 5 seconds, you should print Possible deadlock! and terminate the thread, and if all
payers finished in the given time, you should print Tournament finished..

Your task is to complete the code provided below according to the requirements, and be careful not to create a Race
Condition or a Deadlock.