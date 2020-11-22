% function inner
% Does the third (inner) integral by setting up the third call of quad
% and then making the third call of quad

function inner_integral = inner(y,x,f,v,w)

global accuracy;

n=length(y);

for(k = 1:n)

lower = v(x,y(k));
upper = w(x,y(k));

% Third call of quad which does the third (inner) integral

inner_integral(k) = quad(f,lower,upper,accuracy,[],x,y(k));

end