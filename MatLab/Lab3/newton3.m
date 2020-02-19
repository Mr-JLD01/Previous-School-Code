%John Luke Denny
%CSC 2262
%cs226224
%Lab 3

%Newton approximation with three unknown variables
%2/11/2020

function [t1, t2, phi] = newton3(f1,f2,f3,df1dt1,df1dt2,df1dtPhi,df2dt1,df2dt2,df2dtPhi,df3dt1,df3dt2,df3dtPhi,guess1,guess2,guessPhi,accuracy)
    D = [f1(guess1, guess2, guessPhi); f2(guess1, guess2, guessPhi); f3(guess1, guess2, guessPhi)];
    
    A = [df1dt1(guess1, guess2, guessPhi) df1dt2(guess1, guess2, guessPhi) df1dtPhi(guess1, guess2, guessPhi); 
        df2dt1(guess1, guess2, guessPhi) df2dt2(guess1, guess2, guessPhi) df2dtPhi(guess1, guess2, guessPhi);
        df3dt1(guess1, guess2, guessPhi) df3dt2(guess1, guess2, guessPhi) df3dtPhi(guess1, guess2, guessPhi)];
    P = inv(A) * D;
    
    t1 = guess1 - P(1);
    t2 = guess2 - P(2);
    phi = guessPhi - P(3);
    while(abs(guess1 - t1) > accuracy || abs(guess2 - t2) > accuracy || abs(guessPhi - phi) > accuracy)
        guess1 = t1;
        guess2 = t2;
        guessPhi = phi;
        
        D = [f1(guess1, guess2, guessPhi); f2(guess1, guess2, guessPhi); f3(guess1, guess2, guessPhi)];
        
        A = [df1dt1(guess1, guess2, guessPhi) df1dt2(guess1, guess2, guessPhi) df1dtPhi(guess1, guess2, guessPhi); 
        df2dt1(guess1, guess2, guessPhi) df2dt2(guess1, guess2, guessPhi) df2dtPhi(guess1, guess2, guessPhi);
        df3dt1(guess1, guess2, guessPhi) df3dt2(guess1, guess2, guessPhi) df3dtPhi(guess1, guess2, guessPhi)];
        P = inv(A) * D;
       
        t1 = guess1 - P(1);
        t2 = guess2 - P(2);
        phi = guessPhi - P(3);
    end