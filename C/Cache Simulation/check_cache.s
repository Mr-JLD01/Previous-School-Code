#This function will check whether the given cache
#stores the data at the given memory address. If the
#cache stores the data at the given memory address
#(i.e., cache hit), this function will return the
#stored data. Otherwise (i.e., cache miss), this
#function will return 0xFF.

.global check_cache
#John Luke Denny
#CSC 3501
check_cache:
        #set up
        pushl   %ebp
        movl    %esp,   %ebp
        pushl   %edx
        pushl   %ebx

        #I think overall logic is correct, but how to access the correct registers is where I am messing up
        #Bulk code, Using a single set with four lines simulates cache hits
        movb    2(%ebp), %bh #line
        movb    36(%ebp), %bl #memory address
        movl    $0, %edx #using edx as a counter
        movb    0xFF, %al # default if nothing found
        movb    %bl, %cl
        andb    0x3, %cl #memory block location
        movb    %bl, %ch
        shrb    $4, %ch #memory tag
        .L1:
        #movzb   1(%bh), %ah #valid bit
        cmpb    0x1, %ah #checks if line is valid
        jne .L2

        #movzb   2(%bh), %ah #tag bits
        cmpb    %ah, %ch #checks if tags match
        jne .L2

        #movb    3(%bh, %cl, 1), %ah #block memory at correct address if hit
        movb    %ah, %al

        .L2:
        incl    %edx    #increment loop counter
        cmpl    $4, %edx
        jle .L1



        #Clean up
        popl    %ebx
        popl    %edx
        popl    %ebp
        ret