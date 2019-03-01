# Poly/ML 5.7.1 Release
## comandi ed esercizi 01/03/2019 by Kuper

### **COMANDI utili**

| comando | Descrizione |
| ------ | ------ |
| val | inizializza qualsiasi cosa|
| int | inizializza intero|
| real | inizializza numero reale|
| ~ | numero negativo|
| fun | inizializza funzione|
| fun rec | inizializza funzione ricorsiva|
| DA TROVARE | inizializza funzione ricorsiva|

##
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
