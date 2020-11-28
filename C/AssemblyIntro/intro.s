.globl intro

#your full name:John Luke Denny
#your LSU ID number:896463927

intro:
        pushl   %ebp
        movl    %esp, %ebp
        pushl   %ebx
        #implement here
        #for loop to sum array parts

        #setting up variables

        movl 20(%ebp), %ebx #a[0]
        movl $0, %edx #stores sum
        movl $0, %eax #i
        .L1:
        addl (%ebx, %eax, 4), %edx #adds a[i] to l
        addl $1, %eax #i++
        cmpl $4, %eax #conditional
        jle .L1
        movl 24(%ebp), %ebx #setting %ebx to *l
        movl %edx, (%ebx) #l = sum

        #multiply k without multiplying
        movl 16(%ebp), %ebx # *k
        movl (%ebx), %edx # k
        leal (%edx, %edx, 4), %edx #k * 5
        movl %edx, (%ebx) #setting k to *k value

        #subtracts i from j and stores in return registrer
        movl 12(%ebp), %eax #%eax = j
        subl 8(%ebp), %eax # j - i

        #Returning stack to normal
        popl %ebx
        popl %ebp
        ret
