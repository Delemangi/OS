Потребно е да се синхронизира креирањето на една единствена инстанца од класата Singleton. Повеќе нишки паралелно се
обидуваат да ја добијат инстанцата од Singleton, меѓутоа само една инстанца мора да биде креирана.

--------

Multiple threads are trying to access the same Singleton instance. However, you need to synchronize the creation of the
singleton instance, in a way that only one instance would exist.