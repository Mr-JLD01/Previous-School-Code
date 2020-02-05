%John Luke Denny
%CSC 2262
%cs226224
%Lab 2

%Newton approximation with two unknown variables
%2/4/2020

function [t2, t3] = newton2(f1,f2,df1dt2,df1dt3,df2dt2,df2dt3,guess2,guess3,accuracy)
    D = [f1(guess2, guess3); f2(guess2, guess3)];
    A = [df1dt2(guess2) df1dt3(guess3); df2dt2(guess2) df2dt3(guess3)];
    P = inv(A) * D;
    
    t2 = guess2 - P(1);
    t3 = guess3 - P(2);
    while(abs(guess2 - t2) > accuracy || abs(guess3 - t3) > accuracy)
        guess2 = t2;
        guess3 = t3;
        
        D = [f1(guess2, guess3); f2(guess2, guess3)];
        A = [df1dt2(guess2) df1dt3(guess3); df2dt2(guess2) df2dt3(guess3)];
        P = inv(A) * D;
       
        t2 = guess2 - P(1);
        t3 = guess3 - P(2);
    end