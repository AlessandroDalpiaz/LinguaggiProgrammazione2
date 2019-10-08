# Poly/ML 5.7.1 Release

## comandi ed esempi

### **COMANDI utili**

| Comando                                                                                 | Descrizione                                                                                                                                       |
| --------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------- |
| `val`                                                                                   | inizializza qualsiasi cosa. La variabile può essere di tipo : _intera, reale, negativa, carattere, stringa, booleana, unit value(singolo valore)_ |
| `~`                                                                                     | numero negativo                                                                                                                                   |
| `if()` `then()` `else()`                                                                | se allora, altrimenti (parentesi opzionali)                                                                                                       |
| `fun NOME(INPUT)=ESPRESSIONE`                                                           | inizializza funzione                                                                                                                              |
| `VARIABILE= fn INPUT=>ESPRESSIONE`                                                      | inizializza una funzione all'interno di una variabile                                                                                             |
| `val rec`                                                                               | inizializza --- ricorsiva                                                                                                                         |
| `case VARIABILE of VARIABILE=>CONSEGUENZA \|VARIABILE =>CONSEGUENZA \|_(*DEFAULT*)=>3;` | switch case                                                                                                                                       |
| `goto`                                                                                  | Salto nel ciclo                                                                                                                                   |

http://sml-family.org/Basis/list.html

---

## Le variabili

`>` =input per polyML;

senza `>` è il suo output;

`;` -> `sempre messo a fine riga.`

**dichiarare ed inizializzare una variabile**

```sml
> val x = 3;
val x = 3: int
```

Come notiamo Poly capisce che abbiamo inizializzato una variabile intera con `int`.
Gli altri tipi di variabili possono essere:

```sml
> val x = 3.0;
val x = 3.0: real
> val x = ~3;
val x = ~3: int
```

rispettivamente abbiamo creato una variabile _reale_ ed una _negativa_.

**Operazioni tra variabili**

Vediamo alcuni esempi:

```sml
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

```sml
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

```sml
> val a= x+y;
val a = 7: int
```

**Variabili booleane**

```sml
> val t= true;
val t = true: bool
> val f=false;
val f = false: bool
> 5=3;
val it = false: bool
```

La verifica dell'uguaglianza vale solo per gli interi.

**Stampa variabili**

Per poter visualizzare il contenuto di una variabile basta richiamarla:

```sml
> a;
val it = 7: int
> f;
val it = false: bool
```

Come si nota le operazione `valgono SOLAMENTTE per variabili dello STESSO TIPO`.

---

## if then else

Vediamo subito un esempio:

```sml
> if 5>0 then true else false;
val it = true: bool
```

Al posto di true e false possiao mettere qualsiasi cosa ad esempio:

```sml
> if 5>0 then 10 else 7;
val it = 10: int
```

Possiamo memorizzare questa condizione in una variabile:

```sml
> val ris= if 5>0 then 5 else 0;
val ris = 5: int
> ris; (*RICHIAMO*)
val it = 5: int
```

---

## Funzioni

Per esempio vogliamo creare una funzione che permetta di elevare un numero x alla n dati come input:

```sml
> fun eleva(x,n)=if n=0 then 1 else x*(eleva(x,n-1));
val eleva = fn: int * int -> int
> eleva(5,2);   (*RICHIAMO*)
val it = 25: int
(*--OPPURE POSSO CREARE UN'UNICA VARIABILE PER IL SUO INPUT--*)
> val x=(2,3);             (* una variabile a 2 parametri*)
val x = (2, 3): int * int
> eleva(x);                (* richiamo con solo X *)
val it = 8: int
```

Inoltre possiamo assegnare il risultato di una variabile:

```sml
> val ris= eleva(3,3);
val ris = 27: int
```

Oppure creare una funzione "al volo al suo interno",cioè:

```sml
> val y=2;
val y = 2: int
> val f= fn x=>x+y;
val f = fn: int -> int

> f 4; (*richiamiamo la funzione + INPUT*)
val it = 6: int
```

Una _funzione_ dentro un'altra _funzione_

```sml
> fun alcubo(x)= eleva(x,3);
val alcubo = fn: int -> int

> alcubo(3);(*richiamiamo la funzione + INPUT*)
val it = 27: int
```

