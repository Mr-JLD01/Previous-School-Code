
% function middle
% Does the second (middle) integral by setting up the second call of quad
% and then making the second call of quad

function middle_integral = middle(x,inner,g,h,f,v,w)

global accuracy;

n = length(x);

for(k = 1:n)

c = g(x(k));
d = h(x(k));

% Second call of quad which does the second (middle) integral

middle_integral(k) = quad(inner,c,d,accuracy,[],x(k),f,v,w);

end