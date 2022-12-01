import timeit

primes = [1] * 99999999
primes_length = len(primes)

# To do encryption and decrption


def populate_primes():
    primes[0] = 0
    for i in range(2, primes_length // 2):
        if primes[i - 1]:
            for j in range(i*2, primes_length, i):
                primes[j - 1] = 0


def is_prime(num):
    return primes[num - 1]


def find_primes_in_range(start, end):
    candidates = []
    for prime in range(start, end + 1):
        if primes[prime - 1]:
            candidates.append(prime)
    return candidates


def gcd_is_one(num1, num2):
    for i in range(2, min(num1, num2) + 1):
        if primes[i - 1] and (num1 % i == 0) and (num2 % i == 0):
            return 0
    return 1


def find_e(modulo):
    for e in range(2, modulo):
        if gcd_is_one(e, modulo):
            return e
    return 0


def find_d(e, modulo):
    # Euclid's algorithm
    m0 = modulo
    y = 0
    x = 1

    if (modulo == 1):
        return 0

    while (e > 1):
        quotient = e // modulo
        t = modulo

        # Euclid's algo
        modulo = e % modulo
        e = t
        t = y

        # Update y and x
        y = x - quotient * y
        x = t

    # Make x positive
    if (x < 0):
        x += m0

    return x


def mod_loop(num, mod_num):
    start_of_loop = num % mod_num
    loop_count = 1
    val = num
    for x in range(1, mod_num+1):
        val = val * num
        if val % mod_num == start_of_loop:
            return loop_count
        loop_count = loop_count + 1


def modulus(num, power, mod_to):
    if not num:
        return 0
    loop_count = mod_loop(num, mod_to)
    new_power = power % loop_count
    return num ** new_power % mod_to


def encrypt(N, e, message, output):
    lines = message.readlines()

    for line in lines:
        for char in line:
            if(char.isalpha()):
                asc = ord(char)
                asc = asc - ord('a') if (asc >= ord('a')) else asc - ord('A')
                output.write("{}\n".format(asc**e % N))
            else:
                output.write("\\{}\n".format(char))

        output.write("\n")


def decrypt(p, q, d, cipher, output):
    lines = cipher.readlines()
    n = p*q
    for line in lines:
        if(line[0] == '\\'):
            if(len(line) == 2):
                output.write(line[1:])
            else:
                output.write(line[1:-1])
        elif(line[0] == '\n'):
            continue
        else:
            message = int(line[:-1])
            message = modulus(message, d, n)
            message = message + ord('a')
            output.write("{}".format(chr(message)))

# To hack


def prime_factors(n):
    factors = get_primes(n)
    length = len(factors)
    p_and_q = []

    for p in range(length):
        if n % factors[p] == 0:
            for q in range(p, length):
                if factors[p] * factors[q] == N:
                    p_and_q.append((factors[p], factors[q]))

    return p_and_q


def get_primes(n):
    factors = []
    for z in range(n//2):
        if primes[z] == 1:
            factors.append(z + 1)
    return factors


def possible_d(n, e):
    p_and_q = prime_factors(n)
    d = []

    for pq in p_and_q:
        d.append(find_d(e, (pq[0] - 1)*(pq[1] - 1)))

    return d


if __name__ == "__main__":
    message = open("message.txt", "r")
    cipher = open("ciphertext.txt", "w")
    output = open("decipheredtext.txt", "w")

    print("Finding primes...")
    populate_primes()
    print("Found primes!")

    candidates = find_primes_in_range(1000, 10000)
    p = candidates[9]
    q = candidates[18]
    N = p * q
    print("Found N({}), p({}), and q({})!".format(N, p, q))

    print("Finding e...")
    e = find_e((p-1)*(q-1))
    print("Found e({})!".format(e))

    print("Finding d...")
    d = find_d(e, (p-1)*(q-1))
    print("Found d({})!\n".format(d))

    print("Public key :: [{}, {}]".format(N, e))
    print("Private key :: [{}, {}, {}]\n".format(d, p, q))

    print("Encrypting File...")
    encrypt(N, e, message, cipher)
    print("Encrypted File!")

    cipher.close()
    cipher = open("ciphertext.txt", "r")

    print("Decrypting File...")
    decrypt(p, q, d, cipher, output)
    print("Decrypted File!\n")

    output.close()
    cipher.close()
    message.close()

    print("Time to hack!")
    print("Public key :: [{}, {}]\n".format(N, e))
    print("Getting prime factors of N({})\nand trying to find d".format(N))
    hacked_d = possible_d(N, e)
    time = timeit.repeat(lambda: possible_d(N, e), number=10, repeat=5)
    print("Found possible d({}) in {} seconds".format(hacked_d, time))
