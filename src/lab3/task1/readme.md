Ве најмуваат од шоуто „Танц со студентите“, да имплементирате софтвер кој автоматски ќе ги контролира портите за
насочување на натпреварувачите.

Влезната порта директно води кон една од гардеробите, каде учесниците треба да се пресоблечат. Притоа, во секоја од
двете гардероби може паралелно да влезат повеќе учесници од ист пол, но не повеќе од 10.

По пресоблекувањето, учесниците чекаат да дојде произволен партнер, по што излегуваат од соблекувалната и влегуваат во
салата за танцување. Во салата паралелно може да танцуваат максимум три пара. По завршувањето на танцот, паровите
излегуваат од салата по што може да влезе нов пар на нивно место.

Во почетниот код, дефинирани се класите Masko и Zensko, кои ги симболизираат учесниците од соодветниот пол. Од секој од
типовите роботи паралелно се активни повеќе инстанци, кои може да танцуваат само еднаш.

Во имплементацијата, можете да ги користите следните методи од веќе дефинираната променлива show:

show.presobleci()
Го симболизира влегувањето во соблекувалната на учесниците и нивното пресоблекување Не смее паралелно да биде повикан
повеќе од 10 пати од исти пол на учесници show.tancuvaj()
Го симболизира почетокот на танцот Се повикува само од машките учесници, бидејќи тие водат при танцувањето Машкото пред
повикот, треба да се осигура дека е присутна учесничка која ќе му биде партнерка Не смее да има повеќе од три паралелни
повици на овој метод Претходно назначените методи манипулираат со споделен ресурс и ниту еден од нив не е атомичен.

Вашата задача е да ги имплементирате методите Masko.ucestvo() и Zensko.ucestvo() и init(). При имплементацијата, не
смеете да додадете try-catch блок во нив. Потребните семафори, глобални променливи и променливи за состојбата на
роботите треба да ги дефинирате самите.

Доколку имате грешка, ќе ја добиете пораката:

Procesot ne e sinhroniziran spored uslovite na zadacata

По што ќе ви се прикаже логот на повикување на акциите и настанатите грешки. Овој лог треба да ви послужи за увидување
на тоа каде имате грешка во извршувањето на вашата задача.

Напомена: Поради конкурентниот пристап за логирањето, можно е некои од пораките да не се на позицијата каде што треба да
се. Токму затоа, овие пораки користете ги само како информација, но не се ослонувајте на нив.

--------


You are hired by the show „Dancing with the students“, in order to implement a software solution which will
automatically control the gates which guide the contestants.

The entry gate leads directly to one of the changing rooms, where the contestants should change their clothes. You can
have at most 10 contestants in each changing room, at the same time.

After they change, the contestants wait for a random partner from the opposite gender, after which they exit the
changing room and enter the dancing room. The dancing room can have a maximum of three pairs dancing at the same time (
in parallel). After they finish dancing, the pairs exit the dancing room leaving space for a new pair to enter and start
dancing.

In the starter code, you have the definition of two classes, Masko (Male) and Zensko (Female), which represent
contestants from the corresponding gender. Each of the classes has multiple running instances, and each instance can
dance only once.

In your implementation, you can use the following methods from show:

show.presobleci()
Represents a contestant entering in the changing room and changing Cannot be called in parallel by more than 10
contestants from the same gender show.tancuvaj()
Represents the start of the dance Can only be called by male contestants, as they lead the dance The male contestant
should make sure that a female contestant is present as his partner before he makes the call There cannot be more than 3
parallel calls on this method These methods manipulate with a shared resource and are not atomic.

Your task is to implement the methods Masko.ucestvo(), Zensko.ucestvo() and init(). In your implementation, you can not
add try-catch blocks in them. You should define the necessary semaphores, global variables and state variables.

If you have an error, you will get this message:

The process in not synchronized according to the conditions in the task After that you will see the log of actions and
errors. Use this log to see what went wrong,

Note: Due to concurrent execution of the logging, it is possible that some of the messages in the log are not in the
position they are supposed to be. Therefore, use them only as guideline information, do not base all of the conclusions
on them.