%John Luke Denny
%calculates a newton approximation
%1/28/2020
%CSC 2262

function [new] = newton( f, fp, old, accuracy)
    
    new = old - f(old) / fp(old);
    while(abs(old - new) > accuracy )
        old = new;
        new = old - f(old) / fp(old);
        
    end
