# Poly/ML 5.7.1 Release
## comandi ed esempi

### **COMANDI utili**

| comando | Descrizione |
| ------ | ------ |
| val | inizializza qualsiasi cosa. La variabile può essere di tipo : *intera, reale, negativa, carattere, stringa, booleana, unit value(singolo valore)*|
| ~ | numero negativo|
| if() then() else();| se allora, altrimenti (parentesi opzionali)|
| fun | inizializza funzione|
| fun rec | inizializza funzione ricorsiva|
| DA TROVARE | inizializza funzione ricorsiva|

#
## Le variabili

\> =input per polyML;

senza \> è il suo output;

**;** -> `sempre messo a fine riga.`

**dichiarare ed inizializzare una variabile**
```sh
> val x = 3;
val x = 3: int
```
Come notiamo Poly capisce che abbiamo inizializzato una variabile intera con *int*.
Gli altri tipi di variabili possono essere:
```sh
> val x = 3.0;
val x = 3.0: real
> val x = ~3;
val x = ~3: int
```
rispettivamente abbiamo creato una variabile *reale* ed una  *negativa*.

**operazioni tra variabili**

Vediamo alcuni esempi:
```sh
> 5+4;
val it = 9: int
> 5.2+4.3;
val it = 9.5: real
> (~5)+(~4);
val it = ~9: int
> 5.5*4.2;
val it = 23.1: real
> 5.3/2.0;
val it = 2.65: real
> (~5)*4;
val it = ~20: int
```
Se abbiamo già inizializzato le variabili e vogliamo utilizzarle per qualche operazione basta richiamarle. Vediamo alcuni esempi:
```sh
> val x =5;
val x = 5: int
> val y =2;
val y = 2: int
> x*y;
val it = 10: int
> y*(x*x);
val it = 50: int
```
Inoltre possiamo memorizzare su una nuova variabile il risultato di un operazione (Ovviamente la nuova varibile deve essere dello stesso tipo delle altre):
```sh
> val a= x+y;
val a = 7: int
```
**variabili booleane**
```sh
> val t= true;
val t = true: bool
> val f=false;
val f = false: bool
> 5=3;
val it = false: bool
```
La verifica dell'uguaglianza vale solo per gli interi.

**stampa variabili**

Per poter visualizzare il contenuto di una variabile basta richiamarla:
```sh
> a;
val it = 7: int
> f;
val it = false: bool
```
Come si nota le operazione `valgono SOLAMENTTE per variabili dello STESSO TIPO`. 

 #
 ## if then else
 Vediamo subito un esempio:
 ```sh
 > if 5>0 then true else false;
val it = true: bool
 ```
Al posto di true e false possiao mettere qualsiasi cosa ad esempio:
```sh
> if 5>0 then 10 else 7;
val it = 10: int
```
Possiamo memorizzare questa condione in una variabile:
```sh
> val ris= if 5>0 then 5 else 0;
val ris = 5: int
> ris;
val it = 5: int
```
#
## funzioni

#
 ### by kuper 01/03/2019
> fun power (n,m)= if m=0 then 1 else n*power(n,m-1);
val power = fn: int * int -> int
> val c= power(2,3);
val c = 8:int 
> val f= fn v=>2*v;
val f = fn: int -> int
> f 2;
val it = 4: int
> val y=3;int
val y = 3: int
# f 2;
val it = 4: int

> val f= fn x=>x+y;
val f = fn: int -> int
> f 2;
val it = 5: int

>val rec fact_tr =fn n => fn res => if n=0 then res else fact_tr(n-1)(n*res);
val fact_tr = fn: int -> int -> int

> val fact =fn n =>fact_tr n 1;
val fact = fn: int -> int

> fact_tr 5 1;
val it = 120: int

> fact_tr 2 5*4*3;
val it = 120: int

///da finire
> val fact =fn n =>
# let
# val rec fact_tr = fn n => fn res =># #
poly: : error: => expected but # was found
# if n=0 then res else fact_tr (n-1)(n*res);


val it = 1: int
> val derivative1 =fn(f,x) => (f(x)-f(x-0.00))/0.001;
val derivative1 = fn: (real -> real) * real -> real
> val derivative2= fn f =>(fn x=>(f(x)-f(x-0.001))/0.001);
val derivative2 = fn: (real -> real) -> real -> real

> val rec f= fn a => fn b=> a+b;
val f = fn: int -> int -> int
> fun f(x,y)=x*x+y*y;
val f = fn: int * int -> int
> fun derivative2 f x=(f(x)-f(x-0.001))/0.001;
val derivative2 = fn: (real -> real) -> real -> real
> 


> val introot m=let fun aux(k,m)=if k*k >m then k-1 else aux(k+1,m) in aux ;//da finire FOTO DYLAN
