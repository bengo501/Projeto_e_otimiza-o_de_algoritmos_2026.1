def mult_nat(vezes, nro):
    if vezes < 0:
        raise ValueError("Número negativo")
    elif vezes == 0:
        return 0
    elif vezes == 1:
        return nro
    else:
        return mult_nat(vezes - 1, nro) + nro


def soma_incr(n1, n2):
    if n1 < 0 or n2 < 0:
        raise ValueError()
    elif n1 == 0 and n2 == 0:
        return 0
    elif n1 == 0:
        return soma_incr(n1, n2 - 1) + 1
    elif n2 == 0:
        return soma_incr(n1 - 1, n2) + 1
    else:
        return soma_incr(n1 - 1, n2 - 1) + 2

def soma_incr_alt(n1, n2):
    if n1 < 0 or n2 < 0:
        print(n1, n2)
        raise ValueError()
    elif n1 == 0 and n2 == 0:
        return 0
    elif n1 == 0:
        return soma_incr_alt(n1, n2 - 1) + 1
    else:
        return soma_incr_alt(n1 - 1, n2) + 1


def soma_incr_alt2(n1, n2):
    if n1 < 0 or n2 < 0:
        raise ValueError()
    elif n1 > 0:
        return soma_incr_alt2(n1 - 1, n2) + 1
    elif n2 > 0:
        return soma_incr_alt2(n1, n2 - 1) + 1
    else:
        return 0

def soma_serie(n):
    if n < 0:
        raise ValueError("Nro negativo!")
    elif n == 1:
        return 1
    else:
        return soma_serie(n-1) + 1/n

def reverse_str(s):
    if len(s) <= 1:
        return s
    else:
        return reverse_str(s[1:]) + s[0]

def f_function(n):
    if n < 0:
        raise ValueError("Nro negativo.")
    elif n in (1, 2):
        return n
    else:
        return 2*f_function(n-1) + 3*f_function(n-2)

def ackerman(m, n):
    if m == 0:
        return n + 1
    elif m != 0 and n == 0:
        return ackerman(m-1, 1)
    else:
        return ackerman(m-1, ackerman(m, n-1))

def vet_slice(vet, ini, fim):
    if ini >= fim:
        return []
    elif ini < 0 or fim > len(vet):
        raise ValueError("Indices fora do intervalo permitido!")
    else:
        return [vet[ini]] + vet_slice(vet, ini+1, fim)

def soma_vet1(vet, pos=0):
    if pos < 0 or pos >= len(vet) or vet is None:
        raise ValueError("Nro negativo!")
    elif len(vet) == 0:
        return 0
    elif pos == len(vet) - 1:
        return vet[pos]
    else:
        return vet[pos] + soma_vet1(vet, pos + 1)

def soma_vet2(vet):
    if len(vet) == 0:
        return 0
    else:
        return vet[0] + soma_vet2(vet_slice(vet, 1, len(vet)))

def mult_vet1(vet, pos=0):
    if pos < 0 or pos >= len(vet) or vet is None:
        raise ValueError("Nro negativo!")
    elif len(vet) == 0:
        return 0
    elif pos == len(vet) - 1:
        return vet[pos]
    else:
        return vet[pos] * mult_vet1(vet, pos + 1)

def mult_vet2(vet):
    if len(vet) == 0:
        return 0
    elif len(vet) == 1:
        return vet[0]
    else:
        return vet[0] * mult_vet2(vet_slice(vet, 1, len(vet)))

print(f"6 * 4 = {mult_nat(6, 4)}")

print(f"6 + 4 = {soma_incr(6, 4)}")
print(f"6 + 4 = {soma_incr_alt(6, 4)}")
print(f"6 + 4 = {soma_incr_alt2(6, 4)}")

for i in range(1, 6):
    print(f"n = {i}   serie = {soma_serie(i)}")

print(f"\nCasa -> {reverse_str('Casa')}")
print(f"Orgânico -> {reverse_str('Orgânico')}")
print(f"Paralelo -> {reverse_str('Paralelo')}")
print(f" -> {reverse_str('')}")
print(f"Arara -> {reverse_str('Arara')}")

print("")
for i in range(1, 6):
    print(f"n = {i}   fFunction = {f_function(i)}")

print("")
print(f"m = 0, n = 0   --> {ackerman(0, 0)}")
print(f"m = 0, n = 1   --> {ackerman(0, 1)}")
print(f"m = 1, n = 0   --> {ackerman(1, 0)}")
print(f"m = 0, n = 2   --> {ackerman(0, 2)}")
print(f"m = 2, n = 0   --> {ackerman(2, 0)}")
print(f"m = 1, n = 1   --> {ackerman(1, 1)}")
print(f"m = 1, n = 2   --> {ackerman(1, 2)}")
print(f"m = 1, n = 3   --> {ackerman(1, 3)}")
print(f"m = 2, n = 1   --> {ackerman(2, 1)}")
print(f"m = 3, n = 1   --> {ackerman(3, 1)}")
print(f"m = 3, n = 2   --> {ackerman(3, 2)}")
print(f"m = 2, n = 3   --> {ackerman(2, 3)}")

vet = [1,2,3,4,5,6,7,8,9,10]
print(f"\nSoma de [1,2,3,4,5,6,7,8,9,10] = {soma_vet1(vet)}")
vet = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]
print(f"Soma de [10, 10, 10, 10, 10, 10, 10, 10, 10, 10] = {soma_vet1(vet)}")

vet = [2, 2, 2, 2, 2, 2, 2, 2, 2, 2]
print(f"\nProduto de [2, 2, 2, 2, 2, 2, 2, 2, 2, 2] = {mult_vet1(vet)}")
print(f"Produto de [2, 2, 2, 2, 2, 2, 2, 2, 2, 2] = {mult_vet2(vet)}")