---

## Switch

Come al solito lo switch ha i vari case e quello di default. Vediamo un esempio:

```sml
> fun f(x)= case x of
# 1=>1      (*PRIMO CASO*)
# |2=>2     (*SECONDO CASO*)
# |_=>3;    (*CASO DI DEFAULT*)
val f = fn: int -> int
(*TEST*)
> f(19);
val it = 3: int
> f(2);
val it = 2: int
```

---

## Goto

Alcuni linguaggi permettono di eseguire salti all’interno del for per mezzo del comando. Vediamo un esempio:

```sml
while true do{
read(X) ;
if X = end_of_file then goto fine;
elabora ( X ) ;
}
fine: (*continuo del codice oppure una seconda funzione*)
```

---

(lamdax.x(xy))(lamdaz.zx) ==> f(x)=(x.xy)\*f(z)=z.x
--> x(xy)(barrato) (lamdazzx)((lamdazzx)y)'

### Kuper 12/04/2019

```sml
esercizio da capire e finire
val rec test= fn empty => (fn f=>0)
| cons(l,l) => (fn f)=>.....

datatype list = empty | cons of (int*list);
fun initlist

val rec member = fn
empty => (fn i =>0)
| cons(a,l) = fn 0 => a
| i => member l(i-1);

val a cons(1,cons(2,cons(3,empty))); # inizializzo
val b cons(1,cons(2,cons(1,empty)));

member b 2: # richiama l elemento 2 in b
val rec pal=fn
empty => (fn i => true)
|cons(a,l) => fn i => (
if a<=1 then true else a= member l (i-1)) and also pal 1 (i-2));

type checking

fun comb(n,m)=
if m=0 orelse m=n then 1
else comb(n-1,m)+ comb (n-1,m-1);

sum[3,4,5];
String.^("ab","cd");
val concat = foldr String.^ "";
concat ["ab","cd","ef"]

fun lenght l = foldl (fn(_,a => a+1) 0 l;
lenght [1,3,4]

1::[2,3];
List.:: (1, [2,3]);

fun rev l = foldl List.:: [] l;
rev [1,2,3]

fun map f l = foldr (fn (x,a) => (f x)::a) [] l;
val f = fn x => x*x;
map f [1,2,3];
val f = fn x => x<0
fun filter f l= foldr fn(x,a) => if f x then x::a else a) [] l;
filter f [1,~1,2,~3];

List.tabulate (5,(fn n =>n*n));
val square = fn n =>n*n;
List.tabulate(10,square)


```

---

### Kuper 29/03/2019

```sml
val test = fn f => fn l => List.lenght (List.filter f l);
val greatertwo = fn n => n>2;
val a ={1,2,3,4,5,6};//quadre
test greatertwo a ;
eq [1,2] [2,1];
a List.rev a;
val palindrome = fn l => l=List.rev l;
palindrome a;
a;
val a = []..
fun x ->) 12 ;===> int: 12
fun x y -> x y

let f2 x y = (x @(y x))

val rec copy(a:int,b) = if(a=0) then [] else copy(a-1,b)

val rec sumlist = fn([].[]) => []
| (|1.[]) => |1
| ([].|2) => |2
| (|1,|2) => ((List.hd |1) +(List.hd l2))::sumList((List.tl l1),(List.tl l2));

val rec isin =fn x => (fn [] => false
| y::l => if y =x then true else isin x l);

val rec remove_dup = fn [] => []
| y::l => if (isin y l) then remove_dup | else y::(remove_dup l);

remove_dup [[1],[1,2],[1,2];
remove_dup ["a","a","a"];

fun first_list [] =[]
| first_list((x,y)::l) =x::first_list l;
first_list [(1,2),(1,3)];

```

---

### Kuper 29/03/2019

