Во една фабрика потребно е производство на оцет - C2H4O2.

Во процесот на производство треба да се присутни 2 јаглеродни (C) атоми, 4 водородни (H) и 2 кислородни (О) атоми.
Молекулите на C2H4O2 се формираат една по една.

Секој од атомите е претставен преку соодветна класа, во која execute() методот треба да се извршува во позадина. Во
execute методот, треба да овозможите да се извршуваат паралелно максимум 2 јаглеродни (C) атоми, 4 водородни (H) и 2
кислородни (О) атоми. По влегувањето на секој од атомите треба да се испечати порака дека е присутен. Потоа, атомите
треба да чекаат додека сите потребни атоми за молекулата пристигнат, по што се печати Molecule bonding. од страна на
сите атоми. Откако ќе заврши спојувањето, секој од методите печати дека е завршен. На крајот треба само еден атом да
испечати Molecule created. и да овозможи креирање на нова молекула.

Вашата задача е во main методот да стартувате 20 јаглеродни, 40 водородни и 20 кислородни атоми, кои ќе се извршуваат во
позадина. Потоа треба да почекате 2 секунди за да завршат сите. Они кои не завршиле, треба да ги прекинете и да
испечатите Possible deadlock!. Ако сите завршиле без да ги прекинете, испечатете Process finished..

Вашата задача е да го дополните дадениот код според барањата на задачата, при што треба да внимавате не настане Race
Condition и Deadlock.



-----



A factory hires you to help synchronize the process of vinegar production - C2H4O2.

For the production process you need 2 carbon (C) atoms, 4 hydrogen (H) and 2 oxygen (О) atoms. The C2H4O2 molecules are
created one by one.

Each atom is represented with the corresponding class, where the execute() method should be executed in background. The
execute method should allow parallel execution of maximum 2 carbon (C) atoms, 4 hydrogen (H) and 2 oxygen (О) atoms.
After its execution, each atom should print that it is present. Then, the atoms should wait until all other atoms
required for the molecule are present, and than they all print Molecule bonding.. Afterwards, each of the methods should
print that it is done. At the end, only one atom should print Molecule created. and should enable the creation of the
next molecule.

Your task is to run in the background 20 carbon, 40 hydrogen and 20 oxygen atoms in the main method. Than, you need to
wait 2 seconds for all of them to finish. If some of the atoms do not finish within 2 seconds, you should print Possible
deadlock! and terminate the thread, and if all atoms have finished in the given time, you should print Process
finished..

Your task is to complete the starter code according to the above requirements, while making sure you avoid a Race
Condition or a Deadlock.