%John Luke Denny
%calculates the roots of a function
%1/28/2020
%CSC 2262
accuracy = 1e-7;

for(x = 0: .1: 5)
    f = @(x) 728 * x^4 - 8249 * x^3 + 33660 * x^2 - 57996 * x + 34992;
    fp = @(x) 728 * 4 * x^3 - 8249 * 3 * x^2 + 33660 * 2 * x^1 - 57996;
    
    if(f(x) == 0)
        fprintf('x = %.5f\n',x);
    end
    if(x ~= 5 && f(x) * f((x + .1)) < 0 )
        guess = (x + x + .1) / 2;
        root = newton(f, fp, guess, accuracy);
        fprintf('x = %.5f\n',root);
    end
    
end