```sml
> val meteo = fn x => case x of
# 1 => "sole"
# |2 => "neve"
# |_ => "non lo so";
> val rec containedin = fn (l1,l2) => if isempty (l1) then true
# else ismembre (car l1,l2) andalso containedin.....
> val rec sum = fn empty =>0
# | cons(a,l) => a+sum l;
poly: : error: Constructor (cons) has not been declared Found near cons (a, l)
Static Errors
> val x = [1,2];
val x = [1, 2]: int list
> val x =[1,2.2];
poly: : error: Elements in a list have different types.
  Item 1: 1 : int
  Item 2: 2.2 : real
  Reason:
     Can't unify int (*In Basis*) with real (*In Basis*)
        (Different type constructors)
Found near [1, 2.2]
Static Errors
> val x=(2,2.2);
val x = (2, 2.2): int * real
> val a=[];
val a = []: 'a list
> it
# ;
val it = 4: int
> itt;
val it = [6, 7, 8]: int list
> rev itt;
val it = [8, 7, 6]: int list
> val it =[1,3,4];
val it = [1, 3, 4]: int list
> List.revAppend(it,itt);
val it = [4, 3, 1, 6, 7, 8]: int list
> [it,itt];
val it = [[4, 3, 1, 6, 7, 8], [6, 7, 8]]: int list list
> it@itt;
poly: : error: Type error in function application.
  Function: @ : int list list * int list list -> int list list
  Argument: (it, itt) : int list list * int list
  Reason:
     Can't unify int list (*In Basis*) with int (*In Basis*)
        (Different type constructors)
Found near it @ itt
Static Errors
> fun square n=n*n;
val square = fn: int -> int
> it;
val it = [[4, 3, 1, 6, 7, 8], [6, 7, 8]]: int list list
> itt;
val it = [6, 7, 8]: int list
> List.map square itt;
val it = [36, 49, 64]: int list
> it
# ;
val it = [36, 49, 64]: int list
> itt;
val it = [6, 7, 8]: int list
> List.map square it;
val it = [36, 49, 64]: int list
> fun sum (l:int list):int case l of
poly: : error: = expected but case was found
# [] => 0
# | x::xs => x^(concat xs);
Static Errors
> fun sum (l:int list):int = case l of
# [] => 0 | x::xs => x^(concat xs);
poly: : error: Clauses in case have different types.
  Clause 1: [] => 0 : string list -> int
  Clause 2: x :: xs => x ^ (concat xs) : string list -> string
  Reason:
     Can't unify int (*In Basis*) with string (*In Basis*)
        (Different type constructors)
Found near case l of [] => 0 | x :: xs => x ^ (concat xs)
Static Errors
> fun sum (l:int list):int = case l of
# [] => 0 | x::xs => x+(sum xs);

```

### Kuper 15/03/2019

da int to real

```sml
> fun g(m:int)= fn f:int->real => if m <= 0 then 0.0 else f(m-1) + g(m-1) f;
val g = fn: int -> (int -> real) -> real
> fun toreal(i:int) = real(i);
val toreal = fn: int -> real
> g 7 toreal;
val it = 21.0: real
> fun minimun f 0 = raise Minimun
# |minimun f m = let fun min2(x,y): real = if x<y then x else y
# fun minn(i,z) =
# if i=m then z else minn(i+1,min2(z,f i))
# in minn(1, f 0) end;
val minimun = fn: (int -> real) -> int -> real
> fun minimun2 g n m = minimun (fn i=>minimun(fn j => g(i,j)) n ) m;
val minimun2 = fn: (int * int -> real) -> int -> int -> real

> type currency =string;
eqtype currency

> type money = real* currency;
type money = real * currency
> fun convert (from,to)=
# let val toeur= fn
#   (x,"eur") => x
# | (x,"usd") => x/1.05 eqtype currency (*da errore ma è uguale*)

# datatype money = Eur of real |........
> datatype list = leaf of int | node of (int*list);
datatype list = leaf of int | node of int * list
> val rec Len = fn leaf _ => 1
| node(_,l)=>1+Len l;
val rec Concat = fn (leaf v,l) =node(v,l)
| node(v,l1), l2) => node (v, Concat(l1,l2));
fn x =>x;
datatype 'a oerror =error ! value of ' a;
value 5;
altro....


```

### Kuper 01/03/2019

```sml
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
f 2;
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
> val introot m=let fun aux(k,m)=if k*k >m then k-1 else aux(k+1,m) in aux ;//da finire FOTO DYLAN
```
